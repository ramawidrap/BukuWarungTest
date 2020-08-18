package com.sibi.bukuwarungtest

import android.os.StrictMode
import android.os.StrictMode.VmPolicy
import com.sibi.bukuwarungtest.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val builder = VmPolicy.Builder()
        StrictMode.setVmPolicy(builder.build())
        return DaggerAppComponent.builder().getApp(this).build()
    }

}