package com.danieljayarajan.draganddropapplication.activities.loginActivities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.danieljayarajan.draganddropapplication.R
import com.danieljayarajan.draganddropapplication.databinding.ActivityLoginBinding
import com.danieljayarajan.draganddropapplication.helpers.Navigator
import com.danieljayarajan.draganddropapplication.utils.SharedPrefsUtils
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var binding: ActivityLoginBinding? = null
    private val navigator = Navigator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBindData()
        setupUI()
    }

    private fun onBindData() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding?.lifecycleOwner = this
    }

    private fun setupUI() {
        btnLogin.setOnClickListener {
            if (!tilLoginEmail.text.isNullOrEmpty() && !tilLoginPassword.text.isNullOrEmpty()) {
                if (SharedPrefsUtils.getUser(tilLoginEmail.text.toString()) != null)
                    if (SharedPrefsUtils.getUser(tilLoginEmail.text.toString())?.password == tilLoginPassword.text.toString())
                        navigator.navigateToDragDropActivity(this)
                    else
                        Toast.makeText(
                            applicationContext,
                            "Please make sure to input the correct password",
                            Toast.LENGTH_SHORT
                        ).show()
                else
                    Toast.makeText(
                        applicationContext,
                        "Please navigate to SignUp Page to register",
                        Toast.LENGTH_SHORT
                    ).show()
            } else
                Toast.makeText(
                    applicationContext,
                    "Please fill in the details properly",
                    Toast.LENGTH_SHORT
                ).show()
        }

        tvSignUp.setOnClickListener {
            navigator.navigateToSignUpActivity(this@LoginActivity)
        }
    }

    companion object {
        fun getCallingIntent(context: Context?): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
}