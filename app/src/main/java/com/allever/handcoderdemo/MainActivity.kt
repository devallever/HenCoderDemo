package com.allever.handcoderdemo

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.allever.handcoderdemo.draw.CustomDrawActivity
import com.allever.handcoderdemo.draw.PorterDuffXfermodeDemoActivity
import com.allever.lib.common.util.ActivityCollector

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        findViewById<View>(R.id.drawDemo).setOnClickListener(this)
        findViewById<View>(R.id.cutDemo).setOnClickListener(this)
        btnCircleImageView.setOnClickListener(this)
        btnSearchView.setOnClickListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.drawDemo -> {
                ActivityCollector.startActivity(this, CustomDrawActivity::class.java)
            }
            R.id.cutDemo -> {
                ActivityCollector.startActivity(this, PorterDuffXfermodeDemoActivity::class.java)
            }
            R.id.btnCircleImageView -> {
                ActivityCollector.startActivity(this, CircleImageViewActivity::class.java)
            }
            R.id.btnSearchView -> {
                ActivityCollector.startActivity(this, SearchViewActivity::class.java)
            }
        }

    }

}
