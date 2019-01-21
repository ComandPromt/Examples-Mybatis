package proyecto;

public class Reserva {
	private int idReserva;
	private int idCampo;
	private String nombreReserva;
	private String hora_inicio;
	private String hora_fin;
	private String dia;
	private int idTipoDep;

	public Reserva(int idReserva, int idCampo, String nombreReserva, String hora_inicio, String hora_fin, String dia,
			int idTipoDep) {
		super();
		this.idReserva = idReserva;
		this.idCampo = idCampo;
		this.nombreReserva = nombreReserva;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
		this.dia = dia;
		this.idTipoDep = idTipoDep;
	}

	public Reserva() {

	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public int getIdCampo() {
		return idCampo;
	}

	public void setIdCampo(int idCampo) {
		this.idCampo = idCampo;
	}

	public String getNombreReserva() {
		return nombreReserva;
	}

	public void setNombreReserva(String nombreReserva) {
		this.nombreReserva = nombreReserva;
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

	public void setDia(String string) {
		this.dia = string;
	}

	public int getIdTipoDep() {
		return idTipoDep;
	}

	public void setIdTipoDep(int idTipoDep) {
		this.idTipoDep = idTipoDep;
	}

}
