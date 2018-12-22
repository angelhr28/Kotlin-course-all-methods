fun main(args: Array<String>) {
  val a=5 // variable fija
  var b=4 // variable flexible o mutable
  // no es necesaria definir el tipo de variable 
  val nombre ="pepe" // es un string asignacion automatica de tipo 
  val nombre : String ="pepe"
  // asignacion manual de tipo de manera fija; siempre comienza con mayusculas
  b="4".toInt() //fuerza convertir el string a int.
   // TIPOS DE VARIABLES
   val num:Int = 0 //enteros 
   val lng:Long = 23 // long
   val num = 23L // long x2 forma resumida
   val flt: Float  = 4 // flotantes
   val flt = 4f // flotante x2 forma resumida
   val doub = 23.4 // double 
   val doub: Double = 23.4  // double no requiere el prefijo 
   val isCool : Boolean = false // booleano
  //  kotlin es deductivo y asigna el tipo de manera automatica 
  
}