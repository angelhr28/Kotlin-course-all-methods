fun main(args: Array<String>){
	data class Persona (var nombre:String? , var ape:String)
 	var person = Persona(null,"perez")
    try{ //codigo que  puede caerce 
        var a = 100
    	var b = 0
//     	lateinit var b: Int -------> es para  poder avisar que puede ser  null
         var div:Int = a/b
       println("la div $div")
     	var suma = 0
        if(a<b){
            suma= a-b
        } else{
          suma =b-a
        }
        if (suma < 0) {
//             throw Exception("No puede ser negativo") // control  personalizado de la variable 
        }
        
        print(suma)
    }
    catch(precaucion:Exception){ // respaldo por si se banea 
        println ("no se puede dividir ${precaucion.message}")
    }
//      catch(precaucion:NumberFormatException){ // respaldo y muestra problemas aritmeticos 
//         println ("no se puede dividir ${precaucion.message}")
//     }
//      IOException --> captura cada agregado por medio de consola o interfaz probar no pude gg wp
 val s = person.nombre ?: throw IllegalArgumentException("Name required") // sirvs para poder marcar el punto que no se alcanzara del codigo

//   val s = person.nombre ?: fail("requiere un nombre")
// 	println(s)     // 's' a partir de aqui no corre  

 }
//   fun fail(message: String): Nothing {
//     throw IllegalArgumentException(message)
// } 
