package br.com.spw.app.af

import br.com.spw.model.SupermercadoWeb

fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque
    val todosItensInicial = estoque.getItens().toList()

    val ganhoPotencial = todosItensInicial.sumOf { it.produto.preco.toDouble() }

    println("###### 1. ESTOQUE INICIAL E LUCRO POTENCIAL ######")
    todosItensInicial.forEach { println("Cód: ${it.codigo}, Nome: ${it.produto.nome}, Preço: R$${it.produto.preco}, Válido: ${it.valido()}") }
    println("Total de itens: ${todosItensInicial.size}")
    println(String.format("LUCRO POTENCIAL (venda de todos os itens): R$%.2f\n", ganhoPotencial))

    val itensVencidos = todosItensInicial.filter { !it.valido() }
    val prejuizo = itensVencidos.sumOf { it.produto.preco.toDouble() }

    println("###### 2. RETIRANDO ITENS VENCIDOS... ######")
    itensVencidos.forEach { estoque.saiItem(it) }
    println("${itensVencidos.size} itens vencidos foram retirados.\n")

    println("###### 3. ESTOQUE ATUALIZADO E PREJUÍZO ######")
    estoque.getItens().forEach { println("Cód: ${it.codigo}, Nome: ${it.produto.nome}") }
    println("Total de itens restantes: ${estoque.qtdItens()}")
    println(String.format("PREJUÍZO (itens vencidos descartados): R$%.2f\n", prejuizo))

    val lucroReal = ganhoPotencial - prejuizo
    println("###### 4. LUCRO REAL ######")
    println(String.format("LUCRO REAL (Potencial - Prejuízo): R$%.2f", lucroReal))
}