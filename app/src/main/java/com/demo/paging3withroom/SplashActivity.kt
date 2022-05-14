package com.demo.paging3withroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager


/**
 * @author Rohith S
 * SplashActivity  is the first screen visible to the user when the application’s launched.
 * Splash Screen is the user’s first experience with the application that’s why it is considered to be one of the most vital screens in the application
 */
@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        /**
         * This is used to hide the status bar and make
         * the splash screen as a full screen activity
         */
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        /**
         * we used the postDelayed(Runnable, time) method
         * to send a message with a delayed time.
         */
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)

    }
}