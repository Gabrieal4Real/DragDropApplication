package com.danieljayarajan.draganddropapplication.activities.dragDropActivities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.danieljayarajan.draganddropapplication.R
import com.danieljayarajan.draganddropapplication.databinding.ActivityDragDropBinding
import kotlinx.android.synthetic.main.activity_drag_drop.*


class DragDropActivity : AppCompatActivity() {

    private var binding: ActivityDragDropBinding? = null
    private var yDelta: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBindData()
        setupUI()
    }

    private fun setupUI() {
        setupDraggableLine()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupDraggableLine() {
        vDraggableLine.setOnTouchListener { view, event ->
            val y = event.rawY.toInt()
            when (event.action and MotionEvent.ACTION_MASK) {
                MotionEvent.ACTION_DOWN -> {
                    val lParams = view.layoutParams as RelativeLayout.LayoutParams
                    yDelta = y - lParams.topMargin
                }
                MotionEvent.ACTION_MOVE -> {
                    val layoutParams = view.layoutParams as RelativeLayout.LayoutParams
                    layoutParams.topMargin = y - yDelta!!
                    layoutParams.bottomMargin = 0
                    view.layoutParams = layoutParams
                }
            }
            llMain.invalidate()
            true
        }
    }

    private fun onBindData() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_drag_drop)
        binding?.lifecycleOwner = this
    }

    companion object {
        fun getCallingIntent(context: Context?): Intent {
            return Intent(context, DragDropActivity::class.java)
        }
    }

}