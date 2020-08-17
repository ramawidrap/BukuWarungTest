package com.sibi.bukuwarungtest.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sibi.bukuwarungtest.R
import com.sibi.bukuwarungtest.model.User
import kotlinx.android.synthetic.main.component_list_user.view.*

class ListUserAdapter(private val context : Context)  : PagedListAdapter<User,ListUserAdapter.ListUserViewHolder>(User.CALLBACK){

    class ListUserViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val avatar = itemView.iv_avatar
        val name = itemView.tv_name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListUserViewHolder {
        return ListUserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.component_list_user,parent,false))
    }

    override fun onBindViewHolder(holder: ListUserViewHolder, position: Int) {
        val user = getItem(position)
        Glide.with(context).load(user!!.avatar).error(R.drawable.ic_launcher_background).into(holder.avatar)
        holder.name.text = "${user.firstName} ${user.lastName}"
    }
}