package com.ranzan.takeaway2.viewmodel

import androidx.lifecycle.*
import com.ranzan.takeaway2.model.api.ApiService
import com.ranzan.takeaway2.model.api.Network
import com.ranzan.takeaway2.model.api.ResponseModel
import kotlinx.coroutines.launch

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TheViewModel() as T
    }
}

class TheViewModel : ViewModel() {
    private var liveDataList = MutableLiveData<ResponseModel>()
    private val apiService = Network.getRetrofitInstance().create(ApiService::class.java)

    fun getDataFromApi(city: String): LiveData<ResponseModel> {
        viewModelScope.launch {
            liveDataList.postValue(apiService.getData(city))
        }
        return liveDataList
    }
}