package prepare.byounghong.prepare.log

import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.PrettyFormatStrategy
import prepare.byounghong.prepare.BuildConfig

/**
 * Created by byounghong on 2017. 11. 8..
 */

class LoggerAdapter : AndroidLogAdapter(PrettyFormatStrategy.newBuilder()
//                .showThreadInfo(false)
//                .methodCount(0)
//                .methodOffset(3)
//                .logStrategy(customLog)
        .tag("WL")
        .build()) {

    override fun isLoggable(priority: Int, tag: String?): Boolean {
        return BuildConfig.IS_DEV
    }

}