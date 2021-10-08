package com.interval.click

import android.os.SystemClock
import android.view.View

abstract class IntervalClickListener : View.OnClickListener {
    private var lastClickTime: Long = 0
    abstract fun onIntervalClick()

    override fun onClick(v: View?) {
        val currentClickTime = SystemClock.uptimeMillis()
        val diffTime = currentClickTime - lastClickTime

        if (diffTime > INTERVAL) {
            onIntervalClick()
            lastClickTime = currentClickTime
        }
    }
    
    companion object {
        const val INTERVAL = 2000
    }
}

fun View.setIntervalClickListener(onClick: () -> Unit) {
    this.setOnClickListener(object : IntervalClickListener() {
        override fun onIntervalClick() {
            onClick()
        }
    })
}
