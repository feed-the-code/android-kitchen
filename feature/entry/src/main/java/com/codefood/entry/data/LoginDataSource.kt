package com.codefood.entry.data

import com.codefood.arch.Result
import com.codefood.entry.data.model.LoggedInUser
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> = try {
        // TODO: handle loggedInUser authentication
        val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Jane Doe")
        Result.Success(fakeUser)
    } catch (e: Throwable) {
        Result.Error(cause = IOException("Error logging in", e))
    }

    fun logout() {
        // TODO: revoke authentication
    }
}
