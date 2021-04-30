package ca.six.demo.cleanviper.utils

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

// = = = = = = = = = = = = locate view = = = = = = = = = = = =
fun onViewById(id: Int) = onView(withId(id))



// = = = = = = = = = = = = ViweAction = = = = = = = = = = = =
fun input(text: String) = arrayOf(replaceText(text), closeSoftKeyboard())


// = = = = = = = = = = = = Check = = = = = = = = = = = =
fun ViewInteraction.checkText(text: String) = this.check(matches(withText(text)))

fun ViewInteraction.shouldBeVisible() = this.check(matches(withEffectiveVisibility(Visibility.VISIBLE)))