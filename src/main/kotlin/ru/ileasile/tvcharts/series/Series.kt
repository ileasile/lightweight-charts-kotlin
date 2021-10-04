package ru.ileasile.tvcharts.series

import kotlinx.serialization.json.JsonElement

interface Series <ElemType: DataItem> {
    val addToChartMethodName: String
    val dataAsJson: JsonElement

    fun setData(data: List<ElemType>)
}