fun main(args: Array<String>) {
  val stg="hola que tal"
  val nombre="anel"
  val edad= 19
  val sentencian :String = "ella es "+nombre+" y tiene "+ edad+" años."
  val sentencian :String = "ella es $nombre y tiene $edad años"
  // podemos ver las sentencias usando el simbolo de pesos $ 
  val cumpl="$nombre cumple ${edad+1}"
  // uso comillas para poder realizar operaciones basicas
  println(cumpl)
  val text:String=""" 
      >este es un string que debo imprimir 
      >pero como puedes ver este es 
      >demaciado largo.
  """.trimMargin(marginPrefix ">")
  // este ultimo comando sirve para alinear el texto eligiendo el simbolo de alineado
  
//  println(" hola")
}