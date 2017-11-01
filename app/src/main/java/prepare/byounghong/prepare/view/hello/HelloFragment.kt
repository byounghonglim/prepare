package prepare.byounghong.prepare.view.hello

import android.os.Bundle
import android.view.View
import com.jakewharton.rxbinding2.widget.textChanges
import kotlinx.android.synthetic.main.fragment_hello.*
import prepare.byounghong.prepare.R
import prepare.byounghong.prepare.base.BaseFragment

/**
 * Created by byounghong on 2017. 10. 18..
 */


class HelloFragment : BaseFragment() {
    override val layoutId: Int = R.layout.fragment_hello
    override val fragment = this

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        inputName
                .textChanges()
                .subscribe {
                    val hello = inputName.text
                    textHello.text = hello
                }
    }

}