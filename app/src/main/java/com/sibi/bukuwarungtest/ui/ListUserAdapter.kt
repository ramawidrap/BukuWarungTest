package com.sibi.bukuwarungtest.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sibi.bukuwarungtest.R
import com.sibi.bukuwarungtest.model.User
import com.sibi.bukuwarungtest.viewmodel.ListUserViewModel
import kotlinx.android.synthetic.main.component_list_user.view.*
import java.util.*

class ListUserAdapter(private val context: Context, private val navController: NavController) :
    PagedListAdapter<User, ListUserAdapter.ListUserViewHolder>(User.CALLBACK) {
    val isEndOfList = false

    companion object {
        val CELL = 0
        val LOAD_MORE = 1
    }


    class ListUserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val avatar = itemView.iv_avatar
        val name = itemView.tv_name
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListUserViewHolder {
        return ListUserViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.component_list_user,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ListUserViewHolder, position: Int) {

        val user = getItem(position)
        Glide.with(context).load(user?.avatar).error(R.drawable.ic_launcher_background).placeholder(R.drawable.placeholder)
            .into(holder.avatar)
        holder.name.text = "${user?.firstName} ${user?.lastName}"

        holder.itemView.setOnClickListener {
            val bundle = bundleOf("user" to user)
            navController.navigate(R.id.action_dashboardFragment2_to_detailUserFragment,bundle)

        }


    }


}