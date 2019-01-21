package com.mybatis;

import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class Test {

	public void menu() {
		int opcion = 0;

		do {
			System.out.println("Menú de Opciones");
			System.out.println("1 - Insertar Campo");
			System.out.println("2 - Modificar Campo");
			System.out.println("3 - Eliminar Campo");
			System.out.println("4 - Mostrar Campos");
			System.out.println("5 - Insertar Deporte");
			System.out.println("6 - Modificar Deporte");
			System.out.println("7 - Eliminar Deporte");
			System.out.println("8 - Mostrar Deportes");
			System.out.println("9 - Insertar Reserva");
			System.out.println("10 - Modificar Reserva");
			System.out.println("11 - Eliminar Reserva");
			System.out.println("12 - Mostrar Reservas");
			System.out.println("13 - Salir");

			Scanner s = new Scanner(System.in);
			opcion = s.nextInt();

			switch (opcion) {
			case 1:
				System.out.println("Introduce el nombre del campo");
				String nombre = s.next();
				insertarCampo(nombre);
				break;
			case 2:
				System.out.println("Introduce el id del campo");
				int id = s.nextInt();
				System.out.println("Introduce el nombre del campo");
				String nombre2 = s.next();
				modificarCampo(id, nombre2);
				break;
			case 3:
				System.out.println("Introduce el id del campo");
				int id2 = s.nextInt();
				eliminarCampo(id2);
				break;
			case 4:
				mostrarCampos();
				break;
			case 5:
				System.out.println("Introduce el nombre del deporte");
				String nombre3 = s.next();
				insertarDeporte(nombre3);
				break;
			case 6:
				System.out.println("Introduce el id del deporte");
				int id3 = s.nextInt();
				System.out.println("Introduce el nombre del deporte");
				String nombre4 = s.next();
				modificarDeporte(id3, nombre4);
				break;
			case 7:
				System.out.println("Introduce el id del deporte");
				int id4 = s.nextInt();
				eliminarDeporte(id4);
				break;
			case 8:
				mostrarDeportes();
				break;
			case 9:
				System.out.println("Introduce el id del campo de la reserva");
				int idcampo = s.nextInt();
				System.out.println("Introduce el id del deporte de la reserva");
				int iddeporte = s.nextInt();
				System.out.println("Introduce la fecha de la reserva");
				String fecha = s.next();
				System.out.println("Introduce la hora de inicio de la reserva");
				String inicio = s.next();
				System.out.println("Introduce la hora de fin de la reserva");
				String fin = s.next();
				insertarReserva(idcampo, iddeporte, fecha, inicio, fin);
				break;
			case 10:
				System.out.println("Introduce el id de la reserva");
				int id5 = s.nextInt();
				System.out.println("Introduce la fecha de la reserva");
				String fecha2 = s.next();
				System.out.println("Introduce la hora de inicio de la reserva");
				String inicio2 = s.next();
				System.out.println("Introduce la hora de fin de la reserva");
				String fin2 = s.next();
				modificarReserva(id5, fecha2, inicio2, fin2);
				break;
			case 11:
				System.out.println("Introduce el id de la reserva");
				int id6 = s.nextInt();
				eliminarReserva(id6);
				break;
			case 12:
				mostrarReservas();
			default:
				break;
			}
		} while (opcion != 13);
	}

	private void insertarCampo(String nombre) {
		try {
			String resource = "ConfiguracionMyBatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			Campo campo = new Campo();
			campo.setNombre(nombre);
			sqlMap.insert("insertCampo", campo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void modificarCampo(int id, String nombre) {
		try {
			String resource = "ConfiguracionMyBatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			Campo campoModif = (Campo) sqlMap.queryForObject("getCampo", id);

			campoModif.setNombre(nombre);
			sqlMap.update("updateCampo", campoModif);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void eliminarCampo(int id) {
		try {
			String resource = "ConfiguracionMyBatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			sqlMap.delete("removeCampo", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void mostrarCampos() {
		try {
			String resource = "ConfiguracionMyBatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			List<Campo> campos = sqlMap.queryForList("getCampos", null);
			for (Campo c : campos) {
				System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void insertarDeporte(String nombre) {
		try {
			String resource = "ConfiguracionMyBatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			TipoDeporte tipoDeporte = new TipoDeporte();
			tipoDeporte.setNombre(nombre);
			sqlMap.insert("insertDeporte", tipoDeporte);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void modificarDeporte(int id, String nombre) {
		try {
			String resource = "ConfiguracionMyBatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			TipoDeporte deporteModif = (TipoDeporte) sqlMap.queryForObject("getDeporte", id);

			deporteModif.setNombre(nombre);
			sqlMap.update("updateDeporte", deporteModif);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void eliminarDeporte(int id) {
		try {
			String resource = "ConfiguracionMyBatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			sqlMap.delete("removeDeporte", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void mostrarDeportes() {
		try {
			String resource = "ConfiguracionMyBatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			List<TipoDeporte> deportes = sqlMap.queryForList("getDeportes", null);
			for (TipoDeporte c : deportes) {
				System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void insertarReserva(int idcampo, int iddeporte, String fecha, String horainicio, String horafin) {
		try {
			String resource = "ConfiguracionMyBatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			Reserva reserva = new Reserva();
			reserva.setIdCampo(idcampo);
			reserva.setIdDeporte(iddeporte);
			reserva.setFecha(fecha);
			reserva.setHoraInicio(horainicio);
			reserva.setHoraFin(horafin);
			sqlMap.insert("insertReserva", reserva);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void modificarReserva(int id, String fecha, String horainicio, String horafin) {
		try {
			String resource = "ConfiguracionMyBatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			Reserva reservaModif = (Reserva) sqlMap.queryForObject("getReserva", id);

			reservaModif.setFecha(fecha);
			reservaModif.setHoraInicio(horainicio);
			reservaModif.setHoraFin(horafin);
			sqlMap.update("updateReserva", reservaModif);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void eliminarReserva(int id) {
		try {
			String resource = "ConfiguracionMyBatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			sqlMap.delete("removeReserva", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void mostrarReservas() {
		try {
			String resource = "ConfiguracionMyBatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			List<Reserva> reservas = sqlMap.queryForList("getReservas", null);
			for (Reserva c : reservas) {
				System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.menu();
	}

}
