package dev.acuon.crypto.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import dev.acuon.crypto.data.api.APIService
import dev.acuon.crypto.data.models.mapper.CryptoListMapper
import dev.acuon.crypto.data.pagingsources.CryptoListPagingSource
import dev.acuon.crypto.data.pagingsources.NETWORK_PAGE_SIZE
import dev.acuon.crypto.ui.models.CryptoItemResponse

interface CryptoListRepository {
    suspend fun getCryptoList(): LiveData<PagingData<CryptoItemResponse>>
}

class CryptoRepositoryImpl(
    private val service: APIService,
    private val mapper: CryptoListMapper
) : CryptoListRepository {
    override suspend fun getCryptoList(): LiveData<PagingData<CryptoItemResponse>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                CryptoListPagingSource(service, mapper)
            }
        ).liveData
    }
}