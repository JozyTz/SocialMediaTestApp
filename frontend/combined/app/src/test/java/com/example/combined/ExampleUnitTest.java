package com.example.combined;

import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.rules.ExternalResource;



import static org.junit.Assert.*;

//import androidx.test.espresso.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

//@RunWith(AndroidJUnit4.class)
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);

    }
    @Test
    public void emailValidation() {
        assertTrue(SignUpActivity.EmailValidation("name@gmail.com"));

    }
    @Test
    public void emailValidation2() {
        assertFalse(SignUpActivity.EmailValidation("name@gmailcom"));

    }
    @Test
    public void emailValidation3() {
        assertFalse(SignUpActivity.EmailValidation("namegmail.com"));

    }

//
//    @Rule
//    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);
//

//    @Test
//    public void activityTest() {
//        onView(withText("Hi")).check(matches(isDisplayed()));
//
//
//
//    }

}
