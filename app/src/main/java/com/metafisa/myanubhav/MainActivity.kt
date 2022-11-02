package com.metafisa.myanubhav


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.metafisa.myanubhav.fragments.ExploreFragment
import com.metafisa.myanubhav.fragments.HomeFragment
import com.metafisa.myanubhav.fragments.RewardFragment
import com.metafisa.myanubhav.fragments.UserProfileFragment

class MainActivity : AppCompatActivity() {

    lateinit var button: ImageButton
    private val exploreFragment = ExploreFragment()
    private val homeFragment = HomeFragment()
    private val rewardFragment = RewardFragment()
    private val userProfileFragment=UserProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //anubhav
        val bottomNavinationView =findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavinationView.setOnItemSelectedListener {

            when(it.itemId)
            {
                R.id.explore -> replaceFragment(exploreFragment)
                R.id.home -> replaceFragment(homeFragment)
                R.id.contribute -> replaceActivity()
                R.id.profile -> replaceFragment(userProfileFragment)
                R.id.reward -> replaceFragment(rewardFragment)

            }
            true
        }

    }

    private fun replaceActivity() {
        //newpro
        supportActionBar?.hide()

            val view: View =layoutInflater.inflate(R.layout.bottom_sheet,null)
            val dialog= BottomSheetDialog(this)
            dialog.setContentView(view)
            dialog.show()

    }

    //anubhav
    private fun replaceFragment(fragment: Fragment)
    {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()


    }
}