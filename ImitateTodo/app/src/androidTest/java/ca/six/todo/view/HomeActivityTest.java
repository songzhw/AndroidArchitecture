package ca.six.todo.view;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.six.todo.R;
import ca.six.todo.home.HomeActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by songzhw on 2016-05-17.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class HomeActivityTest {
    @Rule
    public ActivityTestRule<HomeActivity> actvRule = new ActivityTestRule<HomeActivity>(HomeActivity.class);

    // may be wrong. Because Junit does not make sure the calling sequence of all the @Test methods.
//    @Test
//    public void preCondition(){
//        onView(withId(R.id.cbComplete))
//                .check(doesNotExist());
//    }

    @Test
    public void testAdd(){
        onView(withId(R.id.fabHome))
                .perform(click());

        onView(withId(R.id.etAddTask))
                .perform(typeText("May"));
        onView(withId(R.id.fabAdd))
                .perform(click());

        onView(withText("May"))
                .check(matches(isDisplayed()));
    }



}
