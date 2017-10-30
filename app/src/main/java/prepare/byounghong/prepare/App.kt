package prepare.byounghong.prepare

import android.app.Application
import java.io.File

/**
 * Created by byounghong on 2017. 10. 17..
 */

class App : Application() {

    //static method
    companion object {
        val appComponent: AppComponent by lazy {
            DaggerAppComponent.create()
        }
        lateinit var neworkCacheDir: File
    }

    override fun onCreate() {
        super.onCreate()
        neworkCacheDir = cacheDir
    }

}