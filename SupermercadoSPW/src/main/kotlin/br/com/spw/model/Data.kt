package br.com.spw.model

import java.time.LocalDate

class Data(private var dia: Int, private var mes: Int, private var ano: Int) {

    override fun toString(): String {
        return "${dia.toString().padStart(2, '0')}/${mes.toString().padStart(2, '0')}/$ano"
    }

    fun setData(dia: Int, mes: Int, ano: Int) {
        this.dia = dia
        this.mes = mes
        this.ano = ano
    }

    // O MÉTODO QUE ESTAVA FALTANDO PROVAVELMENTE É ESTE
    fun antes(outraData: Data): Boolean {
        if (this.ano < outraData.ano) return true
        if (this.ano == outraData.ano && this.mes < outraData.mes) return true
        if (this.ano == outraData.ano && this.mes == outraData.mes && this.dia < outraData.dia) return true
        return false
    }

    fun depois(outraData: Data): Boolean {
        return !antes(outraData) && !igual(outraData)
    }

    fun igual(outraData: Data): Boolean {
        return this.dia == outraData.dia && this.mes == outraData.mes && this.ano == outraData.ano
    }

    fun getDia(): Int = dia
    fun getMes(): Int = mes
    fun getAno(): Int = ano

    companion object {
        fun dataHoje(): Data {
            val hoje = LocalDate.now()
            return Data(hoje.dayOfMonth, hoje.monthValue, hoje.year)
        }
    }
}


