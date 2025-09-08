package br.com.spw.app.af

import br.com.spw.model.SupermercadoWeb
import br.com.spw.model.Data

fun main() {
    val spw = SupermercadoWeb()
    val estoque = spw.estoque

    try {
        print("Digite uma data de referência.\nDia: ")
        val dia = readLine()!!.toInt()
        print("Mês: ")
        val mes = readLine()!!.toInt()
        print("Ano: ")
        val ano = readLine()!!.toInt()

        val dataFornecida = Data(dia, mes, ano)
        println("\nBuscando itens vencidos antes de $dataFornecida...")

        val listaX = estoque.getItens().filter { it.validade.antes(dataFornecida) }

        println("\n###### ITENS VENCIDOS ANTES DE $dataFornecida ######")
        if(listaX.isNotEmpty()) {
            listaX.forEach { item ->
                val p = item.produto
                println("Cód: ${item.codigo}, Prod: ${p.nome}, Marca: ${p.marca.nome}, Validade: ${item.validade}")
            }
        } else {
            println("Nenhum item encontrado.")
        }
        println("-------------------------------------------------")
        println("QUANTIDADE TOTAL: ${listaX.size} itens.")

    } catch (e: NumberFormatException) {
        println("Entrada inválida. Por favor, digite apenas números para a data.")
    }
}