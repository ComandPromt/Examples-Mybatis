package com.mybatis;

public class TipoDeporte {

	private Integer idDeporte;
	private String nombre;

	public TipoDeporte(Integer idDeporte) {
		super();
		this.idDeporte = idDeporte;
	}

	public TipoDeporte() {

	}

	public Integer getIdDeporte() {
		return idDeporte;
	}

	public void setIdDeporte(Integer idDeporte) {
		this.idDeporte = idDeporte;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "TipoDeporte [idDeporte=" + idDeporte + ", nombre=" + nombre + "]";
	}

}
