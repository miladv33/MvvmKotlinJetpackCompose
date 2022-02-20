package com.example.mvvmKotlinJetpackCompose.ui.TestLogin

import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.mvvmKotlinJetpackCompose.R
import com.example.mvvmKotlinJetpackCompose.ui.base.BaseComponentActivity
import com.example.mvvmKotlinJetpackCompose.ui.dashboard.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainTestActivity : BaseComponentActivity<DashboardViewModel>() {


    override val viewModel: DashboardViewModel by viewModels()
    val text = MutableStateFlow("text")

    @Composable
    override fun ProvideCompose() {
        val myText = text.collectAsState()
        Row {
            TextField(value = myText.value, onValueChange = {

            }, modifier = Modifier.testTag(getString(R.string.name_edit_box)))

            Button(
                onClick = {
                    lifecycleScope.launch {

                        text.emit(getString(R.string.current_name))
                    }
                },
                modifier = Modifier.testTag(getString(R.string.check_name_button))
            ) {

            }
        }
    }

    @Composable
    override fun ProvideComposeLightPreview() {

    }


    @Preview
    @Composable
    fun TestColumn() {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
            Box(
                modifier = Modifier
                    .background(Color.White), contentAlignment = Alignment.Center
            ) {
                Box(modifier = Modifier.size(30.dp).background(Color.Green))
                Text(text = "iran", modifier = Modifier.padding(start = 10.dp, end = 10.dp))

            }
        }

    }
}