package MyBatis.mybatis;

import java.util.Date;

public class Reserva {
	
	public Integer idReserva;
	public Double hora_inicio;
	public Double hora_fin;
	public Date dia;
	public Integer id_tipo;
	public Integer id_campo;
	
	public Reserva() {
		
	}

	public Reserva(Integer idReserva, Double hora_inicio, Double hora_fin, Date dia, Integer id_tipo, Integer id_campo) {
		super();
		this.idReserva = idReserva;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
		this.dia = dia;
		this.id_tipo = id_tipo;
		this.id_campo = id_campo;
	}

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public Double getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(Double hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public Double getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(Double hora_fin) {
		this.hora_fin = hora_fin;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public Integer getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(Integer id_tipo) {
		this.id_tipo = id_tipo;
	}

	public Integer getId_campo() {
		return id_campo;
	}

	public void setId_campo(Integer id_campo) {
		this.id_campo = id_campo;
	}
	
	
	

}
