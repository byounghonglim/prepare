package prepare.byounghong.prepare.views.main.fragments.main

import android.os.Bundle
import android.view.View
import com.jakewharton.rxbinding2.view.clicks
import kotlinx.android.synthetic.main.fagment_main.*
import prepare.byounghong.prepare.R
import prepare.byounghong.prepare.views.base.BaseFragment
import javax.inject.Inject

/**
 * Created by byounghong on 2017. 10. 18..
 */

class MainFragment : BaseFragment(), MainFragmentContract.View {
    override val layoutId = R.layout.fagment_main
    override val fragment = this

    @Inject lateinit var presenter : MainFragmentContract.Presenter

    companion object {
        fun getInstance() = MainFragment()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        initViewEvent()
    }

    override fun onStart() {
        super.onStart()
        presenter.handleEvent(this)
    }

    override fun initViewEvent() {
        buttonHello.clicks().subscribe{
            presenter.sendEvent()
        }
    }

}