package ca.six.demo.cleanviper.router

import ca.six.demo.cleanviper.biz.boook_detail.BookDetailActivity
import ca.six.demo.cleanviper.entity.BookDetail
import ca.six.demo.cleanviper.router.core.IRouter
import ca.six.demo.cleanviper.router.core.Station
import java.util.HashMap

const val BOOK_DETAIL = "BOOK_DETAIL"

class MainRouter : IRouter {
    override fun registerRoute(map: HashMap<String, Station>) {
        map[BOOK_DETAIL] = Station(BOOK_DETAIL, BookDetailActivity::class.java)
    }
}