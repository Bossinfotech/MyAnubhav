package com.metafisa.myanubhav.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.metafisa.myanubhav.CompanyReviewAdapter
import com.metafisa.myanubhav.ItemsViewModel
import com.metafisa.myanubhav.R

class CompanyReviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val v = inflater.inflate(R.layout.fragment_company_review, container, false)

        val recyclerview: RecyclerView =v.findViewById(R.id.recyclerview)

        //recyclerview.layoutManager = LinearLayoutManager(this)

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
        return v
    }


}