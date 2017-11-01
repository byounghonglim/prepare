package prepare.byounghong.prepare.network

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import prepare.byounghong.prepare.BuildConfig
import prepare.byounghong.prepare.network.NetworkConst.Companion.BASE_URL
import prepare.byounghong.prepare.network.NetworkConst.Companion.CONNECT_TIMEOUT
import prepare.byounghong.prepare.network.NetworkConst.Companion.DISK_CACHE_SIZE
import prepare.byounghong.prepare.network.NetworkConst.Companion.READ_TIMEOUT
import prepare.byounghong.prepare.network.NetworkConst.Companion.WRITE_TIMEOUT
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by byounghong on 2017. 10. 17..
 */


@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = if(BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    @Singleton
    @Provides
    fun provideCache(cacheDir: File) = Cache(cacheDir, DISK_CACHE_SIZE.toLong())


    @Singleton
    @Provides
    fun proviceGsonConvertFactory() = GsonConverterFactory.create()


    @Singleton
    @Provides
    fun provideOkHttpClient(cache:Cache, interceptor: HttpLoggingInterceptor) : OkHttpClient =
            OkHttpClient.Builder()
                    .cache(cache)
                    .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                    .cookieJar(JavaNetCookieJar(CookieManager(null, CookiePolicy.ACCEPT_ALL)))
                    .addInterceptor(interceptor)
                    .build()

    @Singleton
    @Provides
    fun provideApiService(client: OkHttpClient, gsonConverterFactory: GsonConverterFactory) =
            Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(NetworkSetting::class.java)

    @Singleton
    @Provides
    fun provideGson() = GsonBuilder().create()
}
