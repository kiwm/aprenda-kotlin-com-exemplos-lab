enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val name: String, val matricula: String) {
    
    override fun toString(): String {
        return name
    }
}

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuario: Usuario) {
    	usuario.forEach{inscritos.add(it)}
    }
}

fun main() {
    val geometria = ConteudoEducacional("geometria", 60, Nivel.INTERMEDIARIO)
    val geometria2 = ConteudoEducacional("geometria2", 60, Nivel.DIFICIL)
    val formacao = Formacao("Mestre em geometria",listOf(geometria, geometria2))
    val usuario1 = Usuario("name1", "matricula1")
    val usuario2 = Usuario("name2", "matricula2")
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    println(formacao.inscritos.toString())
    println(formacao.conteudos)
}
