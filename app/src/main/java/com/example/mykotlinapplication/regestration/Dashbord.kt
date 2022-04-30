package com.example.mykotlinapplication.regestration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.mykotlinapplication.databinding.ActivityDashbordBinding
import com.example.mykotlinapplication.regestration.Userdata
private lateinit var Dashbordbinding: ActivityDashbordBinding
class Dashbord : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Dashbordbinding = ActivityDashbordBinding.inflate(layoutInflater)
        setContentView(Dashbordbinding.root)
        val i = intent
        val UD2 = i.getSerializableExtra("Object1") as Userdata
        Dashbordbinding.Title1.text = "Welcome " + UD2.username
    }
}