package com.example.mykotlinapplication.Widget_Component

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mykotlinapplication.databinding.ActivityWidgetButtonBinding
private lateinit var wbbinding: ActivityWidgetButtonBinding
class WidgetButton : AppCompatActivity() {
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        wbbinding = ActivityWidgetButtonBinding.inflate(getLayoutInflater())
        setContentView(wbbinding.root)
        wbbinding.btnSTC.setOnClickListener { view ->
            val i = Intent(this, STCactivity::class.java)
            startActivity(i)
        }
        wbbinding.btnseek.setOnClickListener { view ->
            val i = Intent(this, Seekbar::class.java)
            startActivity(i)
        }
        wbbinding.btnradio.setOnClickListener { view ->
            val i = Intent(this, STCactivity::class.java)
            startActivity(i)
        }
    }
}