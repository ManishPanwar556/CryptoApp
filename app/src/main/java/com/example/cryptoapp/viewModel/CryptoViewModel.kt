package com.example.cryptoapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.network.response.get.CryptoResponse
import com.example.cryptoapp.repository.CryptoRepository
import com.example.cryptoapp.utils.Result
import com.example.cryptoapp.utils.Status
import kotlinx.coroutines.launch

class CryptoViewModel : ViewModel() {
    private val repository = CryptoRepository()
    private val _cryptoList = MutableLiveData<Result<CryptoResponse>>()
    val cryptoList: LiveData<Result<CryptoResponse>> = _cryptoList


    fun getMarketValue(){
        viewModelScope.launch {
            _cryptoList.postValue(Result(Status.LOADING,null,null))
            _cryptoList.postValue(repository.getCryptoDetails())
        }

    }




}