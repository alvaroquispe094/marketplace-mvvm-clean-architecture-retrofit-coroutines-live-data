package com.groupal.marketplace.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.groupal.marketplace.ui.view.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, HomeActivity::class.java))

        finish()
    }
}