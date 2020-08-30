package ca.six.archi.cfl.core

import retrofit2.Retrofit
import retrofit2.http.GET

data class LoginResponse(val succ: Boolean, val session: String)

interface IHttpService {
    @GET("1e2296f8-3092-4724-975f-6fe565f0f4d8")
    suspend fun login(): LoginResponse
}


object Http {
    val service: IHttpService by lazy {
        Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/")
            .build()
            .create(IHttpService::class.java)
    }

}