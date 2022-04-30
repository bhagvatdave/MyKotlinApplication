package com.example.mykotlinapplication.objpassing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.mykotlinapplication.R
import com.example.mykotlinapplication.databinding.ActivityObjbindingpassingBinding
import com.example.mykotlinapplication.objpassing.Emp
private lateinit var actbinding: ActivityObjbindingpassingBinding
class Objbindingpassing : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actbinding = ActivityObjbindingpassingBinding.inflate(layoutInflater)
        setContentView(actbinding.root)
        actbinding= DataBindingUtil.setContentView(this, R.layout.activity_objbindingpassing)
        actbinding.senddata1.setOnClickListener { view: View? ->
            var e =  Emp(1, "Bhagvat", "Android", 20000, "Gandhinagar")
            actbinding.passobject = e
        }
    }
}