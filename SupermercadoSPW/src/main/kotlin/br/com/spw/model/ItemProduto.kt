package br.com.spw.model


class ItemProduto(
    val codigo: Long,                 // Acesso direto via item.codigo
    val validade: Data,               // Acesso direto via item.validade
    val produto: Produto              // Acesso direto via item.produto
) {

    fun valido(): Boolean {
        return Data.dataHoje().antes(this.validade)
    }
}