package prepare.byounghong.prepare.base

import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by byounghong on 2017. 10. 17..
 */


abstract class BaseActivity : AppCompatActivity()  {

    protected  val disposables by lazy { CompositeDisposable() }

    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }

}