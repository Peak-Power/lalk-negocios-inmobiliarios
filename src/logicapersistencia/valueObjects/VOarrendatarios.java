package logicapersistencia.valueObjects;

public class VOarrendatarios extends VOpersonas{
	
	private int idArrendatario;
	private String detalleArr;
	
	public VOarrendatarios(int idPersona, String nombrePer, String emailPer, String detallePer, int idArrendatario, String detalleArr){
		super(idPersona, nombrePer, emailPer, detallePer);
		this.idArrendatario=idArrendatario;
		this.detalleArr=detalleArr;
	}
	
	public int getIdArrendatario(){
		return idArrendatario;
	}
	public void setIdArrendatario(int idArrendatario){
		this.idArrendatario=idArrendatario;
	}
	public String getDetalleArr(){
		return detalleArr;
	}
	public void setDetalleArr(String detalleArr){
		this.detalleArr=detalleArr;
	}
}