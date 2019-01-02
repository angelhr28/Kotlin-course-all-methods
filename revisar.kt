data class Persona (var nombre:String, var apeP:String,var apeM:String, var fecha:String, var documento:Int, var sexo:Char, var hermanos:Int ,var correo:String,var name1: String?=null, var user: String? = null)
 
fun main(args: Array<String>){
	var lpersonas = mutableListOf<Persona>()
    lpersonas.add(Persona("Carlos Jose","Robles","Gomes","06/08/1995",78541245,'m',2,"carlos.roblesg@hotmail.com"))
	lpersonas.add(Persona("Miguel Angel","Quispe","Otero","28/12/1995",79451654,'m',0,"miguel.anguel@gmail.com"))
    lpersonas.add(Persona("karla Alexandra","Flores","Rosas","15/02/1997", 77485812,'f',1,"Karla.alexandra@hotmail.com"))
    lpersonas.add(Persona("Nicola","Quispe","Zeballos","08/10/1990",71748552,'m',1," nicolas123@gmail.com"))
    lpersonas.add(Persona("Pedro Andre","Picasso","Betencur","17/05/1994",74823157,'m',2," pedroandrepicasso@gmail.com"))
    lpersonas.add(Persona("Fabiola Maria","Palacio","Vega","02/02/1992",76758254,'f',0,"fabi@hotmail.com"))
    
  	var a:Int = 1
  	var b:Int = 1
	var ListHombres = lpersonas.filter { it.sexo == 'm'}
	var ListMujeres = lpersonas.filter { it.sexo == 'f'} 
    var Hermanos = lpersonas.filter{it.hermanos > 2}
	var formato = lpersonas.map{ "${it.nombre}  ${it.apeP} ${it.apeM[0]} "}
	var usuarios = lpersonas.map{ it.correo.split("@hotmail.com","@gmail.com") }
	    for (h in lpersonas.indices){
        val primeroN= lpersonas [h].nombre.substringBefore(" ")
        lpersonas[h].name1= primeroN
    }
	     
//     //     while(b!=0){
   	     println("1.lista de personas")
         println("2.mayor edad")
         println("3.menor edad")
         println("4.lista de hombres")
         println("5.lista de mujeres")
         println("6.mas de dos hermanos")
         println("7.formato")
         println("8.usuario")
         println("		")
//         print("opcion")
        var opcion:Int =8
        
        when(opcion){
	 	 1-> {println(lpersonas.indices )	
         println("")}
//     	 2->{println ("la edad mas alta es ${mayor(Lpersonas)}")
//          println("")}
//       3->{println ("la edad mas baja es ${menor(Lpersonas)}")
//     	 println("")}
         4->{println(ListHombres)
            println("")}    
         5->{println(ListMujeres)
 	     println("")}
         6->{println(Hermanos)
	     println("")}  
         7->{ println(formato) }
         8->{println(usuarios)}
         9->{ lpersonas.forEach {
   		     println("${it.name1}")
    		}}
  		}
        

    for (i in lpersonas.indices) {
        val usuario = lpersonas[i].correo.substringBefore("@")
        lpersonas[i].user = usuario
    }
    println("Estos son sus usuarios")
    lpersonas.forEach {
        println("${it.user}")
    }
}

////////////////////////////////////////////////////////////////////// 
/////////////////////////////////////////////////////////////////////////////////////////7
// fun mayor(edades:ArrayList<Persona>):Int{
//       	    var aux2 = 100000000	
//     	for(a in edades.indices){
//             if(aux2 > edades[a].edad){
//                 aux2=edades[a].edad
//             }
//         }
//                return  2018 - aux2 
// }
//////////////////////////////////////////////////////////////////////7
// fun menor (edades:ArrayList<Persona>):Int{
//       	    var aux = 0	
//     	for(a in edades.indices){
//             if(aux<edades[a].edad){
//                 aux=edades[a].edad
//             }
//         }
//                return 2018-aux 
// }    
////////////////////////////////////
