package com.sibi.bukuwarungtest.model

import android.os.Parcelable
import com.sibi.bukuwarungtest.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyProfile(
    val avatar: Int = R.drawable.my_avatar,
    val name: String = "Rama Widragama Putra",
    val email: String = "rama.widragama@ui.ac.id",
    val location: String = "Jakarta, Indonesia",
    val description: String = "Hey There. My Name Is Rama Widragama Putra, and I'm living in Jakarta. " +
            "I'm graduated computer science student in Universitas Indonesia. " +
            "I'm very interested and curious in mobile development. " +
            "I have experienced in developing mobile application using Native Framework including " +
            "Java and Kotlin, and Flutter Framework as well. Check my Resume for further information about me. Thank you!"

) : Parcelable