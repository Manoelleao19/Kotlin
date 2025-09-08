package br.com.spw.app.ap2

import br.com.spw.model.SupermercadoWeb

fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque
    val carrinho = spw.carrinhoA

    val itensParaMover = estoque.getItens().filter { it.codigo % 2 != 0L }

    for (item in itensParaMover) {
        carrinho.adicionaItem(item, estoque)
    }

    println("###### ITENS NO CARRINHO ######")
    if (carrinho.getItens().isEmpty()) {
        println("Carrinho vazio.")
    } else {
        carrinho.getItens().forEach {
            println("Cód: ${it.codigo}, Produto: ${it.produto.nome}, Preço: R$${it.produto.preco}")
        }
    }
    println("-------------------------------------")
    println("Quantidade no carrinho: ${carrinho.getItens().size} itens.")
    println(String.format("TOTAL A PAGAR: R$%.2f", carrinho.totalAPagar()))
    println("\n=====================================\n")

    println("###### ITENS RESTANTES NO ESTOQUE ######")
    if (estoque.getItens().isEmpty()) {
        println("Estoque vazio.")
    } else {
        estoque.getItens().forEach {
            println("Cód: ${it.codigo}, Produto: ${it.produto.nome}")
        }
    }
    println("-------------------------------------")
    println("Total de itens no estoque: ${estoque.qtdItens()} itens.")
}