package com.example.mvvmKotlinJetpackCompose

import android.os.Bundle
import androidx.test.runner.MonitoringInstrumentation
import cucumber.api.CucumberOptions


@io.cucumber.junit.CucumberOptions(features = ["features"], glue = ["com.example.mvvmKotlinJetpackCompose"])
class TestRunner : MonitoringInstrumentation() {

    override fun onCreate(arguments: Bundle) {
        super.onCreate(arguments)
        val tags: String = BuildConfig.TEST_TAGS
        if (tags.isNotEmpty()) {
            arguments.putString(
                "tags",
                tags.replace(",".toRegex(), "--").replace("\\s".toRegex(), "")
            )
        }
        start()
    }

    override fun onStart() {
        super.onStart()
        waitForIdleSync()
    }
}
