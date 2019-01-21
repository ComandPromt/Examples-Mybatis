package com.objetos;

public class Campo {
	private Integer id_Campo;
	private String nombre_Campo;

	public Campo(Integer id_Campo, String nombre_Campo) {
		super();
		this.id_Campo = id_Campo;
		this.nombre_Campo = nombre_Campo;
	}

	public Campo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId_Campo() {
		return id_Campo;
	}

	public void setId_Campo(Integer id_Campo) {
		this.id_Campo = id_Campo;
	}

	public String getNombre_Campo() {
		return nombre_Campo;
	}

	public void setNombre_Campo(String nombre_Campo) {
		this.nombre_Campo = nombre_Campo;
	}

	@Override
	public String toString() {
		return "Campo [id_Campo=" + id_Campo + ", nombre_Campo=" + nombre_Campo + "]";
	}

}
