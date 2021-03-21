package com.twodev.learningenglishwords.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.twodev.learningenglishwords.data.locale.DataWordDao
import com.twodev.models.ItemModel

class Repository(private var wordDao: DataWordDao) {


    var itemWords = MutableLiveData<MutableList<ItemModel?>>()

    fun savinglocDb(item: ItemModel) {
        Log.d("tag1", "savinglocDb:  ${item.word1.toString()} ----- ${item.word2.toString()}")
        wordDao.insertItemWords(item)
    }

    fun getDataFromDb() {
        Log.d("tag1", "getDataFromDb: ${wordDao.getItemWords()} ")
        itemWords.value = wordDao.getItemWords()
    }

    fun deleteItem(item:ItemModel){
        wordDao.deleteItem(item)
    }
}