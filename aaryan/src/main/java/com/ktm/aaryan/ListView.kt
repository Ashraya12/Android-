package com.ktm.aaryan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_view.*

class ListView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val fruits = arrayOf("Graphes","Pineapples","Apple","Kiwi")
        val adp:ArrayAdapter<String> = ArrayAdapter(this@ListView,android.R.layout.simple_list_item_1,fruits)

        listview.adapter = adp

    }
}
