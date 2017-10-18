package prepare.byounghong.prepare.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import com.jakewharton.rxbinding2.view.clicks
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fagment_main.*
import prepare.byounghong.prepare.R
import prepare.byounghong.prepare.base.BaseActivity
import prepare.byounghong.prepare.base.BaseFragment
import prepare.byounghong.prepare.utils.browse

/**
 * Created by byounghong on 2017. 10. 18..
 */


class MainFragment : BaseFragment() {
    override val layoutId: Int = R.layout.fagment_main

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val activity = activity as? BaseActivity ?: return
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)

        val github = menu.findItem(R.id.github).clicks().map { R.id.github }

        Observable
                .mergeArray(github)
                .subscribe{ clickMenu(it)}
                .apply { disposables.add(this) }
    }

    private fun clickMenu(id: Int) {
        when(id) {
            R.id.github -> activity.browse("https://github.com/byounghong")
        }
    }
}