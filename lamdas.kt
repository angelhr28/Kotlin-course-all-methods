data class Auto(var color:String, var puertas:Int, var llanta:Int)
fun main(args: Array<String>){
	val miauto = Auto("red", 4,4)
    miauto?.let{ // se usa el it para nombrar al elemento a evaluar
        miauto.puertas
        it.puertas
        with(it){// puedes usar el parametro que quieras de la clase directamente
            puertas// pero debes especificar si es null o no por los que se junta con el let
            color
        }
    }
    val resultado= sum(7,2)
    println(resultado)
    val resultado2= maximo4("angel")
    println(resultado2)
}
val sum:(Int, Int)-> Int ={x,y ->x+y } 
// variable de tipo funcion y regrese un entero 
//  x,y valores dentro de la funcion -> operacion a realizar(x+y)
val maximo4:(String) -> Boolean = {it.length <4 }
// funcion				tipo de return = {operacio}
// it = se refiere al string a probrar 
// 
