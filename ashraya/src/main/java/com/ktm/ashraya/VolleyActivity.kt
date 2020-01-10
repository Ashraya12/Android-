package com.ktm.ashraya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_ashraya_main.*
import kotlinx.android.synthetic.main.activity_volley.*
import org.json.JSONObject

class VolleyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volley)
        val textViewF = findViewById<TextView>(R.id.textView4)
        val btn2 = findViewById<Button>(R.id.btn2)


    val mQueue = Volley.newRequestQueue(this)
    val url = "https://pokeapi.co/api/v2/"

        btn2.setOnClickListener {
            val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->
                    // Display the first 500 characters of the response string.
                    textViewF.text = "Response is: ${response.substring(0, 500)}"
                },
                Response.ErrorListener { textView4.text = "That didn't work!" })
            mQueue.add(stringRequest)
//            jsonParse()
        }
//        jsonParse()
        
//        getUsers()
    }

//    fun getUsers(){
//        val queue = Volley.newRequestQueue(this)
//        val url: String = "https://pokeapi.co/api/v2/"
//
//
//        val objReq = new JSONObjectRequest(Request.Method.GET,
//        url,
//        null,
//        new Response.Listener() {
//            public void onResponse(JSONObjectResponse){
//
//            }
//        },
//        new Response.ErrorListener(){
//            public void onErrorResponse(VolleyError error){
//
//            }
//        }
//    });


}
