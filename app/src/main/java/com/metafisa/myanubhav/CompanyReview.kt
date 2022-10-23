package com.metafisa.myanubhav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.metafisa.myanubhav.R

class CompanyReview : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_review)

        var recyclerview: RecyclerView = findViewById(R.id.recyclerview)

        recyclerview.layoutManager = LinearLayoutManager(this)


        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..20) {
            data.add(ItemsViewModel(R.drawable.profiledemo, "Item " + i))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = CompanyReviewAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
    }
}