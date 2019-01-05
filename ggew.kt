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
    	}
    
    interface Presenter {
            fun aperturarCaja(fecha: Date) 
            fun cajaAperturada() 
        	fun mostrarMensaje(mensaje: String)
            fun generarTicket(nombre: String, ciudad: listCiudad)
            fun imprimirTicket(ticket: String)
            fun cerrarCaja()
            fun imprimirInforme(informe: String)
         }
    
    interface Model {
            fun aperturarCaja(fecha: Date)
            fun generarTicket(nombre: String, ciudad: listCiudad)
            fun cerrarCaja()
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
   		  presenter.generarTicket("angel", listCiudad.lima)   
          presenter.generarTicket("jose", listCiudad.tumbes)
          presenter.generarTicket("angela", listCiudad.ica)  
      	  presenter.cerrarCaja()
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
        

  }
  class TicketPresenter(var view:TicketMVP.View): TicketMVP.Presenter{
           
        var model=TicketModel(this)  
            
 		override fun aperturarCaja(fecha: Date){  	   
        	if(Date() >fecha) model.aperturarCaja(fecha) 
            else view.mostrarMensaje("Disculpe, la caja no se pudo aperturar")
        } 
        override fun cajaAperturada() {
            view.cargaVistaDeImpresion()
        }
        override fun mostrarMensaje(mensaje: String){
            view.mostrarMensaje(mensaje)
        }
        override fun generarTicket(nombre: String, ciudad:listCiudad){
            model.generarTicket(nombre,ciudad)
        }
        override fun imprimirTicket(ticket: String){
            view.imprimitTicket(ticket)
        }
      	override fun imprimirInforme(informe: String){
        	view.imprimirInformeDiario(informe)  
      	}   
      	override fun cerrarCaja(){
            model.cerrarCaja()
        }
        
  }
  class TicketModel(var presenter: TicketMVP.Presenter):TicketMVP.Model{
  	
      var contador = 0
      var listaPersonas= mutableListOf<Persona>()
      var fechaActual=""	
      override fun aperturarCaja(fecha: Date){
            if(contador>0){
                return presenter.mostrarMensaje("lo sentimos, la caja ya fue abierta")
            }
            contador++
            fechaActual= fecha.getString()
            presenter.cajaAperturada()
        }
        override fun generarTicket(nombre: String, ciudad: listCiudad){
			contador++
            listaPersonas.add(Persona(nombre,ciudad,fechaActual,contador))
            var Text="""
 			/////////////////tiket emitido///////////////
            Numero de boleto: $contador
            /////////////////////////////////////////////
            Usuario: $nombre
            Lugar de destino: $ciudad
            Fecha de emision: $fechaActual 
            /////////////////////////////////////////////
            """
            
            presenter.imprimirTicket(Text)
        }
       
        override fun cerrarCaja(){
       		
            if(contador == 0){
                return presenter.mostrarMensaje("La caja nunca fue abierta")
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
            presenter.imprimirInforme(Text2)
        
        }
  }
  
data class Persona(var nombre:String,var ciudad:listCiudad,var fecha:String , var nroTicket:Int )
enum class listCiudad{
    lima , tumbes, ica
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
