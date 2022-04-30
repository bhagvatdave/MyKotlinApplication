package com.example.mykotlinapplication.regestration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.example.mykotlinapplication.regestration.Userdata
import android.widget.Toast
import android.content.Intent
import android.view.View
import com.example.mykotlinapplication.databinding.ActivityNewuserBinding
import com.example.mykotlinapplication.regestration.LoginPage
private lateinit var newuserbinding: ActivityNewuserBinding
class newuser : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newuserbinding = ActivityNewuserBinding.inflate(layoutInflater)
        setContentView(newuserbinding.root)
        newuserbinding.Register1.setOnClickListener { view: View? ->
            val UsernameStr = newuserbinding.editnewuserName.text.toString()
            val EmailAddressStr = newuserbinding.editEmailAddress.text.toString()
            val Phone1Str = newuserbinding.editPhone1.text.toString().toLong()
            val Password1Str = newuserbinding.editPassword1.text.toString()
            val repitPassword1Str = newuserbinding.editrepitPassword1.text.toString()
            if (UsernameStr.isEmpty()) {
                Snackbar.make(view!!, "Please Enter User Name", Snackbar.LENGTH_SHORT).show()
            } else if (EmailAddressStr.isEmpty()) {
                Snackbar.make(view!!, "Please Enter Email Address", Snackbar.LENGTH_SHORT).show()
            } else if (Phone1Str == 0L) {
                Snackbar.make(view!!, "Please Enter Phone Number", Snackbar.LENGTH_SHORT).show()
            } else if (Password1Str.isEmpty()) {
                Snackbar.make(view!!, "Please Enter Password", Snackbar.LENGTH_SHORT).show()
            } else if (repitPassword1Str.isEmpty()) {
                Snackbar.make(view!!, "Please Re-Enter Password", Snackbar.LENGTH_SHORT).show()
            } else if (Password1Str != repitPassword1Str) {
                Snackbar.make(view!!, "Please Enter Password Again", Snackbar.LENGTH_SHORT).show()
                newuserbinding.editPassword1.setText("")
                newuserbinding.editrepitPassword1.setText("")
            } else {
                val UD = Userdata(UsernameStr, EmailAddressStr, Password1Str, Phone1Str)
                Toast.makeText(this@newuser, "Regstration Success", Toast.LENGTH_LONG).show()
                try {
                    Thread.sleep(2000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                val i = Intent(this, LoginPage::class.java)
                i.putExtra("Object", UD)
                startActivity(i)
            }
        }
    }
}