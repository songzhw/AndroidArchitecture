package ca.six.mvi.utils.http

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableOnSubscribe
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class HttpEngine {

    fun get(url: String): Flowable<Response> {
        val ret = Flowable.create(FlowableOnSubscribe<Response> { emitter ->
            // 若在主线程运行, 则会有"android.os.NetworkOnMainThreadException"
            println("szw engine ${Thread.currentThread().name}")

            val client = OkHttpClient()
            val request = Request.Builder()
                    .url(url)
                    .build()

            val response = client.newCall(request).execute()
            emitter.onNext(response)
            emitter.onComplete()
        }, BackpressureStrategy.BUFFER)

        return ret
    }

}