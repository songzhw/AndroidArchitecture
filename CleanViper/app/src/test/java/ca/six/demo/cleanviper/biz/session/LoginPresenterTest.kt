package ca.six.demo.cleanviper.biz.session

import ca.six.demo.cleanviper.core.di.DepStore
import ca.six.demo.cleanviper.core.http.HttpService
import ca.six.demo.cleanviper.core.session.UserHttpResponse
import ca.six.demo.cleanviper.utils.RxImmediateSchedulerRule
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import okhttp3.ResponseBody
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*
import retrofit2.Response

class LoginPresenterTest {
    lateinit var originalRetrofit: HttpService
    lateinit var view: ILoginView

    @Rule
    @JvmField
    var rxTestRule = RxImmediateSchedulerRule()

    @Before
    fun before() {
        originalRetrofit = DepStore.http
        //注入mock
        val mockHttp = mock(HttpService::class.java)
        DepStore.http = mockHttp

        view = mock(ILoginView::class.java)
    }

    @After
    fun after() {
        // 还原
        DepStore.http = originalRetrofit
    }


    @Test
    fun testLogin_toastWhenLoginFailed() {
        val body = ResponseBody.create(null, "")
        val resp = Response.error<UserHttpResponse>(406, body)
        `when`(DepStore.http.loginAndFail()).thenReturn(Observable.just(resp))

        val presenter = LoginPresenter(view)
        presenter.disposables = CompositeDisposable()
        presenter.login("", "")
        verify(DepStore.http).loginAndFail()
        // verify(DepStore.http).loginVIPUser()  // 在我意料之内的error: Wanted but not invoked:          httpService.loginVIPUser();
    }

    @Test
    fun testLogin_loginSuccess() {

    }

    @Test
    fun testLogin_loginVip() {

    }
}