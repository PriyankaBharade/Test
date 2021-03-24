package com.example.machinetesting.networking

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.machinetesting.model.ResponseModel

class  MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    var servicesLiveData: MutableLiveData<List<ResponseModel>>? = null

    fun getList() : LiveData<List<ResponseModel>>? {
        servicesLiveData = MainActivityRepository.getServicesApiCall()
        return servicesLiveData
    }

}