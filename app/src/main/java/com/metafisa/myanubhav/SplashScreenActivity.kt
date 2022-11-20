package com.metafisa.myanubhav


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

@Suppress("DEPRECATION")
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val backgroundImg : ImageView= findViewById(R.id.SplashScreenImage)
        val applicationName : TextView=findViewById(R.id.appname)
        val sideAnimation = AnimationUtils.loadAnimation(this,R.anim.slide)
        val textAnimation = AnimationUtils.loadAnimation(this,R.anim.my_text)
        backgroundImg.startAnimation(sideAnimation)
        applicationName.startAnimation(textAnimation)

        Handler().postDelayed({
            startActivity(Intent(this,WelcomeScreen::class.java))
            finish()
        },3000)

    }
}
