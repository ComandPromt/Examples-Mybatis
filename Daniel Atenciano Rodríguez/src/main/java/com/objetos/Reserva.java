package com.objetos;

public class Reserva {

	private Integer id_Reserva;
	private String nombre_Reserva;
	private String Hora_Inicio;
	private String Hora_Fin;
	private String dia;

	// Foráneas
	private Integer id_Campo;
	private Integer id_tipoDeporte;

	public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reserva(Integer id_Reserva, String nombre_Reserva, String hora_Inicio, String hora_Fin, String dia,
			Integer id_Campo, Integer id_tipoDeporte) {
		super();
		this.id_Reserva = id_Reserva;
		this.nombre_Reserva = nombre_Reserva;
		this.Hora_Inicio = hora_Inicio;
		this.Hora_Fin = hora_Fin;
		this.dia = dia;
		this.id_Campo = id_Campo;
		this.id_tipoDeporte = id_tipoDeporte;
	}

	public Integer getId_Reserva() {
		return id_Reserva;
	}

	public void setId_Reserva(Integer id_Reserva) {
		this.id_Reserva = id_Reserva;
	}

	public String getNombre_Reserva() {
		return nombre_Reserva;
	}

	public void setNombre_Reserva(String nombre_Reserva) {
		this.nombre_Reserva = nombre_Reserva;
	}

	public String getHora_Inicio() {
		return Hora_Inicio;
	}

	public void setHora_Inicio(String hora_Inicio) {
		Hora_Inicio = hora_Inicio;
	}

	public String getHora_Fin() {
		return Hora_Fin;
	}

	public void setHora_Fin(String hora_Fin) {
		Hora_Fin = hora_Fin;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Integer getId_Campo() {
		return id_Campo;
	}

	public void setId_Campo(Integer id_Campo) {
		this.id_Campo = id_Campo;
	}

	public Integer getId_tipoDeporte() {
		return id_tipoDeporte;
	}

	public void setId_tipoDeporte(Integer id_tipoDeporte) {
		this.id_tipoDeporte = id_tipoDeporte;
	}

	@Override
	public String toString() {
		return "Reserva [id_Reserva=" + id_Reserva + ", nombre_Reserva=" + nombre_Reserva + ", Hora_Inicio="
				+ Hora_Inicio + ", Hora_Fin=" + Hora_Fin + ", dia=" + dia + ", id_Campo=" + id_Campo
				+ ", id_tipoDeporte=" + id_tipoDeporte + "]";
	}

}
