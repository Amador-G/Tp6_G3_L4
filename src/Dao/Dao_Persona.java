package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Entidad.Persona;

public class Dao_Persona {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdPersonas";
	private Connection cn = null;
	private Statement st;
	
	
	public Dao_Persona(){}
	
	public int AgregarPersona(Persona persona)
	{
			int filas = 0;
			String query = "call sp_AgregarPersona('"+persona.getDni()+"','"+persona.getNombre()+"','"+persona.getApellido()+"')";
			cn = null;
			try 
			{
				cn = DriverManager.getConnection(host+dbName,user,pass);
				st = cn.createStatement();
				filas = st.executeUpdate(query);				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return filas;		
	}
	
    public int ModificarPersona(Persona persona)
	{
		int filas = 0;
		String query = "call sp_ModificarPersona('"+persona.getDni()+"','"+persona.getNombre()+"','"+persona.getApellido()+"')";
		try 
		{
			cn = DriverManager.getConnection(host+dbName,user,pass);
			st = cn.createStatement();
			filas = st.executeUpdate(query);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
	
	public int EliminarPersonas(Persona persona)
	{
		int filas = 0;
		String query = "call sp_EliminarPersona('"+persona.getDni()+"')";
	    cn = null;
		try 
		{
			cn = DriverManager.getConnection(host+dbName,user,pass);
			st = cn.createStatement();
			filas = st.executeUpdate(query);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;		
	}
	
	public Persona ObternerUsuario(String Dni) //devuelve un objeto Persona cargado a partir de un dni
	{
		Persona p = new Persona();
		try
		{
			cn = DriverManager.getConnection(host+dbName,user,pass);
			st = cn.createStatement();
			String query = "select * from personas where Dni = "+Dni;
			ResultSet rs =  st.executeQuery(query);
			rs.next();
			p.setDni(rs.getString("Dni"));
			p.setNombre(rs.getString("Nombre"));
			p.setApellido(rs.getString("Apellido"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return p;
	}
	
	public ArrayList<Persona> TodoPersonas()//Devuelve toda la tabla persona
	{
		ArrayList<Persona> Lusuarios = new ArrayList<Persona>();
		try
		{
			cn = DriverManager.getConnection(host+dbName,user,pass);
			st = cn.createStatement();
			String query = "select * from personas";
			ResultSet rs =  st.executeQuery(query);
			while(rs.next())
			{
				Persona p = new Persona();
				p.setDni(rs.getString("Dni"));
				p.setNombre(rs.getString("Nombre"));
				p.setApellido(rs.getString("Apellido"));
				Lusuarios.add(p);				
			}			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return Lusuarios;		
	}
	
	public boolean ExistePersona(Persona persona)
	{
		boolean Existe = false;
		String query = "select * from personas where Dni = "+ persona.getDni().toString() +"";
	    cn = null;
		try 
		{
			cn = DriverManager.getConnection(host+dbName,user,pass);
			st = cn.createStatement();
			ResultSet rs =  st.executeQuery(query);
			if(rs.next()) {
				Existe = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Existe;
	}
}

