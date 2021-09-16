package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        signupInit()
        loginInit()
    }
//하이요

    private fun signupInit() {
        binding.signup.setOnClickListener {
            val intent = Intent(this, Signupactivity::class.java)
            startActivity(intent)

        }
    }

    private fun loginInit() {
        binding.login.setOnClickListener {
            val intent = Intent(this, Loginactivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
// 사인업 하면 그 아이디 비번 , 그외
// 비밀번호 규칙