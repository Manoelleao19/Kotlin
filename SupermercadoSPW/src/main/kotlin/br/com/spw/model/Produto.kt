package br.com.spw.model


class Produto(
    val codigo: Int,
    val nome: String,
    val preco: Float,
    val marca: Marca,
    val genero: Genero
)