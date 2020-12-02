package logicapersistencia.valueObjects;

public class VOterrenos extends VOinmueble{
	
	private int idTerreno;
	private int FOS;
	private double alturaEdificable;
	private double frente;
	private String situacionJuridicaSuelo;
	private String productividad;
	private String conMejoras;
	private String detalleTerr;
	private String rutaImagenTerreno;
	
	public VOterrenos(int refInmueble, int tipoMonedaPrecioLista,int precioLista,
			int contribucionInmobiliaria, int areaTotal, String exclusividad, String estadoDisponibilidad,
			String fechaIngreso, String direccion,int padron, 
			String barrio, String departamento, String estadoDetalle,
			String detalleInmueble, int antiguedad, String estadoConservacion,int idTerreno, int FOS, double alturaEdificable,double frente, String situacionJuridicaSuelo,
			String productividad,String conMejoras, String detalleTerr, String rutaImagenTerreno) {	
		super(refInmueble,tipoMonedaPrecioLista,precioLista,contribucionInmobiliaria,
				areaTotal,exclusividad,estadoDisponibilidad,fechaIngreso,direccion,
				padron, barrio, departamento, estadoDetalle, detalleInmueble,antiguedad, estadoConservacion);
		this.idTerreno = idTerreno;
		this.FOS = FOS;
		this.alturaEdificable = alturaEdificable;
		this.frente = frente;
		this.situacionJuridicaSuelo = situacionJuridicaSuelo;
		this.productividad = productividad;
		this.conMejoras = conMejoras;
		this.detalleTerr = detalleTerr;
		this.rutaImagenTerreno=rutaImagenTerreno;
	}
	
	public String getRutaImagenTerreno() {
		return rutaImagenTerreno;
	}

	public void setRutaImagenTerreno(String rutaImagenTerreno) {
		this.rutaImagenTerreno = rutaImagenTerreno;
	}

	public int getIdTerreno() {
		return idTerreno;
	}
	public void setIdTerreno(int idTerreno) {
		this.idTerreno = idTerreno;
	}
	public int getFOS() {
		return FOS;
	}
	public void setFOS(int fOS) {
		FOS = fOS;
	}
	public double getAlturaEdificable() {
		return alturaEdificable;
	}
	public void setAlturaEdificable(double alturaEdificable) {
		this.alturaEdificable = alturaEdificable;
	}
	public double getFrente() {
		return frente;
	}
	public void setFrente(double frente) {
		this.frente = frente;
	}
	public String getSituacionJuridicaSuelo() {
		return situacionJuridicaSuelo;
	}
	public void setSituacionJuridicaSuelo(String situacionJuridica) {
		this.situacionJuridicaSuelo = situacionJuridica;
	}
	public String getProductividad() {
		return productividad;
	}
	public void setProductividad(String productividad) {
		this.productividad = productividad;
	}
	public String getConMejoras() {
		return conMejoras;
	}
	public void setConMejoras(String conMejoras) {
		this.conMejoras = conMejoras;
	}
	public String getDetalleTerr() {
		return detalleTerr;
	}
	public void setDetalleTerr(String detalleTerr) {
		this.detalleTerr = detalleTerr;
	}
}