package ru.ileasile.tvcharts.series

import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
class LineDataItem(
    @Serializable(DateSerializer::class)
    val time: Date,
    val value: Double,
) : DataItem

