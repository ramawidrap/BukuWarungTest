package com.sibi.bukuwarungtest.di

import com.sibi.bukuwarungtest.di.fragment_viewmodel.ListUserViewModelModule
import com.sibi.bukuwarungtest.di.fragment_viewmodel.ProfileViewModelModule
import com.sibi.bukuwarungtest.ui.ListUserFragment
import com.sibi.bukuwarungtest.ui.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector(modules = [ListUserViewModelModule::class])
    abstract fun contributeListUserFragment() : ListUserFragment

    @ContributesAndroidInjector(modules = [ProfileViewModelModule::class])
    abstract fun contributeProfileFragment() : ProfileFragment
}
