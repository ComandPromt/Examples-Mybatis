package com.objetos;

public class reserva {
	private Integer id_reserva;
	private String nombreReserva;
	private String horaInicio;
	private String horaFin;
	private String dia;
	private Integer id_campo;
	private Integer id_tipoDeporte;

	public Integer getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(Integer id_reserva) {
		this.id_reserva = id_reserva;
	}

	public String getNombreReserva() {
		return nombreReserva;
	}

	public void setNombreReserva(String nombre_reserva) {
		this.nombreReserva = nombre_reserva;
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

	@Override
	public String toString() {
		return "reserva [id_reserva=" + id_reserva + ", nombre_reserva=" + nombreReserva + ", horaInicio=" + horaInicio
				+ ", horaFin=" + horaFin + ", dia=" + dia + ", id_campo=" + id_campo + ", id_tipoDeporte="
				+ id_tipoDeporte + "]";
	}

}
