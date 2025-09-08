package br.com.spw.app.af

import br.com.spw.model.Carrinho
import br.com.spw.model.Estoque
import br.com.spw.model.SupermercadoWeb

fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque
    val carrinho = spw.carrinhoA

    fun mostrarStatus() {
        println("\n---------- STATUS ATUAL ----------")
        println("--- ESTOQUE (${estoque.qtdItens()} itens) ---")
        estoque.getItens().take(5).forEach { println("  Cód: ${it.codigo}, Prod: ${it.produto.nome}") }
        if (estoque.qtdItens() > 5) println("  ...")

        println("--- CARRINHO (${carrinho.getItens().size} itens) ---")
        if(carrinho.getItens().isEmpty()) println("  Carrinho vazio.")
        else carrinho.getItens().forEach { println("  Cód: ${it.codigo}, Prod: ${it.produto.nome}") }
        println("---------------------------------\n")
    }

    println("###### 1. ESTADO INICIAL ######")
    mostrarStatus()

    println("###### 2. MOVENDO 10 ITENS PARA O CARRINHO ######")
    val itensParaMover = estoque.getItens().shuffled().take(10)
    itensParaMover.forEach { carrinho.adicionaItem(it, estoque) }
    mostrarStatus()

    println("###### 3. DEVOLVENDO ITENS PARA O ESTOQUE ######")
    val itensParaDevolver = carrinho.getItens().toList()
    itensParaDevolver.forEach { carrinho.removeItem(it, estoque) }
    mostrarStatus()
}