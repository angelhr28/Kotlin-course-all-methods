import java.util.*
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
interface TicketMVP {
    interface View {
        fun mostrarMensaje(mensaje: String)
        fun cargaVistaDeImpresion()
        fun imprimitTicket(ticket: String)
        fun imprimirInformeDiario(informe: String)
    }
    
    interface Presenter {
        fun aperturarCaja(fecha: Date) // Validar que no sea mayor a la fecha actual
        fun cajaAperturada() // Notificar a la vista que se aperturo la caja
        fun mostrarMensaje(mensaje: String)
        fun generarTicket(nombre: String, ciudad: String)
        fun imprimirTicket(ticket: String)
        fun cerrarCaja()
        fun imprimirInforme(informe: String)
    }
    
    interface Model {
        // Guarda en una variable la fecha en string para imprimirla en los tickets
        // e inicializa el correlativo en 1
        fun aperturarCaja(fecha: Date)
        // Requerimiento es guardar la lista de personas, sus destinos y que dia fueron
        fun generarTicket(nombre: String, ciudad: String)
        fun cerrarCaja()
    }
}
  class TicketView():TicketMVP.View{
      var presenter: TicketPresenter
      
      init{
          presenter= TicketPresenter(this)
          val hace3dias = sumarDias(Date(), -3)
          presenter.aperturarCaja(hace3dias)
		  var nombre = "angel"
          var ciudad = "lima"
          presenter.generarTicket(nombre , ciudad)     
      }
        override fun mostrarMensaje(mensaje: String){
            println(mensaje)
        }
        override fun cargaVistaDeImpresion(){
            println(" la caja ha sido aperturada")
        }
        override fun imprimitTicket(ticket: String){}
        override fun imprimirInformeDiario(informe: String){}

  }
  class TicketPresenter(var view:TicketMVP.View): TicketMVP.Presenter{
           
        var model=TicketModel(this)  
            
 		override fun aperturarCaja(fecha: Date){  	   
        	 if(Date() >fecha) model.aperturarCaja(fecha) else view.mostrarMensaje("no se puede")
        } 
        override fun cajaAperturada() {
            view.cargaVistaDeImpresion()
           
        }
        override fun mostrarMensaje(mensaje: String){
            view.mostrarMensaje(mensaje)
        }
        override fun generarTicket(nombre: String, ciudad: String){
            model.generarTicket(nombre,ciudad)
        }
        override fun imprimirTicket(ticket: String){
            
        }
        override fun cerrarCaja(){}
        override fun imprimirInforme(informe: String){} 
  }
  class TicketModel(var presenter: TicketMVP.Presenter):TicketMVP.Model{
        
      	override fun aperturarCaja(fecha: Date){
            lista(fecha)
            if(fecha!= null )presenter.cajaAperturada() else presenter.mostrarMensaje("la caja no se aperturo")
        	}
        override fun generarTicket(nombre: String, ciudad: String){
			presenter.imprimirTicket("la persona ${nombre} compro la entrada en la ciudad ${ciudad}")
        }
       
        override fun cerrarCaja(){}
  }
  
  fun lista(fecha:Date){
          var listaFechas = listOf(fecha)
  }
fun main(args: Array<String>){
    val fechaActual = Date()
    val formatter = SimpleDateFormat("dd/MM/yyyy")
    val stringDate = formatter.format(fechaActual)
    var nombre= "angel"
    var ciudad = "lima"
    var vista =TicketView()
    
//      print(vista)
}

fun sumarDias(fecha: Date, dias: Int) : Date {
    val	calendar = Calendar.getInstance()
    calendar.setTime(fecha)
    calendar.add(Calendar.DAY_OF_YEAR, dias)
    return calendar.getTime()
}
