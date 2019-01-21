package MyBatis.mybatis;

import java.io.Reader;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
    	try {
    		String resource = "ConfiguracionIbatis.xml";
    		Reader reader = Resources.getResourceAsReader(resource);
    		SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
    		
    		
    		  
            boolean salir = false;
    	       int opcion; 
    	        
    	       while(!salir){
    	            
    	           System.out.println("1. Insertar Campo");
    	           System.out.println("2. Actualizar Campo");
    	           System.out.println("3. Eliminar Campo");
    	           System.out.println("4. Insertar Tipo Deporte");
    	           System.out.println("5. Actualizar Tipo Deporte");
    	           System.out.println("6. Eliminar Tipo Deporte");
    	           System.out.println("7. Insertar Reserva");
    	           System.out.println("8. Consultar Reserva");
    	           System.out.println("9. Salir");
    	            
    	           System.out.println("Escribe una de las opciones");
    	           opcion = sc.nextInt();
    	            
    	           switch(opcion){
    	               case 1:
     	                   System.out.println("Introduce el nombre Campo");
     	                   String nombreCampo = sc.next();
     	                   
     	                   Campo camp = new Campo();
     	                   camp.setNombre(nombreCampo);
     	                   
     	                  sqlMap.insert("insertCampo",camp);
    	                   break;
    	                case 2:
    	                	System.out.println("Introduce el id Campo");
    	                    int idCampoUpdate = sc.nextInt();
    	                    
      	                   System.out.println("Introduce el nombre Campo");
      	                   String nombreCampoUpdate = sc.next();

    	                    Integer idCampo = new Integer(idCampoUpdate);
    	                    Campo campoUpdate = (Campo) sqlMap.queryForObject("getCampo",idCampo);
    	                   
    	                    campoUpdate.setNombre(nombreCampoUpdate);
    	             	   
    	             	    sqlMap.update("updateCampo",campoUpdate);
    	             	   
    	             	   
    	                	
    	            	   break;
    	                case 3:
    	                	System.out.println("Introduce el id Campo");
    	                    int idCampoRemove = sc.nextInt();
    	                    
    	                    
    	                    	int deleteCampo = sqlMap.delete("removeCampo",idCampoRemove);
    	                    	
    	                    	if(deleteCampo > 0)
    	                    	{
    	                    		System.out.println("Borrador correctamente");  
    	                    	}
    	                    	else
    	                    	{
    	                    		System.out.println("No existe el campo para borrarlo");  
    	                    	}
    	                    	      
    	                    
    	                   break;
    	                case 4:
       	                   System.out.println("Introduce el nombre tipo deporte");
       	                   String nombreTipoDeporte = sc.next();
       	                   
       	                   Tipo_deporte td = new Tipo_deporte();
       	                   td.setNombre(nombreTipoDeporte);
       	                   
       	                  sqlMap.insert("insertTipoDeporte",td);
							break;
    	                case 5:
    	                	System.out.println("Introduce el id Tipo Deporte");
    	                    int idTipoDeporteUpdate = sc.nextInt();
    	                    
      	                   System.out.println("Introduce el nombre Tipo Deporte");
      	                   String nombreTipoDeporteUpdate = sc.next();

    	                    Integer idTipoDeporte = new Integer(idTipoDeporteUpdate);
    	                    Tipo_deporte tipoDeporteUpdate = (Tipo_deporte) sqlMap.queryForObject("getTipoDeporte",idTipoDeporte);
    	                   
    	                    tipoDeporteUpdate.setNombre(nombreTipoDeporteUpdate);
    	             	   
    	             	   sqlMap.update("updateTipoDeporte",tipoDeporteUpdate);
							break;
    	                case 6:
    	                	System.out.println("Introduce el id Tipo Deporte");
    	                    int idTipoDeporteRemove = sc.nextInt();
    	                    
    	                    int deleteTipoDeporte = sqlMap.delete("removeTipoDeporte",idTipoDeporteRemove);
    	                    
	                    	if(deleteTipoDeporte > 0)
	                    	{
	                    		System.out.println("Borrador correctamente");  
	                    	}
	                    	else
	                    	{
	                    		System.out.println("No existe el tipo deporte para borrarlo");  
	                    	}

    	                   break;
    	                case 7:
    	                	
    	                    boolean salir2 = false;
    	         	        int opcion2; 
    	                	
    	         	       while(!salir2)
    	         	       {
    	         	    	  System.out.println("1. Mostrar Campos");
    	         	    	  System.out.println("2. Mostrar Tipo Deporte");
    	         	    	  System.out.println("3.  Insertar Reserva");
    	         	    	  System.out.println("4. Salir");
    	         	    	  
    	         	    	 System.out.println("Escribe una de las opciones");
    	      	             opcion2 = sc.nextInt();
    	      	             
    	      	             switch(opcion2)
    	      	             {
    	      	             case 1:
    	      	               List<Campo> campos = sqlMap.queryForList("getCampos");
    	      	               
    	      	               for(Campo c:campos)
    	      	               {
    	      	                 System.out.println("Id Campo: " + c.getId_campo() + "  Nombre Campo: " + c.getNombre());
    	      	              
    	      	               }
    	      	            	 break;
    	      	             case 2:
      	      	               List<Tipo_deporte> tdSelect = sqlMap.queryForList("getTipoDeportes");
    	      	               
      	      	               for(Tipo_deporte c:tdSelect)
      	      	               {
      	      	                 System.out.println("Id Tipo Deporte: " + c.getId_tipo() + "  Nombre Campo: " + c.getNombre());
      	      	              
      	      	               }    	      	            	 
    	      	            	 break;
    	      	             case 3:
    	      	            	   System.out.println("Introduce la hora de inicio");
    	     	                   Double hi = sc.nextDouble();
    	     	                   System.out.println("Introduce la hora fin");
    	     	                   Double hf = sc.nextDouble();
    	     	                   System.out.println("Introduce el id tipo de deporte");
    	     	                   int idep = sc.nextInt();
    	     	                   System.out.println("Introduce la id campo");
    	     	                   int idcamp = sc.nextInt();
    	     	                   
    	 	    	           		Reserva rs = new Reserva();
    	 	    	        		rs.setHora_inicio(hi);
    	 	    	        		rs.setHora_fin(hf);
    	 	    	        		rs.setDia(new Date());
    	 	    	        		rs.setId_tipo(idep);
    	 	    	        		rs.setId_campo(idcamp);
    	 	    	        		
    	 	    	        		sqlMap.insert("insertReserva",rs);    	      	            	 
    	      	            	 break;    	      	            	 
	    	                 case 4:
	     	                   salir2=true;
	     	                   break;
	     	                default:
	     	                   System.out.println("Solo números entre 1 y 4");    	      	            	 
    	      	             }
    	      	             
    	         	       }
							break;	
    	                case 8:
 	      	               List<Reserva> reservas = sqlMap.queryForList("getReservas");
	      	               
 	      	               for(Reserva r:reservas)
 	      	               {
 	      	                 System.out.println("Id Reserva: " + r.getIdReserva() + "  Hora Inicio: " + r.getHora_inicio() + " Hora fin:  " + r.getHora_fin() + " Día: " + r.getDia() + " Campo: " +r.getId_campo() + " Deporte: " + r.getId_campo());
 	      	              
 	      	               }
    	                	break;
    	                case 9:
    	                   salir=true;
    	                   break;
    	                default:
    	                   System.out.println("Solo números entre 1 y 9");
    	           }
    	            
    	       }
    		    		
              /* System.out.println("Introduce el id Reserva");
               int id4 = sc.nextInt();
               
               System.out.println("Introduce la hora de inicio");
               Double hi1 = sc.nextDouble();
               System.out.println("Introduce la hora fin");
               Double hf1 = sc.nextDouble();

               Integer idReserva = new Integer(id4);
               Reserva rsUpdate = (Reserva) sqlMap.queryForObject("getReserva",idReserva);
              
        	   rsUpdate.setHora_inicio(hi1);
        	   rsUpdate.setHora_fin(hf1);
        	   
        	   sqlMap.update("updateReserva",rsUpdate);*/

    		
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
