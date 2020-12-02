package logicapersistencia.accesoBD;

public class ConsultasDelete{
	

	public String eliminarComprador(){
		String consulta="DELETE FROM comprador WHERE idComprador=?;";
		return consulta;
	}	
	
	public String eliminarFormaDePago(){
		String consulta="DELETE FROM formas_pago WHERE formaDePago=?;";
		return consulta;
	}	
	

	
	public String eliminarOperador(){
		String consulta="DELETE FROM operadores WHERE idOperador=?;";
		return consulta;
	}
	
	public String eliminarAlquiler(){
		String consulta="DELETE FROM alquileres WHERE idAlquiler=?;";
		return consulta;
	}
	public String eliminarArrendatario(){
		String consulta="DELETE FROM arrendatarios WHERE idArrendatario=?;";
		return consulta;
	}
	
	public String eliminarPersona(){
		String consulta="DELETE FROM personas WHERE idPersona=?;";
		return consulta;
	}
	
	public String eliminarPropietario(){
		String consulta="DELETE FROM propietarios WHERE idPropietario=?;";
		return consulta;
	}
	
	public String eliminarTelefono(){
		String consulta="DELETE FROM tel_personas WHERE idPersona=?;";
		return consulta;
	}
	
	public String eliminarTerreno(){
		String consulta="DELETE FROM terrenos WHERE idTerreno=?;";
		return consulta;
	}	
	
	public String eliminarVenta(){
		String consulta="DELETE FROM ventas WHERE idVenta=?;";
		return consulta;
	}
	//******************************************************
	
	public String eliminarInmueble(){
		String consulta="DELETE FROM inmueble2 WHERE refInmueble=?;";
		return consulta;
	}
	
	public String eliminarApartamento(){
		String consulta="DELETE FROM apartamentos WHERE idApartamento=?;";
		return consulta;
	}	
	
	public String eliminarCasa(){
		String consulta="DELETE FROM casas WHERE idCasa=?;";
		return consulta;
	}
	
	
	
	
}