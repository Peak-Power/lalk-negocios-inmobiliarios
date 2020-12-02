package logicapersistencia.accesoBD;

public class ConsultasList{
	

	
	public String listarArrendatarios() {
		String consulta = "SELECT per.idPersona,per.nombrePer,per.emailPer,per.detallePer,"
						+ "arr.idArrendatario,arr.detalleArr"
				
						+ "FROM personas per, arrendatarios arr" 
						+ "WHERE per.idPersona = arr.idPersona;";
		return consulta;
	}
	
	
	public String listarFormasDePago(){
		String consulta="SELECT * FROM formas_pago;";
		return consulta;
	}
	
	
	public String listarOperadores() {
		String consulta = "SELECT per.idPersona,per.nombrePer,per.emailPer,per.detallePer,"
						+ "ope.idOperador,ope.fechaIngOpe,ope.detalleOpe "
				
						+ "FROM personas per, operadores ope "
						+ "WHERE per.idPersona = ope.idPersona;";
		return consulta;
	}
	
	public String listarPersonas(){
		String consulta="SELECT * FROM personas;";
		return consulta;
	}
	
	public String listarPropietarios() {
		String consulta = "SELECT per.idPersona,per.nombrePer,per.emailPer,per.detallePer,"
						+ "pro.idPropietario,pro.detalleCli "
				
						+ "FROM personas per, propietarios pro "
						+ "WHERE per.idPersona = pro.idPersona;";
		return consulta;
	}
	
	
	

	
	
	
	//*************************//
	//******************************************************************************************//
	//*************************************************//
	//***************************************//
	
	public String listarMonedaLista(){
		String consulta = "SELECT monLista, idMonLista FROM monedalista;";
		return consulta;
	}
	
	public String obtenerNombreMonedaLista(){
		String consulta = "select monLista from monedalista where idMonLista = ?;";
		return consulta;
	}
	
	public String obtenerIdMonedaLista(){
		String consulta = "select idMonLista from monedalista where monLista = ?;";
		return consulta;
	}
	
	public String listaInmuebles() {
		String consulta = "SELECT refInmueble, tipoMonedaPrecioLista,"
				+ "precioLista,contribucionInmobiliaria,"
				+"areaTotal,exclusividad,estadoDisponibilidad,fechaIngreso,"
				+"direccion,padron,barrio, departamento, estadoDetalle,"
				+ "detalleInmueble, antiguedad, estadoConservacion FROM inmueble2;";
		return consulta;
	}
	
	public String obtenerDireccionIdInmueble(){
		String consulta = "select direccion from inmueble2 where refInmueble = ?;";
		return consulta;
	}
	
	public String obtenerPadronIdInmueble(){
		String consulta = "select padron from inmueble2 where refInmueble = ?;";
		return consulta;
	}
	
	public String listarCasas() {
	String consulta = "SELECT * "
	 				+ "FROM inmueble2 inm, casas cas "
	 				+ "WHERE inm.refInmueble = cas.idInmueble;";
	return consulta;
}
	
	public String listarApartamentos(){
		String consulta="SELECT * "
					   +"FROM inmueble2 as inm ,apartamentos as apa " 
					   +"WHERE inm.refInmueble = apa.idInmueble";			
		return consulta;
	}
	
	public String listarTerrenos(){
		String consulta="SELECT * "
		 				+"FROM inmueble2 as inm, terrenos as ter "
		 				 +"WHERE inm.refInmueble= ter.idInmueble;";
		return consulta;	
	}
	
	public String listarCasasSoloCasas() {
	String consulta = "SELECT * FROM casas ";
	return consulta;
}
	
	public String listarTerrenosSoloTerrenos(){
		String consulta="SELECT * FROM terrenos ";
		return consulta;	
	}
	
	public String listarApartamentosSoloAptos(){
		String consulta="SELECT * FROM apartamentos";			
		return consulta;
	}
	
	public String contarAptos(){
		String consulta="SELECT inm.estadoDisponibilidad "
					   +"FROM inmueble2 as inm, apartamentos as apa "
					   +"WHERE inm.refInmueble = apa.idInmueble; ";	
		return consulta;
	}
	
	public String contarCasas(){
		String consulta="SELECT inm.estadoDisponibilidad "
					   +"FROM inmueble2 as inm, casas as cas "
					   +"WHERE inm.refInmueble = cas.idInmueble; ";	
		return consulta;
	}
	
	public String contarTerrenos(){
		String consulta="SELECT inm.estadoDisponibilidad "
					   +"FROM inmueble2 as inm, terrenos as ter "
					   +"WHERE inm.refInmueble = ter.idInmueble; ";	
		return consulta;
	}
	
	public String listarAlquileres(){
		String consulta="SELECT * FROM alquileres;";
		return consulta;
	}	
	
	public String listarVentas(){
		String consulta="SELECT * FROM ventas;";
		return consulta;
	}
	
	public String listarCompradores() {
		String consulta = "SELECT per.idPersona, per.nombrePer, per.emailPer, per.detallePer,"
						+ "com.idComprador, com.detalleComp "
				
						+ "FROM personas as per, compradores as com "
						+ "WHERE per.idPersona = com.idPersona;";
		return consulta;
	}
	
	public String listarTelefonos(){
		String consulta="SELECT per.idPersona, per.nombrePer, per.emailPer, per.detallePer, "
				+ "tel.telPersona, tel.detalleTel  "
				+ "FROM tel_personas as tel, personas as per "
				+ "WHERE tel.idPersona = per.idPersona;";
		return consulta;
	}
	
	
	
}