package logicapersistencia.accesoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logicapersistencia.valueObjects.VOConsulta;
import logicapersistencia.valueObjects.VOMonedaLista;
import logicapersistencia.valueObjects.VOMonedaVenta;
import logicapersistencia.valueObjects.VOalquileres;
import logicapersistencia.valueObjects.VOapartamentos;
import logicapersistencia.valueObjects.VOapartamentosSoloAptos;
import logicapersistencia.valueObjects.VOarrendatarios;
import logicapersistencia.valueObjects.VOcasas;
import logicapersistencia.valueObjects.VOcasasSoloCasas;
import logicapersistencia.valueObjects.VOcompradores;
import logicapersistencia.valueObjects.VOformas_pago;
import logicapersistencia.valueObjects.VOinmueble;
import logicapersistencia.valueObjects.VOoperadores;
import logicapersistencia.valueObjects.VOpersonas;
import logicapersistencia.valueObjects.VOpropietarios;
import logicapersistencia.valueObjects.VOtel_personas;
import logicapersistencia.valueObjects.VOterrenos;
import logicapersistencia.valueObjects.VOterrenosSoloTerrenos;
import logicapersistencia.valueObjects.VOventas;

public class AccesoBDList {

	AccesoBD a = new AccesoBD();

	// Lista las actividades del sistema

	
	public List<VOapartamentos> listarApartamentos() {

		Connection con = null;
		con = a.conectarBD();
		VOapartamentos apto = null;
		List<VOapartamentos> lstAptos = null;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ConsultasList consultas = new ConsultasList();
			String strAptos = consultas.listarApartamentos();
			ResultSet rs = stmt.executeQuery(strAptos);
			lstAptos = new ArrayList<VOapartamentos>();
			while (rs.next()) {
				apto = new VOapartamentos(
						rs.getInt("refInmueble"), 
						rs.getInt("tipoMonedaPrecioLista"), 
						rs.getInt("precioLista"),
						rs.getInt("contribucionInmobiliaria"), 
						rs.getInt("areaTotal"), 
						rs.getString("exclusividad"),
						rs.getString("estadoDisponibilidad"), 
						rs.getString("fechaIngreso"), 
						rs.getString("direccion"),
						rs.getInt("padron"), 
						rs.getString("barrio"), 
						rs.getString("departamento"),
						rs.getString("estadoDetalle"), 
						rs.getString("detalleInmueble"), 
						rs.getInt("antiguedad"), 
						rs.getString("estadoConservacion"),
						
						rs.getInt("idApartamento"), 
						rs.getInt("idInmueble"), 
						rs.getInt("unidad"),
						rs.getString("ubicarEdificio"), 
						rs.getString("ubicarPlanta"), 
						rs.getString("habitacionSocial"), 
						rs.getString("cocina"), 
						rs.getString("monoambiente"), 
						rs.getString("unAmbiente"),
						rs.getInt("dorm"), 
						rs.getString("dormConSuite"), 
						rs.getString("dormConVestidor"), 
						rs.getInt("baños"),
						rs.getString("bañoSocial"), 
						rs.getString("bañoServicio"), 
						rs.getString("bañoJacuzzi"),
						rs.getString("balcon"), 
						rs.getString("terrazaPrincipal"), 
						rs.getString("terrazaLavadero"),
						rs.getString("garaje"), 
						rs.getString("cochAbierta"), 
						rs.getString("cochTechada"),
						rs.getString("amenities"), 
						rs.getInt("gastosComunes"), 
						rs.getDouble("areaEdificada"),
						rs.getString("detalleApto"), 
						rs.getString("rutaImagenApto"));
				
						lstAptos.add(apto);	
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		a.desconectarBD(con);
		return lstAptos;
	}

	public List<VOarrendatarios> listarArrendatarios() {

		// devuelve un listado de los datos
		Connection con = null;
		con = a.conectarBD();
		VOarrendatarios arrendatarios = null;
		List<VOarrendatarios> lstArrendatario = null;
		/* creo un Statement para listar todas las actividades */
		Statement stmt;
		try {
			stmt = con.createStatement();
			ConsultasList consultas = new ConsultasList();
			String strArrendatario = consultas.listarArrendatarios();
			ResultSet rs = stmt.executeQuery(strArrendatario);
			lstArrendatario = new ArrayList<VOarrendatarios>();
			while (rs.next()) {
				arrendatarios = new VOarrendatarios(rs.getInt("idPersona"), rs.getString("nombrePer"),
						rs.getString("emailPer"), rs.getString("detallePer"), rs.getInt("idArrendatario"),
						rs.getString("detalleArr"));
				lstArrendatario.add(arrendatarios);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		a.desconectarBD(con);
		return lstArrendatario;
	}

	
	public List<VOformas_pago> listarFormasDePago() {

		Connection con = null;
		con = a.conectarBD();
		VOformas_pago formaDePago = null;
		List<VOformas_pago> lstFormasDePago = null;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ConsultasList consultas = new ConsultasList();
			String strFormasDePago = consultas.listarFormasDePago();
			ResultSet rs = stmt.executeQuery(strFormasDePago);
			lstFormasDePago = new ArrayList<VOformas_pago>();
			while (rs.next()) {
				formaDePago = new VOformas_pago(rs.getString("formaDePago"), rs.getString("detalleFP"));
				lstFormasDePago.add(formaDePago);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		a.desconectarBD(con);
		return lstFormasDePago;
	}

	public List<VOoperadores> listarOperadores() {

		Connection con = null;
		con = a.conectarBD();
		VOoperadores operador = null;
		List<VOoperadores> lstOperadores = null;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ConsultasList consultas = new ConsultasList();
			String strOperador = consultas.listarOperadores();
			ResultSet rs = stmt.executeQuery(strOperador);
			lstOperadores = new ArrayList<VOoperadores>();
			while (rs.next()) {
				operador = new VOoperadores(rs.getInt("idPersona"), rs.getString("nombrePer"), rs.getString("emailPer"),rs.getString("detallePer"),
										  rs.getInt("idOperador"),rs.getString("fechaIngOpe"),rs.getString("detalleOpe"));
	
				lstOperadores.add(operador);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		a.desconectarBD(con);
		return lstOperadores;
	}

	public List<VOpersonas> listarPersonas() {

		Connection con = null;
		con = a.conectarBD();
		VOpersonas persona = null;
		List<VOpersonas> lstPersonas = null;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ConsultasList consultas = new ConsultasList();
			String strPersonas = consultas.listarPersonas();
			ResultSet rs = stmt.executeQuery(strPersonas);
			lstPersonas = new ArrayList<VOpersonas>();
			while (rs.next()) {
				persona = new VOpersonas(rs.getInt("idPersona"), rs.getString("nombrePer"), rs.getString("emailPer"),rs.getString("detallePer"));
				
				lstPersonas.add(persona);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		a.desconectarBD(con);
		return lstPersonas;
	}
	
	public List<VOpropietarios> listarPropietarios() {

		Connection con = null;
		con = a.conectarBD();
		VOpropietarios propietario = null;
		List<VOpropietarios> lstPropietarios = null;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ConsultasList consultas = new ConsultasList();
			String strPropietario = consultas.listarPropietarios();
			ResultSet rs = stmt.executeQuery(strPropietario);
			lstPropietarios = new ArrayList<VOpropietarios>();
			while (rs.next()) {
				propietario = new VOpropietarios(rs.getInt("idPersona"), rs.getString("nombrePer"), rs.getString("emailPer"),rs.getString("detallePer"),
												 rs.getInt("idPropietario"),rs.getString("detalleCli"));
				lstPropietarios.add(propietario);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		a.desconectarBD(con);
		return lstPropietarios;
	}
	
	

	
	
	//*****************************************************************************************************//
	//*****************************************************************************************************//
	//*****************************************************************************************************//


	public List<VOMonedaLista> listarMonedaLista() {
		Connection con=a.conectarBD();
		
		VOMonedaLista lstDato = null;
		List<VOMonedaLista> lstDatos = null;
		
		
		Statement stmt;
		try {
		stmt = (Statement) con.createStatement();
		ConsultasList consultas = new ConsultasList();
			String strMonLista = consultas.listarMonedaLista();
			ResultSet rs = stmt.executeQuery(strMonLista);
			lstDatos = new ArrayList<VOMonedaLista>();
			while (rs.next()) {
				String monedaLista = rs.getString("monLista");
				int idMonedaLista= rs.getInt("idMonLista");
				
				lstDato = new VOMonedaLista(monedaLista, idMonedaLista);
				lstDatos.add(lstDato);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a.desconectarBD(con);
	
	return lstDatos;
	}
	
			
	public int obtenerIdMonedaLista(String nombreMonedaLista) throws SQLException{	
		Connection con = null;				
		con = a.conectarBD();	
		ConsultasList consultas = new ConsultasList ();
		String strIdMonedaLista = consultas.obtenerIdMonedaLista();
		PreparedStatement pstmt = con.prepareStatement (strIdMonedaLista);
		pstmt.setString (1, nombreMonedaLista);
		ResultSet rs = pstmt.executeQuery ();		 	        
	    rs.next();
	    int IdEstado  = rs.getInt(1);		
	    rs.close();
	    pstmt.close();
		a.desconectarBD(con);
		return IdEstado;
	}
	
		
	public String obtenerNombreMonedaLista(int idMonedaLista) throws SQLException{	
		Connection con = null;				
		con = a.conectarBD();	
		ConsultasList consultas = new ConsultasList ();
		String strNombreMonedaLista = consultas.obtenerNombreMonedaLista();
		PreparedStatement pstmt = con.prepareStatement (strNombreMonedaLista);
		pstmt.setInt (1, idMonedaLista);
		ResultSet rs = pstmt.executeQuery ();		 	        
	    rs.next();
	    String nomEstado  = rs.getString(1);		
	    rs.close();
	    pstmt.close();
		a.desconectarBD(con);
		return nomEstado;
	}
	
	//-------------------------------------------- LISTAR INMUEBLE ----------------------------------//
	
	public List<VOinmueble> listaInmuebles() {
		Connection con=a.conectarBD();
		
		VOinmueble lstDato = null;
		List<VOinmueble> lstDatos = null;
		
		
		Statement stmt;
		try {
		stmt = (Statement) con.createStatement();
		ConsultasList consultas = new ConsultasList();
			String strInmueble= consultas.listaInmuebles();
			ResultSet rs = stmt.executeQuery(strInmueble);
			lstDatos = new ArrayList<VOinmueble>();
			while (rs.next()) {
				int refInmueble = rs.getInt("refInmueble");
				int tipoMonedaPrecioLista= rs.getInt("tipoMonedaPrecioLista");
				int precioLista = rs.getInt("precioLista");
				int contribucionInmobiliaria= rs.getInt("contribucionInmobiliaria");
				int areaTotal = rs.getInt("areaTotal");
				int padron= rs.getInt("padron");				
				String exclusividad = rs.getString("exclusividad");
				String estadoDisponibilidad = rs.getString("estadoDisponibilidad");
				String fechaIngreso = rs.getString("fechaIngreso");
				String direccion = rs.getString("direccion");
				int antiguedad = rs.getInt("antiguedad");
				
				String barrio = rs.getString("barrio");
				String departamento = rs.getString("departamento");
				String estadoDetalle = rs.getString("estadoDetalle");
				String detalleInmueble = rs.getString("detalleInmueble");
				String estadoConservacion = rs.getString("estadoConservacion");
								
				lstDato = new VOinmueble(refInmueble,tipoMonedaPrecioLista,precioLista,contribucionInmobiliaria,
						areaTotal,exclusividad,estadoDisponibilidad,fechaIngreso,direccion,
						padron, barrio, departamento, estadoDetalle, detalleInmueble,antiguedad, estadoConservacion);
				lstDatos.add(lstDato);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a.desconectarBD(con);
	
	return lstDatos;
	}
	
	public String obtenerDireccionIdInmueble(int refInmueble) throws SQLException{	
		Connection con = null;				
		con = a.conectarBD();	
		ConsultasList consultas = new ConsultasList ();
		String strDireccionInmueble = consultas.obtenerDireccionIdInmueble();
		PreparedStatement pstmt = con.prepareStatement (strDireccionInmueble);
		pstmt.setInt (1, refInmueble);
		ResultSet rs = pstmt.executeQuery ();		 	        
	    rs.next();
	    String direccionInmueble  = rs.getString(1);		
	    rs.close();
	    pstmt.close();
		a.desconectarBD(con);
		return direccionInmueble;
	}
	
	//***************************************************//
	

	
	public List<VOcasas> listarCasas() {
		// devuelve un listado de los datos
		Connection con = null;
		con = a.conectarBD();
		VOcasas casa = null;
		List<VOcasas> lstCasas = null;
		/* creo un Statement para listar todas las actividades */
		Statement stmt;
		try {
			stmt = con.createStatement();
			ConsultasList consultas = new ConsultasList();
			String strCasas = consultas.listarCasas();
			ResultSet rs = stmt.executeQuery(strCasas);
			lstCasas = new ArrayList<VOcasas>();
			while (rs.next()) {
				//************************ INMUEBLE *******************************//
				int refInmueble = rs.getInt("refInmueble");
				int tipoMonedaPrecioLista= rs.getInt("tipoMonedaPrecioLista");
				int precioLista = rs.getInt("precioLista");
				int contribucionInmobiliaria= rs.getInt("contribucionInmobiliaria");
				int areaTotal = rs.getInt("areaTotal");
				int padron= rs.getInt("padron");				
				String exclusividad = rs.getString("exclusividad");
				String estadoDisponibilidad = rs.getString("estadoDisponibilidad");
				String fechaIngreso = rs.getString("fechaIngreso");
				String direccion = rs.getString("direccion");
				int antiguedad = rs.getInt("antiguedad");
				String barrio = rs.getString("barrio");
				String departamento = rs.getString("departamento");
				String estadoDetalle = rs.getString("estadoDetalle");
				String detalleInmueble = rs.getString("detalleInmueble");
				String estadoConservacion = rs.getString("estadoConservacion");
				
				//************** CASA ***************************************************//
				int idCasa = rs.getInt("idCasa");
				int idInmueble = rs.getInt("idInmueble");
				String situacionJuridica = rs.getString("situacionJuridica");
				String estructura = rs.getString("estructura");
				String habitacionSocial = rs.getString("habitacionSocial");
				String estar = rs.getString("estar");	
				int dormitorios = rs.getInt("dormitorios");
				String dormConSuite = rs.getString("dormConSuite");
				String dormSocial = rs.getString("dormSocial");
				int baños = rs.getInt("baños");
				String bañoServicio = rs.getString("bañoServicio");
				String bañoSocial = rs.getString("bañoSocial");
				String bañoConJacuzzi = rs.getString("bañoConJacuzzi");
				String fondo = rs.getString("fondo");
				String patio = rs.getString("patio");
				String jardin = rs.getString("jardin");
				String garaje = rs.getString("garaje");
				String cocheraAbierta = rs.getString("cocheraAbierta");
				String cocheraTechada = rs.getString("cocheraTechada");
				String amenities = rs.getString("amenities");
				Double areaEdificada = rs.getDouble("areaEdificada");
				Double metrosFrente = rs.getDouble("metrosFrente");
				String detalleCasa = rs.getString("detalleCasa");
				String rutaImagenCasa = rs.getString("rutaImagenCasa");

				
				casa = new VOcasas(
						refInmueble,tipoMonedaPrecioLista,precioLista,contribucionInmobiliaria,
						areaTotal,exclusividad,estadoDisponibilidad,fechaIngreso,direccion,
						padron, barrio, departamento, estadoDetalle, detalleInmueble,antiguedad, estadoConservacion,
						
						idCasa, idInmueble,	situacionJuridica,estructura,
						habitacionSocial,estar,dormitorios,	dormConSuite,dormSocial,
						baños,bañoServicio,	bañoSocial,bañoConJacuzzi,fondo,
						patio,jardin,garaje,cocheraAbierta,cocheraTechada,amenities,
						areaEdificada,metrosFrente,	detalleCasa,rutaImagenCasa);
				
				lstCasas.add(casa);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		a.desconectarBD(con);
		return lstCasas;
	}
	
	
	
	public List<VOterrenos> listarTerrenos(){
		Connection con = null;
		con = a.conectarBD();
		VOterrenos terreno = null;
		List<VOterrenos> lstTerrenos = null;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ConsultasList consultas = new ConsultasList();
			String strTerrenos = consultas.listarTerrenos();
			ResultSet rs = stmt.executeQuery(strTerrenos);
			lstTerrenos = new ArrayList<VOterrenos>();
			while (rs.next()) {
				terreno = new VOterrenos(
						rs.getInt("refInmueble"), rs.getInt("tipoMonedaPrecioLista"), rs.getInt("precioLista"),
						rs.getInt("contribucionInmobiliaria"), rs.getInt("areaTotal"), rs.getString("exclusividad"),
						rs.getString("estadoDisponibilidad"), rs.getString("fechaIngreso"), rs.getString("direccion"),
						rs.getInt("padron"), rs.getString("barrio"), rs.getString("departamento"),rs.getString("estadoDetalle"), 
						rs.getString("detalleInmueble"), rs.getInt("antiguedad"), rs.getString("estadoConservacion"),
						
						rs.getInt("idTerreno"), rs.getInt("FOS"),rs.getDouble("alturaEdificable"), 
						rs.getDouble("frente"), rs.getString("situacionJuridicaSuelo"),rs.getString("productividad"),
						rs.getString("conMejoras"), rs.getString("detalleTerr"),rs.getString("rutaImagenTerreno"));
				
						lstTerrenos.add(terreno);	
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		a.desconectarBD(con);
		return lstTerrenos;
	}
	
	
	public List<VOcasasSoloCasas> listarCasasSoloCasas() {
		// devuelve un listado de los datos
		Connection con = null;
		con = a.conectarBD();
		VOcasasSoloCasas casa = null;
		List<VOcasasSoloCasas> lstCasas = null;
		/* creo un Statement para listar todas las actividades */
		Statement stmt;
		try {
			stmt = con.createStatement();
			ConsultasList consultas = new ConsultasList();
			String strCasas = consultas.listarCasasSoloCasas();
			ResultSet rs = stmt.executeQuery(strCasas);
			lstCasas = new ArrayList<VOcasasSoloCasas>();
			while (rs.next()) {
								
				//************** CASA ***************************************************//
				int idCasa = rs.getInt("idCasa");
				int idInmueble = rs.getInt("idInmueble");
				String situacionJuridica = rs.getString("situacionJuridica");
				String estructura = rs.getString("estructura");
				String habitacionSocial = rs.getString("habitacionSocial");
				String estar = rs.getString("estar");	
				int dormitorios = rs.getInt("dormitorios");
				String dormConSuite = rs.getString("dormConSuite");
				String dormSocial = rs.getString("dormSocial");
				int baños = rs.getInt("baños");
				String bañoServicio = rs.getString("bañoServicio");
				String bañoSocial = rs.getString("bañoSocial");
				String bañoConJacuzzi = rs.getString("bañoConJacuzzi");
				String fondo = rs.getString("fondo");
				String patio = rs.getString("patio");
				String jardin = rs.getString("jardin");
				String garaje = rs.getString("garaje");
				String cocheraAbierta = rs.getString("cocheraAbierta");
				String cocheraTechada = rs.getString("cocheraTechada");
				String amenities = rs.getString("amenities");
				Double areaEdificada = rs.getDouble("areaEdificada");
				Double metrosFrente = rs.getDouble("metrosFrente");
				String detalleCasa = rs.getString("detalleCasa");
				String cocina = rs.getString("Cocina");
				String rutaImagenCasa = rs.getString("rutaImagenCasa");

				
				casa = new VOcasasSoloCasas(						
						idCasa, idInmueble,	situacionJuridica,estructura,
						habitacionSocial,estar,dormitorios,	dormConSuite,dormSocial,
						baños,bañoServicio,	bañoSocial,bañoConJacuzzi,fondo,
						patio,jardin,garaje,cocheraAbierta,cocheraTechada,amenities,
						areaEdificada,metrosFrente,	detalleCasa,cocina,rutaImagenCasa);
				
				lstCasas.add(casa);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		a.desconectarBD(con);
		return lstCasas;
	}
	
	public List<VOterrenosSoloTerrenos> listarTerrenosSoloTerrenos(){
		Connection con = null;
		con = a.conectarBD();
		VOterrenosSoloTerrenos terreno = null;
		List<VOterrenosSoloTerrenos> lstTerrenos = null;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ConsultasList consultas = new ConsultasList();
			String strTerrenos = consultas.listarTerrenosSoloTerrenos();
			ResultSet rs = stmt.executeQuery(strTerrenos);
			lstTerrenos = new ArrayList<VOterrenosSoloTerrenos>();
			while (rs.next()) {
				terreno = new VOterrenosSoloTerrenos(
												
						rs.getInt("idTerreno"),
						rs.getInt("idInmueble"), 
						rs.getInt("FOS"),
						rs.getDouble("alturaEdificable"),
						rs.getDouble("frente"),
						rs.getString("situacionJuridicaSuelo"),
						rs.getString("productividad"),
						rs.getString("conMejoras"), 
						rs.getString("detalleTerr"),
						rs.getString("rutaImagenTerreno")
						
						);
				
						lstTerrenos.add(terreno);	
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		a.desconectarBD(con);
		return lstTerrenos;
	}
	
	
	public List<VOapartamentosSoloAptos> listarApartamentosSoloAptos() {

		Connection con = null;
		con = a.conectarBD();
		VOapartamentosSoloAptos apto = null;
		List<VOapartamentosSoloAptos> lstAptos = null;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ConsultasList consultas = new ConsultasList();
			String strAptos = consultas.listarApartamentosSoloAptos();
			ResultSet rs = stmt.executeQuery(strAptos);
			lstAptos = new ArrayList<VOapartamentosSoloAptos>();
			while (rs.next()) {
				apto = new VOapartamentosSoloAptos(
						
						rs.getInt("idApartamento"), rs.getInt("idInmueble"), rs.getInt("unidad"), rs.getString("ubicarEdificio"), rs.getString("ubicarPlanta"), 
						rs.getString("habitacionSocial"), rs.getString("cocina"), rs.getString("monoambiente"), 
						rs.getString("unAmbiente"), 
						rs.getInt("dorm"),
						rs.getString("dormConSuite"), rs.getString("dormConVestidor"), rs.getInt("baños"),
						rs.getString("bañoSocial"), rs.getString("bañoServicio"), rs.getString("bañoJacuzzi"),
						rs.getString("balcon"), rs.getString("terrazaPrincipal"), rs.getString("terrazaLavadero"),
						rs.getString("garaje"), rs.getString("cochAbierta"), rs.getString("cochTechada"),
						rs.getString("amenities"), rs.getInt("gastosComunes"), rs.getDouble("areaEdificada"),
						rs.getString("detalleApto"), rs.getString("rutaImagenApto"));
				
						lstAptos.add(apto);	
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		a.desconectarBD(con);
		return lstAptos;
	}
	
	//**************************************  CONTADOR DE DISPONIBILIDAD ***********************************//
	
	public String ContarAptos() {
		Connection con = null;
		con = a.conectarBD();
		String respuesta = "", resp = "";
		int contadorDisp = 0, contadorSusp = 0, contadorRet = 0;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ConsultasList consultas = new ConsultasList();
			String str = consultas.contarAptos();
			ResultSet rs = stmt.executeQuery(str);

			while (rs.next()) {
				resp = rs.getString("estadoDisponibilidad");
				switch (resp) {
				case "Disponible":
					contadorDisp++;
					break;
				case "Suspendido":
					contadorSusp++;
					break;
				case "Retirado":
					contadorRet++;
					break;
				default:
					System.out.println("Error");}
			}
			respuesta = contadorDisp + "/" + contadorSusp + "/" + contadorRet;

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		a.desconectarBD(con);
		return respuesta;
	}

	public String ContarCasas() {
		Connection con = null;
		con = a.conectarBD();
		String respuesta = "", resp = "";
		int contadorDisp = 0, contadorSusp = 0, contadorRet = 0;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ConsultasList consultas = new ConsultasList();
			String str = consultas.contarCasas();
			ResultSet rs = stmt.executeQuery(str);

			while (rs.next()) {
				resp = rs.getString("estadoDisponibilidad");
				switch (resp) {
				case "Disponible":
					contadorDisp++;
					break;
				case "Suspendido":
					contadorSusp++;
					break;
				case "Retirado":
					contadorRet++;
					break;
				default:
					System.out.println("Error");}}
			respuesta = contadorDisp + "/" + contadorSusp + "/" + contadorRet;

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		a.desconectarBD(con);

		return respuesta;
	}
	
	public String ContarTerrenos() {
		Connection con = null;
		con = a.conectarBD();
		String respuesta = "", resp = "";
		int contadorDisp = 0, contadorSusp = 0, contadorRet = 0;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ConsultasList consultas = new ConsultasList();
			String str = consultas.contarTerrenos();
			ResultSet rs = stmt.executeQuery(str);
			while (rs.next()) {
				resp = rs.getString("estadoDisponibilidad");
				switch (resp) {
				case "Disponible":
					contadorDisp++;
					break;
				case "Suspendido":
					contadorSusp++;
					break;
				case "Retirado":
					contadorRet++;
					break;
				default:
					System.out.println("Error");}}
			respuesta = contadorDisp + "/" + contadorSusp + "/" + contadorRet;
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		a.desconectarBD(con);
		return respuesta;
	}
	
	//*******************************************************************************************//
	
	public List<VOalquileres> listarAlquileres() {

		Connection con = null;
		con = a.conectarBD();
		VOalquileres alquiler = null;
		List<VOalquileres> lstAlquileres = null;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ConsultasList consultas = new ConsultasList();
			String strAlquileres = consultas.listarAlquileres();
			ResultSet rs = stmt.executeQuery(strAlquileres);
			lstAlquileres = new ArrayList<VOalquileres>();
			while (rs.next()) {
				alquiler = new VOalquileres(rs.getInt("idAlquiler"),rs.getInt("idArrendatario"), 
						rs.getInt("idInmueble"),rs.getString("fechaEgreso"),
						rs.getDouble("precioAlquiler"),rs.getInt("plazoContractual"), 
						rs.getString("garantia1"),rs.getString("garantia2"), 
						rs.getString("nombreFia"),rs.getInt("telFia"),
						rs.getString("emailFia"), rs.getString("detalleFia"), 
						rs.getString("detalleGar"),	rs.getString("detalleAlq"),
						rs.getInt("tipoMoneda"));
				
				lstAlquileres.add(alquiler);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		a.desconectarBD(con);
		return lstAlquileres;
	}
	

	public List<VOventas> listarVentas() {
		Connection con = null;
		con = a.conectarBD();
		VOventas venta = null;
		List<VOventas> lstVentas = null;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ConsultasList consultas = new ConsultasList();
			String strVentas = consultas.listarVentas();
			ResultSet rs = stmt.executeQuery(strVentas);
			lstVentas = new ArrayList<VOventas>();
			while (rs.next()) {
				venta = new VOventas(rs.getInt("idVenta"),rs.getInt("idComprador"),
						rs.getInt("idInmueble"),rs.getInt("tipoMoneda"), 
						rs.getDouble("precioVenta"),
						
						rs.getString("fechaEgreso"), 
						rs.getString("gravamen"),rs.getString("nombreEsc"),
						rs.getInt("telEsc"),rs.getString("emailEsc"), 
						rs.getString("detalleEsc"),rs.getString("detalleVen"));
				
				lstVentas.add(venta);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		a.desconectarBD(con);
		return lstVentas;
	}
	
	public List<VOcompradores> listarCompradores() {

		// devuelve un listado de los datos
		Connection con = null;
		con = a.conectarBD();
		VOcompradores compradores = null;
		List<VOcompradores> lstComprador = null;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ConsultasList consultas = new ConsultasList();
			String strComprador = consultas.listarCompradores();
			ResultSet rs = stmt.executeQuery(strComprador);
			lstComprador = new ArrayList<VOcompradores>();
			while (rs.next()) {
				compradores = new VOcompradores(
						rs.getInt("idPersona"), 
						rs.getString("nombrePer"),
						rs.getString("emailPer"), 
						rs.getString("detallePer"), 
						rs.getInt("idComprador"),
						rs.getString("detalleComp"));
				lstComprador.add(compradores);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		a.desconectarBD(con);
		return lstComprador;
	}
	
	public List<VOtel_personas> listarTelefonos() {

		Connection con = null;
		con = a.conectarBD();
		VOtel_personas telefono = null;
		List<VOtel_personas> lstTelefonos = null;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ConsultasList consultas = new ConsultasList();
			String strTelefonos = consultas.listarTelefonos();
			ResultSet rs = stmt.executeQuery(strTelefonos);
			lstTelefonos = new ArrayList<VOtel_personas>();
			while (rs.next()) {
				telefono = new VOtel_personas(rs.getInt("idPersona"), 
						rs.getString("nombrePer"),
						rs.getString("emailPer"),
						rs.getString("detallePer"),
						rs.getInt("telPersona"),
						rs.getString("detalleTel")
						);
				
				lstTelefonos.add(telefono);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		a.desconectarBD(con);
		return lstTelefonos;
	}
	
	
	
	
}