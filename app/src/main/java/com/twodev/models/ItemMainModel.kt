package com.twodev.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "themes")
data class ItemMainModel(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    var theme: String? = null
)
