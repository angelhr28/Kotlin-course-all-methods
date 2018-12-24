// una funcion de orden mayor es aquella donde una funcion vive dentro de otra, osea lo pasas por parametro 
fun suma(num:Int,num2:Int, func:()->Unit){ // se indica los parametros
    println("suma de $num y $num2 = ${num+num2} ")// funcion suma
	func()
}
fun main(args: Array<String>){
	suma(8, 12) {
        println("funcion de orden mayor")//duncion func:
        // siempre y cuando sea el ultimo parametro
    }
	"hola".funcion{ // toma "hola" y lo evalua
        println("que pex") // imprime luego esto
    }
    "hola".funcion2{ // evalua repoio
        println(it) // ahora podemo usar el it para tomar el dato de hola y evaluar
    }
    "hola".funcion3{
        println(length) // ahora podemos llamar partes especificas de la funcio
        with("hola"){
        println(length) // repoio solo que esta vez usando "with"
        }
    }
}


// ahora para hacer funciones de tipo extendibe o diminutivas
fun String.funcion(func: ()->Unit){ //pasamo por paramtro a una funcion
    func() // llamamos a la funcion
    println(this.length) // realizamos la impresion del objeto de arriba "this"
}
fun String.funcion2(func2: (String)->Unit){ // variacion ahora llamamos un String en nuestra segunda funcio
    func2(this)// por ende podemos usar el this para hacer mencion de este
    println(this.length) 
}
fun String.funcion3(func3: String.()->Unit){ // variacion ahora hacemos que sea parte de la funcion principal
    this.func3()// por ende podemos usar el this para ejecutar la funcion luego de la primera
    println(this.length) 
}
