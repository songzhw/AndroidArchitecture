package ca.six.demo.cleanviper.core.http

import ca.six.demo.cleanviper.core.session.UserHttpResponse
import ca.six.demo.cleanviper.core.session.UserSession
import ca.six.demo.cleanviper.entity.BookDetail
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface HttpService {
    @GET("4c1785a5-723f-4985-95e2-cf5ce2fd9d50")
    fun getChapters(): Observable<BookDetail>

    @GET("f93dbffb-69f6-4d2d-9ce2-3b334d79cf19")
    fun loginAndFail(): Observable<Response<UserHttpResponse>>

    @GET("41a8da41-d4c7-436d-a476-c0f6330c27ea")
    fun LoginUser(): Observable<UserHttpResponse>

    @GET("f6d5bdd7-2cd5-444f-bf26-e711caa18b9c")
    fun loginVIPUser(): Observable<UserHttpResponse>

}


/*
 1. 备注: 若response是:  { "chapters": [...] },
 那这里的的getChapter不能是返回: Observable<List<BookChapter>>. 得是返回一个对象.
 不然会报错:  Caused by: java.lang.IllegalStateException: Expected BEGIN_ARRAY but was BEGIN_OBJECT at line 1 column 2 path $

 2. 备注: 要看status code, 就得返回带Response的类型, 如Call<Response<?>>, 或Observable<Response<?>>


 */