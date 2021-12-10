package com.example.myapplication.API
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class loginmodel (val id:String, val pwd:String)   // 변수이름 jSON 하고 같아야함
data class loginreturnmodel (@SerializedName("user") val user:User , val token:String)
@Parcelize
data class User(val name: String, val major:String, val id:String, val phone:String, val address:String, val num:String, val pwd:String ): Parcelable



//data class loginreturnmodel(val name: String, val major:String, val id:String, val phone:String, val address:String, val secretnum:String, val pwd:String )
// 얘는 로그인 리턴해줌
data class signupmodel(val name: String, val major:String, val id:String, val phone:String, val address:String, val num:String, val pwd:String )
data class signupreturnmodel(val success:String, val message:String)
// "name" : "1" , "major" : "1", "id" : "1", "phone" : "1", "address" : "1", "secretnum" : "1", "pwd" : "1"