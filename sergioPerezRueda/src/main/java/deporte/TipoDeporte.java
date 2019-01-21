package deporte;

public class TipoDeporte {
	private Integer id_tipoDeporte;
	private String nombre;

	public Integer getId_tipoDeporte() {
		return id_tipoDeporte;
	}

	public void setId_tipoDeporte(Integer id_tipoDeporte) {
		this.id_tipoDeporte = id_tipoDeporte;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoDeporte(Integer id_tipoDeporte, String nombre) {
		super();
		this.id_tipoDeporte = id_tipoDeporte;
		this.nombre = nombre;
	}

	public TipoDeporte() {
		super();

	}

	@Override
	public String toString() {
		return "TipoDeporte [id_tipoDeporte=" + id_tipoDeporte + ", nombre=" + nombre + "]";
	}

}
