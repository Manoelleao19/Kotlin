package br.com.spw.model

// Classe também simplificada para acesso direto às propriedades, evitando futuros conflitos.
class Produto(
    val codigo: Int,
    val nome: String,
    val preco: Float,
    val marca: Marca,
    val genero: Genero
)