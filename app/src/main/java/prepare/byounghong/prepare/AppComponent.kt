package prepare.byounghong.prepare

import dagger.Component
import dagger.android.AndroidInjectionModule
import prepare.byounghong.prepare.network.NetworkModule
import prepare.byounghong.prepare.preference.PreferenceModule
import prepare.byounghong.prepare.base.BaseFragment
import prepare.byounghong.prepare.view.progress.ProgressFragment
import javax.inject.Singleton

/**
 * Created by byounghong on 2017. 10. 25..
 */


@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        PreferenceModule::class,
        NetworkModule::class))

interface AppComponent{
    fun inject(f: ProgressFragment)
}