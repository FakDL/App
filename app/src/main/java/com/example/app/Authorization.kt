package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_authorization.*

class Authorization : AppCompatActivity() {

    private lateinit var password : EditText
    private lateinit var email : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkPreference()
        setContentView(R.layout.activity_authorization)

        password = findViewById(R.id.password)
        email = findViewById(R.id.email)
    }

    fun checkUser(view: View) {
        var isUser = false
        val password = password.text.toString()
        val email = email.text.toString()
        val users = resources.getStringArray(R.array.users)
        val error = Toast.makeText(this,
                "Wrong email or password", Toast.LENGTH_SHORT)
        val checkedIntent = Intent(this, Profile::class.java)
        val myPreference = MyPreference(this)
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            for (user in users) {
                if (email == user.split(" ")[0]
                        && password == user.split(" ")[1]) {
                    val name = user.split(" ")[2] + " " + user.split(" ")[3]
                    myPreference.setEmail(email)
                    myPreference.setName(name)
                    checkedIntent.putExtra(Profile.EMAIL, email)
                    checkedIntent.putExtra(Profile.NAME, name)
                    startActivity(checkedIntent)
                    isUser = true
                }
            }
        }
        if (!isUser) error.show()
    }

    fun checkPreference() {
        val myPreference = MyPreference(this)
        if (myPreference.getEmail() == "") return

        val checkedIntent = Intent(this, Profile::class.java)
        val name = myPreference.getName()
        val email = myPreference.getEmail()
        checkedIntent.putExtra(Profile.NAME, name)
        checkedIntent.putExtra(Profile.EMAIL, email)
        startActivity(checkedIntent)
        }
    }


