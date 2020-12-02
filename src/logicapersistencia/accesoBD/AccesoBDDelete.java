package logicapersistencia.accesoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccesoBDDelete{
	
	AccesoBD a=new AccesoBD();
	
	// Elimina una actividad del sistema

	
	
	public void eliminarCasa(int idCasa)throws SQLException{
		
		Connection con=a.conectarBD();	
		ConsultasDelete consultas=new ConsultasDelete();
		String eliminar=consultas.eliminarCasa();	
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(eliminar);
		
		pstmt.setInt(1,idCasa);
		
		pstmt.executeUpdate();			
		pstmt.close();					
		a.desconectarBD(con);
	}
	
	public void eliminarComprador(int idComprador)throws SQLException{
		
		Connection con=a.conectarBD();	
		ConsultasDelete consultas=new ConsultasDelete();
		String eliminar=consultas.eliminarComprador();	
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(eliminar);
		
		pstmt.setInt(1,idComprador);
		
		pstmt.executeUpdate();			
		pstmt.close();					
		a.desconectarBD(con);
	}
	
	public void eliminarFormaDePago(String formaDePago)throws SQLException{
		
		Connection con=a.conectarBD();	
		ConsultasDelete consultas=new ConsultasDelete();
		String eliminar=consultas.eliminarComprador();	
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(eliminar);
		
		pstmt.setString(1,formaDePago);
		
		pstmt.executeUpdate();			
		pstmt.close();					
		a.desconectarBD(con);
	}
	

	
	public void eliminarOperador(int idOperador)throws SQLException{
	
		Connection con=a.conectarBD();	
		ConsultasDelete consultas=new ConsultasDelete();
		String eliminar=consultas.eliminarComprador();	
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(eliminar);
		
		pstmt.setInt(1,idOperador);
		
		pstmt.executeUpdate();			
		pstmt.close();					
		a.desconectarBD(con);
	}
	
	public void eliminarPersona(int idPersona)throws SQLException{
	
		Connection con=a.conectarBD();	
		ConsultasDelete consultas=new ConsultasDelete();
		String eliminar=consultas.eliminarPersona();	
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(eliminar);
		
		pstmt.setInt(1,idPersona);
		
		pstmt.executeUpdate();			
		pstmt.close();					
		a.desconectarBD(con);
	}
	
	public void eliminarPropietario(int idPropietario)throws SQLException{
	
		Connection con=a.conectarBD();	
		ConsultasDelete consultas=new ConsultasDelete();
		String eliminar=consultas.eliminarPropietario();	
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(eliminar);
		
		pstmt.setInt(1,idPropietario);
		
		pstmt.executeUpdate();			
		pstmt.close();					
		a.desconectarBD(con);
	}
	
	public void eliminarTelefono(int idPersona)throws SQLException{
	
		Connection con=a.conectarBD();	
		ConsultasDelete consultas=new ConsultasDelete();
		String eliminar=consultas.eliminarTelefono();	
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(eliminar);
		
		pstmt.setInt(1,idPersona);
		
		pstmt.executeUpdate();			
		pstmt.close();					
		a.desconectarBD(con);
	}
	
	public void eliminarTerreno(int idTerreno)throws SQLException{
		
		Connection con=a.conectarBD();	
		ConsultasDelete consultas=new ConsultasDelete();
		String eliminar=consultas.eliminarTerreno();	
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(eliminar);
		
		pstmt.setInt(1,idTerreno);
		
		pstmt.executeUpdate();			
		pstmt.close();					
		a.desconectarBD(con);
	}
	
	public void eliminarVenta(int idVenta)throws SQLException{
	
		Connection con=a.conectarBD();	
		ConsultasDelete consultas=new ConsultasDelete();
		String eliminar=consultas.eliminarVenta();	
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(eliminar);
		
		pstmt.setInt(1,idVenta);
		
		pstmt.executeUpdate();			
		pstmt.close();					
		a.desconectarBD(con);
	}
	
	//************************************
	//***************************************************
	//********************************************************************
	
	public void eliminarInmueble(int idInmueble)throws SQLException{
		
		Connection con=a.conectarBD();	
		ConsultasDelete consultas=new ConsultasDelete();
		String eliminar=consultas.eliminarInmueble();	
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(eliminar);
		
		pstmt.setInt(1,idInmueble);
		
		pstmt.executeUpdate();			
		pstmt.close();					
		a.desconectarBD(con);
	}
	
	public void eliminarApartamento(int idApartamento)throws SQLException{
		
		Connection con=a.conectarBD();	
		ConsultasDelete consultas=new ConsultasDelete();
		String eliminar=consultas.eliminarApartamento();	
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(eliminar);
		
		pstmt.setInt(1,idApartamento);
		
		pstmt.executeUpdate();			
		pstmt.close();					
		a.desconectarBD(con);
	}
	
public void eliminarAlquiler( int idAlquiler )throws SQLException{
		
		Connection con=a.conectarBD();	
		ConsultasDelete consultas=new ConsultasDelete();
		String eliminar=consultas.eliminarAlquiler();	
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(eliminar);
		
		pstmt.setInt(1,idAlquiler);
		
		pstmt.executeUpdate();			
		pstmt.close();					
		a.desconectarBD(con);
	}
	

	
	public void eliminarArrendatario(int idArrendatario)throws SQLException{
		
		Connection con=a.conectarBD();	
		ConsultasDelete consultas=new ConsultasDelete();
		String eliminar=consultas.eliminarArrendatario();	
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(eliminar);
		
		pstmt.setInt(1,idArrendatario);
		
		pstmt.executeUpdate();			
		pstmt.close();					
		a.desconectarBD(con);
	}
}