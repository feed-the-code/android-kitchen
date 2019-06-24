package com.codefood.entry.ui.login

/**
 * Data validation state of the login form.
 */
data class LoginValidation(
    val usernameResult: Pair<String, Int?>,
    val passwordResult: Pair<String, Int?>
) {
    val isValid
        get() = usernameResult.second == null && passwordResult.second == null

    companion object {
        fun from(username: String, password: String) = LoginValidation(username to null, password to null)
    }
}
