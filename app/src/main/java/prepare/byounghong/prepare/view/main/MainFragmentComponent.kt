package prepare.byounghong.prepare.view.main

import dagger.Subcomponent
import dagger.android.AndroidInjector
import prepare.byounghong.prepare.scope.FragmentScope

/**
 * Created by byounghong on 2017. 10. 31..
 */

@FragmentScope
@Subcomponent(modules = arrayOf(MainFragmentModule::class))
interface MainFragmentComponent : AndroidInjector<MainFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainFragment>() {}
}
