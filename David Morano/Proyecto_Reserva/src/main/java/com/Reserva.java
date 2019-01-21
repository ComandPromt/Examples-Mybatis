package com;

public class Reserva {

	private Integer idReserva;
	private Integer idCampo;
	private Integer idDeporte;
	private String fechaInicio;
	private String fechaFin;
	private String dia;

	public Reserva() {

	}

	public Reserva(Integer idReserva, Integer idCampo, Integer idDeporte, String fechaInicio, String fechaFin,
			String dia) {
		super();
		this.idReserva = idReserva;
		this.idCampo = idCampo;
		this.idDeporte = idDeporte;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.dia = dia;
	}

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public Integer getIdCampo() {
		return idCampo;
	}

	public void setIdCampo(Integer idCampo) {
		this.idCampo = idCampo;
	}

	public Integer getIdDeporte() {
		return idDeporte;
	}

	public void setIdDeporte(Integer idDeporte) {
		this.idDeporte = idDeporte;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	@Override
	public String toString() {
		return "Reserva [idCampo=" + idCampo + ", idDeporte=" + idDeporte + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", dia=" + dia + "]";
	}

}
