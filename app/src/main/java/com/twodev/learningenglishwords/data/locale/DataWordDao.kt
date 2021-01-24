package com.twodev.learningenglishwords.data.locale

import android.content.ClipData
import androidx.room.*
import com.twodev.models.ItemMainModel
@Dao
interface DataWordDao {
    @Query("SELECT*FROM words")
     fun getItemWords(): MutableList<ItemMainModel?>

     @Delete
     fun deleteItem(item:ItemMainModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertItemWords(items: ItemMainModel)
}