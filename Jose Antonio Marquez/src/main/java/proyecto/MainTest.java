package proyecto;

import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class MainTest {
	public static void main(String[] args) throws Exception {

		int opcion;
		do {
			Scanner s = new Scanner(System.in);
			System.out.println("---");
			System.out.println("Menú repetitivo.");
			System.out.println("Acciones con una reserva");
			System.out.println("0. Salir del menú");
			System.out.println("1. Insertar una reserva nueva");
			System.out.println("2. Eliminar una reserva");
			System.out.println("3. Listar las reservas");
			System.out.println();
			System.out.println("Acciones con un campo");
			System.out.println("4. Insertar un campo nuevo");
			System.out.println("5. Eliminar un campo");
			System.out.println("6. Listar los campos");
			System.out.println();
			System.out.println("Acciones con un deporte");
			System.out.println("7. Insertar un deporte nuevo");
			System.out.println("8. Eliminar un deporte");
			System.out.println("9. Listar los deportes");
			System.out.print("Escriba una opción: ");
			opcion = s.nextInt();

			switch (opcion) {
			case 1:
				System.out.println("Insertar una nueva reserva");
				insertarReserva();
				System.out.println(("Reserva insertada").toUpperCase());
				break;
			case 2:
				System.out.println("Eliminar una reserva");
				eliminarReserva();
				System.out.println(("Reserva eliminada").toUpperCase());
				break;
			case 3:
				System.out.println("Listar todas las reservas");
				listarReservas();
				System.out.println(("Listada todas las reservas").toUpperCase());
				break;
			case 4:
				System.out.println("Insertar un nuevo campo");
				insertarCampo();
				System.out.println(("Campo insertado").toUpperCase());
				break;
			case 5:
				System.out.println("Eliminar un campo");
				eliminarCampo();
				System.out.println(("Campo eliminado").toUpperCase());
				break;
			case 6:
				System.out.println("Listar todos los campos");
				listarCampos();
				System.out.println(("Listado de todos los campos").toUpperCase());
				break;
			case 7:
				System.out.println("Insertar un nuevo deporte");
				insertarDeporte();
				System.out.println(("Deporte insertado").toUpperCase());
				break;
			case 8:
				System.out.println("Eliminar un deporte");
				eliminarDeporte();
				System.out.println(("Deporte eliminado").toUpperCase());
				break;
			case 9:
				System.out.println("Listar todos los deportes");
				listarDeportes();
				System.out.println(("Listado de todos los deportes").toUpperCase());
				break;
			}

		} while (opcion != 0);
		{
			System.out.println("Fuera del menú.");
		}

	}

	public static void insertarReserva() throws Exception {
		try {
			String archivo = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(archivo);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			Scanner s = new Scanner(System.in);
			Reserva res = new Reserva();
//			System.out.print("introduce el id del campo: ");
//			res.setIdCampo(s.nextInt());
//			s.nextLine();
			System.out.print("introduce el nombre de la reserva: ");
			res.setNombreReserva(s.nextLine());
			System.out.print("introduce la hora de inicio: ");
			res.setHora_inicio(s.nextLine());
			System.out.print("introduce la hora de fin: ");
			res.setHora_fin(s.nextLine());
			System.out.print("introduce el dia: ");
			res.setDia(s.nextLine());
			System.out.print("introduce el ID del tipo de deporte: ");
			res.setIdTipoDep(s.nextInt());
			s.nextLine();
			sqlMap.insert("insertarReserva", res);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void eliminarReserva() throws Exception {
		try {
			String archivo = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(archivo);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			Scanner s = new Scanner(System.in);
			System.out.print("introduce el id de la reserva a eliminar: ");
			int id = s.nextInt();
			sqlMap.delete("eliminarReserva", id);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void listarReservas() throws Exception {
		try {
			String archivo = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(archivo);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			// SELECT
			Integer reservaClave = new Integer(1);
			Reserva reserva = (Reserva) sqlMap.queryForObject("getReserva", reservaClave);

			List<Reserva> reservas = sqlMap.queryForList("getReservas", null);
			for (Reserva reserva2 : reservas) {
				System.out.println("\tID de la reserva: " + reserva2.getIdReserva());
				System.out.println("\tID del campo: " + reserva2.getIdCampo());
				System.out.println("\tNombre de la reserva: " + reserva2.getNombreReserva());
				System.out.println("\tHora de inicio: " + reserva2.getHora_inicio());
				System.out.println("\tHora de fin: " + reserva2.getHora_fin());
				System.out.println("\tDia de la reserva: " + reserva2.getDia());
				System.out.println("\tID del tipo de deporte: " + reserva2.getIdTipoDep());
				System.out.println("\t---");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void insertarCampo() throws Exception {
		try {
			String archivo = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(archivo);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			Scanner s = new Scanner(System.in);
			Campo campo = new Campo();
			System.out.print("introduce el id del campo: ");
			campo.setIdCampo(s.nextInt());
			s.nextLine();
			System.out.print("introduce el nombre del campo: ");
			campo.setNombreCampo(s.nextLine());
			sqlMap.insert("insertarCampo", campo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void eliminarCampo() throws Exception {
		try {
			String archivo = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(archivo);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			Scanner s = new Scanner(System.in);
			System.out.print("introduce el id del campo a eliminar: ");
			int id = s.nextInt();
			sqlMap.delete("eliminarCampo", id);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void listarCampos() throws Exception {
		try {
			String archivo = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(archivo);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			// SELECT
			Integer campoClave = new Integer(1);
			Campo campo = (Campo) sqlMap.queryForObject("getCampo", campoClave);

			List<Campo> campos = sqlMap.queryForList("getCampos", null);
			for (Campo campo2 : campos) {
				System.out.println("\tID del campo: " + campo2.getIdCampo());
				System.out.println("\tNombre del campo: " + campo2.getNombreCampo());
				System.out.println("\t---");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void insertarDeporte() throws Exception {
		try {
			String archivo = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(archivo);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			Scanner s = new Scanner(System.in);
			TipoDeporte deporte = new TipoDeporte();
			System.out.print("introduce el id del deporte: ");
			deporte.setIdDeporte(s.nextInt());
			s.nextLine();
			System.out.print("introduce el nombre del deporte: ");
			deporte.setNombreDeporte(s.nextLine());
			sqlMap.insert("insertarDeporte", deporte);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void eliminarDeporte() throws Exception {
		try {
			String archivo = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(archivo);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			Scanner s = new Scanner(System.in);
			System.out.print("introduce el id del deporte a eliminar: ");
			int id = s.nextInt();
			sqlMap.delete("eliminarDeporte", id);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void listarDeportes() throws Exception {
		try {
			String archivo = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(archivo);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			// SELECT
			Integer deporteClave = new Integer(1);
			TipoDeporte dep = (TipoDeporte) sqlMap.queryForObject("getDeporte", deporteClave);

			List<TipoDeporte> deportes = sqlMap.queryForList("getDeportes", null);
			for (TipoDeporte dep1 : deportes) {
				System.out.println("\tID del deporte: " + dep1.getIdDeporte());
				System.out.println("\tNombre del deporte: " + dep1.getNombreDeporte());
				System.out.println("\t---");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
