package logicapersistencia.valueObjects;

public class VOMonedaVenta {
	
	String monedaVenta;
	int idMonedaVenta;
	public VOMonedaVenta(String monedaVenta, int idMonedaVenta) {
		super();
		this.monedaVenta = monedaVenta;
		this.idMonedaVenta = idMonedaVenta;
	}
	public String getMonedaVenta() {
		return monedaVenta;
	}
	public void setMonedaVenta(String monedaVenta) {
		this.monedaVenta = monedaVenta;
	}
	public int getIdMonedaVenta() {
		return idMonedaVenta;
	}
	public void setIdMonedaVenta(int idMonedaVenta) {
		this.idMonedaVenta = idMonedaVenta;
	}

}
