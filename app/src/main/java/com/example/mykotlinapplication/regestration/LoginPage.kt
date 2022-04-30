package com.example.mykotlinapplication.regestration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import com.example.mykotlinapplication.regestration.newuser
import com.example.mykotlinapplication.regestration.Userdata
import com.google.android.material.snackbar.Snackbar
import android.widget.Toast
import com.example.mykotlinapplication.databinding.ActivityLoginPageBinding
import com.example.mykotlinapplication.regestration.Dashbord
private lateinit var loginbinding: ActivityLoginPageBinding
class LoginPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginbinding = ActivityLoginPageBinding.inflate(
            layoutInflater
        )
        setContentView(loginbinding.root)
        loginbinding.newuser1.setOnClickListener { view: View? ->
            val i = Intent(this, newuser::class.java)
            startActivity(i)
        }
        loginbinding.Login1.setOnClickListener { view: View? ->
            val i = intent
            val UD1 = i.getSerializableExtra("Object") as Userdata?
            val loginusernamestr = loginbinding.edituserName.text.toString()
            val loginpasswordstr = loginbinding.editPassword.text.toString()
            if (loginusernamestr == "") {
                Snackbar.make(view!!, "Please Enter User Name", Snackbar.LENGTH_SHORT).show()
            } else if (loginpasswordstr == "") {
                Snackbar.make(view!!, "Please Enter Password", Snackbar.LENGTH_SHORT).show()
            } else {
                if (UD1!!.username == loginusernamestr && UD1!!.password == loginpasswordstr) {
                    Toast.makeText(this@LoginPage, "Login Success", Toast.LENGTH_LONG).show()
                    try {
                        Thread.sleep(2000)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                    val ii = Intent(this, Dashbord::class.java)
                    ii.putExtra("Object1", UD1)
                    startActivity(ii)
                } else {
                    loginbinding.edituserName.setText("")
                    loginbinding.editPassword.setText("")
                }
            }
        }
    }
}