fun main(args: Array<String>) {
  	
    println("Ususario: ${name()}")
    println("Password: ${passw()}")
    println("")
    var user = User()
}

interface app{
    interface sol{
        fun mensajeaceptado(reproduce:String)
        fun error(mensaje:String)
    }
	interface prog{
        fun manda()
    }
}

class User():app.sol{
    var obj: app.prog
		
    init { 
     obj = Progra(this)
     obj.manda()
    }
	override fun mensajeaceptado(mensaje:String){
        println(mensaje)
    }
    override fun error(msjerror:String){
        println(msjerror)
    }
}

class Progra(var music: app.sol): app.prog{
	    
    override fun manda(){
        	var comparar = name()
            var comparar2= passw()
        	if( comparar2 == 1234 && comparar =="angel") music.mensajeaceptado("usted ha ingresado a su cuenta")
        	else music.error("el usuario o la contrasena es incorrecta")    
        }
}
fun name():String{
    return "angel"
}
fun passw():Int{
    return 12343
}



////////////////////////////



