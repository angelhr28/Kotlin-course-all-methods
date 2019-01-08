import java.util.*
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

  interface PeliculasMVP {
        interface View {
        	fun imprimirCliente(cliente:String)
            fun imprimirEntrega(entrega:String)
            fun imprimirAviso(mensaje:String)
            fun imprimirMayorCliente(cliente:String)
            fun imprimirMayorVenta(venta:String)
			fun imprimirMenorCliente(cliente:String)
            fun imprimirMenorVenta(venta:String)
			fun imprimirLista(lista:String)
            fun imprimirDeudores(deuda:String)
            
            
        }

        interface Presenter {
  			fun registroCliente(pelicula:String, nombre:String, dni:Int, fecha:Date)
            fun registroEntrega(pelicula:String,fecha:Date,nombre:String)
            fun registroMayorCliente()
            fun registroMayorVenta()
			fun registroMenorCliente()
            fun registroMenorVenta()
 			fun registroLista()
            fun registroDeudores()
        }

        interface Model {
          	fun registroCliente(pelicula:String, nombre:String, dni:Int, fecha:Date, respuesta:(Boolean, String)->Unit)
            fun registroEntrega(pelicula:String,fecha:Date,nombre:String,respuesta:(Boolean, String)->Unit)
            fun registroMayorCliente(mayor:(Boolean, String)->Unit)
            fun registroMayorVenta(mayor:(Boolean, String)->Unit)
 			fun registroMenorCliente(mayor:(Boolean, String)->Unit)
            fun registroMenorVenta(mayor:(Boolean, String)->Unit)
 			fun registroLista(lista:(Boolean, String)->Unit)
            fun registroDeudores(deuda:(Boolean, String)->Unit)
 		       }
        	}
  class TicketView():PeliculasMVP.View{
      var presenter: TicketPresenter

        init{
            var fecha1dia = sumarDias(Date(),-1)
            var adelantadodia = sumarDias(Date(),+1)
            

            presenter= TicketPresenter(this)

            presenter.registroCliente("hulk","angel",12345, fecha1dia)
            presenter.registroCliente("pool","miguel",12344, adelantadodia)
            presenter.registroCliente("rocky3","pedro",12333, Date())
			presenter.registroCliente("hulk","jose",12222, fecha1dia)
            presenter.registroCliente("hulk","samuel",11111, adelantadodia)
            presenter.registroCliente("rocky3","angel",12345, Date())
            presenter.registroCliente("rocky3","pedro",12333, Date())
			presenter.registroCliente("hulk","jose",12222, fecha1dia)
            presenter.registroCliente("hulk","samuel",11111, adelantadodia)
            presenter.registroCliente("rocky3","angel",12345, Date())
            presenter.registroCliente("rocky3","pedro",12333, Date())
			presenter.registroCliente("hulk","jose",12222, fecha1dia)
            presenter.registroCliente("hulk","samuel",11111, adelantadodia)
            presenter.registroCliente("rocky3","angel",12345, Date())
            
            presenter.registroEntrega("hulk",fecha1dia,"angel")
            presenter.registroEntrega("pool",adelantadodia,"miguel")
            presenter.registroEntrega("rocky3",Date(),"pedro")            
            presenter.registroEntrega("hulk",fecha1dia,"jose")
            presenter.registroEntrega("hulk",adelantadodia,"samuel")
            presenter.registroEntrega("rocky3",Date(),"paco")
			presenter.registroMayorCliente()
            presenter.registroMayorVenta()
            presenter.registroDeudores()
            presenter.registroMenorCliente()
            presenter.registroMenorVenta()
            presenter.registroLista()
        } 
  			override fun imprimirCliente(cliente:String){
                println("DATOS DEL CLIENTE: $cliente")
            }
            override fun imprimirEntrega(entrega:String){
                println("RECIBO DE LA PELICULA:  $entrega")
            }
            override fun imprimirAviso(mensaje:String){
                println("AVISOS DE LA PELICULA:  $mensaje")
            }
        	override fun imprimirMayorCliente(cliente:String){
                println( "RECORDS DE ALQUILER DE VENTAS:  $cliente")
            }
            override fun imprimirMayorVenta(venta:String){
                println("RECORDS DE VENTAS DE PELICULAS:  $venta")
            }
        
			override fun imprimirDeudores(deuda:String){
                println("LA LISTA DE DEUDORES ES :  $deuda")
            }
            override fun imprimirMenorVenta(venta:String){
                println("RECORDS DE ALQUILER DE VENTAS:  $venta")
            }
        	override fun imprimirMenorCliente(cliente:String){
                println( "RECORDS DE ALQUILER DE VENTAS:  $cliente")
            }
            override fun imprimirLista(lista:String){
                println("CLASIFICACION DE CLIENTES :  $lista")
            }
            
  }
      
  class TicketPresenter(var view:PeliculasMVP.View): PeliculasMVP.Presenter{
       
        var model=TicketModel(this)
        
          	override fun registroCliente(pelicula:String, nombre:String, dni:Int, fecha:Date){
                model.registroCliente(pelicula,nombre,dni,fecha){consulta,respuesta->
                    if(consulta)view.imprimirCliente(respuesta)
                    else view.imprimirAviso(respuesta)
                }
            }
            override fun registroEntrega(pelicula:String,fecha:Date,nombre:String){
                model.registroEntrega(pelicula,fecha,nombre){consulta, respuesta->
                    if(consulta)view.imprimirEntrega(respuesta)
                    else view.imprimirAviso(respuesta)
                }
            }
            override fun registroMayorCliente(){
              model.registroMayorCliente(){consulta, respuesta->
                  if(consulta) view.imprimirMayorCliente(respuesta)
              
              }  
            }
            override fun registroMayorVenta(){
              model.registroMayorVenta(){consulta, respuesta->
                  if(consulta) view.imprimirMayorVenta(respuesta)
              }  
            }
            
            
 			override fun registroDeudores(){
                model.registroDeudores(){consulta, respuesta ->
                    if(consulta) view.imprimirDeudores(respuesta)
                    else view.imprimirAviso(respuesta)
                }
            }
            
            override fun registroMenorCliente(){
                model.registroMenorCliente(){consulta, respuesta->
                  if(consulta) view.imprimirMenorCliente(respuesta)    
                }
            }
            override fun registroMenorVenta(){
                model.registroMenorVenta(){consulta, respuesta->
                  if(consulta) view.imprimirMenorVenta(respuesta)
                 }
            }
 			
 			override fun registroLista(){
                model.registroLista(){consulta, respuesta ->
                    if(consulta)view.imprimirLista(respuesta)
                }
            }
            
  }
  class TicketModel(var presenter: PeliculasMVP.Presenter):PeliculasMVP.Model{
  		var listaPeliculas = mutableListOf<Peliculas>()
        var listaClientes = mutableListOf<Cliente>()
        var fechaActual = Date()  
      override fun registroCliente(pelicula:String, nombre:String, dni:Int, fecha:Date,  respuesta:(Boolean, String)->Unit){
				peliculas()
			  var conteo = 0
           	          		
          		var peliculaElegida = listaPeliculas.first{it.nombre == pelicula}
           		
         
          		if(peliculaElegida.cantidad == 1){
                var aviso = ""
                var fechaAviso:Date    
                var entrega : Boolean
               	var mora :Float = 0F
           		if(fecha <= fechaActual){
                   entrega= true
                    aviso = "SI"
                    fechaAviso = fecha    
                } else {
                     entrega =false
                 	aviso = "NO"
                 	 conteo++
 
                }
                
                
           var text= """
           NOMBRE: $nombre
           DOCUMENTO: $dni
           PELICULA:${peliculaElegida.nombre}
           PRECIO: ${peliculaElegida.precio}
           FECHA DE ENTREGA: ${fecha.getString()} 
           
           """
             	
               peliculaElegida.cantidad =0
                listaClientes.add(Cliente(pelicula,nombre,dni,fecha,entrega,conteo))
  				respuesta(true,text)           
            
             	}else {
                      peliculaElegida.cantidad =1
                      respuesta(false,"la pelicula ya fue alquilada vuelva luego")

                }      
     
     
      }
           
  
       override fun registroEntrega(pelicula:String,fecha:Date,nombre:String,respuesta:(Boolean, String)->Unit){

           		var peliculaElegida = listaPeliculas.first{it.nombre == pelicula}

           		var aviso = ""
                var fechaAviso:Date    
                var entrega : Boolean
               	var mora :Float = 0F
           		if(fecha <= fechaActual){
                   entrega= true
                    aviso = "SI"
                    fechaAviso = fecha    
                } else {
                     entrega =false
                 	aviso = "NO"
                 }
                
           if(entrega == false){mora = peliculaElegida.precio * peliculaElegida.estrellas *0.1f }
           		else {mora = 0f}
                  
           var text= """
 				 NOMBRE: ${nombre}
                 
                 FECHA DE ENTREGA: ${fecha.getString()}
				 PLAZO CUMPLIDO: $aviso
                 PRECIO POR DEMORA: $mora
           
           """
           
            respuesta(true, text)   
             }
      
       override fun registroMayorCliente(mayor:(Boolean, String)->Unit){
           
            	var listPersonas = listaClientes.groupBy(Cliente::dni, Cliente::pelicula)
                var listPersonas2 = listaClientes.groupBy(Cliente::nombre, Cliente::pelicula)
   				var mayor = listPersonas.maxBy{it.value.count()}?.key			
       var text="""
             EL CLIENTE CON MAYOR RECORDS DE COMPRAS  IDENTIFICADO CON EL DNI:  $mayor
             EL CLIENTE CON MAYOR RECORDS DE COMPRAS  IDENTIFICADO CON ELNOMBRE:  ${listPersonas2.maxBy{it.value.count()}?.key}   
             PELICULAS COMPRADAS SON: ${listPersonas.maxBy{it.value.count()}?.value}
            
            """
            mayor( true, text)
       }
       override fun registroMayorVenta(mayor:(Boolean, String)->Unit){
           
           var listPeliculas = listaClientes.groupBy(Cliente::pelicula, Cliente::nombre)
			var mayor=listPeliculas.maxBy{it.value.count()}?.key   			
           
            var text="""
             LA PELICULA MAS VENDIDAD ES :  $mayor
             Y SUS PRINCIPALES COMPRADORES SON: ${listPeliculas.maxBy{it.value.count()}?.value}
            
            """
            mayor(true,text)
       }
       
 		override fun registroDeudores(deuda:(Boolean, String)->Unit){
        
            var deudores = listaClientes.groupBy(Cliente::nombre, Cliente::mora)
   
            
            var text= """
            EL REGISTRO DE DEUDORES ES :
            $deudores
            """
            deuda(true,text )
        }
        
       
       override fun registroMenorCliente(mayor:(Boolean, String)->Unit){
           
            	var listPersonas = listaClientes.groupBy(Cliente::dni, Cliente::pelicula)
                var listPersonas2 = listaClientes.groupBy(Cliente::nombre, Cliente::pelicula)
   				var menor = listPersonas.minBy{it.value.count()}?.key			
       var text="""
             EL CLIENTE CON MENOR RECORDS DE COMPRAS  IDENTIFICADO CON EL DNI:  $menor
             EL CLIENTE CON MENOR RECORDS DE COMPRAS  IDENTIFICADO CON ELNOMBRE:  ${listPersonas2.minBy{it.value.count()}?.key}   
             PELICULAS COMPRADAS SON: ${listPersonas.minBy{it.value.count()}?.value}
            
            """
            mayor( true, text)
       }
       override fun registroMenorVenta(mayor:(Boolean, String)->Unit){
           
           var listPeliculas = listaClientes.groupBy(Cliente::pelicula, Cliente::nombre)
			var menor=listPeliculas.minBy{it.value.count()}?.key   			
           
            var text="""
             LA PELICULA MENOS VENDIDAD ES :  $menor
             Y SUS PRINCIPALES COMPRADORES SON: ${listPeliculas.minBy{it.value.count()}?.value}
            
            """
            mayor(true,text)
       }
       
 			override fun registroLista(lista:(Boolean, String)->Unit){
               var deudores= listaClientes.groupBy(Cliente::mora, Cliente::nombre)
               var text = """
               /////////////////////////////////////////
               LA RELACION DE DEUDORES ES ${deudores[1]}
               /////////////////////////////////////////
               LA RELACION DE RESPONSABLES ES ${deudores[0]}
               
               """ 
                lista(true,text)
            }
       
       
      fun peliculas(){

        listaPeliculas.add(Peliculas(1,"hulk",5f,5f))
        listaPeliculas.add(Peliculas(2,"pool",4f,2f))
        listaPeliculas.add(Peliculas(3,"avengers",1f,1f))
        listaPeliculas.add(Peliculas(4,"dino",2f,3f))
        listaPeliculas.add(Peliculas(5,"rocky3",3f,4f))
      }              
            
  }

  data class Peliculas(var id:Int,var nombre:String, var precio:Float,  var estrellas:Float,var cantidad:Int = 1)
  data class Cliente(var pelicula:String, var nombre:String, var dni:Int, var fecha:Date, var entrega:Boolean,var mora:Int=0)
  


fun main(args: Array<String>){
    var vista =TicketView()
 }  
fun Date.getString(format: String = "dd/MM/yyyy"): String {
    val formatter = SimpleDateFormat(format)
    return formatter.format(this)
}
fun sumarDias(fecha: Date, dias: Int) : Date {
    val	calendar = Calendar.getInstance()
    calendar.setTime(fecha)
    calendar.add(Calendar.DAY_OF_YEAR, dias)
    return calendar.getTime()
    
}
