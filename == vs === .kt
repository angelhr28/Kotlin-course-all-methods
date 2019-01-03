data class Persona(var name:String)
class Persona2(var name:String)
fun main(args: Array<String>){
    var persona1 = Persona("victor") 
    var persona2 = Persona("victor")
        println(persona1 == persona2)/////  iguala valores
        println(persona1 === persona2)////  iguala referencias
        println(persona1.name == persona2.name)////// iguala valores 
        println(persona1.name === persona2.name)////  iguala valores  
        println("		")

    var ejemplo1 = Persona2("h")
    var ejemplo2 = Persona2("h")
        println(ejemplo1 == ejemplo2)/////  iguala los tipos de datos y como no son Type de algo ni 
        println(ejemplo1 === ejemplo2)////  class de envoltura bota false 
        println(ejemplo1.name == ejemplo2.name)////// aca si revisa las el contenido de la cadenas  
        println(ejemplo1.name === ejemplo2.name)////  aca si revisa las el contenido de la cadenas
		println("")
    
    var a = 8
    var b = 8
        println (a==b)//// compara datos primitivos o previamente inicializados
        println (a===b)/// compara datos primitivos o previamente inicializados
        println	("")
    var c = Integer(1)
    var d = Integer(1)
        println (c==d)//// compara datos que estan dentro de la envoltura (Integer) 
        println (c===d)/// compara las referncias de los datos por lo cual no da  falso 
    
    
    
    
    
    
}
