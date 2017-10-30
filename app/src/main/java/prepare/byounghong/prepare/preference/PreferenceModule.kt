package prepare.byounghong.prepare.preference

import dagger.Module
import dagger.Provides
import prepare.byounghong.prepare.App
import prepare.byounghong.prepare.preference.PreferenceSetting
import javax.inject.Singleton

/**
 * Created by byounghong on 2017. 10. 26..
 */

@Module
class PreferenceModule {

    @Singleton
    @Provides
    fun provideSettingPreference(app : App) : PreferenceSetting {
        return PreferenceSetting(app)
    }
}