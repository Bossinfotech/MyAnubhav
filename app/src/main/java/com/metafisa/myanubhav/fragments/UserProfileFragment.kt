package com.metafisa.myanubhav.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.metafisa.myanubhav.InterviewExperience
import com.metafisa.myanubhav.R
import com.metafisa.myanubhav.RateYourCompany
import com.metafisa.myanubhav.SubmitSalaries
class UserProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_user_profile, container, false)

        val addEmployeeDetails : TextView = v.findViewById(R.id.addEmployeeDetail)
        addEmployeeDetails.setOnClickListener {

            val bottomSheetFragment = BottomSheetFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container,bottomSheetFragment)
            transaction.commit()
        }

        val interviewQuestion : TextView =v.findViewById(R.id.interview_question)
        interviewQuestion.setOnClickListener {

            val intent=Intent(context,InterviewExperience::class.java)
            startActivity(intent)
        }

        val submitSalary : TextView =v.findViewById(R.id.submitSalary)
        submitSalary.setOnClickListener {

            val intent=Intent(context,SubmitSalaries::class.java)
            startActivity(intent)

        }

        val rateYourCompany : TextView = v.findViewById(R.id.rateYourCompany)
        rateYourCompany.setOnClickListener {

            val intent=Intent(context,RateYourCompany::class.java)
            startActivity(intent)

        }

        return v
    }

}