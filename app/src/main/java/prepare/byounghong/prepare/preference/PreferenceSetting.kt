package prepare.byounghong.prepare.preference

import android.content.Context

/**
 * Created by byounghong on 2017. 10. 26..
 */


class PreferenceSetting(context: Context) : PreferenceCache(context, PreferenceConst.PREF_CACHE) {

    fun setPushEnable(enable:Boolean) {
        put(PreferenceConst.PUSH_ENABLE, enable)
    }

    fun isPushEnable() : Boolean? {
        return get(PreferenceConst.PUSH_ENABLE) as Boolean
        return null
    }

    fun setGpsEnable(enable: Boolean) {
        put(PreferenceConst.GPS_ENABLE, enable)
    }

    fun isGpsEnable() : Boolean? {
        return get(PreferenceConst.GPS_ENABLE) as Boolean
        return null
    }

}