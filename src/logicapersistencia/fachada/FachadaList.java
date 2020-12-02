package logicapersistencia.fachada;

import java.sql.SQLException;
import java.util.List;

import logicapersistencia.accesoBD.AccesoBD;
import logicapersistencia.accesoBD.AccesoBDList;
import logicapersistencia.valueObjects.VOConsulta;
import logicapersistencia.valueObjects.VOMonedaLista;
import logicapersistencia.accesoBD.AccesoBDList;
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

public class FachadaList {




	public List<VOarrendatarios> listarArrendatarios() {
		AccesoBDList a = new AccesoBDList();
		return a.listarArrendatarios();
	}



	public List<VOformas_pago> listarFormasDePago() {
		AccesoBDList a = new AccesoBDList();
		return a.listarFormasDePago();
	}

	public List<VOoperadores> listarOperadores() {
		AccesoBDList a = new AccesoBDList();
		return a.listarOperadores();
	}

	public List<VOpersonas> listarPersonas() {
		AccesoBDList a = new AccesoBDList();
		return a.listarPersonas();
	}

	public List<VOpropietarios> listarPropietarios() {
		AccesoBDList a = new AccesoBDList();
		return a.listarPropietarios();
	}



	 public List<VOterrenos> listarTerrenos(){
	 AccesoBDList a=new AccesoBDList();
	 return a.listarTerrenos();
	 }



	// ************************************************************************//
	public List<VOMonedaLista> listarMonedaLista() {
		AccesoBDList a = new AccesoBDList();
		return a.listarMonedaLista();
	}

	public int obtenerIdMonedaLista(String nombre) throws SQLException {
		AccesoBDList a = new AccesoBDList();
		return a.obtenerIdMonedaLista(nombre);
	}

	public String obtenerNombreMonedaLista(int idMonedaLista) throws SQLException {
		AccesoBDList a = new AccesoBDList();
		return a.obtenerNombreMonedaLista(idMonedaLista);
	}

	public List<VOinmueble> listaInmuebles() {
		AccesoBDList a = new AccesoBDList();
		return a.listaInmuebles();
	}

	public String obtenerDireccionIdInmueble(int refInmueble) throws SQLException {
		AccesoBDList a = new AccesoBDList();
		return a.obtenerDireccionIdInmueble(refInmueble);
	}

	public List<VOcasas> listarCasas() {
		AccesoBDList a = new AccesoBDList();
		return a.listarCasas();
	}
	
	public List<VOcasasSoloCasas> listarCasasSoloCasas() {
		AccesoBDList a = new AccesoBDList();
		return a.listarCasasSoloCasas();
	}
	
	public List<VOterrenosSoloTerrenos> listarTerrenosSoloTerrenos() {
		AccesoBDList a = new AccesoBDList();
		return a.listarTerrenosSoloTerrenos();
	}
	
	public List<VOapartamentosSoloAptos> listarApartamentosSoloAptos() {
		AccesoBDList a = new AccesoBDList();
		return a.listarApartamentosSoloAptos();
	}
	
	public List<VOapartamentos> listarApartamentos() {
		AccesoBDList a = new AccesoBDList();
		return a.listarApartamentos();
	}
	
	public String contarAptos(){
		AccesoBDList a = new AccesoBDList();
		return a.ContarAptos();
	}
	
	public String contarCasas(){
		AccesoBDList a = new AccesoBDList();
		return a.ContarCasas();
	}
	
	public String contarTerrenos(){
		AccesoBDList a = new AccesoBDList();
		return a.ContarTerrenos();
	}
	
	public List<VOalquileres> listarAlquileres() {
		AccesoBDList a = new AccesoBDList();
		return a.listarAlquileres();
	}

	public List<VOventas> listarVentas() {
		AccesoBDList a = new AccesoBDList();
		return a.listarVentas();
	}
	
	public List<VOcompradores> listarCompradores() {
		AccesoBDList a = new AccesoBDList();
		return a.listarCompradores();
	}
	
	public List<VOtel_personas> listarTelefonos() {
		AccesoBDList a = new AccesoBDList();
		return a.listarTelefonos();
	}
	

	
	
	
}