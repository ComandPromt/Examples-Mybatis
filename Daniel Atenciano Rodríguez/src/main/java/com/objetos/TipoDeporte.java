package com.objetos;

public class TipoDeporte {
	private Integer id_tipoDeporte;
	private String nombre_Deporte;

	public TipoDeporte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoDeporte(Integer id_tipoDeporte, String nombre_Deporte) {
		super();
		this.id_tipoDeporte = id_tipoDeporte;
		this.nombre_Deporte = nombre_Deporte;
	}

	public Integer getId_tipoDeporte() {
		return id_tipoDeporte;
	}

	public void setId_tipoDeporte(Integer id_tipoDeporte) {
		this.id_tipoDeporte = id_tipoDeporte;
	}

	public String nombre_Deporte() {
		return nombre_Deporte;
	}

	public void setnombre_Deporte(String nombre_Deporte) {
		this.nombre_Deporte = nombre_Deporte;
	}

	@Override
	public String toString() {
		return "TipoDeporte [id_tipoDeporte=" + id_tipoDeporte + ", nombre_Deporte=" + nombre_Deporte + "]";
	}

}
