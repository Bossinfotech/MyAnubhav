package com.metafisa.myanubhav.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.activity.OnBackPressedCallback
import androidx.core.os.trace
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import com.metafisa.myanubhav.CompanyReview
import com.metafisa.myanubhav.MainActivity
import com.metafisa.myanubhav.R
import com.metafisa.myanubhav.fragments.SalaryCalculatorFragment

class ExploreFragment : Fragment() {

      @SuppressLint("UseRequireInsteadOfGet")
      override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val v = inflater.inflate(R.layout.fragment_explore, container, false)

          val interviewPrep = v.findViewById<ImageButton>(R.id.interviewPreparation)

          interviewPrep.setOnClickListener {
              val interviewPreprationFragment = InterviewPreprationFragment()
              val transaction = activity!!.supportFragmentManager.beginTransaction()
              transaction.replace(R.id.container,interviewPreprationFragment)
              transaction.commit()
          }

          val latestJobs = v.findViewById<ImageButton>(R.id.latestJobs)

          latestJobs.setOnClickListener {

              val latestJobsFragment = ExploreLatestJobsFragment()
              val transaction = activity!!.supportFragmentManager.beginTransaction()
              transaction.replace(R.id.container,latestJobsFragment)
              transaction.commit()
          }

          val salary = v.findViewById<ImageButton>(R.id.salaries)

          salary.setOnClickListener {

              val salaryFragment = SalaryFragment()
              val transaction = activity!!.supportFragmentManager.beginTransaction()
              transaction.replace(R.id.container,salaryFragment)
              transaction.commit()
          }

          val salaryCalculator = v.findViewById<ImageButton>(R.id.salaryCalculation)

          salaryCalculator.setOnClickListener {

              val salaryCalculatorFragment = SalaryCalculatorFragment()
              val transaction = activity!!.supportFragmentManager.beginTransaction()
              transaction.replace(R.id.container,salaryCalculatorFragment)
              transaction.commit()
          }

          val companyReview = v.findViewById<ImageButton>(R.id.companyReview)
          companyReview.setOnClickListener {
              val intent = Intent (this@ExploreFragment.context, CompanyReview::class.java)
              startActivity(intent)
          }

          return v

    }
}
