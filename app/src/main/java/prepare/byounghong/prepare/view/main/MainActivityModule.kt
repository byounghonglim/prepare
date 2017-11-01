package prepare.byounghong.prepare.view.main

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap
import prepare.byounghong.prepare.base.BaseFragment
import prepare.byounghong.prepare.scope.ActivityScope

/**
 * Created by byounghong on 2017. 10. 31..
 */


@Module(subcomponents = arrayOf(MainFragmentComponent::class))
abstract class MainActivityModule {
    @ActivityScope
    @Binds
    internal abstract fun bindView(activity: MainActivity): MainActivityContract.View

//    @ActivityScope
//    @Binds
//    internal abstract fun bindPresenter(mainPresenter: MainPresenterImpl): MainActivityContract.Presenter

    @Binds
    @IntoMap
    @FragmentKey(MainFragment::class)
    internal abstract fun bindMainFragment(builder: MainFragmentComponent.Builder): AndroidInjector.Factory<out Fragment>
}