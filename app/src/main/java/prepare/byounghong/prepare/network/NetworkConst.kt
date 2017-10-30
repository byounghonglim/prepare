package prepare.byounghong.prepare.network

/**
 * Created by byounghong on 2017. 10. 30..
 */

class NetworkConst {
   companion object {
      const val CONNECT_TIMEOUT: Long = 30
      const val READ_TIMEOUT: Long = 30
      const val WRITE_TIMEOUT: Long = 30
      const val DISK_CACHE_SIZE = 1024 * 1024 * 10

      const val BASE_URL = "http://jsonplaceholder.typicode.com/"

   }
}
