package prepare.byounghong.prepare.network

import io.reactivex.Flowable
import io.reactivex.Observable
import prepare.byounghong.prepare.network.model.Photos
import prepare.byounghong.prepare.network.model.Users
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by byounghong on 2017. 10. 17..
 */

interface NetworkSetting {

    @GET("users")
    fun getUsers(): Observable<Users>

    @GET("photos")
    fun getPhotos(
            @Query("_id") id:Int = 1,
            @Query("_url") url:String = ""
    ) : Flowable<Response<Photos>>
}