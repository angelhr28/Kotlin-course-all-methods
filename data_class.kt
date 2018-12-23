data class Auto (var marca:String)
data class Persona2(var nombre:String, var edad:Int)
fun main(args: Array<String>){
    val auto = Auto( marca ="escarabajo")
    var marca:String = auto.marca
//     auto.marca="fort"
    auto.hashCode()
    println(auto.toString())
    val mabel= Persona2("mabel",13)
    val diper=mabel.copy("diper")
    val stand=mabel.copy("stand",34)
    println(mabel)
    println(diper)
    println(stand)
}
