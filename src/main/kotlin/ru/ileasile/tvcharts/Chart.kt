package ru.ileasile.tvcharts

import ru.ileasile.tvcharts.series.AnySeries

interface Chart {
    val series: List<AnySeries>
    val options: ChartOptions
}