package prepare.byounghong.prepare.views.main.fragments.main

import dagger.Binds
import dagger.Module
import prepare.byounghong.prepare.scope.FragmentScope

/**
 * Created by byounghong on 2017. 10. 31..
 */

@Module
abstract class MainFragmentModule {

    @FragmentScope
    @Binds
    internal abstract fun bindPresenter(presenter: MainFragmentPresentImpl):
            MainFragmentContract.Presenter

    @FragmentScope
    @Binds
    internal abstract fun bindView(fragment: MainFragment): MainFragmentContract.View
}