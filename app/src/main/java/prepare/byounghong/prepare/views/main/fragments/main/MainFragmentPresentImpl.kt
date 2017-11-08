package prepare.byounghong.prepare.views.main.fragments.main

import com.orhanobut.logger.Logger
import prepare.byounghong.prepare.eventbus.EventBus
import prepare.byounghong.prepare.eventbus.Events
import prepare.byounghong.prepare.views.base.BaseFragment
import javax.inject.Inject

/**
 * Created by byounghong on 2017. 11. 8..
 */

class MainFragmentPresentImpl
@Inject constructor(var view: MainFragmentContract.View, var eventBus: EventBus<Any>)
    : MainFragmentContract.Presenter {

    override fun handleEvent(fragment : MainFragment) {
        (fragment as BaseFragment).subscription = eventBus.bus.subscribe { Object ->
            run{
                Logger.d(Object)
            } }
    }

    override fun sendEvent() = eventBus.bus.accept(Events.HongEvent())
}