fun main(args: Array<String>){
var menu=menu("porque tuvo que terminar asi")
var mabel=Persona2("mabel",23)
var asesino=Persona2("desconocido",34)
println(menu2(mabel))
println(menu2(asesino))
var rango=menu3(10)
}
data class Persona2(var nombre:String, var edad:Int)
fun menu(dato:Any){
   when(dato){
       is String -> println(dato.length)
       is Int -> println("${dato*2}")
       is Boolean -> {println(dato) 
       println("es booleano")}
       else -> println("q wea sera")
   } 
}

fun menu2(Persona:Persona2)=// porque quiero que retorne a ese String
    when(Persona.nombre){
        "mabel","jose", "arturo" -> "pueden entrar a la casa" //puedo juntar las condiciones en un rango
        else -> "corre es un asesino"
    }
    
fun menu3(rango:Int){
    	when(rango){
        in 1..10 -> println("el numero se encuentra en el rango de 1-10")
        in 10..100 -> println("el numero se encuentra en el rango de 10-100")
        else ->println("el numero no se encuentra")
    }
}
