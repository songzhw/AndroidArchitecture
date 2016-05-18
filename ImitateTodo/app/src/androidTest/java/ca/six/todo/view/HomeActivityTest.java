package ca.six.todo.view;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.six.todo.R;
import ca.six.todo.home.HomeActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by songzhw on 2016-05-17.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class HomeActivityTest {
    @Rule
    public ActivityTestRule<HomeActivity> actvRule = new ActivityTestRule<HomeActivity>(HomeActivity.class);

    @Test
    public void preCondition(){
        onView(withId(R.id.cbComplete))
                .check(doesNotExist());
    }
}
