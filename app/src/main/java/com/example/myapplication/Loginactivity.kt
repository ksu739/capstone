package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityLoginactivityBinding


class Loginactivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityLoginactivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val bundle = intent.extras
        Toast.makeText(this, bundle?.get("id").toString(), Toast.LENGTH_LONG).show()

    }
}