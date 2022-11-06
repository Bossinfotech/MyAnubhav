package com.metafisa.myanubhav.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.metafisa.myanubhav.CompanyReview
import com.metafisa.myanubhav.R
import com.metafisa.myanubhav.RateYourCompany

class RewardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_reward, container, false)


        val writeReview=v.findViewById<TextView>(R.id.write_reviewbtn)

        writeReview.setOnClickListener{

           val i=Intent(this@RewardFragment.requireContext(),RateYourCompany::class.java)
           startActivity(i)


        }
        return v
    }
}