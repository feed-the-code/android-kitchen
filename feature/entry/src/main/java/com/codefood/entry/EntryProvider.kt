package com.codefood.entry

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.util.Log
import com.codefood.kitchen.koinApp
import com.codefood.kitchen.feature.AuthFeature
import okhttp3.Interceptor

class EntryProvider : ContentProvider() {

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int = 0

    override fun getType(uri: Uri): String? = null

    override fun insert(uri: Uri, values: ContentValues?): Uri? = null

    override fun onCreate(): Boolean {
        Log.i("EntryProvider", "Initializing...")
        koinApp.koin.apply {
            declare<AuthFeature>(FeatureImpl)
            declare(AuthInterceptor(), secondaryTypes = listOf(Interceptor::class))
        }
        return true
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? = null

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int = 0
}
