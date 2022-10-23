package com.metafisa.myanubhav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

class SubmitSalaries : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit_salaries)
        val item = resources.getStringArray(R.array.experience)
        val jobItem = resources.getStringArray(R.array.job_type)
        val experienceAutoComplete : AutoCompleteTextView = findViewById(R.id.total_experience)
        val jobItemAutoComplete : AutoCompleteTextView = findViewById(R.id.Job_type)
        val jobTitleAdapter : ArrayAdapter<String> = ArrayAdapter<String>(this,R.layout.dropdown_item,jobItem)
        val totalExperienceAdapter : ArrayAdapter<String> = ArrayAdapter<String>(this,R.layout.dropdown_item,item)
        experienceAutoComplete.setAdapter(totalExperienceAdapter)
        jobItemAutoComplete.setAdapter(jobTitleAdapter)

    }
}