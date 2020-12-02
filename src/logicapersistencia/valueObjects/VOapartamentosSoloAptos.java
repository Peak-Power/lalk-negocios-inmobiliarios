package logicapersistencia.valueObjects;

public class VOapartamentosSoloAptos {

	private int idApartamento;
	private int idInmueble;
	private int unidad;
	private String ubicarEdificio;
	private String ubicarPlanta;
	private String habitacionSocial;
	private String cocina;
	private String monoambiente;
	private String unAmbiente;
	private int dorm;
	private String dormConSuite;
	private String dormConVestidor;
	private int baños;
	private String bañoSocial;
	private String bañoServicio;
	private String bañoJacuzzi;
	private String balcon;
	private String terrazaPrincipal;
	private String terrazaLavadero;
	private String garaje;
	private String cochAbierta;
	private String cochTechada;
	private String amenities;
	private int gastosComunes;
	private double areaEdificada;
	private String detalleApto;
	private String rutaImagenApto;
	public VOapartamentosSoloAptos(int idApartamento, int idInmueble, int unidad, String ubicarEdificio,
			String ubicarPlanta, String habitacionSocial, String cocina, String monoambiente, String unAmbiente,
			int dorm, String dormConSuite, String dormConVestidor, int baños, String bañoSocial, String bañoServicio,
			String bañoJacuzzi, String balcon, String terrazaPrincipal, String terrazaLavadero, String garaje,
			String cochAbierta, String cochTechada, String amenities, int gastosComunes, double areaEdificada,
			String detalleApto, String rutaImagenApto) {
		super();
		this.idApartamento = idApartamento;
		this.idInmueble = idInmueble;
		this.unidad = unidad;
		this.ubicarEdificio = ubicarEdificio;
		this.ubicarPlanta = ubicarPlanta;
		this.habitacionSocial = habitacionSocial;
		this.cocina = cocina;
		this.monoambiente = monoambiente;
		this.unAmbiente = unAmbiente;
		this.dorm = dorm;
		this.dormConSuite = dormConSuite;
		this.dormConVestidor = dormConVestidor;
		this.baños = baños;
		this.bañoSocial = bañoSocial;
		this.bañoServicio = bañoServicio;
		this.bañoJacuzzi = bañoJacuzzi;
		this.balcon = balcon;
		this.terrazaPrincipal = terrazaPrincipal;
		this.terrazaLavadero = terrazaLavadero;
		this.garaje = garaje;
		this.cochAbierta = cochAbierta;
		this.cochTechada = cochTechada;
		this.amenities = amenities;
		this.gastosComunes = gastosComunes;
		this.areaEdificada = areaEdificada;
		this.detalleApto = detalleApto;
		this.rutaImagenApto = rutaImagenApto;
	}
	public int getIdApartamento() {
		return idApartamento;
	}
	public void setIdApartamento(int idApartamento) {
		this.idApartamento = idApartamento;
	}
	public int getIdInmueble() {
		return idInmueble;
	}
	public void setIdInmueble(int idInmueble) {
		this.idInmueble = idInmueble;
	}
	public int getUnidad() {
		return unidad;
	}
	public void setUnidad(int unidad) {
		this.unidad = unidad;
	}
	public String getUbicarEdificio() {
		return ubicarEdificio;
	}
	public void setUbicarEdificio(String ubicarEdificio) {
		this.ubicarEdificio = ubicarEdificio;
	}
	public String getUbicarPlanta() {
		return ubicarPlanta;
	}
	public void setUbicarPlanta(String ubicarPlanta) {
		this.ubicarPlanta = ubicarPlanta;
	}
	public String getHabitacionSocial() {
		return habitacionSocial;
	}
	public void setHabitacionSocial(String habitacionSocial) {
		this.habitacionSocial = habitacionSocial;
	}
	public String getCocina() {
		return cocina;
	}
	public void setCocina(String cocina) {
		this.cocina = cocina;
	}
	public String getMonoambiente() {
		return monoambiente;
	}
	public void setMonoambiente(String monoambiente) {
		this.monoambiente = monoambiente;
	}
	public String getUnAmbiente() {
		return unAmbiente;
	}
	public void setUnAmbiente(String unAmbiente) {
		this.unAmbiente = unAmbiente;
	}
	public int getDorm() {
		return dorm;
	}
	public void setDorm(int dorm) {
		this.dorm = dorm;
	}
	public String getDormConSuite() {
		return dormConSuite;
	}
	public void setDormConSuite(String dormConSuite) {
		this.dormConSuite = dormConSuite;
	}
	public String getDormConVestidor() {
		return dormConVestidor;
	}
	public void setDormConVestidor(String dormConVestidor) {
		this.dormConVestidor = dormConVestidor;
	}
	public int getBaños() {
		return baños;
	}
	public void setBaños(int baños) {
		this.baños = baños;
	}
	public String getBañoSocial() {
		return bañoSocial;
	}
	public void setBañoSocial(String bañoSocial) {
		this.bañoSocial = bañoSocial;
	}
	public String getBañoServicio() {
		return bañoServicio;
	}
	public void setBañoServicio(String bañoServicio) {
		this.bañoServicio = bañoServicio;
	}
	public String getBañoJacuzzi() {
		return bañoJacuzzi;
	}
	public void setBañoJacuzzi(String bañoJacuzzi) {
		this.bañoJacuzzi = bañoJacuzzi;
	}
	public String getBalcon() {
		return balcon;
	}
	public void setBalcon(String balcon) {
		this.balcon = balcon;
	}
	public String getTerrazaPrincipal() {
		return terrazaPrincipal;
	}
	public void setTerrazaPrincipal(String terrazaPrincipal) {
		this.terrazaPrincipal = terrazaPrincipal;
	}
	public String getTerrazaLavadero() {
		return terrazaLavadero;
	}
	public void setTerrazaLavadero(String terrazaLavadero) {
		this.terrazaLavadero = terrazaLavadero;
	}
	public String getGaraje() {
		return garaje;
	}
	public void setGaraje(String garaje) {
		this.garaje = garaje;
	}
	public String getCochAbierta() {
		return cochAbierta;
	}
	public void setCochAbierta(String cochAbierta) {
		this.cochAbierta = cochAbierta;
	}
	public String getCochTechada() {
		return cochTechada;
	}
	public void setCochTechada(String cochTechada) {
		this.cochTechada = cochTechada;
	}
	public String getAmenities() {
		return amenities;
	}
	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}
	public int getGastosComunes() {
		return gastosComunes;
	}
	public void setGastosComunes(int gastosComunes) {
		this.gastosComunes = gastosComunes;
	}
	public double getAreaEdificada() {
		return areaEdificada;
	}
	public void setAreaEdificada(double areaEdificada) {
		this.areaEdificada = areaEdificada;
	}
	public String getDetalleApto() {
		return detalleApto;
	}
	public void setDetalleApto(String detalleApto) {
		this.detalleApto = detalleApto;
	}
	public String getRutaImagenApto() {
		return rutaImagenApto;
	}
	public void setRutaImagenApto(String rutaImagenApto) {
		this.rutaImagenApto = rutaImagenApto;
	}
	
}
