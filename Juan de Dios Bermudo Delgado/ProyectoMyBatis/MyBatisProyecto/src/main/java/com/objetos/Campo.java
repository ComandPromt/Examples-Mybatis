package com.objetos;

public class Campo {
	private Integer id_campo;
	private String nombreCampo;

	public Integer getId_campo() {
		return id_campo;
	}

	public void setId_campo(Integer id_campo) {
		this.id_campo = id_campo;
	}

	public String getNombre() {
		return nombreCampo;
	}

	public void setNombre(String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}

	@Override
	public String toString() {
		return "Campo [id_campo=" + id_campo + ", nombreCampo=" + nombreCampo + "]";
	}

}
