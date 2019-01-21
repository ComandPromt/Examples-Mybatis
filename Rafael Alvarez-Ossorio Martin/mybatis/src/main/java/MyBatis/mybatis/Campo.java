package MyBatis.mybatis;

public class Campo {
	
	public Integer id_campo;
	public String nombre;
	
	public Campo() {
		
	}
	public Campo(Integer id_campo, String nombre) {
		super();
		this.id_campo = id_campo;
		this.nombre = nombre;
	}
	public Integer getId_campo() {
		return id_campo;
	}
	public void setId_campo(Integer id_campo) {
		this.id_campo = id_campo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
