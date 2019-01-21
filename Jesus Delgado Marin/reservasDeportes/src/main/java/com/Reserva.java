package com;

public class Reserva {

	private int idReserva;
	private String hora_inicio_reserva;
	private String hora_fin_reserva;
	private String diaReserva;
	private int fkIdCampo;
	private int fkIdDeporte;

	public Reserva() {

	}

	public Reserva(int idReserva, String hora_inicio_reserva, String hora_fin_reserva, String diaReserva, int fkIdCampo,
			int fkIdDeporte) {
		super();
		this.idReserva = idReserva;
		this.hora_inicio_reserva = hora_inicio_reserva;
		this.hora_fin_reserva = hora_fin_reserva;
		this.diaReserva = diaReserva;
		this.fkIdCampo = fkIdCampo;
		this.fkIdDeporte = fkIdDeporte;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public String getHora_inicio_reserva() {
		return hora_inicio_reserva;
	}

	public void setHora_inicio_reserva(String hora_inicio_reserva) {
		this.hora_inicio_reserva = hora_inicio_reserva;
	}

	public String getHora_fin_reserva() {
		return hora_fin_reserva;
	}

	public void setHora_fin_reserva(String hora_fin_reserva) {
		this.hora_fin_reserva = hora_fin_reserva;
	}

	public String getDiaReserva() {
		return diaReserva;
	}

	public void setDiaReserva(String diaReserva) {
		this.diaReserva = diaReserva;
	}

	public int getFkIdCampo() {
		return fkIdCampo;
	}

	public void setFkIdCampo(int fkIdCampo) {
		this.fkIdCampo = fkIdCampo;
	}

	public int getFkIdDeporte() {
		return fkIdDeporte;
	}

	public void setFkIdDeporte(int fkIdDeporte) {
		this.fkIdDeporte = fkIdDeporte;
	}

}
