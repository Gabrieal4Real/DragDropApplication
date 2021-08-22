package com.danieljayarajan.draganddropapplication.activities.baseActivities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.danieljayarajan.draganddropapplication.R
import com.danieljayarajan.draganddropapplication.databinding.ActivitySplashScreenBinding
import com.danieljayarajan.draganddropapplication.helpers.Navigator
import com.danieljayarajan.draganddropapplication.utils.SharedPrefsUtils
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    private var binding: ActivitySplashScreenBinding? = null
    private val navigator = Navigator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SharedPrefsUtils.initSharedUtils(this)
        onBindData()
        setupUI()
    }

    private fun onBindData() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen)
        binding?.lifecycleOwner = this
    }

    private fun setupUI() {
        ivSplashScreen.alpha = 0f
        ivSplashScreen.animate().setDuration(2000).alpha(1f).withEndAction {
            navigator.navigateToLoginActivity(this)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}