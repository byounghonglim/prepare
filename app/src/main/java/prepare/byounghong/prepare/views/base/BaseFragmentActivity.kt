package prepare.byounghong.prepare.views.base

import android.os.Bundle
import android.support.v4.app.Fragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.disposables.Disposable
import prepare.byounghong.prepare.R
import prepare.byounghong.prepare.eventbus.EventBus
import prepare.byounghong.prepare.views.util.setFragment
import javax.inject.Inject

/**
 * Created by byounghong on 2017. 10. 17..
 */


abstract class BaseFragmentActivity()
    : BaseActivity(), HasSupportFragmentInjector {

    @Inject lateinit var IfragmentDispatchAndroidInjector : DispatchingAndroidInjector<Fragment>
    @Inject lateinit var eventBus : EventBus<Any>

    protected abstract val fragment : BaseFragment

    internal  lateinit var subscription : Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        AndroidInjection.inject(activity)
        setFragment(fragment)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return IfragmentDispatchAndroidInjector
    }

    override fun onPause() {
        super.onPause()
        subscription?.let { subscription.dispose() }
    }

}