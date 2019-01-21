package com.objetos;

import java.util.Date;

public class Coche {

	private Integer id;

	private String marca;

	private String matricula;

	private Date fechaMatricula;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Date getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(Date fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", marca=" + marca + ", matricula=" + matricula + ", fechaMatricula="
				+ fechaMatricula + "]";
	}

}
