package ejemplo;

public class TipoDeporte {

	private Integer idTipDeporte;
	private String nombreDeporte;

	public TipoDeporte(Integer idTipDeporte, String nombreDeporte) {
		super();
		this.idTipDeporte = idTipDeporte;
		this.nombreDeporte = nombreDeporte;
	}

	public TipoDeporte() {

	}

	public Integer getIdTipDeporte() {
		return idTipDeporte;
	}

	public void setIdTipDeporte(Integer idTipDeporte) {
		this.idTipDeporte = idTipDeporte;
	}

	public String getNombreDeporte() {
		return nombreDeporte;
	}

	public void setNombreDeporte(String nombreDeporte) {
		this.nombreDeporte = nombreDeporte;
	}

}
