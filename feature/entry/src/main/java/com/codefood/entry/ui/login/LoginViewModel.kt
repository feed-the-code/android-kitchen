package com.codefood.entry.ui.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.codefood.arch.ResourceMessageException
import com.codefood.arch.Result
import com.codefood.entry.R
import com.codefood.entry.data.LoginRepository
import kotlinx.coroutines.launch

typealias LoginResult = Result<LoggedInUserView>

class LoginViewModel(
    private val loginRepository: LoginRepository,
    application: Application
) : AndroidViewModel(application) {

    val form = LoginForm(application.applicationContext)

    private val _loginEnabled = MutableLiveData<Boolean>()
    val loginEnabled: LiveData<Boolean> = _loginEnabled

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login() {
        val username = form.username.value ?: return
        val password = form.password.value ?: return
        // can be launched in a separate asynchronous job
        viewModelScope.launch {
            val result = loginRepository.login(username, password)

            _loginResult.value = result
                .map { LoggedInUserView(displayName = it.displayName) }
                .mapError { ResourceMessageException(R.string.login_failed) }
        }
    }

    fun loginDataChanged() {
        _loginEnabled.value = form.isValid
    }
}
