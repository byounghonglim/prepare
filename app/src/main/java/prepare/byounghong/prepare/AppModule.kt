package prepare.byounghong.prepare

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by byounghong on 2017. 10. 25..
 */

@Module
class AppModule(val app : App) {

    @Singleton
    @Provides
    fun provideApp() = app
}