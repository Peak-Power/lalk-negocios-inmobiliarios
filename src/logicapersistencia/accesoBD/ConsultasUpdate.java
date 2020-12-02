package logicapersistencia.accesoBD;

public class ConsultasUpdate{
	

			public String updatePersona(){
				String consulta="UPDATE personas SET nombrePer=?,emailPer=?,detallePer=? WHERE idPersona=?";
				return consulta;
			}
			
			public String updatePropietario(){
				String consulta="UPDATE propietarios SET idPersona=?,detalleCli=? WHERE idPropietario=?";
				return consulta;
			}
			
			public String updateTelefono(){
				String consulta="UPDATE tel_personas SET idPersona=?,detalleTel=? WHERE telPersona=?";
				return consulta;
			}
			
			//***************************************************
			//**************************************************************
			//******************************************************************************
			
			public String updateInmueble(){
				String consulta ="UPDATE inmueble2 SET tipoMonedaPrecioLista=?,"
						+ "precioLista=?,contribucionInmobiliaria=?,"
						+"areaTotal=?,exclusividad=?,estadoDisponibilidad=?,fechaIngreso=?,"
						+"direccion=?,padron=?,barrio=?, departamento=?, estadoDetalle=?,"
						+ "detalleInmueble=?, antiguedad=?, estadoConservacion=? WHERE refInmueble=?";
				return consulta;
			}
			
			
			
			public String updateCasa(){
				String consulta="UPDATE casas SET idInmueble=?, situacionJuridica=?,estructura=?,habitacionSocial=?,estar=?,"
						+"dormitorios=?,dormConSuite=?,dormSocial=?,baños=?,bañoServicio=?,bañoSocial=?,bañoConJacuzzi=?,fondo=?,patio=?,"
						+"jardin=?,garaje=?,cocheraAbierta=?,cocheraTechada=?,amenities=?,areaEdificada=?,metrosFrente=?,detalleCasa=?,"
						+ "rutaImagenCasa=? WHERE idCasa=?";
				return consulta;
			}
			
			
			public String updateApartamento(){
				String consulta="UPDATE apartamentos SET idInmueble=?,unidad=?,ubicarEdificio=?,ubicarPlanta=?,"
						+"habitacionSocial=?,cocina=?,monoambiente=?,unAmbiente=?,dormConSuite=?,dormConVestidor=?,baños=?,bañoSocial=?,"
						+"bañoServicio=?,bañoJacuzzi=?,balcon=?,terrazaPrincipal=?,terrazaLavadero=?,garaje=?,cochAbierta=?,cochTechada=?,"
						+"amenities=?,gastosComunes=?,areaEdificada=?,detalleApto=?, rutaImagenApto=? WHERE idApartamento=?;";
				return consulta;
			}
			
			public String updateTerreno(){
				String consulta="UPDATE terrenos SET idInmueble=?,FOS=?,alturaEdificable=?,frente=?,situacionJuridicaSuelo=?,"
						+"productividad=?,conMejoras=?,detalleTerr=?, rutaImagenTerreno=?  WHERE idTerreno=?;";
				return consulta;
			}
	
	
			public String updateAlquileres(){
				String consulta="UPDATE alquileres SET idAlquiler=?,idArrendatario=?,idInmueble=?,fechaEgreso=?,"
						+ "precioAlquiler=?,plazoContractual=?,garantia1=?,garantia2=?,nombreFia=?,telFia=?,"
						+ "emailFia=?,detalleFia=?,detalleGar=?,detalleAlq=?,tipoMoneda=?"
						+ "WHERE idAlquiler=?";
				return consulta;
			}
			
			public String nuevaVenta(){
				String consulta="UPDATE  ventas SET idComprador=?,idInmueble,"
						+ "tipoMoneda=?,precioVenta=?,fechaEgreso=?,gravamen=?,"
						+ "nombreEsc=?,telEsc=?,emailEsc=?,detalleEsc=?,detalleVen=?"
						+ "WHERE idVenta=?";
				return consulta;
				}

			
			
	
}