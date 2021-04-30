package ca.six.demo.cleanviper.biz.home

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.action.ViewActions.click
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import ca.six.demo.cleanviper.R
import ca.six.demo.cleanviper.core.session.UserSession
import ca.six.demo.cleanviper.utils.input
import ca.six.demo.cleanviper.utils.onViewById
import ca.six.demo.cleanviper.utils.shouldBeVisible
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
    fun testNavigateToDetailPage_shouldGoToLoginPage_whenNotLoggedIn() {
        UserSession.reset()

        onViewById(R.id.ivHomeBook)
            .perform(click())

        onViewById(R.id.btnLogin)
            .shouldBeVisible()
    }

    @Test
    fun testNavigateToDetailPage_shouldSucceed_afterLogIn() {
        UserSession.reset()

        onViewById(R.id.ivHomeBook)
            .perform(click())

        onViewById(R.id.etLoginName)
            .perform(*input("szw"))

        onViewById(R.id.btnLogin)
            .perform(click())

        onViewById(R.id.rlayBookDetail)
            .shouldBeVisible()
    }
}