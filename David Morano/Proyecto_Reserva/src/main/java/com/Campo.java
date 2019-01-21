package com;

public class Campo {

	private Integer idCampo;
	private String nombreCampo;

	public Campo() {

	}

	public Campo(Integer idCampo, String nombreCampo) {
		super();
		this.idCampo = idCampo;
		this.nombreCampo = nombreCampo;
	}

	public Integer getIdCampo() {
		return idCampo;
	}

	public void setIdCampo(Integer idCampo) {
		this.idCampo = idCampo;
	}

	public String getNombreCampo() {
		return nombreCampo;
	}

	public void setNombreCampo(String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}

	@Override
	public String toString() {
		return idCampo + ", " + nombreCampo;
	}

}
