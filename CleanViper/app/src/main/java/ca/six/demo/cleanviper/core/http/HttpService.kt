package ca.six.demo.cleanviper.core.http

import ca.six.demo.cleanviper.entity.BookDetail
import io.reactivex.Observable
import retrofit2.http.GET

interface HttpService {
    @GET("dbfd6809-d551-4c23-94a5-696b3d4f7efd")
    fun getChapters() : Observable<BookDetail>
}


/*
 1. 备注: 若response是:  { "chapters": [...] },
 那这里的的getChapter不能是返回: Observable<List<BookChapter>>. 得是返回一个对象.
 不然会报错:  Caused by: java.lang.IllegalStateException: Expected BEGIN_ARRAY but was BEGIN_OBJECT at line 1 column 2 path $
 */