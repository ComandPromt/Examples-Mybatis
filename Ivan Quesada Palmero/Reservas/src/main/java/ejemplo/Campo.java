package ejemplo;

public class Campo {

	private Integer idCampo;
	private String nombreCampo;

	public Campo(Integer idCampo, String nombreCampo) {
		super();
		this.idCampo = idCampo;
		this.nombreCampo = nombreCampo;
	}

	public Campo() {

	}

	public Integer getIdCampo() {
		return idCampo;
	}

	public void setIdCampo(Integer idCampo) {
		this.idCampo = idCampo;
	}

	public String getNombreCampo() {
		return nombreCampo;
	}

	public void setNombreCampo(String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}

}
