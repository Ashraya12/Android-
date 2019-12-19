package com.ktm.aaryan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SearchView
import kotlinx.android.synthetic.main.activity_list_view.*
import android.widget.SearchView.OnSuggestionListener as OnSuggestionListener1

class ListView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val company = arrayOf("apple","tesla","spaceX","samsung","nokia")
        val adp:ArrayAdapter<String> = ArrayAdapter(this@ListView,android.R.layout.simple_list_item_1,company)

        listview.adapter = adp

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adp.filter.filter((newText))
                return true
            }

        })
        



        imageButton.setOnClickListener {
            val intent = Intent(this@ListView,AaryanMainActivity::class.java)
            startActivity(intent)
        }



    }
}


