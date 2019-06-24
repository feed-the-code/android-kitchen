package com.codefood.arch

import androidx.annotation.StringRes

/**
 * Exception which message is a string resource.
 * Do not confuse with error on getting resources.
 * @param resource
 */
class ResourceMessageException(@StringRes val resource: Int): Exception()