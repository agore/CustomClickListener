package com.gannett.customclicklistener;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class TestClickAndSwipe {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testApp() throws Exception {

        onView(withId(R.id.activity_main)).check(matches(isDisplayed()));
        onView(withId(R.id.recycler_images)).perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));


        onView(withId(R.id.activity_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.activity_detail)).perform(click());
        onView(withId(R.id.tv1)).check(matches(not(isDisplayed())));

        onView(withId(R.id.activity_detail)).perform(click());
        onView(withId(R.id.tv1)).check(matches(isDisplayed()));

        onView(withId(R.id.activity_detail)).perform(swipeUp());


        onView(withId(R.id.activity_main)).check(matches(isDisplayed()));

    }
}
