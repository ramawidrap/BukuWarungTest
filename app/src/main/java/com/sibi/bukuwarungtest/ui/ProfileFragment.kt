package com.sibi.bukuwarungtest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.sibi.bukuwarungtest.R
import com.sibi.bukuwarungtest.model.MyProfile
import com.sibi.bukuwarungtest.viewmodel.MyProfileViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_profile.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var myProfileViewModel: MyProfileViewModel

    var isModeEdit = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = requireActivity().findNavController(R.id.fragment)
        myProfileViewModel =
            ViewModelProvider(this, viewModelFactory).get(MyProfileViewModel::class.java)
        button_resume.setOnClickListener {
            navController.navigate(R.id.action_dashboardFragment2_to_pdfViewFragment)
        }

        myProfileViewModel.getMyProfile().observe(this.viewLifecycleOwner, Observer { profile ->
            tv_email.setText(profile.email)
            tv_MyName.setText(profile.name)
            tv_location.setText(profile.location)
            tv_descripton.setText(profile.description)
        })

        edit_profile.setOnClickListener {
            isModeEdit = !isModeEdit
            tv_descripton.isEnabled = isModeEdit
            tv_location.isEnabled = isModeEdit
            tv_email.isEnabled = isModeEdit
            tv_MyName.isEnabled = isModeEdit
            tv_descripton.isEnabled = isModeEdit
            if (isModeEdit) {
                edit_profile.setBackgroundResource(R.drawable.ic_save)
                tv_email.requestFocus()
            } else {
                myProfileViewModel.editProfile(
                    MyProfile(
                        name = tv_MyName.text.toString(),
                        email = tv_email.text.toString(),
                        location = tv_location.text.toString(),
                        description = tv_descripton.text.toString()
                    )
                )
                edit_profile.setBackgroundResource(R.drawable.ic_edit_)
            }
        }
    }

}
