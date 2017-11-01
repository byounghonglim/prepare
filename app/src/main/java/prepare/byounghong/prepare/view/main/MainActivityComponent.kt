package prepare.byounghong.prepare.view.main

import dagger.Component
import dagger.Subcomponent
import dagger.android.AndroidInjector
import prepare.byounghong.prepare.AppComponent
import prepare.byounghong.prepare.preference.PreferenceModule
import prepare.byounghong.prepare.preference.PreferenceSetting
import prepare.byounghong.prepare.scope.ActivityScope

/**
 * Created by byounghong on 2017. 10. 31..
 */


@ActivityScope
@Subcomponent(modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()

}