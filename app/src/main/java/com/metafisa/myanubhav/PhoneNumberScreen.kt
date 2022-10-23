package com.metafisa.myanubhav


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.hbb20.CountryCodePicker
import java.util.concurrent.TimeUnit

class PhoneNumberScreen : AppCompatActivity() {
    private var number : String =""

    private var ccp:CountryCodePicker?=null
    private var countryCode:String?=null


    // create instance of firebase auth
    private lateinit var auth: FirebaseAuth
    private lateinit var progressBar: ProgressBar
    private lateinit var mobileno:EditText
    lateinit var sentotp:Button
    // we will use this to match the sent otp from firebase
    lateinit var storedVerificationId:String
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_number_screen)

        mobileno=findViewById(R.id.phone_no)
        auth=FirebaseAuth.getInstance()
        ccp = findViewById<View>(R.id.ccp) as CountryCodePicker
        countryCode= ccp!!.selectedCountryCode
        progressBar=findViewById(R.id.probar1)

        sentotp=findViewById(R.id.btnotp)

        // start verification on click of the button
        sentotp.setOnClickListener {

            number = mobileno.text.trim().toString()
            login()

        }
        // Callback function for Phone Auth
        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            // This method is called when the verification is completed
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finish()
                Log.d("GFG" , "onVerificationCompleted Success")
            }

            // Called when verification is failed add log statement to see the exception
            override fun onVerificationFailed(e: FirebaseException) {
                Log.d("GFG" , "onVerificationFailed  $e")
            }

            // On code is sent by the firebase this method is called
            // in here we start a new activity where user can enter the OTP
            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                Log.d("GFG","onCodeSent: $verificationId")
                storedVerificationId = verificationId
                resendToken = token
                progressBar.setVisibility(View.GONE)
                // Start a new activity using intent
                // also send the storedVerificationId using intent
                // we will use this id to send the otp back to firebase
                val intent = Intent(applicationContext,OtpScreen::class.java)
                intent.putExtra("storedVerificationId",storedVerificationId,)
                intent.putExtra("countrycode",countryCode)
                intent.putExtra("mobile",mobileno.getText().toString())
                startActivity(intent)
                finish()
            }
        }
    }
    private fun login() {
        number = mobileno.text.trim().toString()

        // get the phone number from edit text and append the country cde with it
        if (number.isNotEmpty()){
            number = "+$countryCode$number"
            sendVerificationCode(number)
            progressBar.setVisibility(View.VISIBLE)
            sentotp.setVisibility(View.INVISIBLE)

        }else{
            Toast.makeText(this,"Enter a valid mobile number", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendVerificationCode(number: String) {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(number) // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this) // Activity (for callback binding)
            .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
        Log.d("GFG" , "Auth started")
    }
}