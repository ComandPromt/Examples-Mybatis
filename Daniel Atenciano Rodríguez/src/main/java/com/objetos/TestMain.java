package com.objetos;

import java.io.Reader;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class TestMain {

	public static void main(String[] args) {
		/*
		 * ---------------------EJERCICIO DE PRUEBA--------------------------- try {
		 * String resource = "ConfiguracionIbatis.xml"; Reader reader =
		 * Resources.getResourceAsReader(resource); SqlMapClient sqlMap =
		 * SqlMapClientBuilder.buildSqlMapClient(reader);
		 * 
		 * // Insertar // Insertar Un coche nuevo. No ponemos id porque se genera solo
		 * en la inserción. Coche coche = new Coche(); coche.setMarca("Citroen");
		 * coche.setMatricula("1747KPB"); coche.setFechaMatricula(new Date());
		 * sqlMap.insert("insertCoche", coche);
		 * 
		 * // Ahora insertamos con Hashtable Hashtable hashCoche = new Hashtable();
		 * hashCoche.put("marca", "Seat"); hashCoche.put("matricula", "0747KJJ");
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
		 * // ELIMINAR sqlMap.delete("removeCoche", 4);
		 * 
		 * } catch (Exception ex) { ex.printStackTrace();
		 * 
		 * }
		 */

		try {
			String resource = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			Scanner s = new Scanner(System.in);
			int numero;
			do {
				System.out.println("---------------- MENU 1 ------------------------");
				System.out.println(" /MENÚ PARA CAMPOS/");
				System.out.print("Introduzca una opción del menú para Campos: \n");
				System.out.print(" 1. Insertar un campo: \n");
				System.out.print(" 2. Actualizar un campo: \n");
				System.out.print(" 3. Borrar un campo: \n");
				System.out.println("\n");
				System.out.println("---------------- MENU 2 ------------------------");
				System.out.println(" /MENÚ PARA TIPO DE DEPORTES/");
				System.out.print("Introduzca una opción del menú para Tipo de Deportes: \n");
				System.out.print(" 4. Insertar un tipo de deporte: \n");
				System.out.print(" 5. Actualizar un tipo de deporte: \n");
				System.out.print(" 6. Borrar un tipo de deporte: \n");
				System.out.print(" 0. Para Salir: \n");
				numero = s.nextInt();
				switch (numero) {
				case 1:
					Campo campo = new Campo();
					System.out.println("Introduzca una ID para campo:");
					campo.setId_Campo(s.nextInt());
					System.out.println("Introduzca un nombre para el campo:");
					campo.setNombre_Campo(s.next());
					sqlMap.insert("insertCampo", campo);
					System.out.println("Campo Insertado correctamente!!");
					break;
				case 2:
					Integer claveCampo = new Integer(2);
					Campo campoModif = (Campo) sqlMap.queryForObject("getCampo", claveCampo);
					campoModif.setNombre_Campo("nombre nuevo");
					sqlMap.update("updateCampo", campoModif);
					System.out.println("Campo Actualizado correctamente!! \n");
					break;
				case 3:
					System.out.println("Introduzca el ID para borrar el campo: ");
					sqlMap.delete("removeCampo", s.nextInt());
					System.out.println("Campo Borrado correctamente!! \n");
					break;
				// --- Tipo de deporte --
				case 4:
					TipoDeporte tipoDeporte = new TipoDeporte();
					System.out.println("Introduzca una ID para el tipo de Deporte:");
					tipoDeporte.setId_tipoDeporte(s.nextInt());
					System.out.println("Introduzca un nombre para el tipo de deporte:");
					tipoDeporte.setnombre_Deporte(s.next());
					sqlMap.insert("insertTipoDeporte", tipoDeporte);
					System.out.println("Tipo de Deporte Insertado correctamente!!");
					break;
				case 5:
					Integer claveDeporte = new Integer(1);
					TipoDeporte deporteModif = (TipoDeporte) sqlMap.queryForObject("getTipoDeporte", claveDeporte);
					deporteModif.setnombre_Deporte("baloncesto");
					sqlMap.update("updateTipoDeporte", deporteModif);
					System.out.println("Tipo de Deporte Actualizado correctamente!! \n");

					break;
				case 6:
					System.out.println("Introduzca el ID para borrar un tipo de deporte: ");
					sqlMap.delete("removeTipoDeporte", s.nextInt());
					System.out.println("Tipo de Deporte Borrado correctamente!! \n");
					break;

				default:
					System.out.println("Adios!");
					break;

				}
			} while (numero != 0);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}
}
