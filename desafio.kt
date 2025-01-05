enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(
    val nome: String,
    val conteudos: List<ConteudoEducacional>,
    val nivel: List<Nivel>,
	val inscritos: MutableList<Usuario> = mutableListOf(),
) {    
    fun matricular(usuario: Usuario) {
		inscritos.add(usuario)
    }
}

fun main() {
  val usuario1 = Usuario("Saymon")
  
  val conteudo1 = ConteudoEducacional("POO", 60, Nivel.INTERMEDIARIO)
  
  val formacao1 = Formacao("Java", listOf(conteudo1), listOf(Nivel.INTERMEDIARIO))
  
  formacao1.matricular(usuario1)
  
  println("Formações:")
  println("${formacao1.nome}, ${formacao1.nivel}")
  println("")
  
  println("Alunos matriculados na formação ${formacao1.nome}: ")
  formacao1.inscritos.forEach { aluno -> println("${aluno.nome}")}
}