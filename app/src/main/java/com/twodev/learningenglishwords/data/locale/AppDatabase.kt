package com.twodev.learningenglishwords.data.locale

import androidx.room.Database
import androidx.room.RoomDatabase
import com.twodev.models.ItemMainModel
import com.twodev.models.ItemModel

@Database(entities = [ItemModel::class,ItemMainModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataWordDao() : DataWordDao?
}