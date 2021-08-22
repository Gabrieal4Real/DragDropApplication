package com.danieljayarajan.draganddropapplication.helpers

import android.content.Context
import android.content.Intent
import com.danieljayarajan.draganddropapplication.activities.dragDropActivities.DragDropActivity
import com.danieljayarajan.draganddropapplication.activities.loginActivities.LoginActivity
import com.danieljayarajan.draganddropapplication.activities.loginActivities.SignUpActivity

class Navigator {

    fun navigateToDragDropActivity(context: Context) {
        val intent = DragDropActivity.getCallingIntent(context)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }

    fun navigateToLoginActivity(context: Context) {
        val intent = LoginActivity.getCallingIntent(context)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }

    fun navigateToSignUpActivity(context: Context) {
        val intent = SignUpActivity.getCallingIntent(context)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }

}