package ru.ileasile.tvcharts.series

import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.serializer

class LineSeries : Series<LineDataItem> {
    override val addToChartMethodName: String
        get() = "addLineSeries"

    private val data = mutableListOf<LineDataItem>()

    override val dataAsJson: JsonElement
        get() = Json.encodeToJsonElement(ListSerializer(serializer()), data)

    override fun setData(data: List<LineDataItem>) {
        this.data.clear()
        this.data.addAll(data)
    }
}