// clases heredadas normales 
// menor restriccion al uso de los componetes 
//se necesita la palabra open para acceder al metodo o caracteristica
/////////////////////////////////////////////////////////////////////////////////////
// abstract 
// las clase abstracta  nos  permite modificar la clases a nuestra conveniencia
// se sobreescriben 
// se debe usar  todo lo heredado obligatoriamente 
// no se puede poner valores a los abstrac
////////////////////////////////////////////////////////////////////////////////////
// interface
// las interfaces no emplean metodos  ni datos  solo usan  los que fueron heredados de otras clases 
// defin los metods que deben implementar en las clases 
// listado de las  acciones a utilizar 
 
abstract class Forma(val nombre: String) {
   abstract fun area(): Double

   fun printName() {
       println("el nombre es: ${nombre}")
   }
   abstract fun operar()
}

open class Forma0(var nombre: String) {
    
   open fun area0()= 0.0
    
   fun printNameo(){
       println("el nombre es: ${nombre}")
   }
   
   open fun operar() {
       println("ALISTAR SALA DE OPERACIONES")
   }
}

class Circulo(nombre: String, val radio: Double): Forma(nombre) {
   override fun area() = Math.PI * Math.pow(radio, 2.0)
   override fun operar() {
       
   }
   
    fun hlal(){
       print("asd")
       printName()
   } 
}
class Cuadra(nombre:String , val lado:Double):Forma0(nombre){
    override fun area0()= lado*lado
    override fun operar() {
        super.operar()
        
	}
}

fun main(args: Array<String>) {
   val cuadrado = Cuadra("Cuadrado", 2.0)
   println(cuadrado.nombre)
   println(cuadrado.lado)
   println(cuadrado.area0())
   println(cuadrado.printNameo())
  
    ///////////////////////////////////////////////////
   
   val circulo = Circulo("Circulo", 4.0)
   println(circulo.nombre)
   println(circulo.radio)
   println(circulo.area())
   println(circulo.printName())


// // las interfaces no emplean metodos  ni datos  solo usan  los que fueron heredados de otras clases 
// defin los metods que deben implementar en las clases 

   val circulo2 = Circulo2("Circulo", 4.0)
   println(circulo2.nombre)
   println(circulo2.radio)
   println(circulo2.area2())
   println(circulo2.printName2())
}




interface Forma2 {
   fun area2(): Double
   fun printName2()
}

class Circulo2( var nombre: String, val radio: Double): Forma2 {
   override fun area2() = Math.PI * Math.pow(radio, 2.0)
	override fun printName2() {
        println("el nombre es: ${nombre}")
    } 
}
