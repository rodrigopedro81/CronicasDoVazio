package com.curso.cronicasdovazio.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.curso.cronicasdovazio.MainActivity
import com.curso.cronicasdovazio.R
import com.curso.cronicasdovazio.databinding.ActivityMainBinding
import com.curso.cronicasdovazio.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val splashAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_splash)
        val splashAnimationLottie = AnimationUtils.loadAnimation(this, R.anim.anim_splash_lottie)
        binding.textViewAppName.animation=splashAnimation
        //binding.animationView.animation=splashAnimationLottie
        splashAnimation.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
                //
            }

            override fun onAnimationEnd(p0: Animation?) {
                Handler(Looper.getMainLooper()).postDelayed({
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    finish()
                }, 1500)
            }

            override fun onAnimationRepeat(p0: Animation?) {
                //
            }

        })

    }
}