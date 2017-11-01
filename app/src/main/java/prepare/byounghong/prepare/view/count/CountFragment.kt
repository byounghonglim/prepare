package prepare.byounghong.prepare.view.count

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.jakewharton.rxbinding2.view.clicks
import io.reactivex.Flowable
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_count.*
import prepare.byounghong.prepare.R
import prepare.byounghong.prepare.base.BaseFragment

/**
 * Created by byounghong on 2017. 10. 19..
 */

class CountFragment : BaseFragment() {
    override val layoutId: Int = R.layout.fragment_count
    override val fragment = this

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val inc = buttonInc.clicks().map { +1 }
        val dec = buttonDec.clicks().map { -1 }

        Observable
                .merge(inc, dec)                //두 Stream 합침
                .scan(0) { acc: Int, value: Int  -> acc + value}          //상태변수를 선언하지 않고 값을 계속 유지
                                                                                    //마지막에 한 번에 값을 받아오고 싶으면 reduce
                .subscribe{textValue.text = it.toString()}

    }


}
