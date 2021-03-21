package com.twodev.learningenglishwords.data.locale.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.twodev.models.ItemMainModel
import com.twodev.models.ItemModel

data class ThemesAndWords(
    @Embedded val mainModel: ItemMainModel,
    @Relation(
        parentColumn = "id",
        entityColumn = ""
    )

    val itemModel: ItemModel
)
