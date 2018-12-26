data class Persona (var nombre:String, var apeP:String,var apeM:String, var fecha:String, var documento:Int, var sexo:String, var hermanos:Int, var edad:Int,var correo:String)
 
fun main(args: Array<String>){
    
    var persona1=Persona("Carlos Jose","Robles","Gomes","06/08/1995",78541245,"m",2,1995,"carlos.roblesg@hotmail.com")
    var persona2=persona1.copy("Miguel Angel","Quispe","Otero","28/12/1995",79451654,"m",0,1995,"miguel.anguel@gmail.com")
    var persona3=persona1.copy("karla Alexandra","Flores","Rosas","15/02/1997", 77485812,"f",1,1997,"Karla.alexandra@hotmail.com")
    var persona4=persona1.copy("Nicola","Quispe","Zeballos","08/10/1990",71748552,"m",1,1990," nicolas123@gmail.com")
    var persona5=persona1.copy("Pedro Andre","Picasso","Betencur","17/05/1994",74823157,"m",2,1994," pedroandrepicasso@gmail.com")
    var persona6=persona1.copy("Fabiola Maria","Palacio","Vega","02/02/1992",76758254,"f",0,1992,"fabi@hotmail.com")
	var Lpersonas = arrayListOf(persona1,persona2,persona3,persona4,persona5,persona6)
  	var a:Int = 1
  	var b:Int = 1
    
//     while(b!=0){
// 		println("1.lista de personas")
//         println("2.mayor edad")
//         println("3.menor edad")
//         println("4.lista de hombres")
//         println("5.lista de mujeres")
//         println("6.mas de dos hermanos")
//         println("7.formato")
//         println("8.usuario")
//         print("opcion")
//         var opcion:Int =1
        
     //   when(opcion){
	 	 lista(Lpersonas)	
         println("")
    	 println ("la edad mas alta es ${mayor(Lpersonas)}")
         println("")
         println ("la edad mas baja es ${menor(Lpersonas)}")
    	 println("")
    	 sexoh(Lpersonas)
         println("")    
    	 sexom(Lpersonas)
		 println("")
    	 hermano(Lpersonas)
         println("")  
    	 formato(Lpersonas)
         usuario(Lpersonas)
// 		}}
        }

///////////////////////////////////////////////////////////////////////
fun lista(persona:ArrayList<Persona>){
	for(a:Int in persona.indices){
        println(persona[a])
    }
}
        
/////////////////////////////////////////////////////////////////////////////////////////7
fun mayor(edades:ArrayList<Persona>):Int{
      	    var aux2 = 100000000	
    	for(a in edades.indices){
            if(aux2 > edades[a].edad){
                aux2=edades[a].edad
            }
        }
               return  2018 - aux2 
}
//////////////////////////////////////////////////////////////////////7
fun menor (edades:ArrayList<Persona>):Int{
      	    var aux = 0	
    	for(a in edades.indices){
            if(aux<edades[a].edad){
                aux=edades[a].edad
            }
        }
               return 2018-aux 
}

////////////////////////////////////////////////////////////////////////////

fun sexoh(genero:ArrayList<Persona>){
    var a:Int=0
  
    for(i:Int in genero.indices){
    if(genero[i].sexo =="m"){
    	a++
       var hombre=arrayListOf(genero[i].nombre)
      	  println(hombre)
	     }  
    }
	  println("EL NUMERO DE HOMBRE ES DE $a")
}
fun sexom(genero:ArrayList<Persona>){
    var b:Int=0
    
  for(m:Int in genero.indices){
       if(genero[m].sexo !="m"){
         b++
 		var mujere=arrayListOf(genero[m].nombre)
          	  println(mujere)

     }
  }
   	 println("EL NUMERO DE MUJERES ES DE $b")
}
/////////////////////////////////////////////////////////////////////////7
fun hermano(num:ArrayList<Persona>){
	for(m:Int in num.indices){
       if(num[m].hermanos >=2){
 		var relacion=arrayListOf(num[m].nombre)
          	  println(relacion)
       }
    }
}
       
////////////////////////////////////
fun formato(num:ArrayList<Persona>){
    for(a:Int in num.indices){
    	var aux:String = num[a].apeM
        println("${(num[a].nombre).capitalize()} ${num[a].apeP.capitalize()} ${aux[0]}. ")   
	 

    }
}

/////////////////////////////////////////////7
 fun usuario(num:ArrayList<Persona>){
     for(i:Int in num.indices){
       
        val user = listOf(num[i].correo)	
        val user2=user.map{x->x.split("@")}
        println(user2)
         }
    }
 







