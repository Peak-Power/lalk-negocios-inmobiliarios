package logicapersistencia.accesoBD;

import java.sql.SQLException;

import logicapersistencia.fachada.FachadaComparar;

public class ConsultasComparar {
	
	
	

	
	public String existeArrendatario(){
		String consulta="SELECT * FROM arrendatarios WHERE idArrendatario=?;";
		return consulta;
	}	
	
	
	
	public String existeComprador(){
		String consulta="SELECT * FROM comprador WHERE idComprador=?;";
		return consulta;
	}	
	
	public String existeFormaDePago(){
		String consulta="SELECT * FROM formas_pago WHERE formaDePago=?;";
		return consulta;
	}	
	

	
	public String existeOperador(){
		String consulta="SELECT * FROM operadores WHERE idOperador=?;";
		return consulta;
	}
	

	
	public String existeTelefono(){
		String consulta="SELECT * FROM tel_personas WHERE idPersona=?;";
		return consulta;
	}
	
	
	

	
	//---------------------------------  A PARTIR DE ACÁ ESTA TODO CONECTADO -----------------------///
	
	public String existeUsuario(){
		String consulta="SELECT * FROM control_ingreso WHERE usuario=? AND clave=? ;";
		return consulta;
	}
	
	public String existeCasa(){
		String consulta="SELECT * FROM casas WHERE idCasa=?;";
		return consulta;
	}
	
	public String existeInmueble(){
		String consulta="SELECT * FROM inmueble2 WHERE refInmueble=?;";
		return consulta;
	}
	
	public String existePersona(){
		String consulta="SELECT * FROM personas WHERE idPersona=?;";
		return consulta;
	}
	
	public String existePropietario(){
		String consulta="SELECT * FROM propietarios WHERE idPropietario=?;";
		return consulta;
	}
	
	public String existeApartamento(){
		String consulta="SELECT * FROM apartamentos WHERE idApartamento=?;";
		return consulta;
	}	
	
	public String existeTerreno(){
		String consulta="SELECT * FROM terrenos WHERE idTerreno=?;";
		return consulta;
	}
	
	public String existeAlquiler(){
		String consulta="SELECT * FROM alquileres WHERE idAlquiler=?;";
		return consulta;
	}
	
	public String existeVenta(){
		String consulta="SELECT * FROM ventas WHERE idVenta=?;";
		return consulta;
	}
	

}
