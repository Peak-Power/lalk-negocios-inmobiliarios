package grafica.controladores;

import java.sql.SQLException;

import logicapersistencia.accesoBD.AccesoBDUpdate;
import logicapersistencia.fachada.FachadaInsert;
import logicapersistencia.fachada.FachadaUpdate;

public class ControladorUpdate{

	public void updateTerreno(int idTerreno, int idInmueble, int FOS,double alturaEdificable,double frente,String situacionJuridica,
			String productividad,String conMejoras,String detalleTerr, String rutaImagenTerreno)throws SQLException{
		
		FachadaUpdate f=new FachadaUpdate();
		f.updateTerreno(idTerreno,idInmueble, FOS,alturaEdificable,frente,situacionJuridica,
				productividad,conMejoras,detalleTerr, rutaImagenTerreno);
	}
	
	public void updateApartamento(int idApartamento,int idInmueble,int unidad,String ubicarEdificio,String ubicarPlanta,
			 String habitacionSocial,String cocina,String monoambiente,String unAmbiente,String dormConSuite,
			 String dormConVestidor,int baños,String bañoSocial,String bañoServicio,String bañoJacuzzi,String balcon,
			 String terrazaPrincipal,String terrazaLavadero,String garaje,String cochAbierta,String cochTechada,
			 String amenities,int gastosComunes,double areaEdificada,String detalleApto, String rutaImagenApto)throws SQLException{

		FachadaUpdate f=new FachadaUpdate();
		f.updateApartamento(idApartamento,idInmueble,unidad,ubicarEdificio,ubicarPlanta,
							habitacionSocial,cocina,monoambiente,unAmbiente,dormConSuite,
							dormConVestidor,baños,bañoSocial,bañoServicio,bañoJacuzzi,balcon,
							terrazaPrincipal,terrazaLavadero,garaje,cochAbierta,cochTechada,
							amenities,gastosComunes,areaEdificada,detalleApto, rutaImagenApto);
	}
	
	public void updateCasa(int idCasa, int idInmueble, String situacionJuridica,String estructura,String habitacionSocial,String estar,
			int dormitorios,String dormConSuite,String dormSocial,int baños,String bañoServicio,String bañoSocial,
			String bañoConJacuzzi,String fondo,String patio,String jardin,String garaje,
			String cocheraAbierta,String cocheraTechada,String amenities,double areaEdificada,double metrosFrente,
			String detalleCasa, String rutaImagenCasa)
			throws SQLException{
		
		FachadaUpdate f=new FachadaUpdate();
		f.updateCasa(idCasa, idInmueble, situacionJuridica,estructura,habitacionSocial,estar,dormitorios,dormConSuite,dormSocial,
				baños,bañoServicio,bañoSocial,bañoConJacuzzi,fondo,patio,jardin,garaje,cocheraAbierta,cocheraTechada,amenities,
				areaEdificada,metrosFrente,detalleCasa,rutaImagenCasa);
	}
	
	public void updateInmueble2(int refInmueble, int tipoMonedaPrecioLista,int precioLista,
			int contribucionInmobiliaria, int areaTotal, String exclusividad, String estadoDisponibilidad,
			String fechaIngreso, String direccion,int padron, 
			String barrio, String departamento, String estadoDetalle, 
			String detalleInmueble, int antiguedad, String estadoConservacion)throws SQLException{
		FachadaUpdate f=new FachadaUpdate();
		f.updateInmueble2(refInmueble,tipoMonedaPrecioLista,precioLista,contribucionInmobiliaria,
				areaTotal,exclusividad,estadoDisponibilidad,fechaIngreso,direccion,
				padron, barrio, departamento, estadoDetalle, detalleInmueble,
				antiguedad, estadoConservacion);
		
	}
	
	
	public void updateAlquileres(int idAlquiler,int idArrendatario,int idInmueble,
			String fechaEgreso,double precioAlquiler, int plazoContractual, String garantia1,
			String garantia2,String nombreFia, int telFia, String emailFia, String detalleFia,
			String detalleGar, String detalleAlq, int tipoMoneda)throws SQLException{
		
		FachadaUpdate f=new FachadaUpdate();
		f.updateAlquileres(idAlquiler,
				idArrendatario,	idInmueble,	fechaEgreso,precioAlquiler,	plazoContractual,
				garantia1,garantia2,nombreFia,telFia,emailFia,detalleFia,detalleGar,
				detalleAlq,	tipoMoneda);
	}
	
	public void updateVenta(int idVentas,int idComprador,int idInmueble, int tipoMoneda,
			double precioVenta, String fechaEgreso, String gravamen, String nombreEsc,
			int telEsc, String emailEsc, String detalleEsc, String detalleVen)throws SQLException{
		
		FachadaUpdate f=new FachadaUpdate();
		f.updateVenta(idVentas,idComprador,idInmueble,
				tipoMoneda,precioVenta,fechaEgreso,
				gravamen,nombreEsc,telEsc,emailEsc,detalleEsc,detalleVen);
	}
	
	
}