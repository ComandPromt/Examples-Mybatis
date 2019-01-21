package com;

public class Deporte {

	private String nombreDeporte;
	private Integer idDeporte;

	public Deporte() {

	}

	public Deporte(String nombreDeporte, Integer idDeporte) {
		super();
		this.nombreDeporte = nombreDeporte;
		this.idDeporte = idDeporte;
	}

	public String getNombreDeporte() {
		return nombreDeporte;
	}

	public void setNombreDeporte(String nombreDeporte) {
		this.nombreDeporte = nombreDeporte;
	}

	public Integer getIdDeporte() {
		return idDeporte;
	}

	public void setIdDeporte(Integer idDeporte) {
		this.idDeporte = idDeporte;
	}

	@Override
	public String toString() {
		return nombreDeporte + ", " + idDeporte;
	}

}
