package prepare.byounghong.prepare.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import io.reactivex.disposables.CompositeDisposable
import prepare.byounghong.prepare.view.main.MainFragmentContract

/**
 * Created by byounghong on 2017. 10. 17..
 */

abstract class BaseFragment : Fragment() , MainFragmentContract.View{
    protected  abstract val layoutId : Int
    protected abstract val fragment : Fragment

    protected val disposables by lazy { CompositeDisposable() }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        retainInstance = true                       //화면 전환시 설정 유지
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?)
            = inflater.inflate(layoutId, container, false)


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        throw NotImplementedError()
    }

    override fun onDestroyView() {
        disposables.clear()
        super.onDestroyView()
    }

}