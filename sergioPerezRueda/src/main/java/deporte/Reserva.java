package deporte;

public class Reserva {

	private Integer id_reserva;
	private String hora_inicio;
	private String hora_fin;
	private String dia;
	private Integer id_campo;
	private Integer id_tipoDeporte;

	public Integer getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(Integer id_reserva) {
		this.id_reserva = id_reserva;
	}

	public String getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public String getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Integer getId_campo() {
		return id_campo;
	}

	public void setId_campo(Integer id_campo) {
		this.id_campo = id_campo;
	}

	public Integer getId_tipoDeporte() {
		return id_tipoDeporte;
	}

	public void setId_tipoDeporte(Integer id_tipoDeporte) {
		this.id_tipoDeporte = id_tipoDeporte;
	}

	public Reserva(Integer id_reserva, String hora_inicio, String hora_fin, String dia, Integer id_campo,
			Integer id_tipoDeporte) {
		super();
		this.id_reserva = id_reserva;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
		this.dia = dia;
		this.id_campo = id_campo;
		this.id_tipoDeporte = id_tipoDeporte;
	}

	public Reserva() {
		super();

	}

	@Override
	public String toString() {
		return "Reserva [id_reserva=" + id_reserva + ", hora_inicio=" + hora_inicio + ", hora_fin=" + hora_fin
				+ ", dia=" + dia + ", id_campo=" + id_campo + ", id_tipoDeporte=" + id_tipoDeporte + "]";
	}

}
