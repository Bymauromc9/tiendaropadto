package com.example.tiendaropadto.model.producto

class ProductoDto (
    val id: Long=0,
    val nombre: String="",
    val marca: String="",
    val precioInicial: Double=0.0,
    val precioFinal: Double=0.0,
    val talla: TALLA?=null,
    val color: COLOR?=null,
    val botones: Int=0,
    val bolsillos: Int=0,
    val conCapucha: Boolean=false,
    val nivelAbrigo: Int=0,

)