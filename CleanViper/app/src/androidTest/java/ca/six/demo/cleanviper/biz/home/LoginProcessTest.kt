package ca.six.demo.cleanviper.biz.home

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.action.ViewActions.click
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import ca.six.demo.cleanviper.R
import ca.six.demo.cleanviper.utils.onViewById
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_login.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class RefreshLaterPageTest {
    lateinit var scenario: ActivityScenario<HomeActivity>

    @Before
    fun setup() {
        scenario = launch(HomeActivity::class.java)
    }

    @Test
    fun testOriginalText() {
        onViewById(R.id.ivHomeBook)
            .perform(click())


    }
}