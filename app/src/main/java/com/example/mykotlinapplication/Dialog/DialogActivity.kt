package com.example.mykotlinapplication.Dialog

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.DialogInterface
import android.widget.Toast
import android.content.Intent
import com.example.mykotlinapplication.Menu.MenuActivity
import com.google.android.material.snackbar.Snackbar
import android.app.ProgressDialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.widget.TimePicker
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.widget.DatePicker
import android.content.DialogInterface.OnMultiChoiceClickListener
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.mykotlinapplication.databinding.ActivityCdialogBinding
import com.example.mykotlinapplication.databinding.ActivityDialogBinding
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
private lateinit var dbinding: ActivityDialogBinding
private lateinit var cdbinding: ActivityCdialogBinding
class DialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dbinding = ActivityDialogBinding.inflate(
            layoutInflater
        )
        setContentView(dbinding.root)
        val items = arrayOf(
            "USS Enterprise",
            "USS Stargazer",
            "Millennium Falcon",
            "Razor Crest",
            "Waverider",
            "The TARDIS"
        )
        val vehicles = ArrayList<String>()
        val calendar = Calendar.getInstance()
        dbinding.btnAlert.setOnClickListener { view: View? ->
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Activity Switch")
            builder.setMessage("Want To Go Another Activity")
            builder.setCancelable(false)
            builder.setPositiveButton("Yes") { dialogInterface: DialogInterface?, i: Int ->
                Toast.makeText(this, "Going To Another Activity", Toast.LENGTH_SHORT).show()
                val ii = Intent(this, MenuActivity::class.java)
                startActivity(ii)
            }
            builder.setNegativeButton("No") { dialogInterface: DialogInterface?, i: Int ->
                Toast.makeText(
                    this,
                    "Not Going",
                    Toast.LENGTH_SHORT
                ).show()
            }
            builder.setNeutralButton("Cancel") { dialogInterface: DialogInterface, i: Int -> dialogInterface.dismiss() }
            builder.show()
        }
        dbinding.btnAlert1.setOnClickListener { view: View? ->
            cdbinding = ActivityCdialogBinding.inflate(
                layoutInflater
            )
            AlertDialog.Builder(this)
                .setTitle("Username")
                .setView(cdbinding.root)
                .setPositiveButton("OK") { dialogInterface: DialogInterface?, i: Int ->
                    val str = cdbinding.edtDialog.text.toString()
                    Snackbar.make(dbinding.root, "Your User Name is $str", Snackbar.LENGTH_SHORT)
                        .show()
                }.create().show()
        }
        dbinding.btnProgress.setOnClickListener { view: View? ->
            val dialog = ProgressDialog(this)
            dialog.setTitle("Loading")
            dialog.setMessage("Downloading your file")
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            dialog.setButton(
                DialogInterface.BUTTON_POSITIVE,
                "Cancel"
            ) { dialogInterface: DialogInterface?, i: Int -> }
            dialog.show()
        }
        dbinding.btnProgress1.setOnClickListener { view: View? ->
            val dialog = ProgressDialog(this)
            dialog.setTitle("Downloading")
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
            dialog.max = 100
            Thread {
                for (i in 0..100) {
                    dialog.progress = i
                    try {
                        Thread.sleep(200)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                    if (i == dialog.max) {
                        dialog.dismiss()
                    }
                }
            }.start()
            dialog.show()
        }
        dbinding.btnTime.setOnClickListener { view: View? ->
            val hour = calendar[Calendar.HOUR_OF_DAY]
            val minuet = calendar[Calendar.MINUTE]
            val dialog = TimePickerDialog(this, { timePicker: TimePicker?, i: Int, i1: Int ->
//                binding.btnTime.setText(i+":"+i1);  // 24 hrs
                val hr24 = "$i:$i1"
                val format24 = SimpleDateFormat("HH:mm")
                val format12 = SimpleDateFormat("hh:mm a")
                var hr12: String? = null
                try {
                    hr12 = format12.format(format24.parse(hr24))
                    Snackbar.make(
                        dbinding.root,
                        "Your Selected Time is $hr12",
                        Snackbar.LENGTH_SHORT
                    ).show()
                } catch (e: ParseException) {
                    e.printStackTrace()
                }
            }, hour, minuet, false)
            dialog.show()
        }
        dbinding.btnDate.setOnClickListener { view: View? ->
            val year = calendar[Calendar.YEAR]
            val month = calendar[Calendar.MONTH]
            val day = calendar[Calendar.DAY_OF_MONTH]
            val dialog =
                DatePickerDialog(this, { datePicker: DatePicker?, i: Int, i1: Int, i2: Int ->
                    Snackbar.make(
                        dbinding.root,
                        "Your Selected Date is " + i2 + "/" + (i1 + 1) + "/" + i,
                        Snackbar.LENGTH_SHORT
                    ).show()
                }, year, month, day)
            dialog.show()
        }
        dbinding.btnFullScreen.setOnClickListener { view: View? ->
            cdbinding = ActivityCdialogBinding.inflate(
                layoutInflater
            )
            val dialog = Dialog(this, R.style.Theme_Light_NoTitleBar_Fullscreen)
            dialog.setContentView(cdbinding.root)
            dialog.show()
        }
        dbinding.btnMultiChoiceDialog.setOnClickListener { view: View? ->
            val builder = AlertDialog.Builder(this)
            builder.setMultiChoiceItems(
                items,
                null
            ) { dialogInterface: DialogInterface?, i: Int, b: Boolean ->
                if (b) {
                    vehicles.add(items[i])
                } else {
                    vehicles.remove(items[i])
                }
                Toast.makeText(this@DialogActivity, vehicles.toString(), Toast.LENGTH_SHORT).show()
            }
            builder.show()
        }
        dbinding.btnSingleChoice.setOnClickListener { view: View? ->
            val builder = AlertDialog.Builder(this)
            builder.setSingleChoiceItems(
                items,
                0
            ) { dialogInterface: DialogInterface?, i: Int ->
                Toast.makeText(
                    this,
                    items[i],
                    Toast.LENGTH_SHORT
                ).show()
            }
            builder.show()
        }
    }
}