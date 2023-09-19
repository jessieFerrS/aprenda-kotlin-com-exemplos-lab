enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, var duracao: String, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("------------------------------------------------------------------------------------------")
        println("${usuario.nome} foi matriculado(a) na trilha de formação: $nome.")
    }
}

fun main() {
    //Criação de Usuários
    val usuario1 = Usuario("Ana")
    val usuario2 = Usuario("Beto")
    val usuario3 = Usuario("Clara")
    val usuario4 = Usuario("Danilo")
   
    //Criação de conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", "90 horas", nivel = Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos em Kotlin", "120 horas", nivel = Nivel.INTERMEDIARIO)
    val conteudo3 = ConteudoEducacional("Kotlin Avançado","320 horas", nivel = Nivel.AVANCADO)
    val conteudo4 = ConteudoEducacional("Introdução a Linguagem Python","80 horas", nivel = Nivel.BASICO)
    val conteudo5 = ConteudoEducacional("Programação Orientada a Objetos em Python","160 horas", nivel = Nivel.INTERMEDIARIO)
    val conteudo6 = ConteudoEducacional("Python para Ciência de Dados","350 horas", nivel = Nivel.AVANCADO)
   
    
    //Criação de uma formação e adição de conteúdos
    val formacaoKotlin = Formacao("Formação em Kotlin", mutableListOf(conteudo1, conteudo2, conteudo3))
    val formacaoPython = Formacao("Formação em Python", mutableListOf(conteudo4, conteudo5, conteudo6))
    
    // Matricular usuários na formação
    formacaoKotlin.matricular(usuario1)
    formacaoPython.matricular(usuario2)
    formacaoPython.matricular(usuario3)
    formacaoKotlin.matricular(usuario4)
    
    
    // Visualizar lista de inscritos na formação
    println("------------------------------------------------------------------------------------------")
    println("Inscritos na formação: ${formacaoKotlin.nome}: ${formacaoKotlin.inscritos.map { it.nome }}")
    println("Inscritos na formação: ${formacaoPython.nome}: ${formacaoPython.inscritos.map { it.nome }}")
	println("------------------------------------------------------------------------------------------")
    
    // Visualizar níveis dos conteúdos
    formacaoKotlin.conteudos.forEach { conteudo ->
        println("Conteúdo: ${conteudo.nome}, Duração: ${conteudo.duracao}, Nível: ${conteudo.nivel}")
    }
    formacaoPython.conteudos.forEach { conteudo ->
        println("Conteúdo: ${conteudo.nome}, Duração: ${conteudo.duracao}, Nível: ${conteudo.nivel}")
    }
    println("------------------------------------------------------------------------------------------")
}