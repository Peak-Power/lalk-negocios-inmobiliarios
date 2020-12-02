package grafica.controladores;
import java.sql.SQLException;
import logicapersistencia.fachada.FachadaDelete;

public class ControladorDelete{

	public void eliminarAlquiler(int idAlquiler)throws SQLException{

		FachadaDelete f=new FachadaDelete();
		f.eliminarAlquiler(idAlquiler);
	}

	public void eliminarApartamento(int idApartamento)throws SQLException{
		
		FachadaDelete f=new FachadaDelete();
		f.eliminarApartamento(idApartamento);
	}

	public void eliminarArrendatario(int idArrendatario)throws SQLException{
		
		FachadaDelete f=new FachadaDelete();
		f.eliminarArrendatario(idArrendatario);
	}

	public void eliminarCasa(int idCasa)throws SQLException{
		
		FachadaDelete f=new FachadaDelete();
		f.eliminarCasa(idCasa);
	}
	
	public void eliminarComprador(int idComprador)throws SQLException{
		
		FachadaDelete f=new FachadaDelete();
		f.eliminarComprador(idComprador);
	}

	public void eliminarFormaDePago(String formaDePago)throws SQLException{
		
		FachadaDelete f=new FachadaDelete();
		f.eliminarFormaDePago(formaDePago);
	}

	public void eliminarInmueble(int idInmueble)throws SQLException{
		
		FachadaDelete f=new FachadaDelete();
		f.eliminarInmueble(idInmueble);
	}

	public void eliminarOperador(int idPersona)throws SQLException{
		
		FachadaDelete f=new FachadaDelete();
		f.eliminarOperador(idPersona);
	}

	public void eliminarPersona(int idPersona)throws SQLException{
		
		FachadaDelete f=new FachadaDelete();
		f.eliminarPersona(idPersona);
	}

	public void eliminarPropietario(int idPersona)throws SQLException{
		
		FachadaDelete f=new FachadaDelete();
		f.eliminarPropietario(idPersona);
	}

	public void eliminarTelefono(int idPersona)throws SQLException{
		
		FachadaDelete f=new FachadaDelete();
		f.eliminarTelefono(idPersona);
	}

	public void eliminarTerreno(int idTerreno)throws SQLException{
		
		FachadaDelete f=new FachadaDelete();
		f.eliminarTerreno(idTerreno);
	}

	public void eliminarVenta(int idVentas)throws SQLException{
		
		FachadaDelete f=new FachadaDelete();
		f.eliminarVenta(idVentas);
	}
}