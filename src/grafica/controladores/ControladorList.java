package grafica.controladores;

import java.sql.SQLException;
import java.util.List;

import logicapersistencia.accesoBD.AccesoBDList;
import logicapersistencia.fachada.FachadaList;
import logicapersistencia.valueObjects.VOConsulta;
import logicapersistencia.valueObjects.VOMonedaLista;
import logicapersistencia.valueObjects.VOMonedaVenta;
import logicapersistencia.valueObjects.VOalquileres;
import logicapersistencia.valueObjects.VOapartamentos;
import logicapersistencia.valueObjects.VOapartamentosSoloAptos;
import logicapersistencia.valueObjects.VOcasas;
import logicapersistencia.valueObjects.VOcasasSoloCasas;
import logicapersistencia.valueObjects.VOcompradores;
import logicapersistencia.valueObjects.VOinmueble;
import logicapersistencia.valueObjects.VOtel_personas;
import logicapersistencia.valueObjects.VOterrenos;
import logicapersistencia.valueObjects.VOterrenosSoloTerrenos;
import logicapersistencia.valueObjects.VOventas;

public class ControladorList {
	
	public List<VOMonedaLista> listarMonedaLista() {
		FachadaList f = new FachadaList();
		return f.listarMonedaLista();
	}

	public int obtenerIdMonedaLista(String nombre) throws SQLException {
		FachadaList f = new FachadaList();
		return f.obtenerIdMonedaLista(nombre);
	}

	public String obtenerNombreMonedaLista(int idMonedaLista) throws SQLException {
		FachadaList f = new FachadaList();
		return f.obtenerNombreMonedaLista(idMonedaLista);
	}

	public List<VOinmueble> listaInmuebles() {
		FachadaList f = new FachadaList();
		return f.listaInmuebles();
	}

	public List<VOcasas> listarCasas() {
		FachadaList f = new FachadaList();
		return f.listarCasas();
	}

	public String obtenerDireccionIdInmueble(int refInmueble) throws SQLException {
		FachadaList f = new FachadaList();
		return f.obtenerDireccionIdInmueble(refInmueble);
	}

	public List<VOapartamentos> listarApartamentos() {
		FachadaList f = new FachadaList();
		return f.listarApartamentos();
	}

	public List<VOapartamentosSoloAptos> listarApartamentosSoloAptos() {
		FachadaList f = new FachadaList();
		return f.listarApartamentosSoloAptos();
	}

	public List<VOterrenos> listarTerrenos() {
		FachadaList f = new FachadaList();
		return f.listarTerrenos();
	}

	public List<VOterrenosSoloTerrenos> listarTerrenosSoloTerrenos() {
		FachadaList f = new FachadaList();
		return f.listarTerrenosSoloTerrenos();
	}

	public List<VOcasasSoloCasas> listarCasasSoloCasas() {
		FachadaList f = new FachadaList();
		return f.listarCasasSoloCasas();
	}
	public String contarAptos() {
		FachadaList f = new FachadaList();
		return f.contarAptos();
	}

	public String contarCasas() {
		FachadaList f = new FachadaList();
		return f.contarCasas();
	}

	public String contarTerrenos() {
		FachadaList f = new FachadaList();
		return f.contarTerrenos();
	}
	
	public List<VOalquileres> listarAlquileres() {
		FachadaList f = new FachadaList();
		return f.listarAlquileres();
	}
	
	public List<VOventas> listarVentas() {
		FachadaList f = new FachadaList();
		return f.listarVentas();
	}
	
	public List<VOcompradores> listarCompradores() {
		FachadaList f = new FachadaList();
		return f.listarCompradores();
	}
	
	public List<VOtel_personas> listarTelefonos() {
		FachadaList f = new FachadaList();
		return f.listarTelefonos();
	}
}