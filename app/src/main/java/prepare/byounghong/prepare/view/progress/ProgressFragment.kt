package prepare.byounghong.prepare.view.progress

import android.os.Bundle
import android.view.View
import com.jakewharton.rxbinding2.view.clicks
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fagment_main.*
import kotlinx.android.synthetic.main.fragment_progress.*
import prepare.byounghong.prepare.R
import prepare.byounghong.prepare.app.BaseApplication
import prepare.byounghong.prepare.app.dagger.api.NetworkApi
import prepare.byounghong.prepare.base.BaseFragment
import java.util.*
import javax.inject.Inject

/**
 * Created by byounghong on 2017. 10. 19..
 */


class ProgressFragment : BaseFragment() {
    override val layoutId: Int = R.layout.fragment_progress

    @Inject lateinit var networkApi : NetworkApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BaseApplication.networkComponent.inject(this)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        progress.hide()

        buttonUser.clicks()
                .doOnNext { progress.show()}
                .switchMap { networkApi.getUsers()}
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ users ->
                    val index = Random().nextInt(users.size)
                    val user = users[index]
                    textName.text = user.name
                    textEmail.text = user.email
                    progress.hide()
                }, {
                    progress.hide()
                })
    }

}