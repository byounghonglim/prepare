package prepare.byounghong.prepare.base

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import prepare.byounghong.prepare.R
import prepare.byounghong.prepare.view.main.MainActivityContract
import javax.inject.Inject

/**
 * Created by byounghong on 2017. 10. 17..
 */


abstract class BaseFragmentActivity()
    : BaseActivity(), HasSupportFragmentInjector, MainActivityContract.View{

    @Inject lateinit var IfragmentDispatchAndroidInjector : DispatchingAndroidInjector<Fragment>

    protected abstract val fragment : BaseFragment
    protected abstract val activity : Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        AndroidInjection.inject(activity)

        setFragment(fragment)
    }

   override fun supportFragmentInjector(): AndroidInjector<Fragment> {
       return IfragmentDispatchAndroidInjector
   }

}