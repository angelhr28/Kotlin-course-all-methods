fun main(args: Array<String>){
var numeros = intArrayOf(1,2,3,4,5,6)
for(i:Int in numeros.indices){
    println(numeros[i])
}
var lista= listOf("lapiz", "borrador","tijera","gg")
println("-----------------------")
    var a=4
while(a!=0){
    a--
    println(a)
}
var suma:Int=0
var input:String?=""
do{
    println("ingrese los valores")
    input=readLine()
    suma+=input?.toInt()?:0
}while(input!="0")
println("la suma es $suma")
} 

