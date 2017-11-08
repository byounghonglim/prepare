package prepare.byounghong.prepare.views.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import prepare.byounghong.prepare.R
import kotlin.reflect.KClass

/**
 * Created by byounghong on 2017. 10. 12..
 */

fun AppCompatActivity.setFragment(fragment: Fragment, container: Int = R.id.container) {
    supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
}


fun Context.startActivity(url: String) {
    val intent = Intent(Intent.ACTION_VIEW)
    val uri = Uri.parse(url)
    intent.data = uri

    startActivity(intent)
}

fun Fragment.startActivity(kClass:KClass<out Activity>, bundle: Bundle?=null ){
    val intent = Intent(activity, kClass.java)
    bundle?.let { intent.putExtras(it) }
    startActivity(intent)
}


