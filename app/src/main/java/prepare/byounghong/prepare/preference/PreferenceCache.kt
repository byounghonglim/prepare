package prepare.byounghong.prepare.preference

import android.content.Context
import android.content.SharedPreferences
import org.jetbrains.annotations.NotNull

/**
 * Created by byounghong on 2017. 10. 26..
 */

abstract class PreferenceCache (val context: Context, val name:String) {
    private val mCache: MutableMap<String, Any> = mutableMapOf()

    enum class ScanRange(val v:Int) {
        ALL(0), EACH(1)
    }

    init {
        val pref: MutableMap<String, *> = getSharedPreference().all
        pref.keys
                .forEach { k: String ->
                    pref[k]?.let { mCache.put(k, it) }
                }
    }

    private fun getSharedPreference() : SharedPreferences {
        return context.getSharedPreferences(name, Context.MODE_PRIVATE)
    }


    private fun getPref(@NotNull key:String, scanRange:ScanRange) {
         val pref: MutableMap<String, *> = context.getSharedPreferences(name, Context.MODE_PRIVATE).all
        pref.keys
                .forEach { k:String ->
//                if (scanRange == ScanRange.EACH) -> pref.contains(k)}
//                    pref[k]?.let { mCache.put(k, it) }
                }

    }

    fun get(key:String): Any? {
        if(!mCache.containsKey(key)) {
            return mCache[key]
        } else {
            getPref(key, ScanRange.EACH)
        }

        return null
    }

    fun put(@NotNull key:String, @NotNull value:Any) {
        mCache.put(key, value)

        val prefEditor: SharedPreferences.Editor = getSharedPreference().edit()
        when(value) {
            is Boolean -> prefEditor.putBoolean(key,value)
            is Int -> prefEditor.putInt(key,value)
            is Long -> prefEditor.putLong(key,value)
            is Float -> prefEditor.putFloat(key,value)
            else -> prefEditor.putString(key,value.toString())
        }
        prefEditor.apply()
    }

    fun clearCache() {
        mCache.clear()
    }

    fun claerAll() {
        mCache.clear()

        val editor: SharedPreferences.Editor =  getSharedPreference().edit()
        editor.clear()
        editor.apply()
    }

}