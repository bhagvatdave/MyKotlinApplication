package com.example.mykotlinapplication.Menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mykotlinapplication.R
import androidx.annotation.RequiresApi
import android.os.Build
import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.content.Intent
import android.graphics.Color
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import com.example.mykotlinapplication.Widget_Component.WidgetButton
import com.example.mykotlinapplication.databinding.ActivityMenuBinding
import com.google.android.material.snackbar.Snackbar
import java.util.*
private lateinit var Mbinding: ActivityMenuBinding
class MenuActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mbinding = ActivityMenuBinding.inflate(
            layoutInflater
        )
        setContentView(Mbinding.root)
        registerForContextMenu(Mbinding.btnContext)
        Mbinding.btnPopup.setOnClickListener { view: View? ->
            val pop = PopupMenu(this, view)
            pop.menuInflater.inflate(R.menu.my_menu, pop.menu)
            pop.setOnMenuItemClickListener { item: MenuItem? ->
                itemClick(item!!)
                false
            }
            pop.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        itemClick(item)
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenuInfo) {
        menuInflater.inflate(R.menu.my_menu, menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    override fun onContextItemSelected(item: MenuItem): Boolean {
        itemClick(item)
        return super.onContextItemSelected(item)
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    fun itemClick(item: MenuItem) {
        when (item.itemId) {
            R.id.AnotherActivity -> {
                val i = Intent(this, WidgetButton::class.java)
                startActivity(i)
            }
            R.id.Colorchange -> {
                val red = randomno()
                val blue = randomno()
                val green = randomno()
                Mbinding.root.setBackgroundColor(Color.rgb(red, green, blue))
                Snackbar.make(
                    Mbinding.root,
                    "Current Color Code is " + String.format("#%02x%02x%02x", red, green, blue),
                    Snackbar.LENGTH_SHORT
                ).show()
                Mbinding.btnPopup.visibility = View.INVISIBLE
                Mbinding.btnContext.visibility = View.INVISIBLE
                runonthreading()
            }
            R.id.Loadimage -> {
                Mbinding.root.setBackgroundResource(R.drawable._435045)
                Mbinding.btnPopup.visibility = View.INVISIBLE
                Mbinding.btnContext.visibility = View.INVISIBLE
                runonthreading()
            }
            R.id.AnotherMenu -> Snackbar.make(Mbinding.root, "AnotherMenu", Snackbar.LENGTH_SHORT)
                .show()
            R.id.SubMenu1 -> Snackbar.make(Mbinding.root, "SubMenu1", Snackbar.LENGTH_SHORT)
                .show()
            R.id.SubMenu2 -> Snackbar.make(Mbinding.root, "SubMenu2", Snackbar.LENGTH_SHORT)
                .show()
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    fun randomno(): Int {
        val rand = Random()
        return rand.nextInt(266)
    }

    fun runonthreading() {
        Thread {
            try {
                Thread.sleep(3000)
                runOnUiThread {
                    Mbinding.root.setBackgroundColor(Color.WHITE)
                    Mbinding.btnPopup.visibility = View.VISIBLE
                    Mbinding.btnContext.visibility = View.VISIBLE
                }
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }.start()
    }
}