package prepare.byounghong.prepare.base

import android.os.Bundle
import prepare.byounghong.prepare.R
import prepare.byounghong.prepare.utils.set

/**
 * Created by byounghong on 2017. 10. 17..
 */

abstract class BaseFragmentActivity<out T : BaseFragment> : BaseActivity() {

    protected abstract val fragment : T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        init(savedInstanceState)
    }

    private fun init(savedInstanceState: Bundle?) {
        savedInstanceState.let {
            set(fragment)
        }
    }

}