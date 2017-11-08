package prepare.byounghong.prepare.views.main

import dagger.Subcomponent
import dagger.android.AndroidInjector
import prepare.byounghong.prepare.scope.FragmentScope
import prepare.byounghong.prepare.views.main.fragments.progress.ProgressFragment

/**
 * Created by byounghong on 2017. 10. 31..
 */

@FragmentScope
@Subcomponent(modules = arrayOf(ProgressFragmentModule::class))
interface ProgressFragmentComponent : AndroidInjector<ProgressFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<ProgressFragment>() {}
}
