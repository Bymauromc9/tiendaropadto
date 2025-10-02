package com.example.tiendaropadto.model

import com.example.tiendaropadto.model.pedido.PedidoDto
import java.time.LocalDate

data class UsuarioDto (
    val id: Long=0,
    val dni: String="",
    val nombre: String="",
    val direccion: String="",
    val fechaNacimiento: LocalDate,
    val telefono: String="",
    val email: String="",
    val password: String="",
    val pedidos: List<PedidoDto> = listOf()
    )