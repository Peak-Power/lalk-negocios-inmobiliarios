package logicapersistencia.valueObjects;

public class VOpropietarios extends VOpersonas{
	
	private int idPropietario;
	private int idPersona;
	private String detalleCli;
	
	public VOpropietarios(int idPersona,String nombrePer,String emailPer,String detallePer,int idPropietario,String detalleCli){
		super(idPersona,nombrePer,emailPer,detallePer);
		
		this.idPropietario=idPropietario;
		this.detalleCli=detalleCli;
	}

	public int getIdPropietario(){
		return idPropietario;
	}
	public void setIdPropietario(int idPropietario){
		this.idPropietario=idPropietario;
	}
	public int getIdPersona(){
		return idPersona;
	}
	public void setIdPersona(int idPersona){
		this.idPersona=idPersona;
	}
	public String getDetalleCli(){
		return detalleCli;
	}
	public void setDetalleCli(String detalleCli){
		this.detalleCli=detalleCli;
	}
}