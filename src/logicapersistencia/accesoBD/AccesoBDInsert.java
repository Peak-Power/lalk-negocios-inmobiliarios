package logicapersistencia.accesoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class AccesoBDInsert{
	
	AccesoBD a=new AccesoBD();
	
	
	public void nuevoComprador(int idComprador,String detalleComp)throws SQLException{
		
		Connection con=a.conectarBD();	
		ConsultasInsert consultas=new ConsultasInsert();
		String insert=consultas.nuevoComprador();	
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(insert);
		pstmt.setInt(1,idComprador);
		pstmt.setString(2,detalleComp);	
		pstmt.executeUpdate();			
		pstmt.close();					
		a.desconectarBD(con);
	}

	public void nuevaFormaDePago(String formaDePago,String detalleFP)throws SQLException{
		
		Connection con=a.conectarBD();	
		ConsultasInsert consultas=new ConsultasInsert();
		String insert=consultas.nuevaFormaDePago();	
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(insert);
		pstmt.setString(1,formaDePago);
		pstmt.setString(2,detalleFP);			
		pstmt.executeUpdate();			
		pstmt.close();					
		a.desconectarBD(con);
	}

		
	public void nuevoOperador(int idOperador,int idPersona,String fechaIngOpe,String detalleOpe)throws SQLException{
		
		Connection con=a.conectarBD();
		ConsultasInsert consultas=new ConsultasInsert();
		String insert=consultas.nuevoOperador();
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(insert);
		
		pstmt.setInt(1,idOperador);
		pstmt.setInt(2,idPersona);
		pstmt.setString(3,fechaIngOpe);
		pstmt.setString(4,detalleOpe);
		
		pstmt.executeQuery();
		pstmt.close();
		a.desconectarBD(con);
	}
	

	
	
	

	

	
	//------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------
		//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	
public void nuevaMonedaLista(String monedaLista, int idMonedaLista)throws SQLException{
		
		Connection con=a.conectarBD();
		ConsultasInsert consultas=new ConsultasInsert();
		String insert=consultas.nuevaMonedaLista();
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(insert);
		
		pstmt.setString(1,monedaLista);
		pstmt.setInt(2,idMonedaLista);
		
		pstmt.executeUpdate ();	
		pstmt.close();
		a.desconectarBD(con);
		
		
	}
	
	public void nuevaMonedaVenta(String monedaVenta, int idMonedaVenta)throws SQLException{
		
		Connection con=a.conectarBD();
		ConsultasInsert consultas=new ConsultasInsert();
		String insert=consultas.nuevaMonedaVenta();
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(insert);
		
		pstmt.setString(1,monedaVenta);
		pstmt.setInt(2,idMonedaVenta);
		
		pstmt.executeUpdate ();	
		pstmt.close();
		a.desconectarBD(con);
		
		
	}
	
	public void nuevoInmueble2(int refInmueble, int tipoMonedaPrecioLista,int precioLista,
			int contribucionInmobiliaria, int areaTotal, String exclusividad, String estadoDisponibilidad,
			String fechaIngreso, String direccion,int padron, String barrio, 
			String departamento, String estadoDetalle, String detalleInmueble,
			int antiguedad, String estadoConservacion)throws SQLException{
		
		Connection con=a.conectarBD();	
		ConsultasInsert consultas=new ConsultasInsert();
		String insert=consultas.nuevoInmueble2();	
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(insert);
		pstmt.setInt(1,refInmueble);
		pstmt.setInt(2,tipoMonedaPrecioLista);			
		pstmt.setInt(3,precioLista);
		pstmt.setInt(4,contribucionInmobiliaria);
		pstmt.setInt(5,areaTotal);
				
		pstmt.setString(6,exclusividad);
		pstmt.setString(7,estadoDisponibilidad);
		pstmt.setString(8,fechaIngreso);
		pstmt.setString(9,direccion);
	
		pstmt.setInt(10,padron);
		
		pstmt.setString(11,barrio);
		pstmt.setString(12,departamento);
		pstmt.setString(13,estadoDetalle);
		pstmt.setString(14,detalleInmueble);
		pstmt.setInt(15,antiguedad);
		pstmt.setString(16,estadoConservacion);
		
		
		pstmt.executeUpdate();			
		pstmt.close();					
		a.desconectarBD(con);
	}
	
	public void nuevaPersona(int idPersona,String nombrePer,String emailPer,String detallePer)throws SQLException{
		
		Connection con=a.conectarBD();
		ConsultasInsert consultas=new ConsultasInsert();
		String insert=consultas.nuevaPersona();
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(insert);
		pstmt.setInt(1,idPersona);
		pstmt.setString(2,nombrePer);
		pstmt.setString(3,emailPer);
		pstmt.setString(4,detallePer);
		pstmt.executeUpdate();
		pstmt.close();
		a.desconectarBD(con);
	}
	
public void nuevoPropietario(int idPersona,int idPropietario,String detalleCli)throws SQLException{
		
		Connection con=a.conectarBD();
		ConsultasInsert consultas=new ConsultasInsert();
		String insert=consultas.nuevoPropietario();
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(insert);
		
		pstmt.setInt(1,idPropietario );
		pstmt.setInt(2,idPersona);
		pstmt.setString(3,detalleCli);
		
		pstmt.executeUpdate();
		pstmt.close();
		a.desconectarBD(con);
	}
	
	public void nuevoTelefono(int idPersona,int telPersona,String detalleTel)throws SQLException{
		
		Connection con=a.conectarBD();
		ConsultasInsert consultas=new ConsultasInsert();
		String insert=consultas.nuevoTelefono();
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(insert);
		pstmt.setInt(1,telPersona);
		pstmt.setInt(2,idPersona);
		pstmt.setString(3,detalleTel);
		pstmt.executeUpdate();
		pstmt.close();
		a.desconectarBD(con);
	}
	
	public void nuevaCasa(int idCasa, int idInmueble, String situacionJuridica,String estructura,String habitacionSocial,
			String estar,int dormitorios,String dormConSuite,String dormSocial,int baños,String bañoServicio,
			String bañoSocial,String bañoConJacuzzi,String fondo,String patio,String jardin,String garaje,
			String cocheraAbierta,String cocheraTechada,String amenities,double areaEdificada,double metrosFrente,
			String detalleCasa, String cocina, String rutaImagenCasa)throws SQLException{
		
		Connection con=a.conectarBD();	
		ConsultasInsert consultas=new ConsultasInsert();
		String insert=consultas.nuevaCasa();	
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(insert);
		pstmt.setInt(1,idCasa);
		pstmt.setInt(2,idInmueble);		
		pstmt.setString(3,situacionJuridica);
		pstmt.setString(4,estructura);
		pstmt.setString(5,habitacionSocial);
		pstmt.setString(6,estar);
		pstmt.setInt(7,dormitorios);
		pstmt.setString(8,dormConSuite);
		pstmt.setString(9,dormSocial);
		pstmt.setInt(10,baños);
		pstmt.setString(11,bañoServicio);
		pstmt.setString(12,bañoSocial);
		pstmt.setString(13,bañoConJacuzzi);
		pstmt.setString(14,fondo);
		pstmt.setString(15,patio);	
		pstmt.setString(16,jardin);
		pstmt.setString(17,garaje);
		pstmt.setString(18,cocheraAbierta);
		pstmt.setString(19,cocheraTechada);
		pstmt.setString(20,amenities);	
		pstmt.setDouble(21,areaEdificada);
		pstmt.setDouble(22,metrosFrente);
		pstmt.setString(23,detalleCasa);
		pstmt.setString(24,cocina);
		pstmt.setString(25,rutaImagenCasa);
		
		
		pstmt.executeUpdate();			
		pstmt.close();					
		a.desconectarBD(con);
	}
	
	public void nuevoApartamento(int idApartamento,int idInmueble,int unidad,String ubicarEdificio,String ubicarPlanta,
			String habitacionSocial,String cocina,String monoambiente,String unAmbiente,int dorm,String dormConSuite,
			String dormConVestidor,int baños,String bañoSocial,String bañoServicio,String bañoJacuzzi,String balcon,
			String terrazaPrincipal,String terrazaLavadero,String garaje,String cochAbierta,String cochTechada,
			String amenities,int gastosComunes,double areaEdificada,String detalleApto, String rutaImagenApto)throws SQLException{
		
		Connection con=a.conectarBD();	
		ConsultasInsert consultas=new ConsultasInsert();
		String insert=consultas.nuevoApartamento();	
		PreparedStatement pstmt;
		
		pstmt=con.prepareStatement(insert);
		pstmt.setInt(1,idApartamento);
		pstmt.setInt(2,idInmueble);
		pstmt.setInt(3,unidad);
		pstmt.setString(4,ubicarEdificio);
		pstmt.setString(5,ubicarPlanta);
		pstmt.setString(6,habitacionSocial);
		pstmt.setString(7,cocina);
		pstmt.setString(8,monoambiente);
		pstmt.setString(9,unAmbiente);
		pstmt.setInt(10,dorm);
		pstmt.setString(11,dormConSuite);
		pstmt.setString(12,dormConVestidor);
		pstmt.setInt(13,baños);
		pstmt.setString(14,bañoSocial);
		pstmt.setString(15,bañoServicio);
		pstmt.setString(16,bañoJacuzzi);
		pstmt.setString(17,balcon);
		pstmt.setString(18,terrazaPrincipal);
		pstmt.setString(19,terrazaLavadero);
		pstmt.setString(20,garaje);
		pstmt.setString(21,cochAbierta);
		pstmt.setString(22,cochTechada);
		pstmt.setString(23,amenities);
		pstmt.setInt(24,gastosComunes);
		pstmt.setDouble(25,areaEdificada);
		pstmt.setString(26,detalleApto);
		pstmt.setString(27,rutaImagenApto);
		
		
		pstmt.executeUpdate();			
		pstmt.close();					
		a.desconectarBD(con);
	}
	
	public void nuevoTerreno(int idTerreno, int idInmueble, int FOS,double alturaEdificable,
			double frente,String situacionJuridica,
			String productividad,String conMejoras,String detalleTerr, String rutaImagenTerreno)throws SQLException{
		
		Connection con=a.conectarBD();
		ConsultasInsert consultas=new ConsultasInsert();
		String insert=consultas.nuevoTerreno();
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(insert);
		pstmt.setInt(1,idTerreno);
		pstmt.setInt(2,idInmueble);
		pstmt.setInt(3,FOS);
		pstmt.setDouble(4,alturaEdificable);
		pstmt.setDouble(5,frente);
		pstmt.setString(6,situacionJuridica);
		pstmt.setString(7,productividad);
		pstmt.setString(8,conMejoras);
		pstmt.setString(9,detalleTerr);
		pstmt.setString(10,rutaImagenTerreno);
		pstmt.executeUpdate();
		pstmt.close();
		a.desconectarBD(con);
	}

	public void nuevoAlquiler(int idAlquiler,int idArrendatario,int idInmueble,String fechaEgreso,
			double precioAlquiler,int plazoContractual,String garantia1,String garantia2,String nombreFia,int telFia,
			String emailFia,String detalleFia,String detalleGar,String detalleAlq, int tipoMoneda)throws SQLException{
		
		Connection con=a.conectarBD();	
		ConsultasInsert consultas=new ConsultasInsert();
		String insert=consultas.nuevoAlquiler();	
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
	
	public void nuevoArrendatario(int idArrendatario,String detalleArr)throws SQLException{
		
		Connection con=a.conectarBD();	
		ConsultasInsert consultas=new ConsultasInsert();
		String insert=consultas.nuevoArrendatario();	
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(insert);
		pstmt.setInt(1,idArrendatario);
		pstmt.setString(2,detalleArr);	
		pstmt.executeUpdate();			
		pstmt.close();					
		a.desconectarBD(con);
	}

	
	public void nuevaVenta(int idVentas,int idComprador,int idInmueble, int tipoMoneda,
			double precioVenta, String fechaEgreso, String gravamen, String nombreEsc,
			int telEsc, String emailEsc, String detalleEsc, String detalleVen)throws SQLException{
		
		Connection con=a.conectarBD();
		ConsultasInsert consultas=new ConsultasInsert();
		String insert=consultas.nuevaVenta();
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