package com.example.myapplication.API

data class loginmodel(val id:String, val pwd:String)    // 변수이름 jSON 하고 같아야함
data class loginreturnmodel(val id:String, val pwd:String, val phone:String)    // 얘는 로그인 리턴해줌

data class signupmodel(val phone: String, val id:String, val pwd:String)
data class signupreturnmodel(val success:String, val message:String)