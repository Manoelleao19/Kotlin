package br.com.spw.app.af

import br.com.spw.model.SupermercadoWeb

fun main() {
    val spw = SupermercadoWeb()
    val todosProdutos = spw.produtos
    val generos = spw.generos

    println("###### PRODUTOS MAIS BARATOS POR GÊNERO ######")

    for (genero in generos) {
        val produtosDoGenero = todosProdutos.filter { it.genero.javaClass == genero.javaClass }
        val produtoMaisBarato = produtosDoGenero.minByOrNull { it.preco }

        print("GÊNERO: ${genero.nome} -> ")
        if (produtoMaisBarato != null) {
            println("Produto mais barato: '${produtoMaisBarato.nome}' por R$${produtoMaisBarato.preco}")
        } else {
            println("Nenhum produto encontrado.")
        }
    }
}