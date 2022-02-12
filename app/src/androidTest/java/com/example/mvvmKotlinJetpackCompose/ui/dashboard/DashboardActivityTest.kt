package com.example.mvvmKotlinJetpackCompose.ui.dashboard

import androidx.activity.ComponentActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.mvvmKotlinJetpackCompose.R
import com.example.mvvmKotlinJetpackCompose.ui.BaseInstrument
import com.example.mvvmKotlinJetpackCompose.ui.login.LoginActivity
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalFoundationApi
class DashboardActivityTest :BaseInstrument(){


    @get : Rule
    val composeTestRule = createAndroidComposeRule(DashboardActivity::class.java)
    lateinit var activity: ComponentActivity

    @Before
    override fun setUp(){
        activity=composeTestRule.activity
    }


    @Test
    fun click_On_Icon_And_Show_A_Dialog(){
        composeTestRule
            .onNodeWithTag(activity.getString(R.string.jet_pck_icon))
            .performClick()
            .assertIsDisplayed()

    }

}