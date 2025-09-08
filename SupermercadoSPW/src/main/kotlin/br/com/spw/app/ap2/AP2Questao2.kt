package br.com.spw.app.ap2

import br.com.spw.model.SupermercadoWeb

fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque
    val generos = spw.generos

    println("###### ESTOQUE POR GÊNERO ######")
    println(String.format("%-5s %-15s %-15s %-10s %-8s %-12s %-7s",
        "CÓD", "NOME", "GENERO", "MARCA", "PREÇO", "VALIDADE", "VÁLIDO?"))
    println("--- ------------- ------------- --------- -------- ---------- -------")

    for (genero in generos) {
        val itensPorGenero = estoque.getItens(genero)
        if (itensPorGenero.isNotEmpty()) {
            for (item in itensPorGenero) {
                val produto = item.produto
                val validoStr = if (item.valido()) "sim" else "não"
                println(String.format("%-5d %-15s %-15s %-10s R$%-7.2f %-12s %-7s",
                    item.codigo,
                    produto.nome,
                    produto.genero.nome,
                    produto.marca.nome,
                    produto.preco,
                    item.validade.toString(),
                    validoStr
                ))
            }
            println("TOTAL GENERO: ${itensPorGenero.size} itens.")
        }
    }
    println("...")
    println("TOTAL GERAL: ${estoque.qtdItens()} itens.")
}