package br.com.spw.model


abstract class Genero {
    abstract val nome: String
}


class Leite : Genero() {
    override val nome: String = "Leite"
}

class Presunto : Genero() {
    override val nome: String = "Presunto"
}

class Achocolatado : Genero() {
    override val nome: String = "Achocolatado"
}