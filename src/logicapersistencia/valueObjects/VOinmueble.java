package logicapersistencia.valueObjects;

public class VOinmueble{
	
	private int refInmueble;
	private int tipoMonedaPrecioLista;
	private int precioLista;
	private int contribucionInmobiliaria;
	private int areaTotal;
	private String exclusividad;
	private String estadoDisponibilidad;
	private String fechaIngreso;
	private String direccion;
	private int padron;
	private String barrio;
	private String departamento;
	private String estadoDetalle;
	private String detalleInmueble;
	private int antiguedad;
	private String estadoConservacion;
	public VOinmueble(int refInmueble, int tipoMonedaPrecioLista, int precioLista, int contribucionInmobiliaria,
			int areaTotal, String exclusividad, String estadoDisponibilidad, String fechaIngreso, String direccion,
			int padron, String barrio, String departamento, String estadoDetalle, String detalleInmueble,
			int antiguedad, String estadoConservacion) {
		super();
		this.refInmueble = refInmueble;
		this.tipoMonedaPrecioLista = tipoMonedaPrecioLista;
		this.precioLista = precioLista;
		this.contribucionInmobiliaria = contribucionInmobiliaria;
		this.areaTotal = areaTotal;
		this.exclusividad = exclusividad;
		this.estadoDisponibilidad = estadoDisponibilidad;
		this.fechaIngreso = fechaIngreso;
		this.direccion = direccion;
		this.padron = padron;
		this.barrio = barrio;
		this.departamento = departamento;
		this.estadoDetalle = estadoDetalle;
		this.detalleInmueble = detalleInmueble;
		this.antiguedad = antiguedad;
		this.estadoConservacion = estadoConservacion;
	}
	public VOinmueble(String direccion, String barrio) {
		super();
		this.barrio = barrio;
		this.departamento = departamento;
	}
	public int getRefInmueble() {
		return refInmueble;
	}
	public void setRefInmueble(int refInmueble) {
		this.refInmueble = refInmueble;
	}
	public int getTipoMonedaPrecioLista() {
		return tipoMonedaPrecioLista;
	}
	public void setTipoMonedaPrecioLista(int tipoMonedaPrecioLista) {
		this.tipoMonedaPrecioLista = tipoMonedaPrecioLista;
	}
	public int getPrecioLista() {
		return precioLista;
	}
	public void setPrecioLista(int precioLista) {
		this.precioLista = precioLista;
	}
	public int getContribucionInmobiliaria() {
		return contribucionInmobiliaria;
	}
	public void setContribucionInmobiliaria(int contribucionInmobiliaria) {
		this.contribucionInmobiliaria = contribucionInmobiliaria;
	}
	public int getAreaTotal() {
		return areaTotal;
	}
	public void setAreaTotal(int areaTotal) {
		this.areaTotal = areaTotal;
	}
	public String getExclusividad() {
		return exclusividad;
	}
	public void setExclusividad(String exclusividad) {
		this.exclusividad = exclusividad;
	}
	public String getEstadoDisponibilidad() {
		return estadoDisponibilidad;
	}
	public void setEstadoDisponibilidad(String estadoDisponibilidad) {
		this.estadoDisponibilidad = estadoDisponibilidad;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getPadron() {
		return padron;
	}
	public void setPadron(int padron) {
		this.padron = padron;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getEstadoDetalle() {
		return estadoDetalle;
	}
	public void setEstadoDetalle(String estadoDetalle) {
		this.estadoDetalle = estadoDetalle;
	}
	public String getDetalleInmueble() {
		return detalleInmueble;
	}
	public void setDetalleInmueble(String detalleInmueble) {
		this.detalleInmueble = detalleInmueble;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	public String getEstadoConservacion() {
		return estadoConservacion;
	}
	public void setEstadoConservacion(String estadoConservacion) {
		this.estadoConservacion = estadoConservacion;
	}
	
	
}