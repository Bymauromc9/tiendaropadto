package com.example.tiendaropadto.model

import com.example.tiendaropadto.model.pedido.PedidoDto
import com.example.tiendaropadto.model.producto.ProductoDto
import com.example.tiendaropadto.model.producto.TALLA
import java.time.LocalDate

class Controller {


    val lista = mutableListOf<ProductoDto>()

// · Filtrado de productos por precio. Encuentra prendas dentro de un rango de precios (ej: 20–50 €).

    fun filtradoPrecio(
        productos: List<ProductoDto>,
        precioMin: Double = 0.0,
        precioMax: Double = 1.0
    ) =
        productos.filter { it.precioFinal in precioMin..precioMax }

// · Filtrado de productos por talla: Filtra las prendas de una talla concreta, pero por defecto se tomará la L.

    fun filtradoTalla(productos: List<ProductoDto>, talla: TALLA) =
        productos.filter { talla == it.talla }


// · Ordenar prendas por precio. La función ordena la lista de productos. Se pasará por parámetro el orden (ascendente o descendente).

    fun ordenarPrecio(productos: List<ProductoDto>, ascendente: Boolean) =
        if (ascendente)
            productos.sortedBy { it.precioFinal }
        else
            productos.sortedByDescending { it.precioFinal }

// · Contador de marca. Contar productos que sean de una marca en concreto.

    fun contadorMarca(marca: String) =
        if (marca.isNotBlank())
            lista.count { it.marca.equals(marca.lowercase()) }
        else
            0

// · Gasto total (o por año). Calcula el gasto total del usuario, teniendo en cuenta todos los pedidos del usuario. Si se le pasa 1 año (p.ej 2025)
// calcula el gasto total de ese año, en caso contrario, calcula el gasto de todos los años.

    fun gastoTotal(pedidos: List<PedidoDto>, ano: Int = 0) =
        if (ano != null) pedidos.filter { it.fecha.year == ano } else 0


// · Buscar pedidos por fecha. Dado un usuario, una fecha inicio y una fecha fin, devuelva los pedidos en ese rango de fechas.

    fun buscarPorFecha(usuario: UsuarioDto, fechaInicio: LocalDate, fechaFin: LocalDate) =
        usuario.pedidos.filter { it.fecha in fechaInicio..fechaFin }

    // · Productos más vendidos. Dados todos los pedidos del sistema, obtiene
// un ranking de los 5 productos más vendidos (5 productos por defecto,
// pero podría pasarse otro número como parámetro).
    fun productosMasVendidos(pedidos: List<PedidoDto>, top: Int = 5): List<ProductoDto> = pedidos
        .flatMap { it.lineas }
        .groupBy { it.producto }
        .mapValues { entry -> entry.value.sumOf { it.cantidad } }
        .toList()
        .sortedByDescending { it.second }
        .take(top)
        .map { it.first }
}