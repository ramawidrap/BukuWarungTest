package com.sibi.bukuwarungtest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sibi.bukuwarungtest.R
import com.sibi.bukuwarungtest.viewmodel.ListUserViewModel
import com.sibi.bukuwarungtest.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_list_user.*
import javax.inject.Inject

class ListUserFragment : DaggerFragment() {

    @Inject lateinit var viewModelFactory : ViewModelProvider.Factory

    private lateinit var listUserViewModel: ListUserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listUserViewModel = ViewModelProvider(this,viewModelFactory).get(ListUserViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listUserAdapter = ListUserAdapter(requireContext())
        listUserViewModel.getUsers().observe(this.viewLifecycleOwner, Observer {
            listUserAdapter.submitList(it)
            rv_list_user.apply {
                layoutManager = LinearLayoutManager(this@ListUserFragment.requireContext())
                adapter = listUserAdapter
            }
        })
    }


}
