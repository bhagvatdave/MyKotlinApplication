package com.example.mykotlinapplication.Widget_Component

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.CompoundButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.mykotlinapplication.databinding.ActivityStcactivityBinding
import java.util.*

private lateinit var stcbinding: ActivityStcactivityBinding
class STCactivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        stcbinding = ActivityStcactivityBinding.inflate(getLayoutInflater())
        setContentView(stcbinding.root)
        stcbinding.checkBox.setOnCheckedChangeListener(this)
        stcbinding.switch1.setOnCheckedChangeListener(this)
        stcbinding.toggleButton.setOnCheckedChangeListener(this)
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    override fun onCheckedChanged(compoundButton: CompoundButton, b: Boolean) {
        if (b) {
            stcbinding.checkBox.setChecked(true)
            stcbinding.switch1.setChecked(true)
            stcbinding.toggleButton.setChecked(true)
            stcbinding.getRoot().setBackgroundColor(Color.rgb(randomno(), randomno(), randomno()))
        } else {
            stcbinding.checkBox.setChecked(false)
            stcbinding.switch1.setChecked(false)
            stcbinding.toggleButton.setChecked(false)
            stcbinding.getRoot().setBackgroundColor(Color.WHITE)
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    fun randomno(): Int {
        val rand = Random()
        rand.ints(0, 255).use { ints -> }
        return rand.nextInt()
    }
}