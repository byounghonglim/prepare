package prepare.byounghong.prepare.app.dagger.componets

import dagger.Component
import prepare.byounghong.prepare.app.dagger.modules.NetworkModule
import prepare.byounghong.prepare.base.BaseFragment
import prepare.byounghong.prepare.view.progress.ProgressFragment
import javax.inject.Singleton

/**
 * Created by byounghong on 2017. 10. 17..
 */


@Singleton
@Component(modules = arrayOf(NetworkModule::class))
interface NetworkComponent {
    fun inject(f: BaseFragment)
    fun inject(f: ProgressFragment)
}