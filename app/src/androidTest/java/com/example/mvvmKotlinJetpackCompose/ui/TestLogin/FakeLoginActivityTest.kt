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
        val onNodeWithTag = composeTestRule
            .onNodeWithTag(activity.getString(R.string.jet_pck_icon))
            .performClick()

        composeTestRule
            .onNodeWithTag(activity.getString(R.string.login_title))
            .assertTextContains(activity.getString(R.string.changed_text_test))
    }
}