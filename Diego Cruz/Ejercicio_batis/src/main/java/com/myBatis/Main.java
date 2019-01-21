package com.myBatis;

import java.io.Reader;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.ibatis.io.Resources;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class Main {

	public static void main(String[] args) {
		try {
			String resource = "ConfigurationIbatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			menu(sqlMap);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void menu(SqlMapClient sqlMap) {
		String opcion = "0";
		do {
			opcion = (String) JOptionPane
					.showInputDialog("Seleccione una opción:\n1.Campo\n2.Deporte\n3.Reserva\n4.Salir");
			if (opcion == null) {
				opcion = "4";
			}
			switch (opcion) {
			case "1":
				menuCampo(sqlMap);
				opcion = "4";
				break;
			case "2":
				try {
					menuDeporte(sqlMap);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				opcion = "4";
				break;
			case "3":
				menuReserva(sqlMap);
				opcion = "4";
				break;
			case "4":
				break;
			default:
				JOptionPane.showMessageDialog(null, "Esa opción no es correcta");
				break;
			}
		} while (!opcion.equals("4"));

	}

	private static void menuCampo(SqlMapClient sqlMap) {
		String opcion = "0";
		do {
			opcion = (String) JOptionPane
					.showInputDialog("Seleccione una opción:\n1.Insertar\n2.Cambiar\n3.Borrar\n4.Listar\n5.Salir");
			if (opcion == null) {
				opcion = "5";
			}
			switch (opcion) {
			case "1":
				try {
					String nombre = (String) JOptionPane.showInputDialog("Introduzca el nombre del campo");
					Campo campo = new Campo();
					campo.setNombre(nombre);
					sqlMap.insert("insertCampo", campo);
				} catch (Exception e) {
					e.printStackTrace();
				}
				menu(sqlMap);
				opcion = "5";
				break;
			case "2":
				try {
					String nombre = (String) JOptionPane.showInputDialog("Introduzca el nuevo nombre del campo");
					int id = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el id del campo"));
					Campo campoModif = (Campo) sqlMap.queryForObject("getCampo", id);
					campoModif.setNombre(nombre);
					sqlMap.update("updateCampo", campoModif);
				} catch (Exception e) {
					e.printStackTrace();
				}
				menu(sqlMap);
				opcion = "5";
				break;
			case "3":
				try {
					int id = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el id del campo a borrar"));
					sqlMap.delete("removeCampo", id);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Hay reservas de ese campo, no se puede borrar");
				}
				menu(sqlMap);
				opcion = "5";
				break;
			case "4":
				try {
					String opcion2 = (String) JOptionPane
							.showInputDialog("Seleccione una opción:\n1.Ver una\n2.Ver todas");
					if (opcion2 == null) {
						opcion2 = "3";
					}
					if (opcion2.equals("1")) {
						int id = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el id del campo"));
						Campo campoModif = (Campo) sqlMap.queryForObject("getCampo", id);
						JOptionPane.showMessageDialog(null, campoModif.toString());
					} else if (opcion2.equals("2")) {
						List<Campo> campos = sqlMap.queryForList("getCampos", null);
						String lista = "Lista de campos:\n";
						for (Campo c : campos) {
							lista += c + "\n";
						}
						JOptionPane.showMessageDialog(null, lista);
						if (opcion2.equals("3")) {
							break;
						}
					} else {
						JOptionPane.showMessageDialog(null, "Esa opción no es correcta");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				menu(sqlMap);
				opcion = "5";
				break;
			case "5":
				break;
			default:
				JOptionPane.showMessageDialog(null, "Esa opción no es correcta");
				break;
			}
		} while (!opcion.equals("5"));
	}

	private static void menuDeporte(SqlMapClient sqlMap) throws SQLException {
		String opcion = "0";
		do {
			opcion = (String) JOptionPane
					.showInputDialog("Seleccione una opción:\n1.Insertar\n2.Cambiar\n3.Borrar\n4.Listar\n5.Salir");
			if (opcion == null) {
				opcion = "5";
			}
			switch (opcion) {
			case "1":
				try {
					String nombre = (String) JOptionPane.showInputDialog("Introduzca el nombre del deporte");
					Deportes campo = new Deportes();
					campo.setNombre(nombre);
					sqlMap.insert("insertDeporte", campo);
				} catch (Exception e) {
					e.printStackTrace();
				}
				menu(sqlMap);
				opcion = "5";
				break;
			case "2":
				try {
					String nombre = (String) JOptionPane.showInputDialog("Introduzca el nuevo nombre del deporte");
					int id = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el id del deporte"));
					Deportes campoModif = (Deportes) sqlMap.queryForObject("getDeporte", id);
					campoModif.setNombre(nombre);
					sqlMap.update("updateDeporte", campoModif);
				} catch (Exception e) {
					e.printStackTrace();
				}
				menu(sqlMap);
				opcion = "5";
				break;
			case "3":
				try {
					int id = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el id del deporte a borrar"));
					sqlMap.delete("removeDeporte", id);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Hay reservas de ese deporte, no se puede borrar");
				}
				menu(sqlMap);
				opcion = "5";
				break;
			case "4":
				try {
					String opcion2 = (String) JOptionPane
							.showInputDialog("Seleccione una opción:\n1.Ver una\n2.Ver todas");
					if (opcion2 == null) {
						opcion2 = "3";
					}
					if (opcion2.equals("1")) {
						int id = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el id del deporte"));
						Deportes campoModif = (Deportes) sqlMap.queryForObject("getDeporte", id);
						JOptionPane.showMessageDialog(null, campoModif.toString());
					} else if (opcion2.equals("2")) {
						List<Deportes> campos = sqlMap.queryForList("getDeportes", null);
						String lista = "Lista de deportes:\n";
						for (Deportes c : campos) {
							lista += c + "\n";
						}
						JOptionPane.showMessageDialog(null, lista);

					} else if (opcion2.equals("3")) {
						break;
					} else {
						JOptionPane.showMessageDialog(null, "Esa opción no es correcta");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				menu(sqlMap);
				opcion = "5";
				break;
			case "5":
				break;
			default:
				JOptionPane.showMessageDialog(null, "Esa opción no es correcta");
				break;
			}
		} while (!opcion.equals("5"));
	}

	private static void menuReserva(SqlMapClient sqlMap) {
		String opcion = "0";
		do {
			opcion = (String) JOptionPane.showInputDialog("Seleccione una opción:\n1.Insertar\n2.Listar\n3.Salir");
			if (opcion == null) {
				opcion = "3";
			}
			switch (opcion) {
			case "1":
				try {
					Reserva reserva = new Reserva();
					reserva.setFecha(new Date());
					reserva.setHora_inicio((String) JOptionPane.showInputDialog("Seleccione la hora de inicio"));
					reserva.setHora_fin((String) JOptionPane.showInputDialog("Seleccione la hora de fin"));
					reserva.setId_campo(Integer.parseInt(JOptionPane.showInputDialog("Seleccione el id de campo")));
					reserva.setId_deporte(Integer.parseInt(JOptionPane.showInputDialog("Seleccione el id de deporte")));
					sqlMap.insert("insertReserva", reserva);
				} catch (Exception e) {
					e.printStackTrace();
				}
				menu(sqlMap);
				opcion = "3";
				break;
			case "2":
				try {
					String opcion2 = (String) JOptionPane
							.showInputDialog("Seleccione una opción:\n1.Ver una\n2.Ver todas");
					if (opcion2 == null) {
						opcion2 = "3";
					}
					if (opcion2.equals("1")) {
						int id = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el id de la reserva"));
						Reserva depMod = (Reserva) sqlMap.queryForObject("getReserva", id);
						JOptionPane.showMessageDialog(null, depMod.toString());
					} else if (opcion2.equals("2")) {
						String lista = "Lista de reservas:\n";
						List<Reserva> deportes = sqlMap.queryForList("getReservas", null);
						for (Reserva c : deportes) {
							lista += c.toString() + "\n";
						}
						JOptionPane.showMessageDialog(null, lista);
					} else if (opcion2.equals("3")) {
						break;
					} else {
						JOptionPane.showMessageDialog(null, "Esa opción no es correcta");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				menu(sqlMap);
				opcion = "3";
				break;
			case "3":
				break;
			default:
				JOptionPane.showMessageDialog(null, "Esa opción no es correcta");
				break;
			}
		} while (!opcion.equals("3"));
	}

}
