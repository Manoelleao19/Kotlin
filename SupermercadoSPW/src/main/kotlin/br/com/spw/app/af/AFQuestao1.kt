package br.com.spw.app.af

import br.com.spw.model.SupermercadoWeb

fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque
    val generosDisponiveis = spw.generos

    print("Digite o nome de um gênero (Ex: Leite, Presunto, Achocolatado): ")
    val nomeGenero = readLine()

    if (nomeGenero.isNullOrBlank()) {
        println("Nome de gênero inválido.")
        return
    }

    val generoEscolhido = generosDisponiveis.find { it.nome.equals(nomeGenero, ignoreCase = true) }

    if (generoEscolhido == null) {
        println("Gênero não encontrado.")
        return
    }

    val itensEncontrados = estoque.getItens(generoEscolhido)

    println("\n###### ESTOQUE PARA O GÊNERO '$nomeGenero' ######")
    println(String.format("%-5s %-15s %-15s %-10s %-8s %-12s %-7s",
        "CÓD", "NOME", "GENERO", "MARCA", "PREÇO", "VALIDADE", "VÁLIDO?"))
    println("--- ------------- ------------- --------- -------- ---------- -------")

    if (itensEncontrados.isNotEmpty()) {
        itensEncontrados.forEach { item ->
            val p = item.produto
            val validoStr = if (item.valido()) "sim" else "não"
            println(String.format("%-5d %-15s %-15s %-10s R$%-7.2f %-12s %-7s",
                item.codigo, p.nome, p.genero.nome, p.marca.nome, p.preco, item.validade, validoStr))
        }
    } else {
        println("Nenhum item encontrado para este gênero.")
    }
    println("...")
    println("TOTAL: ${itensEncontrados.size} itens.")
}