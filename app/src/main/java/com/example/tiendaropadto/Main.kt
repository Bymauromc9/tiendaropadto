package com.example.tiendaropadto

package com.example.tiendaropadto

import com.example.tiendaropadto.model.*
import com.example.tiendaropadto.model.pedido.PedidoDto
import com.example.tiendaropadto.model.producto.ProductoDto
import com.example.tiendaropadto.model.producto.TALLA
import java.time.LocalDate

fun main() {
    val controller = Controller()

    // Crear productos de ejemplo
    val p1 = ProductoDto("Camiseta", "Nike", 25.0, TALLA.M)
    val p2 = ProductoDto("Pantalón", "Adidas", 45.0, TALLA.L)
    val p3 = ProductoDto("Chaqueta", "Puma", 60.0, TALLA.L)
    val p4 = ProductoDto("Sudadera", "Nike", 30.0, TALLA.S)

    val productos = listOf(p1, p2, p3, p4)
    controller.lista.addAll(productos)

    println("=== Filtrado por precio (20€ - 50€) ===")
    println(controller.filtradoPrecio(productos, 20.0, 50.0))

    println("\n=== Filtrado por talla L ===")
    println(controller.filtradoTalla(productos, TALLA.L))

    println("\n=== Orden ascendente por precio ===")
    println(controller.ordenarPrecio(productos, ascendente = true))

    println("\n=== Contador de productos Nike ===")
    println("Nike: ${controller.contadorMarca("Nike")}")

    // Crear pedidos con líneas
    val pedido1 = PedidoDto(
        fecha = LocalDate.of(2025, 5, 20),
        lineas = listOf(
            LineaPedido(p1, 2),
            LineaPedido(p2, 1)
        )
    )

    val pedido2 = PedidoDto(
        fecha = LocalDate.of(2025, 8, 10),
        lineas = listOf(
            LineaPedido(p3, 3),
            LineaPedido(p1, 1)
        )
    )

    val pedidos = listOf(pedido1, pedido2)
    val usuario = UsuarioDto("Juan", pedidos)

    println("\n=== Gasto total en 2025 ===")
    println(controller.gastoTotal(pedidos, 2025))

    println("\n=== Pedidos entre mayo y septiembre 2025 ===")
    println(controller.buscarPorFecha(usuario, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 9, 30)))

    println("\n=== Top 5 productos más vendidos ===")
    println(controller.productosMasVendidos(pedidos))
}
