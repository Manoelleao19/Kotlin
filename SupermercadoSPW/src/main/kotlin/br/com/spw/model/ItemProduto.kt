package br.com.spw.model


class ItemProduto(
    val codigo: Long,                 
    val validade: Data,
    val produto: Produto
) {

    fun valido(): Boolean {
        return Data.dataHoje().antes(this.validade)
    }
}