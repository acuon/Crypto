package dev.acuon.crypto.data.api

import dev.acuon.crypto.data.models.CryptoListJson
import dev.acuon.crypto.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET(Constants.END_POINT_LATEST)
    suspend fun getCryptoList(
        @Query("start") start: Int,
        @Query("limit") limit: Int
    ): CryptoListJson
}