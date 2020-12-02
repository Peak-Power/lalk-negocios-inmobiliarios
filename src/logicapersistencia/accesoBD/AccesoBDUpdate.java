package logicapersistencia.accesoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccesoBDUpdate{
	
	AccesoBD a=new AccesoBD();

	public void updateTerreno(int idTerreno, int idInmueble, int FOS,double alturaEdificable,
			double frente,String situacionJuridica,
			String productividad,String conMejoras,String detalleTerr, String rutaImagenTerreno)throws SQLException{
		
		Connection con=a.conectarBD();
		ConsultasUpdate consultas=new ConsultasUpdate();
		String insert=consultas.updateTerreno();
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(insert);
		
		pstmt.setInt(1,idInmueble);
		pstmt.setInt(2,FOS);
		pstmt.setDouble(3,alturaEdificable);
		pstmt.setDouble(4,frente);
		pstmt.setString(5,situacionJuridica);
		pstmt.setString(6,productividad);
		pstmt.setString(7,conMejoras);
		pstmt.setString(8,detalleTerr);
		pstmt.setString(9,rutaImagenTerreno);
		pstmt.setInt(10,idTerreno);
		
		pstmt.executeUpdate();
		pstmt.close();
		a.desconectarBD(con);
	}
	
	public void updateApartamento(int idApartamento,int idInmueble,int unidad,String ubicarEdificio,String ubicarPlanta,
			String habitacionSocial,String cocina,String monoambiente,String unAmbiente,String dormConSuite,
			String dormConVestidor,int baños,String bañoSocial,String bañoServicio,String bañoJacuzzi,String balcon,
			String terrazaPrincipal,String terrazaLavadero,String garaje,String cochAbierta,String cochTechada,
			String amenities,int gastosComunes,double areaEdificada,String detalleApto, String rutaImagenApto)throws SQLException{
		
		Connection con=a.conectarBD();	
		ConsultasUpdate consultas=new ConsultasUpdate();
		String insert=consultas.updateApartamento();	
		PreparedStatement pstmt;
		
		pstmt=con.prepareStatement(insert);
		
		pstmt.setInt(1,idInmueble);
		pstmt.setInt(2,unidad);
		pstmt.setString(3,ubicarEdificio);
		pstmt.setString(4,ubicarPlanta);
		pstmt.setString(5,habitacionSocial);
		pstmt.setString(6,cocina);
		pstmt.setString(7,monoambiente);
		pstmt.setString(8,unAmbiente);
		pstmt.setString(9,dormConSuite);
		pstmt.setString(10,dormConVestidor);
		pstmt.setInt(11,baños);
		pstmt.setString(12,bañoSocial);
		pstmt.setString(13,bañoServicio);
		pstmt.setString(14,bañoJacuzzi);
		pstmt.setString(15,balcon);
		pstmt.setString(16,terrazaPrincipal);
		pstmt.setString(17,terrazaLavadero);
		pstmt.setString(18,garaje);
		pstmt.setString(19,cochAbierta);
		pstmt.setString(20,cochTechada);
		pstmt.setString(21,amenities);
		pstmt.setInt(22,gastosComunes);
		pstmt.setDouble(23,areaEdificada);
		pstmt.setString(24,detalleApto);
		pstmt.setString(25,rutaImagenApto);
		
		pstmt.setInt(26,idApartamento);
		
		pstmt.executeUpdate();			
		pstmt.close();					
		a.desconectarBD(con);
	}
	
	public void updateCasa(int idCasa, int idInmueble, String situacionJuridica,String estructura,String habitacionSocial,
			String estar,int dormitorios,String dormConSuite,String dormSocial,int baños,String bañoServicio,
			String bañoSocial,String bañoConJacuzzi,String fondo,String patio,String jardin,String garaje,
			String cocheraAbierta,String cocheraTechada,String amenities,double areaEdificada,double metrosFrente,
			String detalleCasa, String rutaImagenCasa)throws SQLException{
		
		Connection con=a.conectarBD();	
		ConsultasUpdate consultas=new ConsultasUpdate();
		String insert=consultas.updateCasa();	
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(insert);
		
		pstmt.setInt(1,idInmueble);		
		pstmt.setString(2,situacionJuridica);
		pstmt.setString(3,estructura);
		pstmt.setString(4,habitacionSocial);
		pstmt.setString(5,estar);
		pstmt.setInt(6,dormitorios);
		pstmt.setString(7,dormConSuite);
		pstmt.setString(8,dormSocial);
		pstmt.setInt(9,baños);
		pstmt.setString(10,bañoServicio);
		pstmt.setString(11,bañoSocial);
		pstmt.setString(12,bañoConJacuzzi);
		pstmt.setString(13,fondo);
		pstmt.setString(14,patio);	
		pstmt.setString(15,jardin);
		pstmt.setString(16,garaje);
		pstmt.setString(17,cocheraAbierta);
		pstmt.setString(18,cocheraTechada);
		pstmt.setString(19,amenities);	
		pstmt.setDouble(20,areaEdificada);
		pstmt.setDouble(21,metrosFrente);
		pstmt.setString(22,detalleCasa);
		pstmt.setString(23,rutaImagenCasa);
		
		pstmt.setInt(24,idCasa);
		
		
		pstmt.executeUpdate();			
		pstmt.close();					
		a.desconectarBD(con);
	}
	
	public void updateInmueble2(int refInmueble, int tipoMonedaPrecioLista,int precioLista,
			int contribucionInmobiliaria, int areaTotal, String exclusividad, String estadoDisponibilidad,
			String fechaIngreso, String direccion,int padron, String barrio, 
			String departamento, String estadoDetalle, String detalleInmueble,
			int antiguedad, String estadoConservacion)throws SQLException{
		
		Connection con=a.conectarBD();	
		ConsultasUpdate consultas=new ConsultasUpdate();
		String insert=consultas.updateInmueble();	
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(insert);
		
		pstmt.setInt(1,tipoMonedaPrecioLista);			
		pstmt.setInt(2,precioLista);
		pstmt.setInt(3,contribucionInmobiliaria);
		pstmt.setInt(4,areaTotal);
		pstmt.setString(5,exclusividad);
		pstmt.setString(6,estadoDisponibilidad);
		pstmt.setString(7,fechaIngreso);
		pstmt.setString(8,direccion);
		pstmt.setInt(9,padron);
		pstmt.setString(10,barrio);
		pstmt.setString(11,departamento);
		pstmt.setString(12,estadoDetalle);
		pstmt.setString(13,detalleInmueble);
		pstmt.setInt(14,antiguedad);
		pstmt.setString(15,estadoConservacion);
		
		pstmt.setInt(16,refInmueble);
		
		
		pstmt.executeUpdate();			
		pstmt.close();					
		a.desconectarBD(con);
	}
	
	public void updateAlquileres(int idAlquiler,int idArrendatario,int idInmueble,
					String fechaEgreso,double precioAlquiler, int plazoContractual, String garantia1,
					String garantia2,String nombreFia, int telFia, String emailFia, String detalleFia,
					String detalleGar, String detalleAlq, int tipoMoneda)throws SQLException{
		
		Connection con=a.conectarBD();
		ConsultasUpdate consultas=new ConsultasUpdate();
		String insert=consultas.updateAlquileres();
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(insert);
		
		pstmt.setInt(1,idAlquiler);
		pstmt.setInt(2,idArrendatario);
		pstmt.setInt(3,idInmueble);
		pstmt.setString(4,fechaEgreso);
		pstmt.setDouble(5,precioAlquiler);
		pstmt.setInt(6,plazoContractual);
		pstmt.setString(7,garantia1);
		pstmt.setString(8,garantia2);
		pstmt.setString(9,nombreFia);
		pstmt.setInt(10,telFia);
		pstmt.setString(11,emailFia);
		pstmt.setString(12,detalleFia);
		pstmt.setString(13,detalleGar);
		pstmt.setString(14,detalleAlq);
		pstmt.setInt(15,tipoMoneda);
		
		pstmt.executeUpdate();
		pstmt.close();
		a.desconectarBD(con);
	}
	
	public void updateVenta(int idVentas,int idComprador,int idInmueble, int tipoMoneda,
			double precioVenta, String fechaEgreso, String gravamen, String nombreEsc,
			int telEsc, String emailEsc, String detalleEsc, String detalleVen)throws SQLException{

			Connection con=a.conectarBD();
			ConsultasUpdate consultas=new ConsultasUpdate();
			String insert=consultas.updateAlquileres();
			PreparedStatement pstmt;
			pstmt=con.prepareStatement(insert);

			pstmt.setInt(1,idVentas);
			pstmt.setInt(2,idComprador);
			pstmt.setInt(3,idInmueble);
			pstmt.setInt(4,tipoMoneda);
			pstmt.setDouble(5,precioVenta);
			pstmt.setString(6,fechaEgreso);
			pstmt.setString(7,gravamen);
			pstmt.setString(8,nombreEsc);
			pstmt.setInt(9,telEsc);
			pstmt.setString(10,emailEsc);
			pstmt.setString(11,detalleEsc);
			pstmt.setString(12,detalleVen);

			pstmt.executeUpdate();
			pstmt.close();
			a.desconectarBD(con);
				}
	
}