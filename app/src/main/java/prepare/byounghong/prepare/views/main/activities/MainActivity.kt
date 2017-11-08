package prepare.byounghong.prepare.views.main.activities

import android.os.Bundle
import prepare.byounghong.prepare.preference.PreferenceSetting
import prepare.byounghong.prepare.views.base.BaseFragmentActivity
import prepare.byounghong.prepare.views.main.fragments.main.MainFragment
import javax.inject.Inject

class MainActivity() : BaseFragmentActivity(), MainActivityContract.View {


    override val fragment = MainFragment()
    override val activity = this

    @Inject lateinit var presenter : MainActivityContract.Presenter
    @Inject lateinit var preference: PreferenceSetting

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        presenter.handleEvent(this)
    }



}



