package logicapersistencia.accesoBD;

public class ConsultasInsert{
	

	

	
	public String nuevoArrendatario(){
		String consulta="INSERT INTO arrendatarios(idArrendatario,idPersona,detalleArr)VALUES(?,?,?);";
		return consulta;
	}
	

	
	public String nuevoComprador(){
		String consulta ="INSERT INTO compradores(idComprador,detalleComp)VALUES(?,?);";
		return consulta;
	}
	
	public String nuevaFormaDePago(){
		String consulta ="INSERT INTO formas_pago(formaDePago,detalleFP)VALUES(?,?);";
		return consulta;
	}
	
	public String nuevoOperador(){
		String consulta="INSERT INTO operadores(idOperador,idPersona,fechaIngOpe,detalleOpe)VALUES(?,?,?,?);";
		return consulta;
	}


	

	
	//---------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------
	//---------------------------------------------------------------------------
		//-----------------------------------------------------------------------------------
	
	public String nuevaMonedaVenta() {
		String consulta = "INSERT INTO monedaventa (monedaVenta, idMonedaVenta) VALUES (?,?);";
		return consulta;
	}
	
	public String nuevaMonedaLista() {
		String consulta = "INSERT INTO monedalista (monLista, idMonLista) VALUES (?,?);";
		return consulta;
	}
	
	public String nuevoInmueble2(){
		String consulta ="INSERT INTO inmueble2(refInmueble, tipoMonedaPrecioLista,"
				+ "precioLista,contribucionInmobiliaria,"
				+"areaTotal,exclusividad,estadoDisponibilidad,fechaIngreso,"
				+"direccion,padron,barrio, departamento, estadoDetalle,"
				+ "detalleInmueble, antiguedad, estadoConservacion)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		return consulta;
	}
	
	public String nuevaPersona(){
		String consulta="INSERT INTO personas(idPersona,nombrePer,emailPer,detallePer)VALUES(?,?,?,?);";
		return consulta;
	}
	
	public String nuevoPropietario(){
		String consulta="INSERT INTO propietarios(idPropietario,idPersona,detalleCli)VALUES(?,?,?);";
		return consulta;
	}
	
	public String nuevoTelefono(){
		String consulta="INSERT INTO tel_personas(telPersona,idPersona,detalleTel)VALUES(?,?,?);";
		return consulta;
	}
	
	public String nuevaCasa(){
		String consulta="INSERT INTO casas(idCasa,idInmueble, situacionJuridica,estructura,habitacionSocial,estar,"
				+"dormitorios,dormConSuite,dormSocial,baños,bañoServicio,bañoSocial,bañoConJacuzzi,fondo,patio,"
				+"jardin,garaje,cocheraAbierta,cocheraTechada,amenities,areaEdificada,metrosFrente,detalleCasa,Cocina,"
				+ "rutaImagenCasa)"
				+"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return consulta;
	}
	
	public String nuevoApartamento(){
		String consulta="INSERT INTO apartamentos(idApartamento,idInmueble,unidad,ubicarEdificio,ubicarPlanta,"
				+"habitacionSocial,cocina,monoambiente,unAmbiente,dorm,dormConSuite,dormConVestidor,baños,bañoSocial,"
				+"bañoServicio,bañoJacuzzi,balcon,terrazaPrincipal,terrazaLavadero,garaje,cochAbierta,cochTechada,"
				+"amenities,gastosComunes,areaEdificada,detalleApto, rutaImagenApto)VALUES"
				+"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		return consulta;
	}
	
	public String nuevoTerreno(){
		String consulta="INSERT INTO terrenos(idTerreno,idInmueble,FOS,alturaEdificable,frente,situacionJuridicaSuelo,"
				+"productividad,conMejoras,detalleTerr, rutaImagenTerreno)VALUES(?,?,?,?,?,?,?,?,?,?);";
		return consulta;
	}
	

	
	
	public String nuevoAlquiler(){
		String consulta="INSERT INTO alquileres(idAlquiler,idArrendatario,idInmueble,fechaEgreso,precioAlquiler,"
				+"plazoContractual,garantia1,garantia2,nombreFia,telFia,emailFia,detalleFia,detalleGar,"
				+ "detalleAlq, tipoMoneda)"
				+"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		return consulta;
	}
	
	
	public String nuevaVenta(){
	String consulta="INSERT INTO ventas(idVenta,idComprador,idInmueble,"
			+ "tipoMoneda,precioVenta,fechaEgreso,gravamen,"
			+ "nombreEsc,telEsc,emailEsc,detalleEsc,detalleVen)VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
	return consulta;
	}
	
	
}