package prepare.byounghong.prepare.views.main.activities

import android.content.Context
import com.orhanobut.logger.Logger
import prepare.byounghong.prepare.eventbus.EventBus
import prepare.byounghong.prepare.eventbus.Events
import prepare.byounghong.prepare.views.base.BaseFragmentActivity
import prepare.byounghong.prepare.views.main.fragments.progress.ProgressFragment
import prepare.byounghong.prepare.views.util.setFragment
import javax.inject.Inject

/**
 * Created by byounghong on 2017. 11. 7..
 */


class MainActivityPresentImpl
@Inject constructor(var view: MainActivityContract.View, var eventBus:EventBus<Any>)
    : MainActivityContract.Presenter {

    override fun handleEvent(context : Context) {
        (context as BaseFragmentActivity).subscription = eventBus.bus.subscribe { Object ->
            run{
                Logger.d(Object)
                when(Object){
                    is Events.HongEvent ->
                        context.setFragment(ProgressFragment.getInstance())
                }
            } }
    }

}