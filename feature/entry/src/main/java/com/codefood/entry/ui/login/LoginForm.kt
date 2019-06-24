package com.codefood.entry.ui.login

import android.content.Context
import android.util.Patterns
import com.codefood.entry.R
import com.codefood.util.validation.Field
import com.codefood.util.validation.Form
import com.codefood.util.validation.Rule

class LoginForm(context: Context) : Form {
    val username = Field.required<String> {
        rules {
            message = "Username is required"
            +Rule<String> { input ->
                context.getString(R.string.invalid_username)
                    .takeIf { input.contains('@') && !Patterns.EMAIL_ADDRESS.matcher(input).matches() }
            }
        }
    }
    val password = Field.required<String> {
        rules {
            message = "Password is required"
            +Rule<String> { input ->
                context.getString(R.string.invalid_password)
                    .takeIf { input.length < 6 }
            }
        }
    }
}