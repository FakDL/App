package com.example.app

import android.content.Context

class MyPreference(context: Context) {

    val PREFERENCE_NAME = "SharedPreferenceExample"
    val PREFERENCE_EMAIL = ""
    val PREFERENCE_USERNAME = ""

    val preference = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun getEmail() : String?{
        return preference.getString(PREFERENCE_EMAIL, "")
    }

    fun setEmail(email : String?){
        val editor = preference.edit()
        editor.putString(PREFERENCE_EMAIL, email)
        editor.apply()
    }
    fun getName() : String?{
        return preference.getString(PREFERENCE_USERNAME, "")
    }

    fun setName(name : String?){
        val editor = preference.edit()
        editor.putString(PREFERENCE_USERNAME, name)
        editor.apply()
    }
}