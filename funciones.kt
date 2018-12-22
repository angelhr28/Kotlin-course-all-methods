fun hello():Unit{
  println("hola a todos")
} 

fun suma(a:int, b:int){
  println("la suma de $a y $b es igual a ${a+b}")
}

fun max(a:int, b:int):Int{
  if(a>b)
    return a  
  else
  return b
}