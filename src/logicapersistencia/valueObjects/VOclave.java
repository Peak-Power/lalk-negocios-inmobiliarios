package logicapersistencia.valueObjects;

public class VOclave {
	
	int id;
	String usuario;
	String clave;
	public VOclave(int id, String usuario, String clave) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.clave = clave;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	

}
