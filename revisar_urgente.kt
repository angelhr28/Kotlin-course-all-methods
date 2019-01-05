import java.util.*
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
fun main(args: Array<String>){
var vista =TicketView()
}

interface TicketMVP {
    interface View {
            fun mostrarMensaje(mensaje: String)
            fun cargaVistaDeImpresion()
            fun imprimitTicket(ticket: String)
            fun imprimirInformeDiario(informe: String)
 			fun imprimirTipo(Tipo:String)
            
            fun imprimirDestinosMayor(mayor:String)
            fun imprimirDestinosMenor(menor:String)
            fun imprimirMenorVenta(venta:String)
            fun clienteFrecuente(completo:String)
    	}
    
    interface Presenter {
            fun aperturarCaja(fecha: Date) 
        	fun mostrarMensaje(mensaje: String)
            fun generarTicket(nombre: String, ciudad: listCiudad, cantidadComprada:cantidadComprada)
            fun cerrarCaja()
			fun GenTipodeCliente()
            
            fun DestinosMayor(ciudad: listCiudad)
            fun DestinoMenor(ciudad: listCiudad)
            fun MenorVenta(fecha:Date)
            fun ClienteFrecuente()
    	}
    
    interface Model {
            fun aperturarCaja(fecha: Date , enviar:(Boolean)->Unit)
            fun generarTicket(nombre: String, ciudad: listCiudad, cantidadComprada:cantidadComprada,
                             enviar:(Boolean, String)-> Unit)
            fun cerrarCaja(enviar:(Boolean, String)->Unit)
            fun GenTipodeCliente(enviar:(Boolean, String)->Unit)
        	
        	fun DestinosMayor(ciudad: listCiudad, ver:(Boolean,String)->Unit)
            fun DestinoMenor(ciudad: listCiudad, ver:(Boolean,String)->Unit)
            fun MenorVenta(fecha:Date, ver:(Boolean,String)->Unit)
            fun ClienteFrecuente( ver:(Boolean,String)->Unit)
    	    
        
    	}
	}
  class TicketView():TicketMVP.View{
      var presenter: TicketPresenter
      
      init{
          val hace3dias = sumarDias(Date(), -3)
          presenter= TicketPresenter(this)
          presenter.cerrarCaja()
          presenter.aperturarCaja(hace3dias)  
          presenter.aperturarCaja(hace3dias) 
          presenter.ClienteFrecuente()
   		  presenter.generarTicket("angel", listCiudad.lima, cantidadComprada.uno)   
          presenter.generarTicket("jose", listCiudad.tumbes,cantidadComprada.tres)
          presenter.generarTicket("angela", listCiudad.ica,cantidadComprada.dos)  
      	  
          
          
          val hace2dias = sumarDias(Date(), -2)
          presenter.cerrarCaja()
          presenter.aperturarCaja(hace2dias)  
          presenter.aperturarCaja(hace2dias) 
   		  presenter.generarTicket("hugo", listCiudad.lima, cantidadComprada.uno)   
          presenter.generarTicket("angel", listCiudad.tumbes,cantidadComprada.tres)
          presenter.generarTicket("juan", listCiudad.ica,cantidadComprada.dos)  
      	 
           
          val hace1dias = sumarDias(Date(), -1)
          presenter.cerrarCaja()
          presenter.aperturarCaja(hace1dias)  
          presenter.aperturarCaja(hace1dias) 
   		  presenter.generarTicket("miguel", listCiudad.lima, cantidadComprada.uno)   
          presenter.generarTicket("geral", listCiudad.tumbes,cantidadComprada.tres)
          presenter.generarTicket("angel", listCiudad.ica,cantidadComprada.dos)  
      	  presenter.GenTipodeCliente()
      }
      override fun cargaVistaDeImpresion(){
            println("La caja a sido aperturada con exito")
      }
      override fun imprimitTicket(ticket: String){
      		println("Confirmacion de ticket generado  $ticket")    
      }
      override fun imprimirInformeDiario(informe: String){
          	println("La relacion de compra de tickets es:  $informe")
      }  
      override fun mostrarMensaje(mensaje: String){
            println(mensaje)
      }
        
        
      
      override fun imprimirDestinosMayor(mayor:String){
          println("El destino mayor visitado por los clientes es $mayor")      
      }
      override fun imprimirDestinosMenor(menor:String){
          println("El destino mayor visitado por los clientes es $menor")
      }
      override fun imprimirMenorVenta(venta:String){
          println("El dia que hay menos compra por parte de los clientes es $venta")
      }
	  override fun clienteFrecuente(completo:String){
          println("El cliente mas frecuente de la empresa es  $completo  \t FELICIDADES!!!!!")
      }  

	  override fun imprimirTipo(Tipo:String){
        println("El cliente posee rango :  $Tipo")  
      }
    }
  class TicketPresenter(var view:TicketMVP.View): TicketMVP.Presenter{
           
        var model=TicketModel(this)  
            
 		override fun aperturarCaja(fecha: Date){  	   
         	if(Date() >fecha) model.aperturarCaja(fecha){
 				if(it)view.cargaVistaDeImpresion()
                else view.mostrarMensaje("lo sentimos, la caja ya fue abierta")         
            }
                else view.mostrarMensaje("Disculpe, la caja no se pudo aperturar")

        } 
        override fun mostrarMensaje(mensaje: String){
            view.mostrarMensaje(mensaje)
        }
        override fun generarTicket(nombre: String, ciudad:listCiudad , CantidadComprada:cantidadComprada){
            model.generarTicket(nombre,ciudad,CantidadComprada){enviar, text ->
                if(enviar){
               		view.imprimitTicket(text)     
                } 
                else {
                    view.mostrarMensaje(text)
                }
            }
        }
      	override fun cerrarCaja(){
            model.cerrarCaja(){enviar,nombre ->
               if(enviar) view.imprimirInformeDiario(nombre)
               else view.mostrarMensaje("la caja se cerro")
            }
        }
        override fun GenTipodeCliente(){
            model.GenTipodeCliente(){enviar,nombre ->
                if(enviar) view.imprimirTipo(nombre)
               else view.mostrarMensaje(nombre)
            
            }
        }
        

        override fun DestinosMayor(ciudad: listCiudad){
            model.DestinosMayor(ciudad){eleccion,respuesta->
             if(eleccion) view.imprimirDestinosMayor(respuesta)
             else view.mostrarMensaje(respuesta)
            }
        }
        override fun DestinoMenor(ciudad: listCiudad){
            model.DestinoMenor(ciudad){eleccion,respuesta->
             if(eleccion) view.imprimirDestinosMenor(respuesta)
             else view.mostrarMensaje(respuesta)
            }
        }
        override fun MenorVenta(fecha:Date){
            model.MenorVenta(fecha){eleccion,respuesta ->
                if(eleccion) view.imprimirMenorVenta(respuesta)
                else view.mostrarMensaje(respuesta)
            }
        }
        override fun ClienteFrecuente(){
            model.ClienteFrecuente(){eleccion,respuesta ->
                if(eleccion) view.clienteFrecuente(respuesta)
                else view.mostrarMensaje(respuesta)
            }
        }
    	
        
        
           
  }
  class TicketModel(var presenter: TicketMVP.Presenter):TicketMVP.Model{
  	
      var contador = 0
      var listaPersonas= mutableListOf<Persona>()
      var fechaActual=""	   
      override fun aperturarCaja(fecha: Date,enviar:(Boolean)->Unit){
              
              if(contador>0){
                return enviar(false) 
              }
            	contador++
            	fechaActual= fecha.getString()
             	enviar(true)
		
      }
        override fun generarTicket(nombre: String, ciudad: listCiudad, Cantidad: cantidadComprada,  enviar:(Boolean, String)-> Unit){
			enviar( false , "lo sentimos su ticket ya se creo")
            listaPersonas.add(Persona(nombre,ciudad,fechaActual,contador,Cantidad))
            var Text="""
 	    /////////////////tiket emitido///////////////
            Numero de boleto: $contador
            /////////////////////////////////////////////
            Usuario: $nombre
            Lugar de destino: $ciudad
            Fecha de emision: $fechaActual 
             
            /////////////////////////////////////////////
            """
            contador++
            enviar( true , Text)
        }
        override fun cerrarCaja(enviar:(Boolean, String)->Unit){
       		
            if(contador == 0){
                return enviar(false,"La caja nunca fue abierta")
            }
           
            var listafechas = listaPersonas.filter{it.fecha ==fechaActual}
        	var Text2="""
			/////////////////Registro de compras///////////////
            Fecha del registro: ${fechaActual}
            ///////////////////////////////////////////////////
            Numero de tickets vendidos: ${listafechas.count()}
            Lista de pasajeros
            """
            listafechas.forEach{Text2 += "\t.${it.nombre}\n"}
            contador = 0
            enviar(true, Text2)
        
        }
        override fun GenTipodeCliente(enviar:(Boolean, String)->Unit){
          enviar(false,"")
            var listaDatos = listaPersonas
            var text3= """
             	/////////////////CATEGORIA DE CLIENTE ///////////////
                             """
            
            listaDatos.forEach{ text3 +="""
               Nombre: ${it.nombre}
                Destino: ${it.ciudad}
  				Nivel Clinete : ${it.cantidadCompra}
            """}
            enviar(true, text3)
        }
		 
       override fun DestinosMayor(ciudad: listCiudad, ver:(Boolean,String)->Unit){
        var listadestinos = listaPersonas.map{it.ciudad }
//  	   	var lima = listadestinos.filter{it = }
        
 	   	    	    
       }
       override fun DestinoMenor(ciudad: listCiudad, ver:(Boolean,String)->Unit){
           
       }
       override fun MenorVenta(fecha:Date, ver:(Boolean,String)->Unit){

       }
       override fun ClienteFrecuente(ver:(Boolean,String)->Unit){
           var nombre =  listaPersonas.groupBy(Persona::nombre, Persona::ciudad)
          
           var tex = """
           RECORDS DE VIAJES 
           NOMBRE: 
           DESTINOS: ${nombre}
          """ 
           ver(true , tex)
     
       }
    	  
  }
   

data class Persona(var nombre:String,var ciudad:listCiudad,var fecha:String , var nroTicket:Int, var cantidadCompra:cantidadComprada )
enum class listCiudad{
    lima,tumbes,ica
}

enum class cantidadComprada{
    uno , dos , tres
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
