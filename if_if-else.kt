fun main(args: Array<String>){
    "hola que tal".print()
    val definir=definir(true) // varia segun sea el tipo de variable
} 

fun definir(data:Any){//Any= variable de tipo universal 0 casteo
     if(data is String){
     print(data.length)
     }else if(data is Int){
         println(data+2)
     }else if(data is Boolean){
         if(data==true){
             println("verdad")
         }else{
             println("falso")
         }
     }
 }
