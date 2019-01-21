package com;

import java.io.Reader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class ReservasMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resource = "ConfiguracionIbatis.xml";
		Reader reader;
		SqlMapClient sqlMap = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// inserción de datos
		Scanner scanner = new Scanner(System.in);
		int select = -1;
		//
		// Mientras la opción elegida sea 0, preguntamos al usuario
		while (select != 0) {
			// Try catch para evitar que el programa termine si hay un error
			try {
				System.out.println("Elige opción:\n" + "1.- Insertar Campo\n" + "2.-Insertar deporte\n"
						+ "3.- Insertar Reserva \n" + "4.- Mostrar una reserva \n" + "5.- Mostrar todas las reservas\n"
						+ "6.- Actualizar reserva\n" + "7.- Borrar reserva\n" + "8.- Borrar campo\n"
						+ "9.-Borrar deporte\n" + "0.- Salir de programa\n");
				// Recoger una variable por consola
				select = Integer.parseInt(scanner.next());
				switch (select) {
				case 1:
					Campo campoInsertar = new Campo();
					System.out.println("Insertar el nombre:");
					String nombreCampo = scanner.next();
					campoInsertar.setNombreCampo(nombreCampo);
					sqlMap.insert("insertCampo", campoInsertar);
					System.out.println("Campo insertado");
					break;
				case 2:
					Deporte deporteInsertar = new Deporte();
					System.out.println("Insertar el nombre:");
					String nombreDeporte = scanner.next();
					deporteInsertar.setNombreDeporte(nombreDeporte);

					sqlMap.insert("insertDeporte", deporteInsertar);
					System.out.println("Deporte insertado");
					break;
				case 3:
					Reserva reservaInsertar = new Reserva();
					System.out.println("Insertar hora inicio reserva:");
					String horaInicioReserva = scanner.next();
					System.out.println("Insertar hora fin reserva:");
					String horaFinReserva = scanner.next();

					System.out.println("Insertar dia reserva:");
					String diaReserva = scanner.next();
					System.out.println("Insertar id campo:");
					int idCampoReserva = scanner.nextInt();
					System.out.println("Insertar id deporte:");
					int idDeporteReserva = scanner.nextInt();
					scanner.nextLine();
					try {
						reservaInsertar.setHora_inicio_reserva(horaInicioReserva);
						reservaInsertar.setHora_fin_reserva(horaFinReserva);
						reservaInsertar.setFkIdCampo(idCampoReserva);
						reservaInsertar.setDiaReserva(diaReserva);
						reservaInsertar.setFkIdDeporte(idDeporteReserva);

						/*
						 * System.out.println(horaInicioReserva); System.out.println(horaInicioReserva);
						 * System.out.println(diaReserva); System.out.println(idCampoReserva);
						 * System.out.println(idDeporteReserva);
						 */
						sqlMap.insert("insertReserva", reservaInsertar);

						System.out.println("Reserva insertada.");
					} catch (Exception ex) {
						String error = ex.getMessage();
						if (error.contains("fk_id_campo")) {
							System.out.println("Falla la restricción campo");
						}
						if (error.contains("fk_id_reserva")) {
							System.out.println("Falla la restricción reserva");
						}
					}
					break;
				case 4:
					System.out.println("Insertar id reserva:");
					int idReservaConsultar = scanner.nextInt();
					Reserva reserva = (Reserva) sqlMap.queryForObject("getReserva", idReservaConsultar);
					System.out.println("Datos:");
					System.out.println("Dia: " + reserva.getDiaReserva());
					System.out.println("Hora inicio: " + reserva.getHora_inicio_reserva());
					System.out.println("Hora fin: " + reserva.getHora_fin_reserva());

					break;
				case 5:
					System.out.println("Listado:");
					List<Reserva> reservas = sqlMap.queryForList("getReservas", null);
					for (Reserva r : reservas) {
						System.out.println("  Datos:");
						System.out.println("Dia: " + r.getDiaReserva());
						System.out.println("Hora inicio: " + r.getHora_inicio_reserva());
						System.out.println("Hora fin: " + r.getHora_fin_reserva());

					}
					break;
				case 6:
					Reserva reservaUpdate = new Reserva();
					System.out.println("Vuelve a introducir los datos...");
					System.out.println("Insertar id reserva:");
					int idReserva = scanner.nextInt();
					System.out.println("Insertar hora inicio reserva:");
					String horaInicioReservaUpdate = scanner.next();
					System.out.println("Insertar hora fin reserva:");
					String horaFinReservaUpdate = scanner.next();

					System.out.println("Insertar dia reserva:");
					String diaReservaUpdate = scanner.next();
					System.out.println("Insertar id campo:");
					int idCampoReservaUpdate = scanner.nextInt();
					System.out.println("Insertar id deporte:");
					int idDeporteReservaUpdate = scanner.nextInt();
					scanner.nextLine();
					try {
						reservaUpdate.setIdReserva(idReserva);
						reservaUpdate.setHora_inicio_reserva(horaInicioReservaUpdate);
						reservaUpdate.setHora_fin_reserva(horaFinReservaUpdate);
						reservaUpdate.setFkIdCampo(idCampoReservaUpdate);
						reservaUpdate.setDiaReserva(diaReservaUpdate);
						reservaUpdate.setFkIdDeporte(idDeporteReservaUpdate);

						/*
						 * System.out.println(horaInicioReserva); System.out.println(horaInicioReserva);
						 * System.out.println(diaReserva); System.out.println(idCampoReserva);
						 * System.out.println(idDeporteReserva);
						 */
						sqlMap.update("updateReserva", reservaUpdate);

						System.out.println("Reserva actualizada.");
					} catch (Exception ex) {
						String error = ex.getMessage();
						if (error.contains("fk_id_campo")) {
							System.out.println("Falla la restricción campo");
						}
						if (error.contains("fk_id_reserva")) {
							System.out.println("Falla la restricción reserva");
						}
					}
					break;
				case 7:
					System.out.println("Insertar id reserva :");
					int idReservaBorrar = scanner.nextInt();
					try {
						int result = sqlMap.delete("removeReserva", idReservaBorrar);
						if (result > 0) {
							System.out.println("Registro borrado");
						} else {
							System.out.println("No existe dicho registro");
						}
					} catch (Exception ex) {
						ex.getMessage();
					}
					break;
				case 8:
					System.out.println("Insertar id campo :");
					int idCampoBorrar = scanner.nextInt();
					try {
						int result = sqlMap.delete("removeCampo", idCampoBorrar);
						if (result > 0) {
							System.out.println("Registro borrado");
						} else {
							System.out.println("No existe dicho registro");
						}
					} catch (SQLException ex) {
						String error = ex.getMessage();
						if (error.contains("fk_id_campo")) {
							System.out.println("Falla la restricción campo");
						} else {
							System.out.println(ex.getMessage());
						}

					}
					break;
				case 9:
					System.out.println("Insertar id deporte :");
					int idDeporteBorrar = scanner.nextInt();
					try {
						int result = sqlMap.delete("removeDeporte", idDeporteBorrar);
						if (result > 0) {
							System.out.println("Registro borrado");
						} else {
							System.out.println("No existe dicho registro");
						}

					} catch (SQLException ex) {
						String error = ex.getMessage();
						if (error.contains("fk_id_deporte")) {
							System.out.println("Falla la restricción deporte");
						} else {
							System.out.println(ex.getMessage());
						}

					}
					break;
				case 0:
					System.out.println("Adios!");
					break;
				default:
					System.out.println("Número no reconocido");
					break;
				}

				System.out.println("\n"); // Mostrar un salto de línea en Java

			} catch (Exception e) {
				System.out.println("Uoop! Error!" + e.getMessage());
			}
		}

	}

}
