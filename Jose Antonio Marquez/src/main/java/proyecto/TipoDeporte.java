package proyecto;

public class TipoDeporte {
	private int idDeporte;
	private String nombreDeporte;

	public TipoDeporte(int idDeporte, String nombreDeporte) {
		super();
		this.idDeporte = idDeporte;
		this.nombreDeporte = nombreDeporte;
	}

	public TipoDeporte() {
		super();
	}

	public int getIdDeporte() {
		return idDeporte;
	}

	public void setIdDeporte(int idDeporte) {
		this.idDeporte = idDeporte;
	}

	public String getNombreDeporte() {
		return nombreDeporte;
	}

	public void setNombreDeporte(String nombreDeporte) {
		this.nombreDeporte = nombreDeporte;
	}

}
