package com.mybatis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

	private Integer id;
	private String hora_inicio;
	private String hora_fin;
	private String dia;
	private Integer id_tipoDeporte;
	private Integer id_Campo;

}
