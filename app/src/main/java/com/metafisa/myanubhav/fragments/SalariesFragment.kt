package com.metafisa.myanubhav.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.metafisa.myanubhav.databinding.FragmentSalariesBinding

class SalariesFragment : Fragment() {
    private lateinit var binding: FragmentSalariesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= FragmentSalariesBinding.inflate(layoutInflater)
        return binding.root

        }

}