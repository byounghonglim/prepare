package prepare.byounghong.prepare.app.dagger.api

import io.reactivex.Flowable
import prepare.byounghong.prepare.model.Photos
import prepare.byounghong.prepare.model.Users
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by byounghong on 2017. 10. 17..
 */

interface NetworkApi {
    companion object {
        val BASE_URL = "http://jsonplaceholder.typicode.com"
    }

    @GET("users")
    fun getUsers(): Flowable<Users>

    @GET("photos")
    fun getPhotos(
            @Query("_page") page:Int = 1,
            @Query("_limit") limit:Int = 30
    ) : Flowable<Response<Photos>>
}