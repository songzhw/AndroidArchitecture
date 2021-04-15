package ca.six.demo.cleanviper.biz.session

import ca.six.demo.cleanviper.core.di.DepStore
import ca.six.demo.cleanviper.core.http.HttpService
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class LoginPresenterTest {
    lateinit var http: HttpService
    lateinit var view: ILoginView

    @Before
    fun before() {
        http = DepStore.http
        //注入mock
        val mockHttp = mock(HttpService::class.java)
        DepStore.http = mockHttp

        view = mock(ILoginView::class.java)
    }

    @After
    fun after() {
        // 还原
        DepStore.http = http
    }


    @Test
    fun testLogin_toastWhenLoginFailed() {
        val presenter = LoginPresenter(view)
    }

    @Test
    fun testLogin_loginSuccess() {

    }

    @Test
    fun testLogin_loginVip() {

    }
}