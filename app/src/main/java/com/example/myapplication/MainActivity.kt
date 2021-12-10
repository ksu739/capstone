package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.API.loginmodel
import com.example.myapplication.API.loginreturnmodel
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.utility.APP
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
// 이름 전화번호 << 필수선택 나머지는 제공 여부선택?
    private fun loginInit() {
        binding.login.setOnClickListener {
            val id: String = binding.userid.text.toString()   // 여기서부터 시작
            val pwd: String = binding.userpwd.text.toString()
            val call = APP.service.login(loginmodel(id, pwd))  //!!는 절대 NULL이 될 수 없음 나오면 튕김
            call.enqueue(object : Callback<loginreturnmodel> {
                override fun onResponse(
                    call: Call<loginreturnmodel>,
                    response: Response<loginreturnmodel>
                ) {
                    when (response.code()) {
                        200 -> {
                            val intent = Intent(this@MainActivity, Loginactivity::class.java)
                            val bundle = Bundle()
                            //그외 신상정보 나중에 추가로 넣어주기
                            intent.putExtra("asd",response.body()?.user);
                            Log.i("abcdefg", response.body().toString()) // 로그 체크용
                            startActivity(intent)
                            finish()
                        }
                        401 -> {
                            Toast.makeText(this@MainActivity, "login failed", Toast.LENGTH_LONG)
                                .show() // 오류
                        }
                    }
                }

                override fun onFailure(call: Call<loginreturnmodel>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "오류입니다", Toast.LENGTH_LONG).show()
                }
            })
        }
    }


}
// 사인업 하면 그 아이디 비번 , 그외
// 비밀번호 규칙