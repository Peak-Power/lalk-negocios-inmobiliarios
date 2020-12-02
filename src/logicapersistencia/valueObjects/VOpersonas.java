package logicapersistencia.valueObjects;

public class VOpersonas{
	
	protected int idPersona;
	protected String nombrePer;
	protected String emailPer;
	protected String detallePer;
	
	public VOpersonas(int idPersona,String nombrePer,String emailPer,String detallePer){
		this.idPersona=idPersona;
		this.nombrePer=nombrePer;
		this.emailPer=emailPer;
		this.detallePer=detallePer;
	}

	public void VOidpersona(int idPersona){
		this.idPersona=idPersona;
	}
	public int getIdPersona(){
		return idPersona;
	}
	public void setIdPersona(int idPersona){
		this.idPersona=idPersona;
	}
	public String getNombrePer(){
		return nombrePer;
	}
	public void setNombrePer(String nombrePer){
		this.nombrePer=nombrePer;
	}
	public String getEmailPer(){
		return emailPer;
	}
	public void setEmailPer(String emailPer){
		this.emailPer=emailPer;
	}
	public String getDetallePer(){
		return detallePer;
	}
	public void setDetallePer(String detallePer){
		this.detallePer=detallePer;
	}
}