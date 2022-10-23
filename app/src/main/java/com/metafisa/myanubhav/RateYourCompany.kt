package com.metafisa.myanubhav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

class RateYourCompany : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_your_comapany)

        // Start Working On
        val monthData = resources.getStringArray(R.array.month)
        val yearData = resources.getStringArray(R.array.year)
        val monthAutoComplete : AutoCompleteTextView = findViewById(R.id.select_month)
        val yearAutoComplete : AutoCompleteTextView = findViewById(R.id.select_year)
        val monthAdapter : ArrayAdapter<String> = ArrayAdapter<String>(this,R.layout.dropdown_item,monthData)
        val yearAdapter : ArrayAdapter<String> = ArrayAdapter<String>(this,R.layout.dropdown_item,yearData)
        monthAutoComplete.setAdapter(monthAdapter)
        yearAutoComplete.setAdapter(yearAdapter)

        // Employment ended on

        val monthAutoComplete1 : AutoCompleteTextView = findViewById(R.id.select_month1)
        val yearAutoComplete1 : AutoCompleteTextView = findViewById(R.id.select_year1)
        monthAutoComplete1.setAdapter(monthAdapter)
        yearAutoComplete1.setAdapter(yearAdapter)
    }
}