package MyBatis.mybatis;

import java.io.Reader;
import java.util.Date;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;


public class App 
{
    public static void main( String[] args )
    {
        
    	try {
    		String resource = "ConfiguracionIbatis.xml";
    		Reader reader = Resources.getResourceAsReader(resource);
    		SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
    		
    		
    		//Insertar
    		
    		Coche coche = new Coche();
    		coche.setMarca("Honda");
    		coche.setMatricula("3060DWC");
    		coche.setFechaMatricula(new Date());
    		sqlMap.insert("insertCoche",coche);
    		
    		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    	
    	
    }
}
