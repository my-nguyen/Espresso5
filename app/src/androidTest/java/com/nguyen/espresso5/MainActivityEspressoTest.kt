package com.nguyen.espresso5

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityEspressoTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun ensureTextChangesWork() {
        // Type text and then press the button.
        onView(withId(R.id.inputField))
            .perform(typeText("HELLO"), closeSoftKeyboard())
        onView(withId(R.id.changeText)).perform(click())

        // Check that the text was changed.
        onView(withId(R.id.inputField)).check(matches(withText("Lalala")))
    }

    @Test
    fun changeText_newActivity() {
        // Type text and then press the button.
        onView(withId(R.id.inputField)).perform(
            typeText("NewText"),
            closeSoftKeyboard()
        )
        onView(withId(R.id.switchActivity)).perform(click())

        // This view is in a different Activity, no need to tell Espresso.
        onView(withId(R.id.resultView)).check(matches(withText("NewText")))
    }
}