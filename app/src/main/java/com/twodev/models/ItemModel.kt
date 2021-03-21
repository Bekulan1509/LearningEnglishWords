package com.twodev.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class ItemModel(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    var word1: String? = null,
    var word2: String? = null
)
