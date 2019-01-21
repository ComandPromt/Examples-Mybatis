package com.objetos;

import java.io.Reader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class TestMain {
	static Scanner s = new Scanner(System.in);
	static SqlMapClient sqlMap;

	public static void main(String[] args) {
		try {
			String resource = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			/*
			 * // INSERTAR // Insertar un coche nuevo. No ponemos id porque se genera solo
			 * en la inserci�n. Coche coche = new Coche(); coche.setMarca("una marca");
			 * coche.setMatricula("una matricula"); coche.setFechaMatricula(new Date());
			 * sqlMap.insert("insertCoche", coche);
			 * 
			 * // Ahora insertamos con un Hashtable. Hashtable hashCoche = new Hashtable();
			 * hashCoche.put("marca", "la marca"); hashCoche.put("matricula", "x-2222-z");
			 * hashCoche.put("fechaMatricula", new Date()); sqlMap.insert("insertCoche",
			 * hashCoche);
			 * 
			 * // MODIFICAR // Obtenemos un coche. Integer claveCoche = new Integer(1);
			 * Coche cocheModif = (Coche) sqlMap.queryForObject("getCoche", claveCoche);
			 * 
			 * // modificar un coche cocheModif.setMarca("cambiada");
			 * sqlMap.update("updateCoche", cocheModif);
			 * 
			 * // SELECT Integer claveCoche2 = new Integer(1); Coche coche2 = (Coche)
			 * sqlMap.queryForObject("getCoche", claveCoche2);
			 * 
			 * List<Coche> coches = sqlMap.queryForList("getCoches", null); for (Coche c :
			 * coches) { System.out.println(c); }
			 * 
			 * // Map hashCoche2 = (Map)sqlMap.queryForObject("getHashCoche",3);
			 * 
			 * // ELIMINAR sqlMap.delete("removeCoche", 4);
			 */
			int num;
			do {
				System.out.println(
						"Opciones del menu:\n" + "\t 1.Campos\n \t 2.Tipos de deportes\n \t 3.Reservas\n \t 0.Salir\n");
				System.out.print("Introduzca el numero de la opcion: ");
				num = s.nextInt();
				s.nextLine();
				System.out.println("\n");
				switch (num) {
				case 1:
					funcionCampo();
					break;
				case 2:
					funcionTipoDeporte();
					break;
				case 3:
					funcionReserva();
					break;
				default:
					break;
				}
			} while (num != 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void funcionCampo() throws SQLException {
		// TODO Auto-generated method stub
		int num1;
		do {
			System.out.println(
					"Opciones del menu:\n \t 1.Añadir campo\n \t 2.Eliminar campo\n \t 3.Actualizar campo\n \t 4.Listar campos\n \t 0.Salir\n");
			System.out.print("Introduzca el numero de la opcion: ");
			num1 = s.nextInt();
			s.nextLine();
			System.out.println("\n");
			switch (num1) {
			case 1:
				añadirCampo();
				break;
			case 2:
				eliminarCampo();
				break;
			case 3:
				actualizarCampo();
				break;
			case 4:
				listarCampo();
				break;
			default:
				break;
			}
		} while (num1 != 0);
	}

	private static void añadirCampo() throws SQLException {
		// TODO Auto-generated method stub

		Campo campo = new Campo();
		System.out.println("Introduzca el nombre del campo");
		campo.setNombre(s.nextLine());
		sqlMap.insert("insertCampo", campo);
	}

	private static void eliminarCampo() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Introduzca el id del campo a eliminar");
		sqlMap.delete("removeCampo", s.nextInt());
	}

	private static void actualizarCampo() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Introduzca el id del campo a modificar");
		Campo campoModif = (Campo) sqlMap.queryForObject("getCampo", s.nextInt());
		s.nextLine();
		System.out.println("Introduzca el nuevo nombre");
		campoModif.setNombre(s.nextLine());
		sqlMap.update("updateCampo", campoModif);
	}

	private static void listarCampo() throws SQLException {
		// TODO Auto-generated method stub
		List<Campo> campos = sqlMap.queryForList("getCampos", null);
		for (Campo c : campos) {
			System.out.println(c);
		}
	}

	private static void funcionTipoDeporte() throws SQLException {
		// TODO Auto-generated method stub
		int num1;
		do {
			System.out.println(
					"Opciones del menu:\n \t 1.Añadir tipo de deporte\n \t 2.Eliminar tipo de deporte\n \t 3.Actualizar tipo de deporte\n \t 4.Listar tipo de deportes\n \t 0.Salir\n");
			System.out.print("Introduzca el numero de la opcion: ");
			num1 = s.nextInt();
			s.nextLine();
			System.out.println("\n");
			switch (num1) {
			case 1:
				añadirTipoDeporte();
				break;
			case 2:
				eliminarTipoDeporte();
				break;
			case 3:
				actualizarTipoDeporte();
				break;
			case 4:
				listarTipoDeporte();
				break;
			default:
				break;
			}
		} while (num1 != 0);
	}

	private static void añadirTipoDeporte() throws SQLException {
		// TODO Auto-generated method stub
		tipoDeporte deporte = new tipoDeporte();
		System.out.println("Introduzca el nombre del deporte");
		deporte.setNombreDeporte(s.nextLine());
		sqlMap.insert("insertTipoDeporte", deporte);
	}

	private static void eliminarTipoDeporte() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Introduzca el id del deporte a eliminar");
		sqlMap.delete("removeTipoDeporte", s.nextInt());
	}

	private static void actualizarTipoDeporte() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Introduzca el id del deporte a modificar");
		tipoDeporte deporteModif = (tipoDeporte) sqlMap.queryForObject("getTipoDeporte", s.nextInt());
		s.nextLine();
		System.out.println("Introduzca el nuevo nombre");
		deporteModif.setNombreDeporte(s.nextLine());
		sqlMap.update("updateTipoDeporte", deporteModif);
	}

	private static void listarTipoDeporte() throws SQLException {
		// TODO Auto-generated method stub
		List<tipoDeporte> deportes = sqlMap.queryForList("getTipoDeportes", null);
		for (tipoDeporte d : deportes) {
			System.out.println(d);
		}
	}

	private static void funcionReserva() throws SQLException {
		// TODO Auto-generated method stub
		int num1;
		do {
			System.out.println(
					"Opciones del menu:\n \t 1.Añadir tipo de reserva\n \t 2.Eliminar tipo de reserva\n \t 3.Actualizar tipo de reserva\n \t 4.Listar tipo de reservas\n \t 0.Salir\n");
			System.out.print("Introduzca el numero de la opcion: ");
			num1 = s.nextInt();
			s.nextLine();
			System.out.println("\n");
			switch (num1) {
			case 1:
				añadirReserva();
				break;
			case 2:
				eliminarReserva();
				break;
			case 3:
				actualizarReserva();
				break;
			case 4:
				listarReserva();
				break;
			default:
				break;
			}
		} while (num1 != 0);
	}

	private static void añadirReserva() throws SQLException {
		// TODO Auto-generated method stub
		reserva reserva = new reserva();
		System.out.println("Introduzca el nombre de la reserva");
		reserva.setNombreReserva(s.nextLine());
		System.out.println("Introduzca el dia de la reserva");
		reserva.setDia(s.nextLine());
		System.out.println("Introduzca la hora de inicio la reserva");
		reserva.setHoraInicio(s.nextLine());
		System.out.println("Introduzca la hora de fin de la reserva");
		reserva.setHoraFin(s.nextLine());
		System.out.println("Introduzca el id del campo");
		reserva.setId_campo(s.nextInt());
		System.out.println("Introduzca el id del deporte");
		reserva.setId_tipoDeporte(s.nextInt());
		sqlMap.insert("insertReserva", reserva);
	}

	private static void eliminarReserva() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Introduzca el id de la reserva a eliminar");
		sqlMap.delete("removeReserva", s.nextInt());
	}

	private static void actualizarReserva() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Introduzca el id de la reserva a modificar");
		reserva reservaModif = (reserva) sqlMap.queryForObject("getReserva", s.nextInt());
		s.nextLine();
		System.out.println("Introduzca el nuevo nombre");
		reservaModif.setNombreReserva(s.nextLine());
		System.out.println("Introduzca el nuevo dia de la reserva");
		reservaModif.setDia(s.nextLine());
		System.out.println("Introduzca la nueva hora de inicio la reserva");
		reservaModif.setHoraInicio(s.nextLine());
		System.out.println("Introduzca la nueva hora de fin de la reserva");
		reservaModif.setHoraFin(s.nextLine());
		System.out.println("Introduzca el nuevo nuevo id del campo");
		reservaModif.setId_tipoDeporte(s.nextInt());
		System.out.println("Introduzca el nuevo id del deporte");
		reservaModif.setId_campo(s.nextInt());
		sqlMap.update("updateReserva", reservaModif);
	}

	private static void listarReserva() throws SQLException {
		// TODO Auto-generated method stub
		List<reserva> reservas = sqlMap.queryForList("getReservas", null);
		for (reserva r : reservas) {
			System.out.println(r);
		}
	}

}
