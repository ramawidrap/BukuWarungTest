package com.sibi.bukuwarungtest.model


import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName  = "users")
data class User(
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
    val firstName: String,

    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @SerializedName("last_name")
    val lastName: String
) {
    companion object {
        val CALLBACK = object  : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id== newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return true
            }

        }
    }
}