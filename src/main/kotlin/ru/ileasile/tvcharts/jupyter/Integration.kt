package ru.ileasile.tvcharts.jupyter

import org.jetbrains.kotlinx.jupyter.api.libraries.JupyterIntegration
import org.jetbrains.kotlinx.jupyter.api.libraries.resources
import ru.ileasile.tvcharts.Chart
import ru.ileasile.tvcharts.series.AnySeries

class Integration: JupyterIntegration() {
    override fun Builder.onLoaded() {
        resources {
            js("TVLightweightCharts") {
                url("https://unpkg.com/lightweight-charts/dist/lightweight-charts.standalone.production.js")
            }
        }

        render<Chart> { ChartRenderer.render(it) }

        importPackage<Chart>()
        importPackage<AnySeries>()
    }
}
