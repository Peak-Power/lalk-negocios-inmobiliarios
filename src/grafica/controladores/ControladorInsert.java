package grafica.controladores;
import java.sql.SQLException;

import logicapersistencia.accesoBD.AccesoBDInsert;
import logicapersistencia.fachada.FachadaInsert;

public class ControladorInsert{
	
	
	public void nuevaFormas_pagos(String formaDePago,String detalleFP)throws SQLException{
		
		FachadaInsert f=new FachadaInsert();
		f.nuevaFormaDePago(formaDePago,detalleFP);
	}
	

	
	
	public void nuevoComprador(int idComprador,String detalleComp)throws SQLException{
		
		FachadaInsert f=new FachadaInsert();
		f.nuevoComprador(idComprador,detalleComp);
	}
	
	public void nuevaFormaDePago(String formaDePago,String detalleFP)throws SQLException{
		
		FachadaInsert f=new FachadaInsert();
		f.nuevaFormaDePago(formaDePago,detalleFP);
	}
	
	public void nuevoOperador(int idPersona,int idOperador,String fechaIngOpe,String detalleOpe)throws SQLException{
		
		FachadaInsert f=new FachadaInsert();
		f.nuevoOperador(idPersona,idOperador,fechaIngOpe,detalleOpe);
	}
	

	

	

	

	
	//*************************************************************************//
	//*************************************************************************************//
	
	public void nuevaMonedaLista(String monedaLista, int idMonedaLista)throws SQLException{
		FachadaInsert f = new FachadaInsert();
		f.nuevaMonedaLista(monedaLista, idMonedaLista);
	}
	
	public void nuevaMonedaVenta(String monedaVenta, int idMonedaVenta)throws SQLException{
		FachadaInsert f = new FachadaInsert();
		f.nuevaMonedaVenta(monedaVenta, idMonedaVenta);
	}
	
	public void nuevoInmueble2(int refInmueble, int tipoMonedaPrecioLista,int precioLista,
			int contribucionInmobiliaria, int areaTotal, String exclusividad, String estadoDisponibilidad,
			String fechaIngreso, String direccion,int padron, 
			String barrio, String departamento, String estadoDetalle, 
			String detalleInmueble, int antiguedad, String estadoConservacion)throws SQLException{
		FachadaInsert f = new FachadaInsert();
		f.nuevoInmueble2(refInmueble,tipoMonedaPrecioLista,precioLista,contribucionInmobiliaria,
				areaTotal,exclusividad,estadoDisponibilidad,fechaIngreso,direccion,
				padron, barrio, departamento, estadoDetalle, detalleInmueble,
				antiguedad, estadoConservacion);
		
	}
	
	public void nuevaPersona(int idPersona,String nombrePer,String emailPer,String detallePer)throws SQLException{
		FachadaInsert f=new FachadaInsert();
	f.nuevaPersona(idPersona,nombrePer,emailPer,detallePer);
	}
	
	public void nuevoPropietario(int idPersona,int idPropietario,String detalleCli)throws SQLException{
		
		FachadaInsert f=new FachadaInsert();
		f.nuevoPropietario(idPersona,idPropietario,detalleCli);
	}
	
	public void nuevoTelefono(int idPersona,int telPersona,String detalleTel)throws SQLException{
		
		FachadaInsert f=new FachadaInsert();
		f.nuevoTelefono(idPersona,telPersona,detalleTel);
	}
	
	public void nuevaCasa(int idCasa, int idInmueble, String situacionJuridica,String estructura,String habitacionSocial,String estar,
			int dormitorios,String dormConSuite,String dormSocial,int baños,String bañoServicio,String bañoSocial,
			String bañoConJacuzzi,String fondo,String patio,String jardin,String garaje,
			String cocheraAbierta,String cocheraTechada,String amenities,double areaEdificada,double metrosFrente,
			String detalleCasa, String cocina, String rutaImagenCasa)
			throws SQLException{
		
		FachadaInsert f=new FachadaInsert();
		f.nuevaCasa(idCasa, idInmueble, situacionJuridica,estructura,habitacionSocial,estar,dormitorios,dormConSuite,dormSocial,
				baños,bañoServicio,bañoSocial,bañoConJacuzzi,fondo,patio,jardin,garaje,cocheraAbierta,cocheraTechada,amenities,
				areaEdificada,metrosFrente,detalleCasa, cocina, rutaImagenCasa);
	}
	
	
	public void nuevoApartamento(int idApartamento,int idInmueble,int unidad,String ubicarEdificio,String ubicarPlanta,
			 String habitacionSocial,String cocina,String monoambiente,String unAmbiente, int dorm, String dormConSuite,
			 String dormConVestidor,int baños,String bañoSocial,String bañoServicio,String bañoJacuzzi,String balcon,
			 String terrazaPrincipal,String terrazaLavadero,String garaje,String cochAbierta,String cochTechada,
			 String amenities,int gastosComunes,double areaEdificada,String detalleApto, String rutaImagenApto)throws SQLException{

		FachadaInsert f=new FachadaInsert();
		f.nuevoApartamento(idApartamento,idInmueble,unidad,ubicarEdificio,ubicarPlanta,
							habitacionSocial,cocina,monoambiente,unAmbiente,dorm,dormConSuite,
							dormConVestidor,baños,bañoSocial,bañoServicio,bañoJacuzzi,balcon,
							terrazaPrincipal,terrazaLavadero,garaje,cochAbierta,cochTechada,
							amenities,gastosComunes,areaEdificada,detalleApto, rutaImagenApto);
	}
	
	public void nuevoTerreno(int idTerreno, int idInmueble, int FOS,double alturaEdificable,double frente,String situacionJuridica,
			String productividad,String conMejoras,String detalleTerr, String rutaImagenTerreno)throws SQLException{
		
		FachadaInsert f=new FachadaInsert();
		f.nuevoTerreno(idTerreno,idInmueble, FOS,alturaEdificable,frente,situacionJuridica,
				productividad,conMejoras,detalleTerr, rutaImagenTerreno);
	}
	
//	public void nuevaVenta(int idVentas, int idComprador, int idInmueble, int tipoMoneda,
//			double precioVenta,String fechaEgreso,
//			String gravamen,String nombreEsc,
//			int telEsc,String emailEsc,String detalleEsc,String detalleVen)throws SQLException{
//		
//		FachadaInsert f=new FachadaInsert();
//		f.nuevaVenta(idVentas,idComprador,idInmueble,tipoMoneda,
//				precioVenta,fechaEgreso,gravamen,nombreEsc,telEsc,emailEsc,detalleEsc,detalleVen);
//	}
	
	

	
	public void nuevoAlquiler(int idAlquiler,int idArrendatario,int idInmueble,String fechaEgreso,double precioAlquiler,int plazoContractual,
			  String garantia1,String garantia2,String nombreFia,int telFia,String emailFia,String detalleFia,
			  String detalleGar,String detalleAlq, int tipoMoneda)throws SQLException{

		FachadaInsert f=new FachadaInsert();
		f.nuevoAlquiler(idAlquiler,idArrendatario,idInmueble,fechaEgreso,precioAlquiler,plazoContractual,garantia1,garantia2,nombreFia,telFia,
	emailFia,detalleFia,detalleGar,detalleAlq, tipoMoneda);
	}



	public void nuevoArrendatario(int idArrendatario,String detalleArr)throws SQLException{

		FachadaInsert f=new FachadaInsert();
		
		f.nuevoArrendatario(idArrendatario,detalleArr);
	} 
	
	public void nuevaVenta(int idVentas, int idComprador, int idInmueble, int tipoMoneda,
			double precioVenta, String fechaEgreso, String gravamen, String nombreEsc,
			int telEsc, String emailEsc, String detalleEsc, String detalleVen)throws SQLException{
		
		FachadaInsert f=new FachadaInsert();
		
		f.nuevaVenta(idVentas,idComprador,idInmueble, tipoMoneda, precioVenta, fechaEgreso, gravamen,
				nombreEsc, telEsc, emailEsc, detalleEsc, detalleVen);
	}
	
}