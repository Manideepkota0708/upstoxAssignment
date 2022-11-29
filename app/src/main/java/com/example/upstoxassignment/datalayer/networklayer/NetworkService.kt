package com.example.upstoxassignment.datalayer.networklayer

import com.example.upstoxassignment.datalayer.CustomerInfo
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

class NetworkService {
    private val okHttpClient = OkHttpClient.Builder().build()
    private val gson = Gson()


    suspend fun getCustomerInfo(): CustomerInfo {
        return withContext(Dispatchers.IO) {
            val request = Request.Builder()
                .url("https://run.mocky.io/v3/6d0ad460-f600-47a7-b973-4a779ebbaeaf")
                .build()
            val response = okHttpClient.newCall(request).execute()
            if (!response.isSuccessful) throw Exception("response is not successful, response code: ${response.code}")
            response.use {
                gson.fromJson(it.body!!.string(), CustomerInfo::class.java)
            }
        }
    }

}