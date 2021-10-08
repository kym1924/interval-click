package com.interval.click

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.interval.click.databinding.ActivityMainBinding
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBtnLogClickListener()
    }

    private fun setBtnLogClickListener() {
        binding.btnLog.setIntervalClickListener {
            Timber.d(currentTimeFormat())
        }
    }

    private fun currentTimeFormat() =
        SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.KOREA).format(System.currentTimeMillis())
}
