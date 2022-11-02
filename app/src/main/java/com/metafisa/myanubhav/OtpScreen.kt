package com.metafisa.myanubhav

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.metafisa.myanubhav.fragments.HomeFragment
import java.util.concurrent.TimeUnit

class OtpScreen : AppCompatActivity() {

    var et1: EditText? = null
    var et2:EditText? = null
    var et3:EditText? = null
    var et4:EditText? = null
    var et5:EditText? = null
    var et6:EditText? = null
    var btnsubmit: Button? = null
    var getbackendotp: String? = null
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_screen)
        et1 = findViewById(R.id.inputotp1)
        et2 = findViewById(R.id.inputotp2)
        et3 = findViewById(R.id.inputotp3)
        et4 = findViewById(R.id.inputotp4)
        et5 = findViewById(R.id.inputotp5)
        et6 = findViewById(R.id.inputotp6)

        getbackendotp = intent.getStringExtra("storedVerificationId")

        btnsubmit = findViewById(R.id.verify)

        btnsubmit?.setOnClickListener(View.OnClickListener {
            if (!et1?.getText().toString().trim { it <= ' ' }.isEmpty()
                && !et2?.getText().toString().trim { it <= ' ' }.isEmpty()
                && !et3?.getText().toString().trim { it <= ' ' }.isEmpty()
                && !et4?.getText().toString().trim { it <= ' ' }.isEmpty()
                && !et5?.getText().toString().trim { it <= ' ' }.isEmpty()
                && !et6?.getText().toString().trim { it <= ' ' }.isEmpty()) {

                // marging user's input in a string
                val getuserotp = et1?.getText().toString() +
                        et2?.getText().toString() +
                        et3?.getText().toString() +
                        et4?.getText().toString() +
                        et5?.getText().toString() +
                        et6?.getText().toString()
                if (getbackendotp != null) {
                    progressBar?.setVisibility(View.VISIBLE)
                    btnsubmit?.setVisibility(View.INVISIBLE)
                    val phoneAuthCredential = PhoneAuthProvider.getCredential(
                        getbackendotp!!, getuserotp
                    )
                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                        .addOnCompleteListener { task ->
                            progressBar?.setVisibility(View.GONE)
                            btnsubmit?.setVisibility(View.VISIBLE)
                            if (task.isSuccessful) {
                                val intent = Intent(applicationContext, HomeFragment::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                Toast.makeText(this@OtpScreen,"Authentication Successfully",Toast.LENGTH_SHORT).show()
                                startActivity(intent)
                            }
                            else
                            {
                                Toast.makeText(
                                    this@OtpScreen,
                                    "Please Enter a valid OTP",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                        }
                } else {
                    Toast.makeText(this@OtpScreen, "Please check internet", Toast.LENGTH_SHORT)
                        .show()
                }

                //Toast.makeText(MainActivity2.this, "OTP Verify", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this@OtpScreen, "Please fill all number", Toast.LENGTH_SHORT)
                    .show()
            }


        })

        findViewById<TextView>(R.id.sendotp_again).setOnClickListener {
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+"+intent.getStringExtra("countrycode") + intent.getStringExtra("mobile"),
                60,
                TimeUnit.SECONDS,
                this@OtpScreen,
                object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {}
                    override fun onVerificationFailed(e: FirebaseException) {
                        Toast.makeText(this@OtpScreen, e.message, Toast.LENGTH_SHORT).show()
                    }

                    override fun onCodeSent(
                        newbackendotp: String,
                        forceResendingToken: PhoneAuthProvider.ForceResendingToken
                    ) {
                        getbackendotp = newbackendotp
                        Toast.makeText(
                            this@OtpScreen,
                            "OTP Send Sucessfuly",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            )
        }
        movenumtonext() //move num to next
    }

    private fun movenumtonext() {
        et1!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (!charSequence.toString().trim { it <= ' ' }.isEmpty()) {
                    et2!!.requestFocus()
                }
            }

            override fun afterTextChanged(editable: Editable) {}
        })
        et2!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (!charSequence.toString().trim { it <= ' ' }.isEmpty()) {
                    et3!!.requestFocus()
                }
            }

            override fun afterTextChanged(editable: Editable) {}
        })
        et3!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (!charSequence.toString().trim { it <= ' ' }.isEmpty()) {
                    et4!!.requestFocus()
                }
            }

            override fun afterTextChanged(editable: Editable) {}
        })
        et4!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (!charSequence.toString().trim { it <= ' ' }.isEmpty()) {
                    et5!!.requestFocus()
                }
            }

            override fun afterTextChanged(editable: Editable) {}
        })
        et5!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (!charSequence.toString().trim { it <= ' ' }.isEmpty()) {
                    et6!!.requestFocus()
                }
            }
            override fun afterTextChanged(editable: Editable) {}
        })
        et6!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (!charSequence.toString().trim { it <= ' ' }.isEmpty()) {

                    btnsubmit!!.requestFocus()
                }
            }
            override fun afterTextChanged(editable: Editable) {}
        })
    }
}