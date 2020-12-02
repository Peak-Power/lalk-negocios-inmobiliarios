package logicapersistencia.valueObjects;

public class VOtel_personas extends VOpersonas{
	
	
	private int telPersona;
	private String detalleTel;
	
	public VOtel_personas(int idPersona, String nombrePer, String emailPer, String detallePer, int telPersona,String detalleTel){
		
		super(idPersona, nombrePer, emailPer,detallePer);
		this.idPersona=idPersona;
		this.telPersona=telPersona;
		this.detalleTel=detalleTel;
	}
	
	
	public int getTelPersona(){
		return telPersona;
	}
	public void setTelPersona(int telPersona){
		this.telPersona=telPersona;
	}
	public String getDetalleTel(){
		return detalleTel;
	}
	public void setDetalleTel(String detalleTel){
		this.detalleTel=detalleTel;
	}
}