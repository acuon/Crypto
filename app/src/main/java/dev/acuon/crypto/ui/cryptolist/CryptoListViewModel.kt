package dev.acuon.crypto.ui.cryptolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dev.acuon.crypto.data.repository.CryptoListRepository
import dev.acuon.crypto.ui.base.BaseViewModel
import dev.acuon.crypto.ui.models.CryptoItemResponse

class CryptoListViewModel(private val repository: CryptoListRepository) : BaseViewModel() {

    private val _cryptoList = MutableLiveData<PagingData<CryptoItemResponse>>()

    suspend fun getCryptoList(): LiveData<PagingData<CryptoItemResponse>> {
        val response = repository.getCryptoList().cachedIn(viewModelScope)
        _cryptoList.value = response.value
        return response
    }

}