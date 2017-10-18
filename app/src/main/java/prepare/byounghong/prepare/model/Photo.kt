package prepare.byounghong.prepare.model

import android.media.ThumbnailUtils


/**
 * Created by byounghong on 2017. 10. 17..
 */

data class Photo (
        val id : Int,
        val title : String,
        val url : String,
        val thumbnailUtils: String
)