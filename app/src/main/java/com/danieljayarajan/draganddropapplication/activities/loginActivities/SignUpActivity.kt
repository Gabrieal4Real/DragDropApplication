package com.danieljayarajan.draganddropapplication.activities.loginActivities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.danieljayarajan.draganddropapplication.R
import com.danieljayarajan.draganddropapplication.databinding.ActivitySignUpBinding
import com.danieljayarajan.draganddropapplication.helpers.Navigator
import com.danieljayarajan.draganddropapplication.models.User
import com.danieljayarajan.draganddropapplication.utils.SharedPrefsUtils
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private var binding: ActivitySignUpBinding? = null
    private val navigator = Navigator()
    private val user = User()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBindData()
        setupUI()
    }

    private fun onBindData() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        binding?.lifecycleOwner = this
    }

    private fun setupUI() {
        btnSignUp.setOnClickListener {

            if (!tilSignUpEmail.text.isNullOrEmpty() && !tilSignUpPassword.text.isNullOrEmpty() && !tilSignUpConfirmPassword.text.isNullOrEmpty()) {
                if (tilSignUpPassword.text.toString() == tilSignUpConfirmPassword.text.toString()) {
                    user.email = tilSignUpEmail.text.toString()
                    user.password = tilSignUpPassword.text.toString()
                    SharedPrefsUtils.saveUser(user)
                    navigator.navigateToDragDropActivity(this)
                } else
                    Toast.makeText(
                        applicationContext,
                        "Please make sure to confirm the password",
                        Toast.LENGTH_SHORT
                    ).show()
            } else
                Toast.makeText(
                    applicationContext,
                    "Please fill in the details properly",
                    Toast.LENGTH_SHORT
                ).show()

        }

        tvLogin.setOnClickListener {
            navigator.navigateToLoginActivity(this@SignUpActivity)
        }
    }

    companion object {
        fun getCallingIntent(context: Context?): Intent {
            return Intent(context, SignUpActivity::class.java)
        }
    }
}