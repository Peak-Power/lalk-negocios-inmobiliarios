package logicapersistencia.valueObjects;

public class VOoperadores extends VOpersonas{

	private int idOperador;
	private String fechaIngOpe;
	private String detalleOpe;
	
	public VOoperadores(int idPersona, String nombrePer, String emailPer, String detallePer , int idOperador, String fechaIngOpe, String detalleOpe){
		super(idPersona,nombrePer,emailPer,detallePer);
		
		this.idOperador=idOperador;
		this.fechaIngOpe=fechaIngOpe;
		this.detalleOpe=detalleOpe;
	}
	
	public int getIdOperador(){
		return idOperador;
	}
	public void setIdOperador(int idOperador){
		this.idOperador=idOperador;
	}
	public int getIdPersona(){
		return idPersona;
	}
	public void setIdPersona(int idPersona){
		this.idPersona=idPersona;
	}
	public String getFechaIngOpe(){
		return fechaIngOpe;
	}
	public void setFechaIngOpe(String fechaIngOpe){
		this.fechaIngOpe=fechaIngOpe;
	}
	public String getDetalleOpe(){
		return detalleOpe;
	}
	public void setDetalleOpe(String detalleOpe){
		this.detalleOpe=detalleOpe;
	}
}