package prepare.byounghong.prepare.view.main

import android.os.Bundle
import android.support.v4.app.Fragment
import prepare.byounghong.prepare.base.BaseFragmentActivity
import prepare.byounghong.prepare.base.setFragment
import prepare.byounghong.prepare.network.setConnectSetting
import prepare.byounghong.prepare.preference.PreferenceSetting
import javax.inject.Inject


class MainActivity() : BaseFragmentActivity() {
    override val fragment = MainFragment()
    override val activity = this

    @Inject lateinit var preference:PreferenceSetting

    fun chageFragment(fragment: Fragment) {
        setFragment(fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setConnectSetting(this)
    }
}

