package logicapersistencia.accesoBD;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import logicapersistencia.valueObjects.VOConsulta;

public class AccesoBD{
	
	private String driver;
	private String username;
	private String pass;
	private String url;
	private String base;
	
	// Carga los datos desde el archivo de configuracion, conecta y desconecta al servidor de la BD
	
	public Connection conectarBD(){
		
		Connection con=null;
		try{
			Properties p=new Properties();		
			try{
				p.load(new FileInputStream("config/parametros.txt"));
			}catch(FileNotFoundException e){			
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}		
			driver=p.getProperty("driver");
			username=p.getProperty("usuario");
			pass=p.getProperty("password");
			url=p.getProperty("url");
			base=p.getProperty("bdatos");
			Class.forName(driver);
			con=DriverManager.getConnection(url + base, username, pass);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}	
		return con;
	}
	
	public void desconectarBD(Connection con){
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}