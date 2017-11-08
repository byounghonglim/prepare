package prepare.byounghong.prepare.eventbus

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by byounghong on 2017. 11. 6..
 */

@Module
class EventBusModule {
    @Singleton
    @Provides
    fun provideEventBus(): EventBus<Any> {
        return EventBus()
    }
}