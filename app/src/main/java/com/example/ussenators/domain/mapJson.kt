package com.example.ussenators.domain

import android.content.Context
import java.io.IOException
import java.io.InputStream

fun mapJson(context: Context): String? {
    var inputStream: InputStream? = null
    val jsonString: String
    try {
        inputStream = context.assets.open("us_senators.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)

        jsonString = String(buffer)
        return jsonString
    } catch (e: IOException) {
        e.printStackTrace()
    } finally {
        inputStream?.close()
    }
    return null
}
