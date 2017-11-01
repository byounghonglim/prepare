package prepare.byounghong.prepare

import android.app.Activity
import android.app.Application
import com.crashlytics.android.Crashlytics
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.fabric.sdk.android.Fabric
import prepare.byounghong.prepare.network.NetworkModule
import prepare.byounghong.prepare.network.NetworkSetting
import prepare.byounghong.prepare.preference.PreferenceModule
import prepare.byounghong.prepare.preference.PreferenceSetting
import javax.inject.Inject

/**
 * Created by byounghong on 2017. 10. 17..
 */

class App : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var preference : PreferenceSetting

    @Inject
    lateinit var network: NetworkSetting

    val appComponent: AppComponent by lazy {
          DaggerAppComponent.builder()
                  .appModule(AppModule(this, this, cacheDir))
                  .networkModule(NetworkModule())
                  .preferenceModule(PreferenceModule())
                  .build()}

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)

        Fabric.with(this, Crashlytics())

    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector
}