package ru.ileasile.tvcharts

import ru.ileasile.tvcharts.series.AnySeries

class ChartImpl(
    override val options: ChartOptions,
) : Chart {
    private val _series: MutableList<AnySeries> = mutableListOf()

    override val series: List<AnySeries>
        get() = _series

    fun addSeries(series: AnySeries) {
        _series.add(series)
    }
}
