package com.dohyun.pathfinder.data.remote

import android.content.Context
import com.dohyun.pathfinder.data.model.Cards
import org.json.JSONObject
import java.nio.charset.Charset

object JsonParser {

    fun getJSONData(context: Context): MutableList<Cards> {
//        val inputStreamReader = InputStreamReader(URL(url).openStream())
//        val bufferedReader = BufferedReader(inputStreamReader)
//        var line: String?
//        val buffer = StringBuffer()
//        while (bufferedReader.readLine().also { line = it } != null) {
//            buffer.append(line)
//        }
//        bufferedReader.close()
//        inputStreamReader.close()
//        val jsonData = buffer.toString()
//        val obj = JSONObject(jsonData)
//        return JsonReader.parseDataList(obj)
        val inputStreamReader = context.resources.assets.open("Data.json")
        val fileSize = inputStreamReader.available()
        val buffer = ByteArray(fileSize)
        inputStreamReader.read(buffer)
        inputStreamReader.close()

        val jsonData = String(buffer, Charset.defaultCharset())
        val obj = JSONObject(jsonData)
        return JsonReader.parseDataList(obj)
    }
}