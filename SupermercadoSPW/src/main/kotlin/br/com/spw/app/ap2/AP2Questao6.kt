package br.com.spw.app.ap2

import br.com.spw.model.SupermercadoWeb
import kotlin.random.Random

fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque
    val carrinho = spw.carrinhoA

    val itensValidosNoEstoque = estoque.getItens().filter { it.valido() }.toMutableList()

    if (itensValidosNoEstoque.isNotEmpty()) {
        val quantidadeAPegar = Random.nextInt(1, itensValidosNoEstoque.size + 1)
        println("Selecionando $quantidadeAPegar itens válidos aleatoriamente para o carrinho...\n")

        itensValidosNoEstoque.shuffle()
        val itensSelecionados = itensValidosNoEstoque.take(quantidadeAPegar)

        for (item in itensSelecionados) {
            carrinho.adicionaItem(item, estoque)
        }
    } else {
        println("Não há itens válidos no estoque para adicionar ao carrinho.")
    }

    println("###### ITENS NO CARRINHO ######")
    carrinho.getItens().forEach {
        println("Cód: ${it.codigo}, Produto: ${it.produto.nome}")
    }
    println("-------------------------------------")
    println("Quantidade no carrinho: ${carrinho.getItens().size} itens.")
    println("\n=====================================\n")

    println("###### ITENS RESTANTES NO ESTOQUE ######")
    estoque.getItens().forEach {
        println("Cód: ${it.codigo}, Produto: ${it.produto.nome}")
    }
    println("-------------------------------------")
    println("Total de itens no estoque: ${estoque.qtdItens()} itens.")
}