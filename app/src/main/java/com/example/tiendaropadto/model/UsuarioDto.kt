package com.example.tiendaropadto.model

import java.time.LocalDate

class UsuarioDto (
    val id: Long=0,
    val dni: String="",
    val nombre: String="",
    val direccion: String="",
    val fechaNacimiento: LocalDate,
    val telefono: String="",
    val email: String="",
    val password: String=""
    )