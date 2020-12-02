package logicapersistencia.valueObjects;

public class VOMonedaLista {
	
	String monedaLista;
	int idMonedaLista;
	public VOMonedaLista(String monedaLista, int idMonedaLista) {
		super();
		this.monedaLista = monedaLista;
		this.idMonedaLista = idMonedaLista;
	}
	public String getMonedaLista() {
		return monedaLista;
	}
	public void setMonedaLista(String monedaLista) {
		this.monedaLista = monedaLista;
	}
	public int getIdMonedaLista() {
		return idMonedaLista;
	}
	public void setIdMonedaLista(int idMonedaLista) {
		this.idMonedaLista = idMonedaLista;
	}
	
	

}
