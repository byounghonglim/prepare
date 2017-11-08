package prepare.byounghong.prepare.location

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.Settings
import android.widget.Toast
import com.tedpark.tedpermission.rx2.TedRx2Permission
import org.jetbrains.annotations.NotNull
import prepare.byounghong.prepare.preference.PreferenceSetting

/**
 * Created by byounghong on 2017. 10. 31..
 */


fun isGpsOn(@NotNull context: Activity) =
        context.packageManager.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS)


fun setGpsSetting(@NotNull context: Activity) =
        AlertDialog.Builder(context)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("")
                .setMessage("")
                .setCancelable(false)
                .setPositiveButton("OK") { dialog, which ->
                    context.startActivityForResult(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS),0)
                }
                .show()

fun turnOnGps(@NotNull context: Activity) =
        context.sendBroadcast(Intent("android.location.GPS_ENABLED_CHANGE")
                .putExtra("enabled",true))


fun setLocationPermission(@NotNull preferenceSetting: PreferenceSetting
                          , @NotNull context:Activity) {

    TedRx2Permission.with(context)
            .setRationaleTitle("")
            .setRationaleMessage("")
            .setPermissions(android.Manifest.permission.ACCESS_COARSE_LOCATION,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)
            .request()
            .subscribe{tedPermissionResult ->
                if(tedPermissionResult.isGranted) {
                    Toast.makeText(context, "", Toast.LENGTH_SHORT).show()
                    preferenceSetting.setGpsEnable(true)
                }else {
                    Toast.makeText(context, "", Toast.LENGTH_SHORT).show()
                    preferenceSetting.setGpsEnable(false)
                }
            }
}
