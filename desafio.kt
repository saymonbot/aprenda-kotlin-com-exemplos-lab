class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(
    val nome: String,
    val conteudos: List<ConteudoEducacional>,
	val inscritos: MutableList<Usuario> = mutableListOf(),
) {    
    fun matricular(usuario: Usuario) {
		inscritos.add(usuario)
    }
}

fun main() {
  val usuario1 = Usuario("Saymon")
  
  val conteudo1 = ConteudoEducacional("POO", 60)
  
  val formacao1 = Formacao("Java", listOf(conteudo1))
  
  formacao1.matricular(usuario1)
  
  println("Alunos matriculados na formação ${formacao1.nome}: ")
  formacao1.inscritos.forEach { aluno -> println("Nome: ${aluno.nome}")}
  
}