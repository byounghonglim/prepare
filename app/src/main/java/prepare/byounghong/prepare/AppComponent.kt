package prepare.byounghong.prepare

import dagger.Component
import dagger.android.AndroidInjectionModule
import prepare.byounghong.prepare.network.NetworkModule
import prepare.byounghong.prepare.preference.PreferenceModule
import prepare.byounghong.prepare.preference.PreferenceSetting
import prepare.byounghong.prepare.scope.ApplicationScope
import prepare.byounghong.prepare.view.main.MainActivity
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
        NetworkModule::class))

interface AppComponent{
    fun inject(app: App)
}