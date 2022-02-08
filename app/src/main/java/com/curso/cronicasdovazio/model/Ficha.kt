package com.curso.cronicasdovazio.model

class Ficha(
    val nome:String,
    val idade:String,
    val raca:String,
    val arquetipo:String,
    val sexo:String,
    val vantagem:String,
    val forca:String,
    val agilidade:String,
    val vigor:String,
    val carisma:String,
    val autoconfianca:String,
    val coragem:String,
    val destreza:String,
    val visao:String,
    val percepcao:String,
    val foco:String,
    val inteligencia:String,
    val sabedoria:String,
    val arremesso:String?,
    val arquearia:String?,
    val bloqueio:String?,
    val montaria:String?,
    val luta:String?,
    val armaLeve:String?,
    val armaPesada:String?,
    val acrobacia:String?,
    val esportes:String?,
    val arcano:String?,
    val medicina:String?,
    val historia:String?,
    val sentidos:String?,
    val seguranca:String?,
    val sobrevivencia:String?,
    val consciencia:String?,
    val furtividade:String?,
    val planejamento:String?,
    val intimidar:String?,
    val enganar:String?,
    val empatia:String?,
    val performance:String?,
    val lideranca:String?,
    val atuacao:String?,
    val interrogatorio:String?,
    val jogo:String?,
    val barganha:String?,
    val listaDeMagias:ArrayList<Magia>?,
    val pontosDePoderGastos:Int?
){
    val vida = (vigor.toInt() + coragem.toInt())*8
    val energia = (vigor.toInt() + sabedoria.toInt())*8
    val pontosDePoderTotal = vigor.toInt() + inteligencia.toInt() + autoconfianca.toInt()
    val pontosDePoderRestantes = pontosDePoderTotal-(pontosDePoderGastos?:0)
}

data class Magia(
    val titulo : String,
    val nivel : Int,
)
