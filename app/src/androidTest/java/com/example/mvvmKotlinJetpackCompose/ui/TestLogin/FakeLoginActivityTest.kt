package com.example.mvvmKotlinJetpackCompose.ui.TestLogin

import androidx.activity.ComponentActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.example.mvvmKotlinJetpackCompose.R
import com.example.mvvmKotlinJetpackCompose.ui.BaseInstrument
import org.junit.Rule
import org.junit.Test

@ExperimentalFoundationApi
class FakeLoginActivityTest : BaseInstrument() {

    @get : Rule
    val composeTestRule = createAndroidComposeRule(FakeLoginActivity::class.java)
    lateinit var activity: ComponentActivity

    override fun setUp() {
        activity = composeTestRule.activity
    }

    @Test
    fun change_text_when_click_on_image() {
        composeTestRule
            .onNodeWithTag(activity.getString(R.string.jet_pck_icon))
            .performClick()

        composeTestRule
            .onNodeWithTag(activity.getString(R.string.login_title))
            .assertTextContains(activity.getString(R.string.changed_text_test))
    }

    @Test
    fun when_click_on_email_icon_change_text_to_say_this_is_email() {
        composeTestRule
            .onNodeWithTag(activity.getString((R.string.email_icon)))
            .performClick()
        composeTestRule
            .onNodeWithTag(activity.getString(R.string.login_title))
            .assertTextContains(activity.getString(R.string.this_is_email_icon))
    }

    @Test
    fun when_click_on_password_icon_change_text_to_say_this_is_password() {
        composeTestRule
            .onNodeWithTag(activity.getString((R.string.password_icon)))
            .performClick()
        composeTestRule
            .onNodeWithTag(activity.getString(R.string.login_title))
            .assertTextContains(activity.getString(R.string.this_is_password_icon))
    }
}