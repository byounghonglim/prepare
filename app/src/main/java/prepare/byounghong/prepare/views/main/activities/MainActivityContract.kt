package prepare.byounghong.prepare.views.main.activities

import android.content.Context


/**
 * Created by byounghong on 2017. 10. 30..
 */

class MainActivityContract {
    interface View{
    }
    interface Presenter {
        fun handleEvent(context : Context)
    }
}