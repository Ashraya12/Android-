package com.ktm.androiddevelopment.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ktm.aaryan.AaryanMainActivity
import com.ktm.androiddevelopment.R
import com.ktm.androiddevelopment.utils.toastShort
import com.ktm.ashraya.AshrayaMainActivity
import com.ktm.bibek.BibekMainActivity
import com.ktm.bipul.BipulMainActivity
import com.ktm.sujan.SujanMainActivity
import kotlinx.android.synthetic.main.content_main_activity.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce = true
        toastShort(getString(R.string.please_click_back_again_to_exit))
        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 1300)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button1 -> startActivity(Intent(this, AaryanMainActivity::class.java))
            R.id.button2 -> startActivity(Intent(this, AshrayaMainActivity::class.java))
            R.id.btn2 -> startActivity(Intent(this, BibekMainActivity::class.java))
            R.id.button4 -> startActivity(Intent(this, BipulMainActivity::class.java))
            R.id.button5 -> startActivity(Intent(this, SujanMainActivity::class.java))
        }
    }
}
