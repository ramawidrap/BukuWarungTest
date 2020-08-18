package com.sibi.bukuwarungtest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sibi.bukuwarungtest.R
import kotlinx.android.synthetic.main.fragment_pdf_view.*

/**
 * A simple [Fragment] subclass.
 */
class PdfViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pdf_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        back_pdfView.setOnClickListener {
            navController.popBackStack()
        }
        pdfView.fromAsset("CV_Rama Widragama Putra.pdf").load()

    }

}
