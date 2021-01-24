package com.twodev.learningenglishwords

import android.content.Context
import androidx.room.Room
import com.twodev.learningenglishwords.data.locale.AppDatabase
import com.twodev.learningenglishwords.data.locale.DataWordDao

fun provideDb(context: Context): AppDatabase {
    return Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "app_database"
    ).allowMainThreadQueries().build()
}

fun provideDataWordDao(db: AppDatabase): DataWordDao? = db.dataWordDao()
