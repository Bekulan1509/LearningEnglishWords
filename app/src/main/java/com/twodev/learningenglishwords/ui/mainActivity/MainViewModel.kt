package com.twodev.learningenglishwords.ui.mainActivity

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.twodev.learningenglishwords.repository.Repository
import com.twodev.models.ItemMainModel


class MainViewModel(private var repository: Repository): ViewModel() {
    var item:ItemMainModel? = null
    var itemWordsLiveData = MutableLiveData<MutableList<ItemMainModel?>>()
    init {
        item?.let { fetchWords(it) }
        fetchGetWords()
        item?.let { delateItem(it) }
    }

     fun fetchWords(item:ItemMainModel) {
        repository.savinglocDb(item)
    }

    fun fetchGetWords() {
        repository.itemWords.observeForever{
            Log.d("tag2", "fetchGetWords: $it ")
            itemWordsLiveData.value = it

        }
        repository.getDataFromDb()
    }

    fun delateItem(item: ItemMainModel){
        repository.deleteItem(item)
    }


}

