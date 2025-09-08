package br.com.spw.model

class Estoque {
    private val itens: MutableList<ItemProduto> = mutableListOf()

    fun entraItem(item: ItemProduto) {
        itens.add(item)
    }

    fun saiItem(item: ItemProduto): ItemProduto? {
        return if (itens.remove(item)) item else null
    }

    fun getItens(): List<ItemProduto> = itens

    fun getItens(marca: Marca): List<ItemProduto> {
        return itens.filter { it.produto.marca == marca }
    }

    fun getItens(produto: Produto): List<ItemProduto> {
        return itens.filter { it.produto == produto }
    }

    fun getItens(genero: Genero): List<ItemProduto> {
        return itens.filter { it.produto.genero.javaClass == genero.javaClass }
    }

    fun qtdItens(): Int = itens.size
}