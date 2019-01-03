open abstract class Animales(var nombre:String, var genero:Char ){
		 open fun cazar(){
            print(" el animal $nombre caza ")
        }   
        abstract fun cazar2()
}

class carnivoro( nombre:String , genero:Char , var alimento:String):Animales( nombre , genero ) {
    override fun cazar(){
        print(" el animal caza $alimento ")
    }
    override fun cazar2(){
        println("gg")
    }
}
class Herv(nombre:String, genero:Char, var alimento:String):Animales( nombre, genero){
    override fun cazar2(){
        print(" el animal caza $alimento ")
    }
}
interface Animales2{
    var animal:String
    fun cazar0()
    fun comer()
    fun dormir()
    
}

class Homni(var nombre:String):Animales2 {
   override var animal = "animal"
    override fun cazar0(){
        print("el $nombre caza $animal")
    }
    override fun comer(){
        println("el $nombre come $animal")
    }
    override fun dormir(){
        println("el $nombre duerme")
    }
    
}

class Personas{
    companion object cualidades : Animales2{
        // digo q devuelve un tipo Animales2 y luego uso el companion objetc para 
        // poder ingresar a esos valores de manera directa.
        override var animal = "animal"
        override fun cazar0(){
            print("el caza $animal")
        }
        override fun comer(){
            println("el  come $animal")
        }
        override fun dormir(){
            println("el  duerme")
        }
        
    }
}

fun main(args: Array<String>) {
  	Personas.cualidades.cazar0()
    Personas.cualidades.comer()
    Personas.cualidades.dormir()
    var animal0 = Homni("hombre")
    println(animal0.cazar0())
    print(animal0.comer())
    println(animal0.dormir())

    
    
    var animal1 = carnivoro("leon", 'm', "zebra")
    print(animal1.nombre)
    print(" de sexo  ${animal1.genero} come	")
    print(animal1.alimento)
    println(animal1.cazar())


    var animal2 = Herv("zebra", 'f', "pasto")
    print(animal2.nombre)
    print(" de sexo  ${animal1.genero} come	")
    print(animal2.alimento)
    print(animal2.cazar())
	println(animal2.cazar2())
    
}
