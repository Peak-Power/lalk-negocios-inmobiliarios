package logicapersistencia.valueObjects;

public class VOformas_pago{

	private String formaDePago;
	private String detalleFP;
	
	public VOformas_pago(String formaDePago,String detalleFP){
		
		super();
		this.formaDePago=formaDePago;
		this.detalleFP=detalleFP;
	}
	
	public String getFormaDePago(){
		return formaDePago;
	}
	public void setFormaDePago(String formaDePago){
		this.formaDePago=formaDePago;
	}
	public String getDetalleFP(){
		return detalleFP;
	}
	public void setDetalleFP(String detalleFP){
		this.detalleFP=detalleFP;
	}
}