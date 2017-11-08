package prepare.byounghong.prepare.views.main.activities

import dagger.Subcomponent
import dagger.android.AndroidInjector
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