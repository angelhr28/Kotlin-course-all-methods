import java.util.*
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

  interface PeliculasMVP {
        interface View {
        	fun imprimirCliente(cliente:String)
            fun imprimirEntrega(entrega:String)
            fun imprimirAviso(mensaje:String)
        }

        interface Presenter {
  			fun registroCliente(pelicula:String, id:Int, nombre:String, dni:Int, fecha:Date)
            fun registroEntrega()
            
        }

        interface Model {
          	fun registroCliente(pelicula:String,id:Int, nombre:String, dni:Int, fecha:Date, respuesta:(Boolean, String)->Unit)
            fun registroEntrega(respuesta:(Boolean, String)->Unit)
            
        }
        }
  class TicketView():PeliculasMVP.View{
      var presenter: TicketPresenter

        init{
            var fecha1dia = sumarDias(Date(),-1)
        	presenter= TicketPresenter(this)

            presenter.registroCliente("hulk",1,"angel",70544414, fecha1dia)
            presenter.registroCliente("hulk",1,"miguel",7544414, fecha1dia)
            presenter.registroCliente("rocky3",1,"angel",70544414, fecha1dia)
            
            presenter.registroEntrega()
        } 
  			override fun imprimirCliente(cliente:String){
                println("RECIBO DE LA PELICULA: $cliente")
            }
            override fun imprimirEntrega(entrega:String){
                println("DATOS DEL CLIENTE:  $entrega")
            }
            override fun imprimirAviso(mensaje:String){
                println("AVISOS DE LA PELICULA:  $mensaje")
            }
        
  }
      
  class TicketPresenter(var view:PeliculasMVP.View): PeliculasMVP.Presenter{
       
        var model=TicketModel(this)
        
          	override fun registroCliente(pelicula:String, id:Int, nombre:String, dni:Int, fecha:Date){
                model.registroCliente(pelicula,id,nombre,dni,fecha){consulta,respuesta->
                    if(consulta)view.imprimirCliente(respuesta)
                    else view.imprimirAviso(respuesta)
                }
            }
            override fun registroEntrega(){
                model.registroEntrega(){consulta, respuesta->
                    if(consulta)view.imprimirEntrega(respuesta)
                    else view.imprimirAviso(respuesta)
                }
            }
  }
  class TicketModel(var presenter: PeliculasMVP.Presenter):PeliculasMVP.Model{
  		var listaPeliculas = mutableListOf<Peliculas>()
        var listaClientes = mutableListOf<Cliente>()
        var fechaActual = Date()  
      
      override fun registroEntrega(respuesta:(Boolean, String)->Unit){
            
          	var text ="""
            	DATOS DEL CLIENTE: 
            """
          listaClientes.forEach{text+= """
                 NOMBRE: ${it.nombre}
                 DNI: ${it.dni}
                 PELICULA: ${it.pelicula}
             	 FECHA DE ENTREGA: ${it.fecha.getString()}
               
          """
              
          }
          respuesta(true,text)
          
          
          
          
            }
      
      override fun registroCliente(pelicula:String, id:Int, nombre:String, dni:Int, fecha:Date,  respuesta:(Boolean, String)->Unit){
        	    peliculas()
				var peliculaElegida = listaPeliculas.first{it.nombre == pelicula}
          		 if(peliculaElegida.cantidad == 1){
                     var aviso = ""
                var fechaAviso:Date    
                var entrega : Boolean
            	var mora :Float = 0F
          		if(fecha == fechaActual){
                  entrega= true
                   aviso = "SI"
                   fechaAviso = fecha    
                } else {
                    entrega =false
                	aviso = "NO"
                } 
               	if(entrega == false) mora = peliculaElegida.precio * peliculaElegida.estrellas *0.1f 
          		var text = """
                NOMBRE: $nombre
                DNI: $dni
                FECHA DE ENTREGA: ${fecha.getString()}
                PLAZO CUMPLIDO : $aviso
                MONTO ADICIONAL: $mora
                """
               	
             	peliculaElegida.cantidad =0
                listaClientes.add(Cliente(pelicula,id,nombre,dni,fecha,entrega))
 				respuesta(true,text)           
            
            	}else {
                     peliculaElegida.cantidad =1
                     respuesta(false,"la pelicula ya fue alquilada vuelva luego")

                 }
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
  data class Cliente(var pelicula:String, var id:Int, var nombre:String, var dni:Int, var fecha:Date, var entrega:Boolean)
  


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
 
