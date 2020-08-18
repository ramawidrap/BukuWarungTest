package com.sibi.bukuwarungtest.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sibi.bukuwarungtest.viewmodel.ListUserViewModel
import com.sibi.bukuwarungtest.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory (viewModelFactory: ViewModelFactory) : ViewModelProvider.Factory
}