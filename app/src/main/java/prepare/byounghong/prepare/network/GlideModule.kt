package prepare.byounghong.prepare.network

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator
import okhttp3.OkHttpClient
import prepare.byounghong.prepare.network.NetworkConst.Companion.CONNECT_TIMEOUT
import prepare.byounghong.prepare.network.NetworkConst.Companion.DISK_CACHE_SIZE
import java.io.InputStream
import java.util.concurrent.TimeUnit

/**
 * Created by byounghong on 2017. 10. 30..
 */
//
//class GlideModule : GlideModule {
//    override fun registerComponents(context: Context?, glide: Glide?) {
//        val client: OkHttpClient = OkHttpClient.Builder()
//                .readTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
//                .writeTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
//                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
//                .build()
//
//    }
//
//    override fun applyOptions(context: Context?, builder: GlideBuilder?) {
//        val calculator: MemorySizeCalculator = MemorySizeCalculator(context)
//        val defaultMemoryCacheSize: Int = calculator.memoryCacheSize
//        val defaultBitmapPoolSize: Int = calculator.bitmapPoolSize
//
//        val memoryCacheSize: Int = defaultMemoryCacheSize.toInt()
//        val bitmapCacheSize: Int = defaultBitmapPoolSize.toInt()
//
//        builder?.setDecodeFormat(DecodeFormat.PREFER_RGB_565)
//        builder?.setDiskCache(InternalCacheDiskCacheFactory(context,
//                "image_manager_disk_cache",
//                DISK_CACHE_SIZE.toInt()))
//        builder?.setMemoryCache(LruResourceCache(memoryCacheSize))
//        builder?.setBitmapPool(LruBitmapPool(bitmapCacheSize))
//    }
//
//}