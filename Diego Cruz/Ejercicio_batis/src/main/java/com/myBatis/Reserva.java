package com.myBatis;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

	private int id, id_campo, id_deporte;
	private Date fecha;
	private String hora_inicio, hora_fin;

}
