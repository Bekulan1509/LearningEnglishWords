package com.twodev.learningenglishwords.ui.PutDataActivity

import androidx.lifecycle.ViewModel
import com.twodev.learningenglishwords.repository.Repository
import com.twodev.models.ItemModel

class PutDataViewModel(private var repository: Repository) : ViewModel() {

    fun fetchWords(item: ItemModel) {
        repository.savinglocDb(item)
    }
}