package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.API.signupmodel
import com.example.myapplication.API.signupreturnmodel
import com.example.myapplication.databinding.ActivitySignupBinding
import com.example.myapplication.utility.APP
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Signupactivity : AppCompatActivity() {
    private val binding by lazy {
        ActivitySignupBinding.inflate(layoutInflater)
    }

    val TAG: String = "Signupactivity"
    var isExistBlank = false
    var isPWSame = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        signup()

    }

    private fun signup() {
        binding.signupcheck.setOnClickListener {
            // "name" : "1" , "major" : "1", "id" : "1", "phone" : "1", "address" : "1", "secretnum" : "1", "pwd" : "1"

            val name: String = binding.signupname.text.toString()
            val major: String = binding.signupmajor.text.toString()
            val id: String = binding.signupid.text.toString()
            val phone: String = binding.signupphone.text.toString()
            val address: String = binding.signupaddress.text.toString()
            val secretnum: String = binding.signupsecretnum.text.toString()
            val pwd: String = binding.signuppwd.text.toString()
            val check = binding.pwdcheck.text.toString()


            val call = APP.service.signup(signupmodel(name, major, id, phone, address, secretnum, pwd));

            if (registercheck(phone, id, pwd, check)) {
                call.enqueue(object : Callback<signupreturnmodel> {
                    override fun onResponse(
                        call: Call<signupreturnmodel>,
                        response: Response<signupreturnmodel>
                    ) {
                        when (response.code()) {
                            201 -> {
                                Toast.makeText(this@Signupactivity, "회원가입 성공", Toast.LENGTH_LONG).show()
                                val intent = Intent(this@Signupactivity, MainActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                            400 -> {
                                Toast.makeText(this@Signupactivity, "회원가입 실패!", Toast.LENGTH_SHORT).show()
                            }
                        }


                    }

                    override fun onFailure(call: Call<signupreturnmodel>, t: Throwable) {
                        TODO("Not yet implemented")
                    }
                }
                )
            }
        }
    }

    private fun registercheck(phone: String, id: String, pwd: String, check: String): Boolean {
        if (!(phone.isEmpty() || id.isEmpty() || pwd.isEmpty() || check.isEmpty())) {
            if (check == pwd) {
                return true
            }
            Toast.makeText(this@Signupactivity, "비밀번호가 틀립니다.", Toast.LENGTH_SHORT).show()
            Log.i("abcdefg", "비밀번호오류")
            return false
        }
        Toast.makeText(this@Signupactivity, "공백이 존재합니다.", Toast.LENGTH_SHORT).show()
        Log.i("abcdefg", "공백")
        return false
    }
}


/*
    // 회원가입 실패시 다이얼로그를 띄워주는 메소드
    fun dialog(type: String){
        val dialog = AlertDialog.Builder(this)

        // 작성 안한 항목이 있을 경우
        if(type.equals("blank")){
            dialog.setTitle("회원가입 실패")
            dialog.setMessage("입력란을 모두 작성해주세요")
        }
        // 입력한 비밀번호가 다를 경우
        else if(type.equals("not same")){
            dialog.setTitle("회원가입 실패")
            dialog.setMessage("비밀번호가 일치하지 않습니다")
        }

        val dialog_listener = object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                when(which){
                    DialogInterface.BUTTON_POSITIVE ->
                        Log.d(TAG, "다이얼로그")
                }
            }
        }

        dialog.setPositiveButton("확인",dialog_listener)
        dialog.show()

    }
   */