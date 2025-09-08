package br.com.spw.app.ap2

import br.com.spw.model.SupermercadoWeb

fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque

    print("Digite o nome de uma marca para buscar: ")
    val nomeMarca = readLine()

    if (nomeMarca.isNullOrBlank()) {
        println("Nome da marca inválido.")
        return
    }

    val itensEncontrados = estoque.getItens().filter {
        it.valido() && it.produto.marca.nome.equals(nomeMarca, ignoreCase = true)
    }

    println("\n###### RESULTADO DA BUSCA POR ITENS VÁLIDOS DA MARCA '$nomeMarca' ######")
    if (itensEncontrados.isEmpty()) {
        println("Nenhum item válido encontrado para esta marca.")
    } else {
        println(String.format("%-5s %-15s %-15s %-10s", "CÓD", "NOME", "GENERO", "PREÇO"))
        println("--- ------------- ------------- ---------")
        itensEncontrados.forEach { item ->
            val p = item.produto
            println(String.format("%-5d %-15s %-15s R$%-7.2f",
                item.codigo, p.nome, p.genero.nome, p.preco))
        }
        println("-------------------------------------------------")
        println("TOTAL DE ITENS ENCONTRADOS: ${itensEncontrados.size}")
    }
}