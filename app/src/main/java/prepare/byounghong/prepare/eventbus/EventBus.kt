package prepare.byounghong.prepare.eventbus

import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.Observable

/**
 * Created by byounghong on 2017. 11. 6..
 */

class EventBus<Any>() {
    val bus = PublishRelay.create<Any>()

    fun <E : Any> post(event : E) = bus.accept(event)
    fun bus() = bus
}