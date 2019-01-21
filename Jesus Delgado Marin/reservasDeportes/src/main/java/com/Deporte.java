package com;

public class Deporte {

	private int idDeporte;
	private String nombreDeporte;

	public Deporte() {

	}

	public Deporte(int idDeporte, String nombreDeporte) {
		super();
		this.idDeporte = idDeporte;
		this.nombreDeporte = nombreDeporte;
	}

	public int getIdDeporte() {
		return idDeporte;
	}

	public void setIdDeporte(int idDeporte) {
		this.idDeporte = idDeporte;
	}

	public String getNombreDeporte() {
		return nombreDeporte;
	}

	public void setNombreDeporte(String nombreDeporte) {
		this.nombreDeporte = nombreDeporte;
	}

}
