package deporte;

public class Campo {
	private Integer id_campo;
	private String nombre;

	public Integer getId_reserva() {
		return id_campo;
	}

	public void setId_reserva(Integer id_reserva) {
		this.id_campo = id_reserva;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Campo(Integer id_reserva, String nombre) {
		super();
		this.id_campo = id_reserva;
		this.nombre = nombre;
	}

	public Campo() {
		super();

	}

	@Override
	public String toString() {
		return "Campo [id_campo=" + id_campo + ", nombre=" + nombre + "]";
	}

}
