package com.nguyen.espresso5

import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EspressoTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun buttonShouldUpdateText() {
        Espresso.onView(withId(R.id.update)).perform(ViewActions.click())

        // use InstrumentationRegistry.getTargetContext() to find a resource ID
        Espresso.onView(withId(getResourceId("click")))
            .check(ViewAssertions.matches(ViewMatchers.withText("Done")))
    }

    private fun getResourceId(s: String): Int {
        val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
        val packageName = targetContext.packageName
        return targetContext.resources.getIdentifier(s, "id", packageName)
    }
}