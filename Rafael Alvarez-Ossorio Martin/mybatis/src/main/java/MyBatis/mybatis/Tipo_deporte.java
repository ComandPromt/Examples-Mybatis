package MyBatis.mybatis;

public class Tipo_deporte {
	
	public Integer id_tipo;
	public String nombre;
	
	public Tipo_deporte() {
	}

	public Tipo_deporte(Integer id_tipo, String nombre) {
		super();
		this.id_tipo = id_tipo;
		this.nombre = nombre;
	}

	public Integer getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(Integer id_tipo) {
		this.id_tipo = id_tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	

}
