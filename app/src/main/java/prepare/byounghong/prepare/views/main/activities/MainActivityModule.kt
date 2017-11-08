package prepare.byounghong.prepare.views.main.activities

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap
import prepare.byounghong.prepare.scope.ActivityScope
import prepare.byounghong.prepare.views.main.fragments.main.MainFragment
import prepare.byounghong.prepare.views.main.fragments.main.MainFragmentComponent
import prepare.byounghong.prepare.views.main.ProgressFragmentComponent
import prepare.byounghong.prepare.views.main.fragments.progress.ProgressFragment

/**
 * Created by byounghong on 2017. 10. 31..
 */


@Module(subcomponents = arrayOf(MainFragmentComponent::class, ProgressFragmentComponent::class))
abstract class MainActivityModule {
    @ActivityScope
    @Binds
    internal abstract fun bindMainView(activity: MainActivity): MainActivityContract.View

    @ActivityScope
    @Binds
    internal abstract fun bindMainPresenter(mainPresenter: MainActivityPresentImpl): MainActivityContract.Presenter

    @Binds
    @IntoMap
    @FragmentKey(MainFragment::class)
    internal abstract fun bindMainFragment(builder: MainFragmentComponent.Builder): AndroidInjector.Factory<out Fragment>

    @Binds
    @IntoMap
    @FragmentKey(ProgressFragment::class)
    internal abstract fun bindProgressFragment(builder: ProgressFragmentComponent.Builder): AndroidInjector.Factory<out Fragment>
}