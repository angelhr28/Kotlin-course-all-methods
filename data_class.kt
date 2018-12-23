data class Auto (var marca:String, private	var puertas:Int){
    var numero_puertas=puertas
    get(){
       return if(field>0) field else 1
    }
}
data class Persona2(var nombre:String, var edad:Int)
fun main(args: Array<String>){
    val auto = Auto( marca ="escarabajo",puertas=0)
    var marca:String = auto.marca
//     auto.marca="fort"
    auto.hashCode()
    auto.numero_puertas=4
    println(auto.toString())
    println(auto.numero_puertas)
   
    val mabel= Persona2("mabel",13)
    val diper=mabel.copy("diper")
    val stand=mabel.copy("stand",34)
    println(mabel)
    println(diper)
    println(stand)
}
