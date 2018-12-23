fun main(args: Array<String>){
    var arrA =intArrayOf(1,2,3,4)// intArray crea un array
    val lisA= arrayListOf("hola","como estas","te","extraño")
	
    val num1=arrA[2]// tomas el valor especifico de un array por su index
    arrA[0]=39//cambias el valor de un array por su posicion
	
    val mutablelist=mutableListOf(1,2,3,4,5)
// se usa para tener un array que puede aumentar su tamaño
    mutablelist.add(9)//añade un valor al array al final
	mutablelist.add(2,9)//añade valor segun la posicion (posicion, valor)
    mutablelist[3]=3// cambio de un valor del array
    val map=mutableMapOf<String, Int>(Pair("key",12))//ingresa un string y devuelve un entero
    //Pair objeto que relaciona dos valores de una clase
    map.put("key2",2)// ingreso de llaves
} 
 
