
//INLINE
//  -Se debe usar cuando la funcion que queremos insertar es demasiada grande ya q solo hara llamado de esta 
//  -Ademas al convertir en lenguaje java sera menos extenso. 

//SEALED CLASS
//  -sirve para poder crear clases dentro de otras clases.
//  -se puede hacer "when" de clases
//  -se denota con "sealed class <name>(parametros)" 
//  ---------------------------------EJEMPLO----------------------------------------------
  sealed class Eleccion(){
    class Estudiar :Eleccion()
    class Pedear: Eleccion()
}
fun main(args: Array<String>){
	val eleccion: Eleccion = Eleccion.Pedear()
    // creo un objeto el cual es igualado al tipo clase "Eleccion", 
    // este sera igualado a la subclase "Estudiar"
    // ahora haremos un ejemplo de lo que se puede hacer
    val output:String = when(eleccion){
        is Eleccion.Estudiar->"Aprobaras"
        is Eleccion.Pedear -> "te iras de la casa por bika"
    }
	println(output)
}
