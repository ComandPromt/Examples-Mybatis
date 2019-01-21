package MyBatis.mybatis;

import java.util.Date;

public class Coche {
	
	private Integer id;
	private String marca; 
	private String matricula;
	private Date fechaMatricula;
	
	public Coche() {

	}
	public Coche(Integer id, String marca, String matricula, Date fechaMatriculacion) {
		this.id = id;
		this.marca = marca;
		this.matricula = matricula;
		this.fechaMatricula = fechaMatriculacion;
	}
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

	
}
