package prepare.byounghong.prepare

import android.app.Activity
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import prepare.byounghong.prepare.view.main.MainActivityComponent
import prepare.byounghong.prepare.view.main.MainActivity
import java.io.File
import javax.inject.Singleton

/**
 * Created by byounghong on 2017. 10. 25..
 */

@Module(includes = arrayOf(AppModule.AppModuleSubMain::class))
class AppModule(val app: App, val context: Context, val cacheDir: File) {

    @Singleton
    @Provides
    fun provideApp() = app

    @Singleton
    @Provides
    fun provideContext() = context

    @Singleton
    @Provides
    fun provideCashDir() = cacheDir

    @Module(subcomponents = arrayOf(MainActivityComponent::class))
    abstract class AppModuleSubMain{
        @Binds
        @IntoMap
        @ActivityKey(MainActivity::class)
        abstract fun bindBaseActivity(builder: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>
    }
}