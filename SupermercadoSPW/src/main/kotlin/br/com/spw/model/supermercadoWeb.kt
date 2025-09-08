package br.com.spw.model

import br.com.spw.model.Carrinho
import kotlin.random.Random

class SupermercadoWeb {

    val estoque: Estoque = Estoque()
    val carrinhoA: Carrinho = Carrinho()
    val carrinhoB: Carrinho = Carrinho()

    val generos: List<Genero>
    val marcas: List<Marca>
    val produtos: List<Produto>

    init {
        val todasMarcas = criaMarcas()
        val todosGeneros = criaGeneros()
        val todosProdutos = criaProdutos(todosGeneros, todasMarcas)

        this.marcas = todasMarcas
        this.generos = todosGeneros
        this.produtos = todosProdutos

        populaEstoqueInicial(todosProdutos)
    }

    private fun criaMarcas(): List<Marca> {
        return listOf(
            Marca("Nestlé"), Marca("Itambé"), Marca("Parmalat"),
            Marca("ABF"), Marca("Pepsico"), Marca("Perdigão"),
            Marca("Sadia"), Marca("Seara")
        )
    }

    private fun criaGeneros(): List<Genero> {
        return listOf(Leite(), Achocolatado(), Presunto())
    }

    private fun criaProdutos(generos: List<Genero>, marcas: List<Marca>): List<Produto> {
        val generoLeite = generos.find { it is Leite }!!
        val generoAchocolatado = generos.find { it is Achocolatado }!!
        val generoPresunto = generos.find { it is Presunto }!!

        val nestle = marcas.find { it.nome == "Nestlé" }!!
        val itambe = marcas.find { it.nome == "Itambé" }!!
        val parmalat = marcas.find { it.nome == "Parmalat" }!!
        val pepsico = marcas.find { it.nome == "Pepsico" }!!
        val abf = marcas.find { it.nome == "ABF" }!!
        val perdigao = marcas.find { it.nome == "Perdigão" }!!
        val sadia = marcas.find { it.nome == "Sadia" }!!
        val seara = marcas.find { it.nome == "Seara" }!!

        return listOf(
            Produto(1, "Ninho", 12.50f, nestle, generoLeite),
            Produto(2, "Leite em Pó", 9.80f, itambe, generoLeite),
            Produto(3, "Leite Caixa", 7.50f, parmalat, generoLeite),
            Produto(4, "Nescau", 8.99f, nestle, generoAchocolatado),
            Produto(5, "Toddy", 8.50f, pepsico, generoAchocolatado),
            Produto(6, "Ovomaltine", 15.00f, abf, generoAchocolatado),
            Produto(7, "Presunto Delícia", 5.50f, perdigao, generoPresunto),
            Produto(8, "Presunto Sadia", 6.20f, sadia, generoPresunto),
            Produto(9, "Presunto Seara", 5.90f, seara, generoPresunto)
        )
    }

    private fun populaEstoqueInicial(produtos: List<Produto>) {
        var itemCodigo = 100L
        val produtosLeite = produtos.filter { it.genero is Leite }
        val produtosAchocolatado = produtos.filter { it.genero is Achocolatado }
        val produtosPresunto = produtos.filter { it.genero is Presunto }

        val anoAtual = Data.dataHoje().getAno()

        repeat(10) {
            val produto = produtosLeite.random()
            val validade = if (Random.nextDouble() < 0.7) Data(1, 1, anoAtual + 1) else Data(1, 1, anoAtual - 1)
            estoque.entraItem(ItemProduto(itemCodigo++, validade, produto))
        }
        repeat(10) {
            val produto = produtosAchocolatado.random()
            val validade = if (Random.nextDouble() < 0.8) Data(1, 12, anoAtual + 1) else Data(1, 5, anoAtual - 1)
            estoque.entraItem(ItemProduto(itemCodigo++, validade, produto))
        }
        repeat(10) {
            val produto = produtosPresunto.random()
            val validade = if (Random.nextDouble() < 0.9) Data(20, 10, anoAtual + 1) else Data(10, 8, anoAtual - 1)
            estoque.entraItem(ItemProduto(itemCodigo++, validade, produto))
        }
    }
}