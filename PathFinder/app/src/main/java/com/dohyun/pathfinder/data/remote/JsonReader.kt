package com.dohyun.pathfinder.data.remote

import com.dohyun.pathfinder.data.model.Cards
import org.json.JSONObject

object JsonReader {

    fun parseDataList(jsonObject: JSONObject): MutableList<Cards> {
        return jsonObject.getJSONArray("items")
            .run {
                mutableListOf<Cards>()
                    .apply {
                        for (i in 0 until length()) {
                            add(parseContent(getJSONObject(i)))
                        }
                    }
            }
    }

    private fun parseContent(jsonObject: JSONObject): Cards {
        return jsonObject.run {
            Cards(
                if (has("text")) getString("text") else null,
                if (has("image_url")) getString("image_url") else null
            )
        }
    }
}