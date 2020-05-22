package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_profile.*

class Profile : AppCompatActivity() {

    private lateinit var email: TextView
    private lateinit var name: TextView
    private lateinit var photo: ImageView

    companion object {
        const val EMAIL = "email"
        const val NAME = "name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        email = findViewById(R.id.email)
        name = findViewById(R.id.name)
        photo = findViewById(R.id.photo)

        showData()
    }

    fun showData() {
        val email = intent.getStringExtra(EMAIL)
        val name = intent.getStringExtra(NAME)
        email_name.text = email
        your_name.text = name
        val photo = photo
        when (email.split("@")[0]) {
            "qwerty" -> photo.setImageResource(R.drawable.user1)
            "asdfg" -> photo.setImageResource(R.drawable.user2)
        }
    }
    fun exit(view: View) {
        val exitIntent = Intent(this, Authorization::class.java)
        val myPreference = MyPreference(this)
        myPreference.setEmail("")
        startActivity(exitIntent)
    }
}
