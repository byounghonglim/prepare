package prepare.byounghong.prepare.preference

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by byounghong on 2017. 10. 26..
 */

@Module
class PreferenceModule {

    @Singleton
    @Provides
    fun provideSettingPreference(app : Context) : PreferenceSetting {
        return PreferenceSetting(app)
    }
}