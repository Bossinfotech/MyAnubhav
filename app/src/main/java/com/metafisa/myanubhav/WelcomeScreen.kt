package com.metafisa.myanubhav

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.metafisa.myanubhav.adapter.OnBoardingViewPagerAdapter
import com.metafisa.myanubhav.models.OnBoardingData

class WelcomeScreen : AppCompatActivity() {
    private var onBoardingViewPagerAdapter: OnBoardingViewPagerAdapter?=null
    private var tabLayout: TabLayout?=null
    private var onBoardingViewPager: ViewPager?=null
    var next: TextView?=null
    var skip: TextView?=null
    var position = 0
    var sharedPreferences : SharedPreferences?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(restorePreData()){

            val i = Intent(applicationContext, SplashScreenActivity::class.java)
            startActivity(i)
            finish()

        }

        setContentView(R.layout.activity_welcome_screen)
        tabLayout = findViewById(R.id.tabindicator)
        next = findViewById(R.id.next)
        skip=findViewById(R.id.skip)



        val onBoardingData:MutableList<OnBoardingData> = ArrayList()
        onBoardingData.add(
            OnBoardingData("Latest Jobs",
                "Explore jobs across India and know \n"+" about the company \n" +
                        "salary, employee review, interview and benefits",R.drawable.latesjobs_onboard))


        onBoardingData.add(OnBoardingData("Company Review","Real employee share how it is to \n"+"work at their company. \n" +
                "Read review and make \n" +
                "informed decision.",R.drawable.company_review_onboard))

        onBoardingData.add(OnBoardingData("Interview Experiences","Read and practice interview \n"+"questions and experiences \n" +
                "shared by candidates who \n" +
                "appeared for the interview.",R.drawable.interview_experience_onboard))

        onBoardingData.add(OnBoardingData("Earn Rewards","Get Rewards for helping others,\n" +
                "Share your advice. Help\n" + "someone achieve their dream.",R.drawable.earn_rewards_onboard))

        setOnBoardingViewPagerAdapter(onBoardingData)

        position = onBoardingViewPager!!.currentItem

        next?.setOnClickListener{

            if (position<onBoardingData.size)
            {
                position++
                onBoardingViewPager!!.currentItem=position

            }
            if (position==onBoardingData.size){

                savePrefData()
                val i = Intent(applicationContext, SplashScreenActivity::class.java)
                startActivity(i)

            }
        }

        skip?.setOnClickListener {

            savePrefData()
            val i = Intent(applicationContext, SplashScreenActivity::class.java)
            startActivity(i)
            finish()

        }


        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

                position=tab!!.position

                if (tab.position==onBoardingData.size-1)
                {
                    next!!.text="Get Started"

                }
                else
                {
                    next!!.text="Next"

                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {


            }

            override fun onTabReselected(tab: TabLayout.Tab?) {


            }

        })

    }

    private fun setOnBoardingViewPagerAdapter(onBoardingData:List<OnBoardingData>){

        onBoardingViewPager = findViewById(R.id.screenIntroPage)
        onBoardingViewPagerAdapter=OnBoardingViewPagerAdapter(this,onBoardingData)
        onBoardingViewPager!!.adapter=onBoardingViewPagerAdapter
        tabLayout?.setupWithViewPager(onBoardingViewPager)


    }
    private fun savePrefData(){

        sharedPreferences=applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor = sharedPreferences!!.edit()
        editor.putBoolean("isFirstTimeRun",true)
        editor.apply()

    }

    private fun restorePreData():Boolean{

        sharedPreferences=applicationContext.getSharedPreferences("pref"    , Context.MODE_PRIVATE)
        return sharedPreferences!!.getBoolean("isFirstTimeRun",false)

    }
}