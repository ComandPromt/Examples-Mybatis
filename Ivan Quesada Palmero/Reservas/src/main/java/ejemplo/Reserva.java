package ejemplo;

public class Reserva {

	private Integer idReserva;
	private String horaInicio;
	private String horaFin;
	private String dia;
	private Integer idCampo;
	private Integer idTipDeporte;

	public Reserva(String horaInicio, String horaFin, String dia, Integer idCampo, Integer idTipDeporte) {
		super();
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.dia = dia;
		this.idCampo = idCampo;
		this.idTipDeporte = idTipDeporte;
	}

	public Reserva() {

	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Integer getIdCampo() {
		return idCampo;
	}

	public void setIdCampo(Integer idCampo) {
		this.idCampo = idCampo;
	}

	public Integer getIdTipDeporte() {
		return idTipDeporte;
	}

	public void setIdTipDeporte(Integer idTipDeporte) {
		this.idTipDeporte = idTipDeporte;
	}

}
