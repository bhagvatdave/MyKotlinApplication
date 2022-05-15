package com.example.mykotlinapplication.Widget_Component

import android.graphics.Color
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.mykotlinapplication.databinding.ActivitySeekbarBinding
import com.example.mykotlinapplication.databinding.ActivityWidgetButtonBinding

private lateinit var sbbinding: ActivitySeekbarBinding
class Seekbar : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sbbinding = ActivitySeekbarBinding.inflate(getLayoutInflater())
        setContentView(sbbinding.root)
        sbbinding.ivColorCode.setBackgroundColor(Color.BLACK)
        sbbinding.sbBlue.setOnSeekBarChangeListener(this)
        sbbinding.sbGreen.setOnSeekBarChangeListener(this)
        sbbinding.sbRed.setOnSeekBarChangeListener(this)
    }

    override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
        val red: Int = sbbinding.sbRed.getProgress()
        val blue: Int = sbbinding.sbBlue.getProgress()
        val green: Int = sbbinding.sbGreen.getProgress()
        sbbinding.ivColorCode.setBackgroundColor(Color.rgb(red, green, blue))
        sbbinding.textView2.setText(String.format("#%02x%02x%02x", red, green, blue))
        sbbinding.textView3.setText("$red $green $blue")
    }

    override fun onStartTrackingTouch(seekBar: SeekBar) {}
    override fun onStopTrackingTouch(seekBar: SeekBar) {}
}