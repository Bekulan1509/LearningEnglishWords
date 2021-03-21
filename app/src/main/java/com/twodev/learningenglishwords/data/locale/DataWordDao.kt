package com.twodev.learningenglishwords.data.locale

import androidx.room.*
import com.twodev.models.ItemModel
@Dao
interface DataWordDao {
    @Query("SELECT*FROM words")
     fun getItemWords(): MutableList<ItemModel?>

     @Delete
     fun deleteItem(item:ItemModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertItemWords(items: ItemModel)
}