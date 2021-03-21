package com.twodev.learningenglishwords.di

import com.twodev.learningenglishwords.provideDataWordDao
import com.twodev.learningenglishwords.provideDb
import com.twodev.learningenglishwords.repository.Repository
import com.twodev.learningenglishwords.ui.ItemsActivity.ItemsViewModel
import com.twodev.learningenglishwords.ui.PutDataActivity.PutDataViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var dbModule = module {
    single { provideDb(androidContext()) }
    single { provideDataWordDao(get()) }
}
var repositoryModule = module {
    factory { Repository(get()) }
}
var viewModuleModule = module {
    viewModel { ItemsViewModel(get()) }
    viewModel { PutDataViewModel(get()) }
}