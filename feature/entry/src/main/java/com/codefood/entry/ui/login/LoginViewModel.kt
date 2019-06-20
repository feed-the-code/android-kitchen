package com.codefood.entry.ui.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codefood.arch.ResourceMessageException
import com.codefood.arch.Result
import com.codefood.arch.into
import com.codefood.entry.R
import com.codefood.entry.data.LoginRepository

typealias LoginResult = Result<LoggedInUserView>

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginValidation = MutableLiveData<LoginValidation>()
    val loginValidation: LiveData<LoginValidation> = _loginValidation

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(username: String, password: String) {
        // can be launched in a separate asynchronous job
        val result = loginRepository.login(username, password)

        _loginResult.value = result
            .map { LoggedInUserView(displayName = it.displayName) }
            .mapError { ResourceMessageException(R.string.login_failed) }
    }

    fun loginDataChanged(username: String, password: String) {

        fun validateUser(validation: LoginValidation) = with(validation) {
            Result.Success(
                if (!isUserNameValid(usernameResult.first))
                    copy(usernameResult = usernameResult.copy(second = R.string.invalid_username)) else this
            )
        }

        fun validatePassword(validation: LoginValidation) = with(validation) {
            Result.Success(
                if (!isPasswordValid(passwordResult.first))
                    copy(passwordResult = passwordResult.copy(second = R.string.invalid_password)) else this
            )
        }

        fun postResult(validation: LoginValidation) {
            _loginValidation.value = validation
        }

        LoginValidation.from(username, password) into ::validateUser then ::validatePassword run ::postResult
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}
