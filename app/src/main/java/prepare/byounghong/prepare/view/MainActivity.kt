package prepare.byounghong.prepare.view

import prepare.byounghong.prepare.base.BaseFragmentActivity


class MainActivity : BaseFragmentActivity<MainFragment>() {
    override val fragment by lazy {
        MainFragment()
    }
}
