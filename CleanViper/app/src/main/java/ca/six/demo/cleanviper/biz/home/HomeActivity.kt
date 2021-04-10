package ca.six.demo.cleanviper.biz.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.demo.cleanviper.R
import ca.six.demo.cleanviper.router.BOOK_DETAIL
import ca.six.demo.cleanviper.router.core.Router
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(R.layout.activity_home) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ivHomeBook.setOnClickListener {
            Router.nav(this, BOOK_DETAIL)
        }
    }
}
