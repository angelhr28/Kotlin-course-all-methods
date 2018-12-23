fun main(args: Array<String>){
    "hola que tal".print()
} 
fun String.print(){ //creas una funcion en base a un tipo de variables
    println(this)// se hace mencion al mismo elemento con el this
// esta funcion hace que todo texto sea impreso
println(4.multiplicar(3))//forma normal de impresion
println(4 multiplicar 2)//forma usando el infix
val lista=mutableListOf("hola", "que","tal")
lista.swap(0,2)
println(lista.toString())
}
infix fun Int.multiplicar(numero:Int):Int{
    return this*numero
//     esta funcion realiza la multiplicacion de la variable
}
fun <T>MutableList<T>.swap(index:Int, index2:Int ){
//  T template variable global
    val temp=this[index]// se pone this[index] porque es una lista
    this[index]=this[index2]
    this[index2]=temp
}
 
