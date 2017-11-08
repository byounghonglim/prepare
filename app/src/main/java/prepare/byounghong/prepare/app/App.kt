package prepare.byounghong.prepare.app

import android.app.Activity
import android.app.Application
import com.crashlytics.android.Crashlytics
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.fabric.sdk.android.Fabric
import prepare.byounghong.prepare.eventbus.EventBusModule
import prepare.byounghong.prepare.network.NetworkModule
import prepare.byounghong.prepare.preference.PreferenceModule
import javax.inject.Inject
import com.orhanobut.logger.PrettyFormatStrategy
import com.orhanobut.logger.FormatStrategy
import prepare.byounghong.prepare.log.LoggerAdapter


/**
 * Created by byounghong on 2017. 10. 17..
 */

class App : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this, this, cacheDir))
                .networkModule(NetworkModule())
                .preferenceModule(PreferenceModule())
                .eventBusModule(EventBusModule())
                .build()}

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)

        Logger.addLogAdapter(LoggerAdapter())
        Fabric.with(this, Crashlytics())
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector
}