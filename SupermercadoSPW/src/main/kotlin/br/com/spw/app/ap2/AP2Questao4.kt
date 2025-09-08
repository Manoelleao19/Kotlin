package br.com.spw.app.ap2

import br.com.spw.model.SupermercadoWeb

fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque
    val todosItens = estoque.getItens()

    val itensValidos = todosItens.count { it.valido() }
    val itensVencidos = todosItens.count { !it.valido() }
    val totalCalculado = itensValidos + itensVencidos
    val totalEstoque = estoque.qtdItens()

    println("###### VERIFICAÇÃO DO ESTOQUE ######")
    println("Total de itens válidos (não vencidos): $itensValidos")
    println("Total de itens vencidos: $itensVencidos")
    println("Soma (válidos + vencidos): $totalCalculado")
    println("Total de itens reportado pelo estoque: $totalEstoque")
    println("\nA soma é igual ao total de itens no estoque? ${if (totalCalculado == totalEstoque) "Sim" else "Não"}")
}