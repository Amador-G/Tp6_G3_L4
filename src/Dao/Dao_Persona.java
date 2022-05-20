package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import Entidad.Persona;

public class Dao_Persona {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "3f6A9wV5dr";
	private String dbName = "bdPersonas";
	
	
	public Dao_Persona(){}
	
	public int AgregarPersona(Persona persona) {
			int filas = 0;
			String query = "call sp_AgregarPersona('"+persona.getDni()+"','"+persona.getNombre()+"','"+persona.getApellido()+"')";
			Connection cn = null;
			try 
			{
				cn = DriverManager.getConnection(host+dbName,user,pass);
				Statement st = cn.createStatement();
				filas = st.executeUpdate(query);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return filas;			
	}
	
}
