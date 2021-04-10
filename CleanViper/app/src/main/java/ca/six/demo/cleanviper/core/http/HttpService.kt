package ca.six.demo.cleanviper.core.http

import ca.six.demo.cleanviper.entity.BookDetail
import io.reactivex.Observable
import retrofit2.http.GET

interface HttpService {
    @GET("4c1785a5-723f-4985-95e2-cf5ce2fd9d50")
    fun getChapters() : Observable<BookDetail>
}


/*
 1. 备注: 若response是:  { "chapters": [...] },
 那这里的的getChapter不能是返回: Observable<List<BookChapter>>. 得是返回一个对象.
 不然会报错:  Caused by: java.lang.IllegalStateException: Expected BEGIN_ARRAY but was BEGIN_OBJECT at line 1 column 2 path $
 */