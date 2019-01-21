package ejemplo;

import java.io.Reader;
import java.util.List;

import javax.swing.JOptionPane;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class ReservasTest {

	public static void main(String[] args) {
		try {
			String resource = "Configuracion.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			// INSERTAR

			String[] options = { "Campo", "Deporte", "Reserva" };
			int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

			switch (seleccion) {
			case 0:
				String[] options2 = { "Insertar", "Eliminar", "Modificar" };
				int seleccion2 = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Campo",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);

				switch (seleccion2) {
				case 0:

					String nombre = JOptionPane.showInputDialog("Nombre de Campo");
					Campo campo = new Campo();
					campo.setNombreCampo(nombre);
					sqlMap.insert("insertCampo", campo);
					JOptionPane.showMessageDialog(null, "Campo Insertado!");
					break;

				case 1:

					List<Campo> campos = sqlMap.queryForList("getCampos", null);
					String lista = "";
					for (Campo c : campos) {
						lista += "ID: " + c.getIdCampo() + " NOMBRE: " + c.getNombreCampo()
								+ "\n--------------------------";
					}

					String id = JOptionPane.showInputDialog(null, lista);
					Integer idAux = Integer.parseInt(id);

					try {
						sqlMap.delete("removeCampo", idAux);
						JOptionPane.showMessageDialog(null, "Campo Eliminado!");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Error: Campo en uso");
					}

					break;

				case 2:
					String claveCampo = JOptionPane.showInputDialog(null, "Id del Campo a modificar");
					Campo campoModif = (Campo) sqlMap.queryForObject("getCampo", claveCampo);

					String nuevoNombre = JOptionPane.showInputDialog(null, "Nuevo Nombre");
					campoModif.setNombreCampo(nuevoNombre);
					sqlMap.update("updateCampo", campoModif);
					JOptionPane.showMessageDialog(null, "Campo Modificado!");

					break;

				}
				break;

			case 1:
				String[] options3 = { "Insertar", "Eliminar", "Modificar" };
				int seleccion3 = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Deporte",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options3, options3[0]);

				switch (seleccion3) {
				case 0:

					String nombre = JOptionPane.showInputDialog("Nombre de Deporte");
					TipoDeporte deporte = new TipoDeporte();
					deporte.setNombreDeporte(nombre);
					sqlMap.insert("insertTipoDeporte", deporte);
					JOptionPane.showMessageDialog(null, "Tipo de Deporte Insertado!");
					break;

				case 1:

					List<TipoDeporte> deportes = sqlMap.queryForList("getTiposDeportes", null);
					String lista = "";
					for (TipoDeporte t : deportes) {
						lista += "ID: " + t.getIdTipDeporte() + " NOMBRE: " + t.getNombreDeporte()
								+ "\n--------------------------";
					}

					String id = JOptionPane.showInputDialog(null, lista);
					Integer idAux = Integer.parseInt(id);

					try {
						sqlMap.delete("removeTipoDeporte", idAux);
						JOptionPane.showMessageDialog(null, "Tipo de Deporte Eliminado!");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Error: Deporte en uso");
					}
					break;

				case 2:
					String claveTipoDeporte = JOptionPane.showInputDialog(null, "Id del Tipo de Deporte a modificar");
					TipoDeporte tipoDeporteModif = (TipoDeporte) sqlMap.queryForObject("getTipoDeporte",
							claveTipoDeporte);

					String nuevoNombre = JOptionPane.showInputDialog(null, "Nuevo Nombre");
					tipoDeporteModif.setNombreDeporte(nuevoNombre);
					sqlMap.update("updateTipoDeporte", tipoDeporteModif);
					JOptionPane.showMessageDialog(null, "Tipo de Deporte Modificado!");

					break;
				}
				break;

			case 2:

				String[] options4 = { "Nueva Reserva", "Ver Reservas" };
				int seleccion4 = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Reserva",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options4, options4[0]);

				switch (seleccion4) {
				case 0:

					String horaInicio = JOptionPane.showInputDialog("Hora de Inicio");
					String horaFin = JOptionPane.showInputDialog("Hora de Fin");
					String dia = JOptionPane.showInputDialog("Día");

					List<Campo> campos = sqlMap.queryForList("getCampos", null);
					String lista = "";
					for (Campo c : campos) {
						lista += "ID: " + c.getIdCampo() + " NOMBRE: " + c.getNombreCampo()
								+ "\n--------------------------";
					}
					String campo = JOptionPane.showInputDialog(null, lista);
					Integer campoAux = Integer.parseInt(campo);

					List<TipoDeporte> deportes = sqlMap.queryForList("getTiposDeportes", null);
					String lista2 = "";
					for (TipoDeporte t : deportes) {
						lista2 += "ID: " + t.getIdTipDeporte() + " NOMBRE: " + t.getNombreDeporte()
								+ "\n--------------------------";
					}
					String tipoDeporte = JOptionPane.showInputDialog(null, lista2);
					Integer tipoDeporteAux = Integer.parseInt(tipoDeporte);

					Reserva reserva = new Reserva();
					reserva.setHoraInicio(horaInicio);
					reserva.setHoraFin(horaFin);
					reserva.setDia(dia);
					reserva.setIdCampo(campoAux);
					reserva.setIdTipDeporte(tipoDeporteAux);
					sqlMap.insert("insertReserva", reserva);
					JOptionPane.showMessageDialog(null, "Reserva Registrada!");
					break;

				case 1:
					List<Reserva> reservas = sqlMap.queryForList("getReservas", null);
					String lista3 = "";
					for (Reserva r : reservas) {
						lista3 += "Hora De Inicio: " + r.getHoraInicio() + "\nHora de Fin:" + r.getHoraFin() + "\nDía:"
								+ r.getDia() + "\nCampo:" + r.getIdCampo() + "\nDeporte:" + r.getIdTipDeporte()
								+ "\n--------------------------\n";
					}
					JOptionPane.showMessageDialog(null, lista3);
					break;
				}

				break;
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}

	}
}
