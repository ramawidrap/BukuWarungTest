package com.sibi.bukuwarungtest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.sibi.bukuwarungtest.R
import com.sibi.bukuwarungtest.model.User
import kotlinx.android.synthetic.main.fragment_detail_user.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class DetailUserFragment : Fragment() {

    private lateinit var user : User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        user = arguments?.getParcelable<User>("user") as User
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_detail_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        println(user.email)
        tv_name.text = "${user?.firstName} ${user?.lastName}"
        tv_email.text = user.email.toString()
        Glide.with(requireContext()).load(user.avatar).error(R.drawable.ic_launcher_background)
            .into(iv_avatar_userDetail)

        back.setOnClickListener {
            navController.popBackStack()
        }

    }

}
