package com.example.cinscore

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.cinscore.api.Endpoints
import com.example.cinscore.databinding.ActivityMainBinding
import com.example.cinscore.utils.NetworkHelper
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun getGamesByDate() {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val date = LocalDateTime.now().format(formatter)
        Log.d("", date)
        val path = getString(R.string.handball_path)
        val retrofitClient = NetworkHelper.getRetrofitInstance(path)
        val endpoint = retrofitClient.create(Endpoints::class.java)

        endpoint.getGamesByDate(date.toString()).enqueue(object :
            retrofit2.Callback<JsonObject>{
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val recieved = response.body().toString()
                Log.d("DEBUG", call.toString())
                Log.d("DEBUG", recieved)
            }
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                showToast("error ${t.message}")
            }
        })
    }

    fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}