class hola{
    fun hola(){
        println("hola kotlin")
    }
}
class Persona (val nombre:String){
  init{
      println("nombre $nombre")
  }
  constructor(name:String, edad:Int):this(name){
      println("Nombre $nombre, edad $edad")
  }
}
open class Base(val inicial:Int){
    open fun imprime(){
         println("algo $inicial")
     }
 }
 class General (val d:Int):Base(d){
     override fun imprime(){  //se usa para sobreescribir 
         super.imprime() //se usa si no hay constructor primario
         val suma: Int	= 4+d
     }
     
 }
 
fun main(args: Array<String>){
    var persona=Persona("angel", 19)
    println(persona)
//     var base=Base(4)
    var general=General(8)
	general.imprime()
    general.suma
    
}
