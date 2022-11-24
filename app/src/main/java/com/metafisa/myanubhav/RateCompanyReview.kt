package com.metafisa.myanubhav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.metafisa.myanubhav.models.WriteCompanyReviewDataModel

class RateCompanyReview : AppCompatActivity() {

    private lateinit var userCompanyName: TextInputEditText
    private lateinit var userDesignation: TextInputEditText
    private lateinit var submitCompanyReview: AppCompatButton

    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_company_review)
        val monthData = resources.getStringArray(R.array.month)
        val yearData = resources.getStringArray(R.array.year)
        val monthAutoComplete : AutoCompleteTextView = findViewById(R.id.select_month)
        val yearAutoComplete : AutoCompleteTextView = findViewById(R.id.select_year)
        val monthAdapter : ArrayAdapter<String> = ArrayAdapter<String>(this,
            R.layout.dropdown_item,monthData)
        val yearAdapter : ArrayAdapter<String> = ArrayAdapter<String>(this,
            R.layout.dropdown_item,yearData)
        monthAutoComplete.setAdapter(monthAdapter)
        yearAutoComplete.setAdapter(yearAdapter)

        val monthAutoComplete1 : AutoCompleteTextView = findViewById(R.id.select_month1)
        val yearAutoComplete1 : AutoCompleteTextView = findViewById(R.id.select_year1)
        monthAutoComplete1.setAdapter(monthAdapter)
        yearAutoComplete1.setAdapter(yearAdapter)


        userCompanyName=findViewById(R.id.user_companyName)
        userDesignation=findViewById(R.id.user_designation)
        submitCompanyReview=findViewById(R.id.submit_companyReview)

        databaseReference= FirebaseDatabase.getInstance().getReference("Employees")

        submitCompanyReview.setOnClickListener{

            saveCompanyReview()
        }

    }

    private fun saveCompanyReview()
    {

        val companyName= userCompanyName.text.toString()
        val designation= userDesignation.text.toString()

        if (companyName.isEmpty())
        {
            userCompanyName.error="Please enter Company Name"
        }

        if (designation.isEmpty())
        {
            userDesignation.error="Please enter your disignation"
        }
        val userId = databaseReference.push().key!!

        val companyReview= WriteCompanyReviewDataModel(companyName,designation)

        databaseReference.child(userId).setValue(companyReview)
            .addOnCompleteListener {
                Toast.makeText(this,"Thanks for your Review", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener { err->

                Toast.makeText(this,"Error ${err.message}", Toast.LENGTH_SHORT).show()

            }

    }
}