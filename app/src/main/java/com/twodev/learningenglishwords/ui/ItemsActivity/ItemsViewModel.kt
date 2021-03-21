package com.twodev.learningenglishwords.ui.ItemsActivity

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.twodev.learningenglishwords.repository.Repository
import com.twodev.models.ItemModel


class ItemsViewModel(private var repository: Repository): ViewModel() {
    var item:ItemModel? = null
    var itemWordsLiveData = MutableLiveData<MutableList<ItemModel?>>()
    init {
        item?.let { fetchWords(it) }
        fetchGetWords()
        item?.let { delateItem(it) }
    }

     fun fetchWords(item:ItemModel) {
        repository.savinglocDb(item)
    }

    fun fetchGetWords() {
        repository.itemWords.observeForever{
            Log.d("tag2", "fetchGetWords: $it ")
            itemWordsLiveData.value = it
        }
        repository.getDataFromDb()
    }

    fun delateItem(item: ItemModel){
        repository.deleteItem(item)
    }


}

