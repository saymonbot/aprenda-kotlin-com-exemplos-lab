enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val email: String)

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
  val usuario1 = Usuario("Saymon", "Saymon@email.com")
  val usuario2 = Usuario("Lucas", "Lucas@email.com")
  val usuario3 = Usuario("Adalberto", "Adalberto@email.com")
  
  val conteudo1 = ConteudoEducacional("Lógica", 20, Nivel.BASICO)
  val conteudo2 = ConteudoEducacional("POO", 60, Nivel.INTERMEDIARIO)
  val conteudo3 = ConteudoEducacional("Spring Boot", 30, Nivel.DIFICIL)
  
  
  val formacao1 = Formacao("Java", listOf(conteudo2, conteudo3), listOf(Nivel.DIFICIL))
  val formacao2 = Formacao("Lógica de Programação", listOf(conteudo1), listOf(Nivel.BASICO))
  val formacao3 = Formacao("Backend", listOf(conteudo1, conteudo2, conteudo3), listOf(Nivel.DIFICIL))
  
  
  formacao1.matricular(usuario1)
  formacao2.matricular(usuario1)
  formacao2.matricular(usuario2)
  formacao3.matricular(usuario3)
  
  println("Formações:")
  println("${formacao1.nome}, ${formacao1.nivel}")
  println("${formacao2.nome}, ${formacao2.nivel}")
  println("${formacao3.nome}, ${formacao3.nivel}")
  println("")
  
  println("Alunos matriculados na formação ${formacao1.nome}: ")
  formacao1.inscritos.forEach { aluno -> println("${aluno.nome}")}
  println("")
  
  println("Alunos matriculados na formação ${formacao2.nome}: ")
  formacao2.inscritos.forEach { aluno -> println("${aluno.nome}")}
  println("")
  
  println("Alunos matriculados na formação ${formacao3.nome}: ")
  formacao3.inscritos.forEach { aluno -> println("${aluno.nome}")}
}