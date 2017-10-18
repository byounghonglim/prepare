package prepare.byounghong.prepare.app

import android.app.Application
import prepare.byounghong.prepare.app.dagger.componets.DaggerNetworkComponent
import prepare.byounghong.prepare.app.dagger.componets.NetworkComponent

/**
 * Created by byounghong on 2017. 10. 17..
 */

class BaseApplication : Application() {

    private lateinit var networkComponent : NetworkComponent

    //static method
    companion object {
        private lateinit var app: BaseApplication
        val networkComponent by lazy { app.networkComponent}
    }

    override fun onCreate() {
        super.onCreate()

        app = this
        networkComponent = DaggerNetworkComponent.builder().build()
    }

}