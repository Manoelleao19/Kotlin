package br.com.spw.model



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

        return itens.sumOf { it.produto.preco.toDouble() }
    }

    fun getItens(): List<ItemProduto> = itens
}