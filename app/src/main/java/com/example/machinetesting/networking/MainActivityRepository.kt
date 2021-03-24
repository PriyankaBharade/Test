package com.example.machinetesting.networking

import NetworkService
import androidx.lifecycle.MutableLiveData
import com.example.machinetesting.model.ResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {

    val list = MutableLiveData<List<ResponseModel>>()

    fun getServicesApiCall(): MutableLiveData<List<ResponseModel>> {

        val call = WebServiceClient.client.create(NetworkService::class.java).vehicleList()

        call.enqueue(object : Callback<List<ResponseModel>> {

            override fun onResponse(
                call: Call<List<ResponseModel>>,
                response: Response<List<ResponseModel>>
            ) {
                // TODO("Not yet implemented")
                list.value = response.body()
            }

            override fun onFailure(call: Call<List<ResponseModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        return list
    }
}