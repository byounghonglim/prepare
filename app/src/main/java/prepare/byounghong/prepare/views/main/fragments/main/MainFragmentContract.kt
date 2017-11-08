package prepare.byounghong.prepare.views.main.fragments.main

/**
 * Created by byounghong on 2017. 10. 31..
 */

class MainFragmentContract {
    interface View{
        fun initViewEvent()
    }

    interface Presenter {
        fun handleEvent(fragment : MainFragment)
        fun sendEvent()
    }
}