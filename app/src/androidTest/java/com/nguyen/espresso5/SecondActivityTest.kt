package com.nguyen.espresso5

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SecondActivityTest {

    // third parameter is set to false which means the activity is not started automatically
    @get:Rule
    val rule = ActivityTestRule(SecondActivity::class.java, true, false)
    // val activityRule = ActivityScenarioRule(SecondActivity::class.java)

    @Test
    fun demonstrateIntentPrep() {
        val intent = Intent()
        intent.putExtra("EXTRA", "Test")
        rule.launchActivity(intent)
        onView(withId(R.id.resultView)).check(matches(withText("Test")))
    }
}