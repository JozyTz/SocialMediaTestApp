package com.example.combined;

import android.content.Context;
import android.provider.Telephony;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.*;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule = new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void listGoesOverTheFold() {
        onView(withText("Sign in")).check(matches(isDisplayed()));
    }


    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.combined", appContext.getPackageName());
    }

    @Test
    public void checkifFollowButtonHasFollowerText() {
        // Context of the app under test.
        onView(allOf(withId(R.id.follow), withText("Follow")));
    }

    @Test
    public void performClickTest() {
        // Context of the app under test.
        onView(withId(R.id.follow)).perform(click());
    }

    //@Rule public ActivityScenarioRule

//        onView(withText("Hi")).check(matches(isDisplayed()));

//        @Test
//        public void testLoginAttempt() {
//            Espresso.onView(ViewMatchers.withId(R.id.username)).perform(ViewActions.clearText()).perform(ViewActions.typeText("nonexistinguser@example.com"));
//            Espresso.onView(ViewMatchers.withId(R.id.password)).perform(ViewActions.clearText()).perform(ViewActions.typeText("invalidpassword"));
//
//            Intents.init();
//            Espresso.onView(ViewMatchers.withId(R.id.login_button)).perform(ViewActions.click());
//            Telephony.Sms.Intents.release();
//        }
}