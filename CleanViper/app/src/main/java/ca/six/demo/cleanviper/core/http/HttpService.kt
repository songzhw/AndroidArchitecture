package ca.six.demo.cleanviper.core.http

import ca.six.demo.cleanviper.entity.BookChapter
import io.reactivex.Observable
import retrofit2.http.GET

interface HttpService {
    @GET("dbfd6809-d551-4c23-94a5-696b3d4f7efd")
    fun getChapters() : Observable<List<BookChapter>>
}