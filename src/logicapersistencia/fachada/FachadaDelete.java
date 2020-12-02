package logicapersistencia.fachada;
import java.sql.SQLException;

import logicapersistencia.accesoBD.AccesoBDDelete;

public class FachadaDelete{

	

	
	public void eliminarComprador(int idComprador)throws SQLException{
		
		AccesoBDDelete a=new AccesoBDDelete();
		a.eliminarComprador(idComprador);
	}
	
	public void eliminarFormaDePago(String formaDePago)throws SQLException{
		
		AccesoBDDelete a=new AccesoBDDelete();
		a.eliminarFormaDePago(formaDePago);
	}
	

	
	public void eliminarOperador(int idPersona)throws SQLException{
		
		AccesoBDDelete a=new AccesoBDDelete();
		a.eliminarOperador(idPersona);
	}
	
	public void eliminarPersona(int idPersona)throws SQLException{
		
		AccesoBDDelete a=new AccesoBDDelete();
		a.eliminarPersona(idPersona);
	}
	
	public void eliminarPropietario(int idPersona)throws SQLException{
		
		AccesoBDDelete a=new AccesoBDDelete();
		a.eliminarPropietario(idPersona);
	}
	
	public void eliminarTelefono(int idPersona)throws SQLException{
		
		AccesoBDDelete a=new AccesoBDDelete();
		a.eliminarTelefono(idPersona);
	}
	
	public void eliminarTerreno(int idTerreno)throws SQLException{
		
		AccesoBDDelete a=new AccesoBDDelete();
		a.eliminarTerreno(idTerreno);
	}
	
	public void eliminarVenta(int idVentas)throws SQLException{
		
		AccesoBDDelete a=new AccesoBDDelete();
		a.eliminarVenta(idVentas);
	}
	
	//************************************
	//*********************************************************
	//*********************************************************************
	
	public void eliminarApartamento(int idApartamento)throws SQLException{
		
		AccesoBDDelete a=new AccesoBDDelete();
		a.eliminarApartamento(idApartamento);
	}
	
	public void eliminarCasa(int idCasa)throws SQLException{
		
		AccesoBDDelete a=new AccesoBDDelete();
		a.eliminarCasa(idCasa);
	}
	
	public void eliminarInmueble(int idInmueble)throws SQLException{
		
		AccesoBDDelete a=new AccesoBDDelete();
		a.eliminarInmueble(idInmueble);
	}
	
	public void eliminarAlquiler(int idAlquiler)throws SQLException{
		
		AccesoBDDelete a=new AccesoBDDelete();
		a.eliminarAlquiler(idAlquiler);
	}
	
	public void eliminarArrendatario(int idArrendatario)throws SQLException{
		
		AccesoBDDelete a=new AccesoBDDelete();
		a.eliminarArrendatario(idArrendatario);
	} 
	
	
}