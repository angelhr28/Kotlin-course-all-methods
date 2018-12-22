data class auto(var marca:String) {
  
}


fun main(args: Array<String>) {
  val auto=auto(marca:"fort")
  var marca:String = auto.marca
  println(auto)
}