package br.com.spw.model

/**
 * Classe Abstrata Corrigida - Estilo Kotlin
 * Nós apenas declaramos que toda subclasse de Genero DEVE ter uma propriedade 'nome'.
 */
abstract class Genero {
    abstract val nome: String
}

/**
 * Subclasses Concretas Corrigidas
 * Aqui nós implementamos (override) a propriedade 'nome' que foi exigida pela classe pai.
 */
class Leite : Genero() {
    override val nome: String = "Leite"
}

class Presunto : Genero() {
    override val nome: String = "Presunto"
}

class Achocolatado : Genero() {
    override val nome: String = "Achocolatado"
}