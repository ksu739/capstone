package com.example.myapplication

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.API.User
import com.example.myapplication.databinding.ActivityLoginactivityBinding
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter
import kotlinx.android.synthetic.main.activity_loginactivity.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_signup.*
import android.content.Intent as Intent

class Loginactivity : AppCompatActivity() {
        private val loginUser:User by lazy {
            intent.getParcelableExtra("asd")!!
        }
        private val binding by lazy {
            ActivityLoginactivityBinding.inflate(layoutInflater)

        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(binding.root)
            qrmake()
            valueon()
        }

        private fun valueon(){
            binding.major.text = loginUser.major
            binding.number.text = loginUser.id
            binding.signupname.text = loginUser.name
        }

        private fun qrmake() {
            binding.btnGenerateQRcode.setOnClickListener {
                val bundle = intent.extras
                val writer = QRCodeWriter()

                try {
                    val bitMatrix = writer.encode(loginUser.id, BarcodeFormat.QR_CODE, 512, 512)
                    val width = bitMatrix.width
                    val height = bitMatrix.height
                    val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
                    for (x in 0 until width){
                        for (y in 0 until height){
                            bmp.setPixel(x, y, if (bitMatrix[x,y]) Color.BLACK else Color.WHITE)
                        }
                    }
                    binding.ivQRCode.setImageBitmap(bmp)

                }catch (e: WriterException){
                    e.printStackTrace()
                }


            }
        }
    }


