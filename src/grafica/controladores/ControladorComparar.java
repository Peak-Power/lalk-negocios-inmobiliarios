package grafica.controladores;

import java.sql.SQLException;

import logicapersistencia.accesoBD.AccesoBDComparar;
import logicapersistencia.fachada.FachadaComparar;

public class ControladorComparar {
	



	public boolean existeArrendatario(String idArrendatario)throws SQLException{
		FachadaComparar f = new FachadaComparar();
		return f.existeArrendatario(idArrendatario); 
	}
	

//	public boolean existeComprador(String idComprador)throws SQLException{
//		FachadaComparar f = new FachadaComparar();
//		return f.existeComprador(idComprador); 
//	}
//	public boolean existeFormaDePago(String formaDePago)throws SQLException{
//		FachadaComparar f = new FachadaComparar();
//		return f.existeFormaDePago(formaDePago); 
//	}
//	public boolean existeOperador(String idOperador)throws SQLException{
//		FachadaComparar f = new FachadaComparar();
//		return f.existeOperador(idOperador); 
//	}
//
//	public boolean existeTelefono(String idPersona)throws SQLException{
//		FachadaComparar f = new FachadaComparar();
//		return f.existeTelefonoo(idPersona); 
//	}

	
	// ------------------------------ A PARTIR DE ACÁ YA ESTÁ INSTANCIADO  ------------------------ //
	
	public boolean existeUsuario(String usuario, String clave) throws SQLException {
		FachadaComparar f = new FachadaComparar();
		return f.existeUsuario(usuario, clave);
	}
	
	public boolean existeCasa(int idCasa)throws SQLException{
		FachadaComparar f = new FachadaComparar();
		return f.existeCasa(idCasa); 
	}

	public boolean existePersona(int idPersona)throws SQLException{
		FachadaComparar f = new FachadaComparar();
		return f.existePersona(idPersona); 
	}
	public boolean existePropietario(int idPropietario)throws SQLException{
		FachadaComparar f = new FachadaComparar();
		return f.existePropietario(idPropietario); 
	}
	
	public boolean existeInmueble(int idInmueble)throws SQLException{
		FachadaComparar f = new FachadaComparar();
		return f.existeInmueble(idInmueble); 
	}
	
	public boolean existeApartamento(int idApartamento)throws SQLException{
		FachadaComparar f = new FachadaComparar();
		return f.existeApartamento(idApartamento); 
	}
	
	public boolean existeTerreno(int idTerreno)throws SQLException{
		FachadaComparar f = new FachadaComparar();
		return f.existeTerreno(idTerreno); 
	}
	
	public boolean existeAlquiler(int refAlquiler)throws SQLException{
		FachadaComparar f = new FachadaComparar();
		return f.existeAlquiler(refAlquiler); 
	}
	
	public boolean existeVenta(int idVenta) throws SQLException {
		FachadaComparar f = new FachadaComparar();
		return f.existeVenta(idVenta);
	}

}
