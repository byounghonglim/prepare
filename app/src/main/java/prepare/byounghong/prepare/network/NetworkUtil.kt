package prepare.byounghong.prepare.network

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.provider.Settings
import org.jetbrains.annotations.NotNull

/**
 * Created by byounghong on 2017. 11. 1..
 */

private fun getNetworkInfo(context: Context) =
         (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
                 .activeNetworkInfo


fun isConnectedNetwork(context: Context) =
        getNetworkInfo(context).isConnected

fun isConnectedWifi(context : Context) =
        (getNetworkInfo(context).type == ConnectivityManager.TYPE_WIFI)


fun isConnectedMobile(context : Context) =
        (getNetworkInfo(context).type == ConnectivityManager.TYPE_MOBILE)

fun setConnectSetting(@NotNull context: Activity) =
        AlertDialog.Builder(context)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("")
                .setMessage("")
                .setCancelable(false)
                .setPositiveButton("OK") { dialog, which ->
                    context.startActivityForResult(Intent(Settings.ACTION_WIRELESS_SETTINGS),0)
                }
                .show()

