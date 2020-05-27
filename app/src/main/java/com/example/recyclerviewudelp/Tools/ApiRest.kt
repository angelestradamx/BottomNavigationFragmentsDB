package com.example.recyclerviewudelp.Tools

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class ApiRest(context: Context) {

    private val queue = Volley.newRequestQueue(context)
    private val url= "https://test.gcsecurity.mx/api/GpsData"

    fun getAllString():String?{

        var answer:String? = null

        val stringRequest = StringRequest(Request.Method.GET,url, Response.Listener<String>{ response ->
            answer = response
            Log.d("UDELP","MI SERVICIO RESPONSE!!!   $response")
        },Response.ErrorListener {  error ->
            error.printStackTrace()
            Log.d("UDELP","ERROR MI SERVICIO!!!   ${error.toString()}")
        })
        queue.add(stringRequest)

        return answer
    }


}