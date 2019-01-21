package com.objetos;

public class tipoDeporte {
	private Integer id_tipoDeporte;
	private String nombreDeporte;

	public Integer getId_tipoDeporte() {
		return id_tipoDeporte;
	}

	public void setId_tipoDeporte(Integer id_tipoDeporte) {
		this.id_tipoDeporte = id_tipoDeporte;
	}

	public String getNombreDeporte() {
		return nombreDeporte;
	}

	public void setNombreDeporte(String nombreDeporte) {
		this.nombreDeporte = nombreDeporte;
	}

	@Override
	public String toString() {
		return "tipoDeporte [id_tipoDeporte=" + id_tipoDeporte + ", nombreDeporte=" + nombreDeporte + "]";
	}

}
