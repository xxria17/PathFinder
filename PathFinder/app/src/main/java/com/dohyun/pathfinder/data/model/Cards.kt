package com.dohyun.pathfinder.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cards(
    val text: String?,
    val image_url: String?
) {
    @PrimaryKey(autoGenerate = true) var id : Int = 0
}
