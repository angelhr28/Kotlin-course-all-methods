data class Persona  (var apellido: String, var nombre: String , var sexo:String  )
var angel = Persona ( "robles", "angel", "m" ) 
fun main(args: Array<String>){	

	
    println(angel)
     
   angel.apply{
       apellido = "perez "
       nombre = " jose "
   }
       
   println(angel)
    
   angel.let{ config->
 	config.nombre= "hugo"
    config.apellido = " jij"
   }
    println (angel)
	
    sumar8(10, 23) {
     println("la suma es: $it ")
	}
    
    validar {
        angel.sexo == "m"
    }
    
    ver(10,2) { x, y, z ->
       var opcion = z + y
       when 
    }
}

fun ver ( a:Int, b:Int, nombre:(String,Int ,Int)->Boolean){
    var dato = nombre(angel.nombre, 6 ,2)
    var imprimir=0
    if(dato){
        imprimir = a +b
    }else {
        imprimir =a - b
    }
 	println( imprimir)   
}


fun validar (mira:(String)->Boolean){
    var sexo = mira(angel.sexo)
    if(sexo){
        println("hombre")
    }else { println ("mujer ")}
}

fun sumar8(a: Int, b: Int, suma:(Int)-> Unit)	{
    suma(a + b + 8)
}




