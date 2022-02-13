package com.example.mvvmKotlinJetpackCompose.ui.TestLogin

import androidx.activity.ComponentActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.example.mvvmKotlinJetpackCompose.R
import com.example.mvvmKotlinJetpackCompose.ui.BaseInstrument
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

@ExperimentalFoundationApi
class MainTestActivityTest: BaseInstrument() {
    @get : Rule
    val composeTestRule = createAndroidComposeRule(MainTestActivity::class.java)
    lateinit var activity: ComponentActivity
    override fun setUp() {
        activity = composeTestRule.activity
    }

    @Test
    fun show_loading_when_page_is_appear() {
        composeTestRule
            .onNodeWithTag(activity.getString(R.string.baseLoadingIcon))
            .assertIsDisplayed()
    }

    @Test
    fun current_name_entered() {
        composeTestRule
            .onNodeWithTag(activity.getString(R.string.check_name_button))
            .performClick()
        composeTestRule
            .onNodeWithTag(activity.getString(R.string.name_edit_box))
            .assertTextContains(activity.getString(R.string.current_name))
    }


}