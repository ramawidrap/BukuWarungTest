package com.sibi.bukuwarungtest.di

import com.sibi.bukuwarungtest.ui.ListUserFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeListUserFragment() : ListUserFragment
}
