package com.sibi.bukuwarungtest.di.fragment_viewmodel

import androidx.lifecycle.ViewModel
import com.sibi.bukuwarungtest.di.ViewModelKey
import com.sibi.bukuwarungtest.viewmodel.ListUserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ListUserViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ListUserViewModel::class)
    abstract fun bindListUserViewModel(listUserViewModel: ListUserViewModel) : ViewModel
}