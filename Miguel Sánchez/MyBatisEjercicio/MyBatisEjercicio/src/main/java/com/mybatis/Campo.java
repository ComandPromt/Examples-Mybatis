package com.mybatis;

public class Campo {

	private Integer idCampo;
	private String nombre;

	public Campo(Integer idCampo, String nombre) {
		super();
		this.idCampo = idCampo;
		this.nombre = nombre;
	}

	public Campo() {

	}

	public Integer getIdCampo() {
		return idCampo;
	}

	public void setIdCampo(Integer idCampo) {
		this.idCampo = idCampo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Campo [idCampo=" + idCampo + ", nombre=" + nombre + "]";
	}

}
