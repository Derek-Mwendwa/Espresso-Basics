package com.example.espressobasics

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EspressoBasicsTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testGreetingIsDisplayedOnAppLaunch() {
        onView(withText(R.string.greeting))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testInputIsCorrectlyDisplayed() {
        val inputText = "Jetbrains Academy"
        val expectedText = "JETBRAINS ACADEMY"

        onView(withId(R.id.et_text))
            .perform(typeText(inputText), closeSoftKeyboard())

        onView(withId(R.id.rb_uppercase))
            .perform(click())

        onView(withId(R.id.bt_display))
            .perform(click())

        onView(withId(R.id.tv_display))
            .check(matches(withText(expectedText)))
    }
}