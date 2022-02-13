package com.example.mvvmKotlinJetpackCompose.ui.TestLogin

import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.lifecycleScope
import com.example.mvvmKotlinJetpackCompose.R
import com.example.mvvmKotlinJetpackCompose.ui.base.BaseComponentActivity
import com.example.mvvmKotlinJetpackCompose.ui.dashboard.DashboardViewModel
import com.example.mvvmKotlinJetpackCompose.ui.theme.Shapes
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

}