package prepare.byounghong.prepare.app.dagger.modules

import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import prepare.byounghong.prepare.BuildConfig
import prepare.byounghong.prepare.app.dagger.api.NetworkApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by byounghong on 2017. 10. 17..
 */


@Module
class NetworkModule {

    fun initHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = if(BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    fun initRetrofit(client: OkHttpClient, baseUrl: String) : Retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideOkHttpClient() : OkHttpClient =OkHttpClient.Builder()
                .addInterceptor(initHttpLoggingInterceptor())
                .build()

    @Singleton
    @Provides
    fun provideApiService(client: OkHttpClient) : NetworkApi {
        return initRetrofit(client, NetworkApi.BASE_URL)
                .create(NetworkApi::class.java)
    }

}
