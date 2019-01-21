package proyecto;

public class Campo {
	private int idCampo;
	private String nombreCampo;

	public Campo(int idCampo, String nombreCampo) {
		super();
		this.idCampo = idCampo;
		this.nombreCampo = nombreCampo;
	}

	public Campo() {
		
	}

	public int getIdCampo() {
		return idCampo;
	}

	public void setIdCampo(int idCampo) {
		this.idCampo = idCampo;
	}

	public String getNombreCampo() {
		return nombreCampo;
	}

	public void setNombreCampo(String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}

}
