package com;

import java.io.Reader;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.ibatis.io.Resources;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class Main {

	public void insertarDeporte(String nombre) {
		try {
			String resource = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			Deporte deporte = new Deporte();
			deporte.setNombreDeporte(nombre);
			sqlMap.insert("insertDeporte", deporte);
			JOptionPane.showMessageDialog(null, "El deporte ha sido insertado exitosamente");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertarCampo(String nombre) {
		try {
			String resource = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			Campo campo = new Campo();
			campo.setNombreCampo(nombre);
			sqlMap.insert("insertCampo", campo);
			JOptionPane.showMessageDialog(null, "El campo ha sido insertado exitosamente");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertarReserva(Integer idCampo, Integer idDeporte, String dia, String fechaInicio, String fechaFin) {
		try {
			String resource = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			Reserva reserva = new Reserva();
			reserva.setIdDeporte(idDeporte);
			reserva.setIdCampo(idCampo);
			reserva.setDia(dia);
			reserva.setFechaInicio(fechaInicio);
			reserva.setFechaFin(fechaFin);
			sqlMap.insert("insertReserva", reserva);
			JOptionPane.showMessageDialog(null, "La reserva ha sido insertada exitosamente");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void modificarDeporte(Integer id, String nombre) {
		try {
			String resource = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			Deporte deporteModif = (Deporte) sqlMap.queryForObject("getDeporte", id);
			deporteModif.setNombreDeporte(nombre);
			sqlMap.update("updateDeporte", deporteModif);
			JOptionPane.showMessageDialog(null, "El deporte ha sido modificado exitosamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modificarCampo(Integer id, String nombre) {
		try {
			String resource = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			Campo campoModif = (Campo) sqlMap.queryForObject("getCampo", id);
			campoModif.setNombreCampo(nombre);
			sqlMap.update("updateCampo", campoModif);
			JOptionPane.showMessageDialog(null, "El campo ha sido modificado exitosamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void eliminarDeporte(Integer id) {
		try {
			String resource = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			sqlMap.delete("removeDeporte", id);
			JOptionPane.showMessageDialog(null, "El deporte ha sido eliminado exitosamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void eliminarCampo(Integer id) {
		try {
			String resource = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			sqlMap.delete("removeCampo", id);
			JOptionPane.showMessageDialog(null, "El campo ha sido eliminado exitosamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void eliminarReserva(Integer id) {
		try {
			String resource = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			sqlMap.delete("removeReserva", id);
			JOptionPane.showMessageDialog(null, "La reserva ha sido eliminada exitosamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listarCampo(Integer id) {
		try {
			String resource = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			Campo campo = (Campo) sqlMap.queryForObject("getCampo", id);
			JOptionPane.showMessageDialog(null, campo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listarCampos() {
		try {
			String resource = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			List<Campo> campos = sqlMap.queryForList("getCampos", null);
			String lista = "";
			for (Campo c : campos) {
				lista += c + "\n";
			}
			JOptionPane.showMessageDialog(null, lista);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listarDeporte(Integer id) {
		try {
			String resource = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			Deporte deporte = (Deporte) sqlMap.queryForObject("getDeporte", id);
			JOptionPane.showMessageDialog(null, deporte);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listarDeportes() {
		try {
			String resource = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			List<Deporte> deportes = sqlMap.queryForList("getDeportes", null);
			String lista = "";
			for (Deporte d : deportes) {
				lista += d + "\n";
			}
			JOptionPane.showMessageDialog(null, lista);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listarReserva(Integer id) {
		try {
			String resource = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			Reserva reserva = (Reserva) sqlMap.queryForObject("getReserva", id);
			JOptionPane.showMessageDialog(null, reserva);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listarReservas() {
		try {
			String resource = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			List<Reserva> reservas = sqlMap.queryForList("getReservas", null);
			String lista = "";
			for (Reserva r : reservas) {
				lista += r + "\n";
			}
			JOptionPane.showMessageDialog(null, lista);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// try {
		// String resource = "ConfiguracionIbatis.xml";
		// Reader reader = Resources.getResourceAsReader(resource);
		// SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
		//
		// // INSERTAR
		// // Insertar un deporte nuevo. No ponemos id porque se genera solo en la
		// // inserción.
		// Deporte deporte = new Deporte();
		// deporte.setNombreDeporte("Fútbol");
		// Deporte deporte1 = new Deporte();
		// deporte.setNombreDeporte("Tenis");
		// sqlMap.insert("insertDeporte", deporte);
		//
		// // Insertar un campo nuevo. No ponemos id porque se genera solo en la
		// inserción.
		// Campo campo = new Campo();
		// campo.setNombreCampo("1");
		// sqlMap.insert("insertCampo", campo);
		//
		// // Insertar una reserva nueva. No ponemos id porque se genera solo en la
		// // inserción.
		// Reserva reserva = new Reserva();
		// reserva.setIdDeporte(5);
		// reserva.setIdCampo(2);
		// reserva.setDia("3");
		// reserva.setFechaInicio("9:00");
		// reserva.setFechaFin("10:00");
		// sqlMap.insert("insertReserva", reserva);
		//
		// // MODIFICAR
		// // Obtenemos un deporte.
		// Deporte deporteModif = (Deporte) sqlMap.queryForObject("getDeporte", 5);
		//
		// // Obtenemos un campo.
		// Campo campoModif = (Campo) sqlMap.queryForObject("getCampo", 3);
		//
		// // modificar un deporte
		// deporteModif.setNombreDeporte("Baloncesto");
		// sqlMap.update("updateDeporte", deporteModif);
		//
		// // modificar un campo
		// campoModif.setNombreCampo("10");
		// sqlMap.update("updateCampo", campoModif);
		//
		// // SELECT
		// Deporte deporte2 = (Deporte) sqlMap.queryForObject("getDeporte", 1);
		// Campo campo2 = (Campo) sqlMap.queryForObject("getCampo", 1);
		//
		// List<Deporte> deportes = sqlMap.queryForList("getDeportes", null);
		// for (Deporte c : deportes) {
		// System.out.println(c);
		// }
		// List<Campo> campos = sqlMap.queryForList("getCampos", null);
		// for (Campo c : campos) {
		// System.out.println(c);
		// }
		// List<Reserva> reservas = sqlMap.queryForList("getReservas", null);
		// for (Reserva r : reservas) {
		// System.out.println(r);
		// }
		//
		// // ELIMINAR
		// sqlMap.delete("removeDeporte", 2);
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		String id;
		String nombre;
		String fechaInicio;
		String fechaFin;
		String dia;
		String idCampo;
		String idDeporte;
		Main main = new Main();

		String[] opcionesMenu = { "Campo", "Reserva", "Deporte" };
		String[] opcionesCampo = { "Crear un campo", "Modificar un campo", "Eliminar un campo", "Listar campos" };
		String[] opcionesDeporte = { "Crear un deporte", "Modificar un deporte", "Eliminar un deporte",
				"Listar deportes" };
		String[] opcionesReserva = { "Crear una reserva", "Listar todas las reservas", "Eliminar una reserva" };

		int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción del menú", null,
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesMenu, opcionesMenu[0]);

		switch (opcion) {
		case 0:
			opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción del menú", null,
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesCampo, opcionesCampo[0]);
			switch (opcion) {
			case 0:
				nombre = JOptionPane.showInputDialog("Introduzca el nombre del campo");
				main.insertarCampo(nombre);
				break;

			case 1:
				id = JOptionPane.showInputDialog("Introduzca el id del campo a modificar");
				nombre = JOptionPane.showInputDialog("Introduzca el nombre del campo nuevo");
				main.modificarCampo(Integer.parseInt(id), nombre);
				break;

			case 2:
				id = JOptionPane.showInputDialog("Introduzca el id del campo a eliminar");
				main.eliminarCampo(Integer.parseInt(id));
				break;

			case 3:
				main.listarCampos();
				break;
			}
			break;

		case 1:

			opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción del menú", null,
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesReserva,
					opcionesReserva[0]);
			switch (opcion) {
			case 0:
				dia = JOptionPane.showInputDialog("Introduzca el dia de la reserva");
				fechaInicio = JOptionPane.showInputDialog("Introduzca la hora de inicio");
				fechaFin = JOptionPane.showInputDialog("Introduzca la hora de fin");
				idCampo = JOptionPane.showInputDialog("Introduzca el id del campo");
				idDeporte = JOptionPane.showInputDialog("Introduzca el id del deporte");
				main.insertarReserva(Integer.parseInt(idCampo), Integer.parseInt(idDeporte), dia, fechaInicio,
						fechaFin);
				break;

			case 1:
				main.listarReservas();
				break;

			case 2:
				id = JOptionPane.showInputDialog("Introduzca el id de la reserva a eliminar");
				main.eliminarReserva(Integer.parseInt(id));
				break;

			case 3:
				main.listarDeportes();
				break;
			}
			break;

		case 2:
			opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción del menú", null,
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesDeporte,
					opcionesDeporte[0]);
			switch (opcion) {
			case 0:
				nombre = JOptionPane.showInputDialog("Introduzca el nombre del deporte");
				main.insertarDeporte(nombre);
				break;

			case 1:
				id = JOptionPane.showInputDialog("Introduzca el id del deporte a modificar");
				nombre = JOptionPane.showInputDialog("Introduzca el nombre del deporte nuevo");
				main.modificarDeporte(Integer.parseInt(id), nombre);
				break;

			case 2:
				id = JOptionPane.showInputDialog("Introduzca el id del deporte a eliminar");
				main.eliminarDeporte(Integer.parseInt(id));
				break;

			case 3:
				main.listarDeportes();
				break;
			}
			break;

		}
	}

}
