package ca.six.demo.cleanviper.router

import ca.six.demo.cleanviper.biz.boook_detail.BookDetailActivity
import ca.six.demo.cleanviper.biz.session.LoginActivity
import ca.six.demo.cleanviper.biz.session.LogoutActivity
import ca.six.demo.cleanviper.core.session.UserSession
import ca.six.demo.cleanviper.router.core.IRouter
import ca.six.demo.cleanviper.router.core.Precondition
import ca.six.demo.cleanviper.router.core.Station
import java.util.*

const val BOOK_DETAIL = "BOOK_DETAIL"
const val LOGIN = "LOGIN"
const val LOGOUT = "LOGOUT"

class MainRouter : IRouter {
    override fun registerRoute(map: HashMap<String, Station>) {
        map[LOGIN] = Station(LOGIN, LoginActivity::class.java)
        map[LOGOUT] = Station(LOGOUT, LogoutActivity::class.java)

        map[BOOK_DETAIL] = Station(BOOK_DETAIL, BookDetailActivity::class.java)
            .addPrecondition(Precondition(UserSession::hasLoggedIn, LOGIN))
    }
}