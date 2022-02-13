package com.example.mvvmKotlinJetpackCompose.ui.TestLogin

import android.content.Intent
import android.content.res.Configuration
import androidx.activity.viewModels
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.mvvmKotlinJetpackCompose.R
import com.example.mvvmKotlinJetpackCompose.data.network.DataError
import com.example.mvvmKotlinJetpackCompose.data.network.Success
import com.example.mvvmKotlinJetpackCompose.ui.base.BaseComponentActivity
import com.example.mvvmKotlinJetpackCompose.ui.dashboard.DashboardActivity
import com.example.mvvmKotlinJetpackCompose.ui.login.LoginViewModel
import com.example.mvvmKotlinJetpackCompose.ui.theme.CoinTheme
import com.example.mvvmKotlinJetpackCompose.ui.theme.Shapes
import com.example.mvvmKotlinJetpackCompose.util.observe
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FakeLoginActivity : BaseComponentActivity<LoginViewModel>() {


    override val viewModel: LoginViewModel by viewModels()

//    @Inject
//    lateinit var registrationComponent: RegistrationComponent
//    val toDoRepository = EntryPoints
//        .get(registrationComponent, RegistrationComponentEntryPoint::class.java)
//        .getRegistrationRepo()


    @Composable
    override fun ProvideCompose() {

        observe(viewModel.loginResponse) {
            when (it) {
                is DataError -> {
                }
                is Success -> {
                    startDashboardAcitivty()
                    finish()
                }


            }
        }

        LoginCompose {
            TopImageAndText()
            var txtAccountNo by remember {
                mutableStateOf("suorizwansayyed786@gmail.com")
            }

            TextFieldUserName(txtAccountNo) { txtAccountNo = it }
            var txtPass by remember { mutableStateOf("SuoRizwan") }

            TextFieldPassword(txtPass) {
                txtPass = it
            }

            RegistrationButton {
                viewModel.onSignInBtnClick(
                    txtAccountNo.trim(),
                    txtPass.trim()
                )
            }


        }

    }

    @Composable
    private fun RegistrationButton(onClick: () -> Unit = {}) {

        Button(modifier = Modifier
            .testTag(stringResource(id = R.string.sign_in))
            .width(dimensionResource(R.dimen.dp_150)),
            colors = ButtonDefaults
                .buttonColors(MaterialTheme.colors.secondary),
            onClick = { onClick() }) {

            Text(text = stringResource(id = R.string.sign_in).uppercase())
        }

        Spacer(
            modifier = Modifier
                .height(dimensionResource(R.dimen.dp_30))
        )


    }


    @Composable
    private fun TextFieldPassword(txtPass: String, setPass: (String) -> Unit = {}) {


        TextField(modifier = Modifier
            .testTag(stringResource(R.string.password))
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                shape = Shapes.medium,
                color = MaterialTheme.colors.secondary
            ),
            maxLines = 1,
            singleLine = true,
            value = txtPass,
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = { setPass(it) },
            placeholder = {
                Text(
                    text = stringResource(R.string.password),
                    color = MaterialTheme.colors.onSecondary
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.onSecondary,
                disabledTextColor = Color.Transparent,
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                cursorColor = MaterialTheme.colors.onSecondary
            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_baseline_lock_24),
                    contentDescription = "", tint = MaterialTheme.colors.onSecondary,
                    modifier = Modifier.testTag(getString((R.string.password_icon)))
                        .clickable(onClick = {
                            lifecycleScope.launch {
                                text.emit(getString(R.string.this_is_password_icon))
                            }
                        })

                )
            })

        Spacer(
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.dp_40))
        )


    }

    val text = MutableStateFlow("A demo App using kotlin, Mvvm, jetpack Compose, Unit testing")

    @Composable
    private fun TopImageAndText() {
        Image(
            modifier = Modifier
                .padding(top = dimensionResource(id = R.dimen.dp_100))
                .size(dimensionResource(id = R.dimen.dp_100))
                .testTag(stringResource(id = R.string.jet_pck_icon))
                .clickable(onClick = {
                    lifecycleScope.launch {
                        text.emit(getString(R.string.changed_text_test))
                        text
                    }
                }),
            painter = painterResource(id = R.drawable.jetpack_logo),
            contentDescription = "",

        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dp_10)))
        val myText by text.collectAsState()
        Text(
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .testTag(stringResource(id = R.string.login_title)),
            textAlign = TextAlign.Center,
            text = myText,
            style = MaterialTheme.typography.button,
            color = MaterialTheme.colors.secondary
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dp_100)))


    }

    @Composable
    private fun TextFieldUserName(txtAccountNo: String, setAcc: (String) -> Unit = {}) {


        TextField(modifier = Modifier
            .testTag(stringResource(R.string.email_address))
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                shape = Shapes.medium,
                color = MaterialTheme.colors.secondary
            ),
            maxLines = 1,
            singleLine = true,
            value = txtAccountNo,
            onValueChange = { setAcc(it) },
            placeholder = {
                Text(
                    text = stringResource(R.string.email_address),
                    color = MaterialTheme.colors.onSecondary
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.onSecondary,
                disabledTextColor = Color.Transparent,
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                cursorColor = MaterialTheme.colors.onSecondary

            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_baseline_person_24),
                    contentDescription = "", tint = MaterialTheme.colors.onSecondary,
                    modifier = Modifier
                        .testTag(getString(R.string.email_icon))
                        .clickable(
                        onClick = {
                            lifecycleScope.launch {
                                text.emit(getString( R.string.this_is_email_icon))
                            }
                        })
                )
            })
        Spacer(
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.dp_20))
        )


    }

    private fun startDashboardAcitivty() {
        startActivity(Intent(this, DashboardActivity::class.java))
    }

    @Composable
    fun LoginCompose(childrenCompose: @Composable () -> Unit) {


        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.dp_20)),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            childrenCompose()
        }


    }

    @Preview(
        showBackground = true,
        uiMode = Configuration.UI_MODE_NIGHT_NO
    )
    @Composable
    override fun ProvideComposeLightPreview() {
        CoinTheme {
            LoginCompose {

                TopImageAndText()
                TextFieldUserName("")
                TextFieldPassword("")
                RegistrationButton()

            }

        }
    }


}