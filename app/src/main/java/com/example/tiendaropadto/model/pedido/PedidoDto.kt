package com.example.tiendaropadto.model.pedido

import com.example.tiendaropadto.model.LineaPedidoDto
import java.time.LocalDate
import java.util.Date

class PedidoDto (
    val id: Long=0,
    val fecha: LocalDate,
    val estado: EstadoPedido?=null,
    val lineas: List<LineaPedidoDto> = listOf()
)