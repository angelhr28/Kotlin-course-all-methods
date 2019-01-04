//in - !in   esta entre - no esta dentro      var= 2 --> if(x in 2..3) -->true   
// lambdas: lo primero armar bien la lambda y luego pasar a la segunda funcion que sera el  parametro
// ver -------> fun Order.maxPricedItemValue(): Float = this.items.maxBy { it.price }?.price ?: 0F    // 2  
// ver -------> fun Order.maxPricedItemName() = this.items.maxBy { it.price }?.name ?: "NO_PRODUCTS"
// .any {condicion}-->alguno de los elementos cumplen el predicado
// .all {condicion}-->todos los elementos cumplen el predicado
// .none{condicion}-->ninguno de los elementos cumplen el predicado
// .find{it.startsWith(Palab.buscar)} --> busca a la primera palabra que contenga eso palabra 
// .findLast{it.startsWith(Palab.buscar)} --> busca a la ultima palabra que contenga eso palabra
// .find { it.contains("nothing") } --> busca a algun elemnto que contenga esa palabra
// .first() --> busca o ejecuta desde el  primer elemento 
// last() --> busca o ejecuta desde el  ultimo elemnto \
// .count() --> numero de elemento, conteo de elementos 
// .partition --> divide a la lista en dos partes 
//.associateBy { it.phone }  -->los agrupa y si se repite  se toma el ultimos                         // 3
//.associateBy(Person::city, Person::phone) -->repoio pero se da los parametros (key, contenido)
//.groupBy(Person::city, Person::name)  --> agrupa todo dentro de un array (key, contenido), 
//											si se repite se ingresa ambos dentro de un mismo array
//zip --> union de elementos:
//							A zip B --> crea un objeto pair [(A1,b1),..,(An,Bn)]                      
// 							A.zip(B) { a, b -> "$a$b" } --> junta los elemntos dentro de un string
//.flatMap --> repoio del map, diferencia de que puedes puedes concatenar  flapMaps  
//.min(valores) --> compara los valores y halla el minimo
//.max(valores) --> compara los valores y halla el maximo
//.sorted(valores) --> ordena los elementos de manera ascendente 
//.sortedBy{ it,fun, .class} --> ordena los elementos de manera ascendente especificando el elemento
//								si pones  un -it lo ordena de manera descendente
//.getOrElse(indice o key) { default value }  --> metodo de busqueda seguro por medio de indices o keys							
//
