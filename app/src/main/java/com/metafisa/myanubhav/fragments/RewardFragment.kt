package com.metafisa.myanubhav.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.metafisa.myanubhav.*

class RewardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_reward, container, false)


        val writeCompanyReview=v.findViewById<TextView>(R.id.write_reviewbtn)
        val contributeSalary=v.findViewById<TextView>(R.id.contribute_salarybtn)
        val shareInterviewTips=v.findViewById<TextView>(R.id.shareinterviewtips_btn)

        writeCompanyReview.setOnClickListener{

           val i=Intent(this@RewardFragment.requireContext(),RateYourCompany::class.java)
           startActivity(i)
        }

        contributeSalary.setOnClickListener{

            val i=Intent(this@RewardFragment.requireContext(),SubmitSalaries::class.java)
            startActivity(i)
        }

        shareInterviewTips.setOnClickListener{

            val i=Intent(this@RewardFragment.requireContext(),InterviewExperience::class.java)
            startActivity(i)
        }

        return v
    }
}