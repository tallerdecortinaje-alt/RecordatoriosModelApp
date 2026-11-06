//Hecho por Oscar Flores

package com.example.recordatoriosmodelapp

import androidx.compose.ui.graphics.Color

enum class Prioridad(val nivel: String) {
    CRITICA("Crítica"),
    NORMAL("Normal"),
    OPCIONAL("Opcional")
}

sealed class EstadoRecordatorio(val etiqueta: String) {
    object Planificado : EstadoRecordatorio("Planificado")
    object EnEjecucion : EstadoRecordatorio("En Ejecución")
    object Finalizado : EstadoRecordatorio("Finalizado")
}

data class Recordatorio(
    val id: Int,
    val titulo: String,
    val detalles: String?,
    val area: String,
    val prioridad: Prioridad,
    val estado: EstadoRecordatorio
)

object RecordatorioRepository {

    val listaRecordatorios = listOf(
        Recordatorio(1, "Reunión de planificación", "Alineación del equipo de desarrollo", "Gestión", Prioridad.CRITICA, EstadoRecordatorio.Planificado),
        Recordatorio(2, "Revisión de requerimientos", null, "Sistemas", Prioridad.NORMAL, EstadoRecordatorio.EnEjecucion),
        Recordatorio(3, "Actualización de servidores", "Aplicar parches de seguridad", "Infraestructura", Prioridad.CRITICA, EstadoRecordatorio.Finalizado),
        Recordatorio(4, "Capacitación de personal", "Taller sobre nuevas herramientas", "Capacitación", Prioridad.OPCIONAL, EstadoRecordatorio.Planificado)
    )

    val categoriasUnicas: Set<String> = listaRecordatorios.map { it.area }.toSet()

    val mapaColoresCategoria: Map<String, Color> = mapOf(
        "Gestión" to Color(0xFFAB47BC),
        "Sistemas" to Color(0xFF26A69A),
        "Infraestructura" to Color(0xFFFFA726),
        "Capacitación" to Color(0xFF42A5F5)
    )
}