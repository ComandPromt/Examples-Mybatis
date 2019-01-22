package com.mybatis;

import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;

import com.ibatis.common.jdbc.exception.NestedSQLException;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class Main {

	public static void main(String[] args) {

		try {
			String resource = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			menu(sqlMap);

			// INSERTAR TIPO DEPORTE

			// TipoDeporte tipoD1 = new TipoDeporte();
			// tipoD1.setNombre("fútbol");
			// sqlMap.insert("insertTipoDeporte", tipoD1);
			//
			// // INSERTAR CAMPO
			//
			// Campo campo1 = new Campo();
			// campo1.setNombre("campo3");
			// sqlMap.insert("insertCampo", campo1);

			// INSERTAR RESERVA
			//
			// Reserva r1 = new Reserva();
			// r1.setHora_inicio("09:00");
			// r1.setHora_fin("10:00");
			// r1.setDia("01/02/2019");
			// r1.setId_Campo(3);
			// r1.setId_tipoDeporte(3);
			// sqlMap.insert("insertReserva", r1);

			// ELIMINAR RESERVA
			// sqlMap.delete("removeReserva", 4);
			// ELIMINAR TIPO DEPORTE
			// try {
			// sqlMap.delete("removeTipoDeporte", 3);
			// } catch (NestedSQLException e) {
			// System.out.println("Existe un tipo de deporte con una reserva hecha.");
			// }
			//
			// // // ELIMINAR CAMPO
			// try {
			// sqlMap.delete("removeCampo", 3);
			// } catch (NestedSQLException e) {
			// System.out.println("Existe un campo con una reserva hecha.");
			// }

			// // MODIFICAR TIPO DEPORTE
			// // Obtenemos un tipoDeporte
			// Integer claveTipoDeporte = new Integer(3);
			// TipoDeporte tipoModif = (TipoDeporte) sqlMap.queryForObject("getTipoDeporte",
			// claveTipoDeporte);
			//
			// // modificar un tipo de deporte
			// tipoModif.setNombre("futbolModif");
			// sqlMap.update("updateTipoDeporte", tipoModif);
			//
			// // MODIFICAR CAMPO
			// // Obtenemos un campo
			// Integer claveCampo = new Integer(3);
			// Campo campoModif = (Campo) sqlMap.queryForObject("getCampo", claveCampo);
			//
			// // modificar un tipo de deporte
			// campoModif.setNombre("campoModif");
			// sqlMap.update("updateCampo", campoModif);

			// SELECT RESERVA

			// List<Reserva> reservas = sqlMap.queryForList("getReservas", null);
			// for (Reserva r : reservas) {
			// System.out.println(r);
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void menu(SqlMapClient sqlMap) {

		try {

			int opcion1;
			int opcion2;

			do {

				Scanner sc = new Scanner(System.in);
				System.out.println("========================");
				System.out.println("MENÚ PRINCIPAL");
				System.out.println("1. Tipo de deporte. \n2. Campos. \n3. Reservas. \n4. Salir.");
				System.out.print("Elige una opcion: ");
				opcion1 = sc.nextInt();

				do {

					Scanner s = new Scanner(System.in);
					System.out.println("========================");

					if (opcion1 == 3) {
						System.out.println("1. Insertar. \n2. Consultar. \n4. Salir.");
					} else {
						System.out.println("1. Insertar. \n2. Actualizar. \n3. Eliminar. \n4. Salir.");
					}

					System.out.print("Elige una opcion: ");

					opcion2 = s.nextInt();

					switch (opcion2) {

					case 1:
						// INSERTAR
						if (opcion1 == 1) {
							System.out.print("Introduzca el nombre del tipo de deporte: ");
							String nombre = s.next();
							TipoDeporte tipoD1 = new TipoDeporte();
							tipoD1.setNombre(nombre);
							sqlMap.insert("insertTipoDeporte", tipoD1);

						} else if (opcion1 == 2) {
							System.out.print("Introduzca el nombre del campo: ");
							String nombre = s.next();
							Campo campo1 = new Campo();
							campo1.setNombre(nombre);
							sqlMap.insert("insertCampo", campo1);
						} else {
							Reserva r1 = new Reserva();
							System.out.print("Introduzca la hora de inicio: ");
							String horaInicio = s.next();
							System.out.print("Introduzca la hora de finalización: ");
							String horaFinal = s.next();
							System.out.print("Introduzca el dia: ");
							String dia = s.next();
							System.out.print("Introduzca el campo: ");
							int campo = s.nextInt();
							System.out.print("Introduzca el tipo de deporte: ");
							int tipoDep = s.nextInt();
							r1.setHora_inicio(horaInicio);
							r1.setHora_fin(horaFinal);
							r1.setDia(dia);
							r1.setId_Campo(campo);
							r1.setId_tipoDeporte(tipoDep);
							sqlMap.insert("insertReserva", r1);
						}

						break;
					case 2:
						// MODIFICAR TIPO DEPORTE
						String nombre;
						if (opcion1 == 1) {

							// MODIFICAR TIPO DEPORTE
							// Obtenemos un tipoDeporte
							System.out.print("Introduzca el id del tipo de deporte que desea modificar: ");
							int idtipo = s.nextInt();
							System.out.print("Introduzca el nuevo nombre: ");
							nombre = s.next();
							Integer claveTipoDeporte = new Integer(idtipo);
							TipoDeporte tipoModif = (TipoDeporte) sqlMap.queryForObject("getTipoDeporte",
									claveTipoDeporte);

							// modificar un tipo de deporte
							tipoModif.setNombre(nombre);
							sqlMap.update("updateTipoDeporte", tipoModif);

						} else if (opcion1 == 2) {

							// MODIFICAR CAMPO
							// Obtenemos un campo
							System.out.print("Introduzca el id del campo que desea modificar: ");
							int idcampo = s.nextInt();
							System.out.print("Introduzca el nuevo nombre: ");
							nombre = s.next();
							Integer claveCampo = new Integer(idcampo);
							Campo campoModif = (Campo) sqlMap.queryForObject("getCampo", claveCampo);

							// modificar un tipo de deporte
							campoModif.setNombre(nombre);
							sqlMap.update("updateCampo", campoModif);

						} else {

							List<Reserva> reservas = sqlMap.queryForList("getReservas", null);
							for (Reserva r : reservas) {
								System.out.println(r);
							}

						}
						break;

					case 3:
						// ELIMINAR
						if (opcion1 == 1) {
							try {
								System.out.print("Introduzca el id del tipo de deporte que desea eliminar: ");
								int idTipo = s.nextInt();
								sqlMap.delete("removeTipoDeporte", idTipo);
							} catch (NestedSQLException e) {
								System.out.println("Existe un tipo de deporte con una reserva hecha.");
							}

						} else if (opcion1 == 2) {
							try {
								System.out.print("Introduzca el id del tipo del campo que desea eliminar: ");
								int idCampo = s.nextInt();
								sqlMap.delete("removeCampo", idCampo);
							} catch (NestedSQLException e) {
								System.out.println("Existe un campo con una reserva hecha.");
							}

						} else {
							System.out.print("Introduzca el id de la reserva que desea eliminar: ");
							int idReserva = s.nextInt();
							sqlMap.delete("removeReserva", idReserva);
						}

						break;

					case 4:
						// SALIR
						System.out.println("Hasta luego.");
						break;
					}

				} while (opcion2 != 4);

			} while (opcion1 != 4);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
