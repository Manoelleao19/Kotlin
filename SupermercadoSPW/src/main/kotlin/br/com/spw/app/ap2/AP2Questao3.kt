package br.com.spw.app.ap2

import br.com.spw.model.SupermercadoWeb

fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque
    val generos = spw.generos
    val marcas = spw.marcas

    println("###### ESTOQUE DE ITENS VÁLIDOS POR GÊNERO E MARCA ######")
    println(String.format("%-5s %-15s %-15s %-10s %-8s %-12s %-7s",
        "CÓD", "NOME", "GENERO", "MARCA", "PREÇO", "VALIDADE", "VÁLIDO?"))
    println("--- ------------- ------------- --------- -------- ---------- -------")

    val itensValidos = estoque.getItens().filter { it.valido() }

    for (genero in generos) {
        for (marca in marcas) {
            val itensFiltrados = itensValidos.filter {
                it.produto.genero.javaClass == genero.javaClass &&
                        it.produto.marca == marca
            }

            if (itensFiltrados.isNotEmpty()) {
                for (item in itensFiltrados) {
                    val produto = item.produto
                    println(String.format("%-5d %-15s %-15s %-10s R$%-7.2f %-12s %-7s",
                        item.codigo,
                        produto.nome,
                        produto.genero.nome,
                        produto.marca.nome,
                        produto.preco,
                        item.validade.toString(),
                        "sim"
                    ))
                }
            }
        }
    }
    println("...")
    println("TOTAL DE ITENS VÁLIDOS MOSTRADOS: ${itensValidos.size} itens.")
}