package prepare.byounghong.prepare.views.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import prepare.byounghong.prepare.eventbus.EventBus
import javax.inject.Inject

/**
 * Created by byounghong on 2017. 10. 17..
 */

abstract class BaseFragment : Fragment() {
    protected abstract val layoutId : Int
    protected abstract val fragment : Fragment

    @Inject lateinit var eventBus : EventBus<Any>

    protected val disposables by lazy { CompositeDisposable() }
    internal  lateinit var subscription : Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidSupportInjection.inject(this)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?)
            = inflater.inflate(layoutId, container, false)


    override fun onPause() {
        super.onPause()
        subscription?.let { subscription.dispose() }
    }
    override fun onDestroyView() {
        disposables.clear()
        super.onDestroyView()
    }

}