package com.dohyun.pathfinder.data.remote

import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL

object JsonParser {

    fun getJSONFromUrl(url : String): JSONObject {
        var obj = JSONObject()
        try {
            val address = URL(url)

            val inputStream = address.openStream()
            val inputStreamReader = InputStreamReader(inputStream)
            val reader = BufferedReader(inputStreamReader)

            val buffer = StringBuffer()
            var line = reader.readLine()
            while (line != null) {
                buffer.append(line + "\n")
                line = reader.readLine()
            }

            val jsonData = buffer.toString()

            obj = JSONObject(jsonData)
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return obj
    }
}