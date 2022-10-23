package com.metafisa.myanubhav

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.metafisa.myanubhav.fragments.ExploreFragment
import com.metafisa.myanubhav.fragments.SalaryCalculatorFragment
import org.w3c.dom.Text

class UserProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        val addEmployeeDetails : TextView = findViewById(R.id.addEmployeeDetail)
        addEmployeeDetails.setOnClickListener {
            val bottomSheetFragment : BottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(supportFragmentManager,bottomSheetFragment.tag)
        }
        val interviewQuestion : TextView = findViewById(R.id.interview_question)
        interviewQuestion.setOnClickListener {
            startActivity(Intent(this,InterviewExperience::class.java))
        }

        val submitSalary : TextView = findViewById(R.id.submitSalary)
        submitSalary.setOnClickListener {
            startActivity(Intent(this,SubmitSalaries::class.java))
        }

        val rateYourCompany : TextView = findViewById(R.id.rateYourCompany)
        rateYourCompany.setOnClickListener {
            startActivity(Intent(this,RateYourCompany::class.java))
        }
    }
}