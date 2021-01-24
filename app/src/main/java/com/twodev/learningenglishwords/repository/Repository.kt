package com.twodev.learningenglishwords.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.twodev.learningenglishwords.data.locale.DataWordDao
import com.twodev.models.ItemMainModel

class Repository(private var wordDao: DataWordDao) {


    var itemWords = MutableLiveData<MutableList<ItemMainModel?>>()

    fun savinglocDb(item: ItemMainModel) {
        Log.d("tag1", "savinglocDb:  ${item.word1} ----- ${item.word2}")
        wordDao.insertItemWords(item)
    }

    fun getDataFromDb() {
        Log.d("tag1", "getDataFromDb: ${wordDao.getItemWords()} ")
        itemWords.value = wordDao.getItemWords()
    }

    fun deleteItem(item:ItemMainModel){
        wordDao.deleteItem(item)
    }
}