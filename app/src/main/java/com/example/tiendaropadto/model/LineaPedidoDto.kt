package com.example.tiendaropadto.model

import com.example.tiendaropadto.model.producto.ProductoDto

class LineaPedidoDto (
    val id: Long=0,
    val cantidad: Int=0,
    val producto: ProductoDto
)