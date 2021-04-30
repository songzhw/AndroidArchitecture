package ca.six.demo.cleanviper.utils

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText

fun onViewById(id: Int) = onView(withId(id))

fun ViewInteraction.checkText(text: String) = this.check(matches(withText(text)))