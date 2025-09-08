package br.com.spw.model

// Imports necessários para a classe Carrinho funcionar

class Carrinho {
    private val itens: MutableList<ItemProduto> = mutableListOf()

    fun adicionaItem(item: ItemProduto, estoque: Estoque) {
        estoque.saiItem(item)?.let {
            itens.add(it)
        }
    }

    fun removeItem(item: ItemProduto, estoque: Estoque) {
        if (itens.remove(item)) {
            estoque.entraItem(item)
        }
    }

    fun totalAPagar(): Double {
        // Acessamos as propriedades diretamente, como corrigimos antes
        return itens.sumOf { it.produto.preco.toDouble() }
    }

    fun getItens(): List<ItemProduto> = itens
}