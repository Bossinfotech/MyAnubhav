package com.metafisa.myanubhav.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.metafisa.myanubhav.R


@Suppress("NAME_SHADOWING")

class ExploreFragment : Fragment() {

      @SuppressLint("UseRequireInsteadOfGet")
      override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
         val v = inflater.inflate(R.layout.fragment_explore, container, false)

          val interviewPrepration : TextView=v.findViewById(R.id.interviewpreparation)

          interviewPrepration.setOnClickListener{

              val interviewPreprationFragment=InterviewPreprationFragment()
              val transaction=requireActivity().supportFragmentManager.beginTransaction()
              transaction.replace(R.id.container,interviewPreprationFragment)
              transaction.commit()
          }

          val companyReview:TextView=v.findViewById(R.id.companyreview)

          companyReview.setOnClickListener{

              val companyReviewFragment=CompanyReviewFragment()
              val transaction=requireActivity().supportFragmentManager.beginTransaction()
              transaction.replace(R.id.container,companyReviewFragment)
              transaction.commit()
          }
          val latestJobs:TextView=v.findViewById(R.id.latestjobs)

          latestJobs.setOnClickListener{

              val latestJobsFragment=ExploreLatestJobsFragment()
              val transaction=requireActivity().supportFragmentManager.beginTransaction()
              transaction.replace(R.id.container,latestJobsFragment)
              transaction.commit()

          }

          val companySalary:TextView=v.findViewById(R.id.salary)

          companySalary.setOnClickListener{

              val salariesFragment=SalariesFragment()
              val transaction=requireActivity().supportFragmentManager.beginTransaction()
              transaction.replace(R.id.container,salariesFragment)
              transaction.commit()
          }

          val salaryCal:TextView=v.findViewById(R.id.salarycalculator)

          salaryCal.setOnClickListener{

              val salaryCalculatorFragment=SalaryCalculatorFragment()
              val transaction=requireActivity().supportFragmentManager.beginTransaction()
              transaction.replace(R.id.container,salaryCalculatorFragment)
              transaction.commit()

          }

         return v
    }

}
