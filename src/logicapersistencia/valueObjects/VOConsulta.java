package logicapersistencia.valueObjects;

public class VOConsulta {
	
	private String barrio;
	private String direccion;
	private String estadoDisponibilidad;
	private String exclusivo;
	public VOConsulta(String barrio, String direccion, String estadoDisponibilidad, String exclusivo) {
		super();
		this.barrio = barrio;
		this.direccion = direccion;
		this.estadoDisponibilidad = estadoDisponibilidad;
		this.exclusivo = exclusivo;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEstadoDisponibilidad() {
		return estadoDisponibilidad;
	}
	public void setEstadoDisponibilidad(String estadoDisponibilidad) {
		this.estadoDisponibilidad = estadoDisponibilidad;
	}
	public String getExclusivo() {
		return exclusivo;
	}
	public void setExclusivo(String exclusivo) {
		this.exclusivo = exclusivo;
	}
	
	

}
