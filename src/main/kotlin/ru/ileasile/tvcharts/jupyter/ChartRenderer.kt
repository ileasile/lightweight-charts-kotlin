package ru.ileasile.tvcharts.jupyter

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.jetbrains.kotlinx.jupyter.api.DisplayResult
import org.jetbrains.kotlinx.jupyter.api.htmlResult
import ru.ileasile.tvcharts.Chart
import java.util.concurrent.atomic.AtomicLong

object ChartRenderer {
    private val counter = AtomicLong()

    fun getId(name: String): String {
        return "${name}_${counter.getAndIncrement()}"
    }

    fun render(chart: Chart): DisplayResult {
        val htmlText = buildString {
            val divId = getId("chart_elem")
            val divVarId = "div_$divId"
            val chartId = getId("chart")
            val chartOptionsJson = Json.encodeToString(chart.options)

            appendLine("""<div id="$divId"></div>""")

            appendLine("""<script type="text/javascript">""")
            appendLine("""call_TVLightweightCharts(function(){""")

            appendLine("""
                var $divVarId = document.getElementById("$divId");
                var $chartId = LightweightCharts.createChart($divVarId, $chartOptionsJson);
            """.trimIndent())

            for (series in chart.series) {
                val seriesId = getId("series")
                val seriesDataJson = series.dataAsJson.toString()
                appendLine("""
                    var $seriesId = $chartId.${series.addToChartMethodName}();
                    $seriesId.setData($seriesDataJson);
                """.trimIndent())
            }

            appendLine("""});""")
            appendLine("""</script>""")
        }

        return htmlResult(htmlText)
    }
}
