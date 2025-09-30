package com.example.tiendaropadto.model.producto

class ProductoDto (
    val id: Long=0,
    val nombre: String="",
    val marca: String="",
    val precioInicial: Double=0.0,
    val precioFinal: Double=0.0,
    val talla: TALLA,
    val color: COLOR,
    val botones: Int,
    val bolsillos: Int,
    val conCapucha: Boolean,
    val nivelAbrigo: Int
)