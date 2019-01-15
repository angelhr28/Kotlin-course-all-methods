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
            
            fun imprimirDestinosMenoryMayor(menor:String)
            fun imprimirMenorVenta(venta:String)
            fun clienteFrecuente(completo:String)
    	}
    
    interface Presenter {
            fun aperturarCaja(fecha: Date) 
        	fun mostrarMensaje(mensaje: String)
            fun generarTicket(id:Int ,nombre: String, ciudad: listCiudad, cantidadComprada:cantidadComprada)
            fun cerrarCaja()
			fun GenTipodeCliente()
            
            fun DestinosMenoryMayor()
            fun MenorVenta()
            fun ClienteFrecuente()
    	}
    
    interface Model {
            fun aperturarCaja(fecha: Date , enviar:(Boolean)->Unit)
            fun generarTicket(id:Int, nombre: String, ciudad: listCiudad, cantidadComprada:cantidadComprada,
                             enviar:(Boolean, String)-> Unit)
            fun cerrarCaja(enviar:(Boolean, String)->Unit)
            fun GenTipodeCliente(enviar:(Boolean, String)->Unit)
        	
            fun DestinosMenoryMayor( ver:(Boolean,String)->Unit)
            fun MenorVenta( ver:(Boolean,String)->Unit)
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
          presenter.generarTicket(1,"angel", listCiudad.tumbes, cantidadComprada.uno)   
          presenter.generarTicket(2,"jose", listCiudad.tumbes,cantidadComprada.tres)
          presenter.generarTicket(3,"angela", listCiudad.ica,cantidadComprada.dos)  
          presenter.generarTicket(4,"angelo", listCiudad.ica,cantidadComprada.dos)  

      	  
          
          
          val hace2dias = sumarDias(Date(), -2)
          presenter.cerrarCaja()
          presenter.aperturarCaja(hace2dias)  
          presenter.aperturarCaja(hace2dias) 
   		  presenter.generarTicket(5,"hugo", listCiudad.lima, cantidadComprada.uno)   
          presenter.generarTicket(1,"angel", listCiudad.tumbes,cantidadComprada.tres)
            
      	 
           
          val hace1dias = sumarDias(Date(), -1)
          presenter.cerrarCaja()
          presenter.aperturarCaja(hace1dias)  
          presenter.aperturarCaja(hace1dias) 
   		  presenter.generarTicket(6,"miguel", listCiudad.tumbes, cantidadComprada.uno)   
          presenter.generarTicket(7,"geral", listCiudad.tumbes,cantidadComprada.tres)
          presenter.generarTicket(1,"angel", listCiudad.lima,cantidadComprada.dos)  
//       	  presenter.GenTipodeCliente()
      	  presenter.ClienteFrecuente()
          presenter.MenorVenta()
          presenter.DestinosMenoryMayor()

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
        
        
    
      override fun imprimirDestinosMenoryMayor(menor:String){
          println("TOP DE DESTINOS :  $menor")
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
        override fun generarTicket(id:Int,nombre: String, ciudad:listCiudad , CantidadComprada:cantidadComprada){
            model.generarTicket(id,nombre,ciudad,CantidadComprada){enviar, text ->
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
        


        override fun DestinosMenoryMayor(){
            model.DestinosMenoryMayor{eleccion,respuesta->
             if(eleccion) view.imprimirDestinosMenoryMayor(respuesta)
             else view.mostrarMensaje(respuesta)
            }
        }
        override fun MenorVenta(){
            model.MenorVenta{eleccion,respuesta ->
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
        override fun generarTicket(id:Int ,nombre: String, ciudad: listCiudad, Cantidad: cantidadComprada,  enviar:(Boolean, String)-> Unit){
			enviar( false , "lo sentimos su ticket ya se creo")
     
            listaPersonas.add(Persona(id,nombre,ciudad,fechaActual,contador,Cantidad))
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
		 
       override fun DestinosMenoryMayor( ver:(Boolean,String)->Unit){
           var listDestinos=  listaPersonas.groupBy(Persona::ciudad, Persona::nombre)
           var limaCant = listDestinos[listCiudad.lima]!!.count() 
           var icaCant = listDestinos[listCiudad.ica]!!.count() 
           var tumbesCant = listDestinos[listCiudad.tumbes]!!.count()
           var listcanti = listOf(limaCant,icaCant,tumbesCant) 
           var listcant = listOf(listCiudad.ica,listCiudad.tumbes,listCiudad.lima) 
           var objetivoMin = listcanti.min()
           var objetivoMax = listcanti.max()
           var text= """
              - El destino con mayor visitas es  ${listCiudad.tumbes} con $objetivoMax
              - El destino con menor visitas es ${listCiudad.lima} con $objetivoMin
            """
           
           ver(true,text)
            
       }
     
       override fun ClienteFrecuente(ver:(Boolean,String)->Unit){
           var listID =  listaPersonas.groupBy(Persona::id, Persona::ciudad)
           
           var valores1 = listID[1]!!.count()
           var valores2 = listID[2]!!.count() 
           var valores3 = listID[3]!!.count() 
           var valores4 = listID[4]!!.count() 
           var valores5 = listID[5]!!.count() 
           var valores6 = listID[6]!!.count() 
           var valores7 = listID[7]!!.count() 
		   var listaIDS = listOf(valores1,valores2,valores3,valores4,valores5,valores6,valores7)
           var listaIDS2 = listOf(listID[1],listID[2],listID[3])
//            var lugar = listaIDS.filter{ it == listaIDS.max()}
           
           var text = """
           //////////RECORDS DE VIAJES//////////
           NOMBRE: 
           NUMERO DE VIAJES: ${listaIDS.max()}
           DESTINOS: ${listaIDS[1]}
          """ 
           
           ver(true , text)
     
       }
    	  override fun MenorVenta(ver:(Boolean,String)->Unit){
      	   var listfechas =  listaPersonas.groupBy(Persona::fecha, Persona::nombre)
		   var fecha1 = listfechas["03/01/2019 "]!!.count()
           var fecha2 = listfechas["04/01/2019 "]!!.count()
		   var fecha3 = listfechas["05/01/2019 "]!!.count()
// 		   var listfecha0= listOf("03/01/2019 ","04/01/2019 ","05/01/2019 ")
           var listfecha= listOf(fecha1,fecha2,fecha3)
           var text0= """
           LA FECHA EN LA QUE HUBO POCAS VENTAS FUE  CON UN TOTAL DE ${listfecha.min()}
           """
           ver(true, text0)
       }  
  }
   

data class Persona(var id: Int, var nombre:String,var ciudad:listCiudad,var fecha:String , var nroTicket:Int, var cantidadCompra:cantidadComprada )
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
