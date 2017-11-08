package prepare.byounghong.prepare.app

import dagger.Component
import dagger.android.AndroidInjectionModule
import prepare.byounghong.prepare.eventbus.EventBusModule
import prepare.byounghong.prepare.network.NetworkModule
import prepare.byounghong.prepare.preference.PreferenceModule
import prepare.byounghong.prepare.scope.ApplicationScope
import javax.inject.Singleton

/**
 * Created by byounghong on 2017. 10. 25..
 */


@ApplicationScope
@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        PreferenceModule::class,
        NetworkModule::class,
        EventBusModule::class))

interface AppComponent{
    fun inject(app: App)
}