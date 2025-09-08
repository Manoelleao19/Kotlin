package br.com.spw.model

// A classe foi simplificada. As propriedades no construtor já são publicamente acessíveis.
class ItemProduto(
    val codigo: Long,                 // Acesso direto via item.codigo
    val validade: Data,               // Acesso direto via item.validade
    val produto: Produto              // Acesso direto via item.produto
) {
    /**
     * Verifica se o item está dentro da data de validade.
     * Um item é válido se sua data de validade vem depois da data de hoje.
     */
    fun valido(): Boolean {
        return Data.dataHoje().antes(this.validade)
    }
}