package dev.acuon.crypto.ui.models

import dev.acuon.crypto.utils.toDecimals
import dev.acuon.crypto.utils.toDecimalsNoComma
import dev.acuon.crypto.utils.toDecimalsUnits

data class CryptoItemResponse(
    val id: Int,
    val name: String,
    val symbol: String,
    val cmcRank: String,
    val price: Double,
    val volume24h: Double,
    val percentChange24h: Double,
    val marketCap: Double
) {
    val priceDisplay: String
        get() = price.toDecimals()

    val priceDisplayNoComma: String
        get() = price.toDecimalsNoComma()

    val percentChangeDisplay: String
        get() = percentChange24h.toDecimals()

    val volumeDisplay: String
        get() = volume24h.toDecimalsUnits()
}