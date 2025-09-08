package br.com.spw.app.af

import br.com.spw.model.SupermercadoWeb

fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque
    val carrinhoA = spw.carrinhoA
    val carrinhoB = spw.carrinhoB

    val todosItens = estoque.getItens().toList()

    println("Separando itens válidos e inválidos em carrinhos diferentes...")

    val itensValidos = todosItens.filter { it.valido() }
    itensValidos.forEach { carrinhoA.adicionaItem(it, estoque) }

    val itensInvalidos = todosItens.filter { !it.valido() }
    itensInvalidos.forEach { carrinhoB.adicionaItem(it, estoque) }

    println("\n###### ESTADO FINAL DO SISTEMA ######")

    println("\n--- ESTOQUE ---")
    println("Total de itens: ${estoque.qtdItens()}")
    if (estoque.qtdItens() == 0) println("Estoque corretamente esvaziado.")

    println("\n--- CARRINHO A (ITENS VÁLIDOS) ---")
    carrinhoA.getItens().forEach { println("  Cód: ${it.codigo}, Prod: ${it.produto.nome}, Validade: ${it.validade}") }
    println("Total de itens: ${carrinhoA.getItens().size}")

    println("\n--- CARRINHO B (ITENS INVÁLIDOS/VENCIDOS) ---")
    carrinhoB.getItens().forEach { println("  Cód: ${it.codigo}, Prod: ${it.produto.nome}, Validade: ${it.validade}") }
    println("Total de itens: ${carrinhoB.getItens().size}")
}