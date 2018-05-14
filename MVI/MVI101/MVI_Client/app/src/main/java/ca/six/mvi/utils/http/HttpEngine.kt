package ca.six.mvi.utils.http

import okhttp3.OkHttpClient
import okhttp3.Request

class HttpEngine {

    fun get(url : String){
        // 若在主线程运行, 则会有"android.os.NetworkOnMainThreadException"
        val client = OkHttpClient()
        val request = Request.Builder()
                .url(url)
                .build()

        val response = client.newCall(request).execute()
        val resp = response.body()?.string()
        println("szw actv resp = $resp")
    }

}