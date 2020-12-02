package logicapersistencia.valueObjects;

public class VOcompradores extends VOpersonas{
	
	private int idComprador;
	private String detalleComp;
	
	public VOcompradores(int idPersona, String nombrePer, String emailPer, String detallePer, int idComprador, String detalleComp){
		super(idPersona, nombrePer, emailPer,detallePer);
		this.idComprador=idComprador;
		this.detalleComp=detalleComp;
	}
	
	public int getIdComprador(){
		return idComprador;
	}
	public void setIdComprador(int idComprador){
		this.idComprador=idComprador;
	}
	public String getDetalleComp(){
		return detalleComp;
	}
	public void setDetalleComp(String detalleComp){
		this.detalleComp=detalleComp;
	}
}

