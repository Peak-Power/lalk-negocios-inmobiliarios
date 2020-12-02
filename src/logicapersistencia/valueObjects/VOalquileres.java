package logicapersistencia.valueObjects;

public class VOalquileres{
	
	private int idAlquiler;
	private int idArrendatario;
	private int idInmueble;
	private String fechaEgreso;
	private double precioAlquiler;
	private int plazoContractual;
	private String garantia1;
	private String garantia2;
	private String nombreFia;
	private int telFia;
	private String emailFia;
	private String detalleFia;
	private String detalleGar;
	private String detalleAlq;
	private int tipoMoneda;
	public VOalquileres(int idAlquiler, int idArrendatario, int idInmueble, String fechaEgreso, double precioAlquiler,
			int plazoContractual, String garantia1, String garantia2, String nombreFia, int telFia, String emailFia,
			String detalleFia, String detalleGar, String detalleAlq, int tipoMoneda) {
		super();
		this.idAlquiler = idAlquiler;
		this.idArrendatario = idArrendatario;
		this.idInmueble = idInmueble;
		this.fechaEgreso = fechaEgreso;
		this.precioAlquiler = precioAlquiler;
		this.plazoContractual = plazoContractual;
		this.garantia1 = garantia1;
		this.garantia2 = garantia2;
		this.nombreFia = nombreFia;
		this.telFia = telFia;
		this.emailFia = emailFia;
		this.detalleFia = detalleFia;
		this.detalleGar = detalleGar;
		this.detalleAlq = detalleAlq;
		this.tipoMoneda = tipoMoneda;
	}
	public int getIdAlquiler() {
		return idAlquiler;
	}
	public void setIdAlquiler(int idAlquiler) {
		this.idAlquiler = idAlquiler;
	}
	public int getIdArrendatario() {
		return idArrendatario;
	}
	public void setIdArrendatario(int idArrendatario) {
		this.idArrendatario = idArrendatario;
	}
	public int getIdInmueble() {
		return idInmueble;
	}
	public void setIdInmueble(int idInmueble) {
		this.idInmueble = idInmueble;
	}
	public String getFechaEgreso() {
		return fechaEgreso;
	}
	public void setFechaEgreso(String fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}
	public double getPrecioAlquiler() {
		return precioAlquiler;
	}
	public void setPrecioAlquiler(double precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}
	public int getPlazoContractual() {
		return plazoContractual;
	}
	public void setPlazoContractual(int plazoContractual) {
		this.plazoContractual = plazoContractual;
	}
	public String getGarantia1() {
		return garantia1;
	}
	public void setGarantia1(String garantia1) {
		this.garantia1 = garantia1;
	}
	public String getGarantia2() {
		return garantia2;
	}
	public void setGarantia2(String garantia2) {
		this.garantia2 = garantia2;
	}
	public String getNombreFia() {
		return nombreFia;
	}
	public void setNombreFia(String nombreFia) {
		this.nombreFia = nombreFia;
	}
	public int getTelFia() {
		return telFia;
	}
	public void setTelFia(int telFia) {
		this.telFia = telFia;
	}
	public String getEmailFia() {
		return emailFia;
	}
	public void setEmailFia(String emailFia) {
		this.emailFia = emailFia;
	}
	public String getDetalleFia() {
		return detalleFia;
	}
	public void setDetalleFia(String detalleFia) {
		this.detalleFia = detalleFia;
	}
	public String getDetalleGar() {
		return detalleGar;
	}
	public void setDetalleGar(String detalleGar) {
		this.detalleGar = detalleGar;
	}
	public String getDetalleAlq() {
		return detalleAlq;
	}
	public void setDetalleAlq(String detalleAlq) {
		this.detalleAlq = detalleAlq;
	}
	public int getTipoMoneda() {
		return tipoMoneda;
	}
	public void setTipoMoneda(int tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}
	
	
	
	
	}
