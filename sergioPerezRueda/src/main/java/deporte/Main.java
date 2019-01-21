package deporte;

import java.io.Reader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class Main {
	public static Scanner sn = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			String resource = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			int opcion = 0;
			while (opcion != 10) {
				System.out.println("\n1. Insertar campos");
				System.out.println("2. Actualizar campos");
				System.out.println("3. Borrar campos");
				System.out.println("4. Insertar tipo deporte");
				System.out.println("5. Actualizar tipo deporte");
				System.out.println("6. Borrar tipo deporte");
				System.out.println("7. Insertar nueva reserva");
				System.out.println("8. Eliminar reserva");
				System.out.println("9. Mostrar reservas");
				System.out.println("10. Salir");

				opcion = sn.nextInt();
				switch (opcion) {
				case 1:
					System.out.println("Has seleccionado insertar un registro para campos");
					insertaCampo(sqlMap);
					break;
				case 2:
					System.out.println("Has seleccionado actualizar registro para campos");
					actualizarCampo(sqlMap);
					break;
				case 3:
					System.out.println("Has seleccionado borrar un registro para campos");
					borrarCampo(sqlMap);
					break;
				case 4:
					System.out.println("Has seleccionado insertar un tipo de deporte");
					insertaTipoDeporte(sqlMap);
					break;
				case 5:
					System.out.println("Has seleccionado actualizar un tipo de deporte");
					actualizarTipoDeporte(sqlMap);
					break;
				case 6:
					System.out.println("Has seleccionado borrar un tipo de deporte");
					borrarTipoDeporte(sqlMap);
					break;
				case 7:
					System.out.println("Has seleccionado insertar una reserva");
					insertaReserva(sqlMap);
					break;
				case 8:
					System.out.println("Has seleccionado borrar una reserva");
					borrarReserva(sqlMap);
					break;
				case 9:
					System.out.println("Has seleccionado mostrar todas las reservas");
					mostrarReserva(sqlMap);
					break;
				case 10:
					System.out.println("Hasta la vista");
					break;
				default:
					System.out.println("Solo números entre 1 y 10");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// PARA CAMPOS
	public static void insertaCampo(SqlMapClient sqlMap) throws SQLException {
		Campo campo = new Campo();
		String cambioNombre;
		System.out.println("Introduzca el nombre para este campo");
		cambioNombre = sn.next();
		campo.setNombre(cambioNombre);
		sqlMap.insert("insertCampos", campo);
	}

	public static void borrarCampo(SqlMapClient sqlMap) throws SQLException {
		Integer aux;
		System.out.println("Introduzca el ID del campo a borrar");
		aux = sn.nextInt();
		List<Reserva> reserva = sqlMap.queryForList("comprobarCampos", aux);

		if (reserva == null || reserva.size() == 0) {
			sqlMap.delete("removeCampo", aux);
		} else {
			System.out.println("No se puede borrar, existen reservas con ese campo");
		}
	}

	public static void actualizarCampo(SqlMapClient sqlMap) throws SQLException {
		Integer aux;
		String cambioNombre;
		System.out.println("Introduzca el ID del campo a actualizar");
		aux = sn.nextInt();
		Integer claveCampo = new Integer(aux);
		Campo campoModif = (Campo) sqlMap.queryForObject("getCampo", claveCampo);
		System.out.println("Introduzca el nuevo nombre para este campo");
		cambioNombre = sn.next();
		campoModif.setNombre(cambioNombre);
		sqlMap.update("updateCampos", campoModif);
	}

	// PARA TIPO DE DEPORTE
	public static void insertaTipoDeporte(SqlMapClient sqlMap) throws SQLException {
		TipoDeporte deporte = new TipoDeporte();
		String cambioNombre;
		System.out.println("Introduzca el nombre para este deporte");
		cambioNombre = sn.next();
		deporte.setNombre(cambioNombre);
		sqlMap.insert("insertDeporte", deporte);
	}

	public static void borrarTipoDeporte(SqlMapClient sqlMap) throws SQLException {
		Integer aux;
		Integer idBorrar;
		System.out.println("Introduzca el ID del deporte a borrar");
		aux = sn.nextInt();
		List<Reserva> reserva = sqlMap.queryForList("comprobarDeportes", aux);

		if (reserva == null || reserva.size() == 0) {
			sqlMap.delete("removeDeporte", aux);
		} else {
			System.out.println("No se puede borrar, existen reservas con ese tipo de deporte");
		}
	}

	public static void actualizarTipoDeporte(SqlMapClient sqlMap) throws SQLException {
		Integer aux;
		String cambioNombre;
		System.out.println("Introduzca el ID del deporte a actualizar");
		aux = sn.nextInt();
		Integer claveCampo = new Integer(aux);
		TipoDeporte campoModif = (TipoDeporte) sqlMap.queryForObject("getDeporte", claveCampo);
		System.out.println("Introduzca el nuevo nombre para este deporte");
		cambioNombre = sn.next();
		campoModif.setNombre(cambioNombre);
		sqlMap.update("updateDeporte", campoModif);
	}

	// PARA RESERVAS
	public static void insertaReserva(SqlMapClient sqlMap) throws SQLException {
		Reserva reserva = new Reserva();
		String cambioNombre;
		Integer idAux;
		System.out.println("Introduzca la hora de inicio para esta reserva");
		cambioNombre = sn.next();
		reserva.setHora_inicio(cambioNombre);
		System.out.println("Introduzca la hora de fin para esta reserva");
		cambioNombre = sn.next();
		reserva.setHora_fin(cambioNombre);
		System.out.println("Introduzca el dia para esta reserva");
		cambioNombre = sn.next();
		reserva.setDia(cambioNombre);
		System.out.println(
				"Introduzca el id del campo para esta reserva que se encuentren entre las siguientes opciones");
		List<Campo> campo = sqlMap.queryForList("getCampos", null);
		for (Campo c : campo) {
			System.out.println(c);
		}
		idAux = sn.nextInt();
		reserva.setId_campo(idAux);
		System.out.println(
				"Introduzca el id del deporte para esta reserva que se encuentre entre las siguientes opciones");
		List<TipoDeporte> tipoDeporte = sqlMap.queryForList("getDeportes", null);
		for (TipoDeporte c : tipoDeporte) {
			System.out.println(c);
		}
		idAux = sn.nextInt();
		reserva.setId_tipoDeporte(idAux);
		sqlMap.insert("insertReserva", reserva);
	}

	public static void borrarReserva(SqlMapClient sqlMap) throws SQLException {
		Integer aux;
		System.out.println("Introduzca el ID de la reserva a borrar");
		aux = sn.nextInt();
		sqlMap.delete("removeReserva", aux);
	}

	public static void mostrarReserva(SqlMapClient sqlMap) throws SQLException {
		List<Reserva> reserva = sqlMap.queryForList("getReservas", null);
		for (Reserva c : reserva) {
			System.out.println(c);
		}
	}

}
