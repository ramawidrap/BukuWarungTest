package com.sibi.bukuwarungtest.di.fragment_viewmodel

import androidx.lifecycle.ViewModel
import com.sibi.bukuwarungtest.di.ViewModelKey
import com.sibi.bukuwarungtest.viewmodel.MyProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ProfileViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MyProfileViewModel::class)
    abstract fun bindProfileViewModel(myProfileViewModel: MyProfileViewModel) : ViewModel
}