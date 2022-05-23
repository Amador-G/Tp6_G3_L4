package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Idao_Persona;
import Entidad.Persona;


public class Dao_Persona_impl implements Idao_Persona {
	
	private static final String insert = "call sp_AgregarPersona(?,?,?);";
	private static final String modify = "call sp_ModificarPersona(?,?,?);";
	private static final String delete = "call sp_EliminarPersona(?);";
	private static final String readall = "SELECT * FROM personas";

	@Override
	public boolean insert(Persona p) {
		PreparedStatement pst;
		Connection cn = Conexion.getConexion().getSQLConexion();
		boolean insertOk = false;
		try
		{
			pst = cn.prepareStatement(insert);
			pst.setString(1, p.getDni());
			pst.setString(2, p.getNombre());
			pst.setString(3, p.getApellido());
			if(pst.executeUpdate()>0)
			{
				cn.commit();
				cn.close();
				insertOk = true;
			}				
		}
		catch(Exception e)
		{
			e.printStackTrace();
			try
			{
				cn.rollback();
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		return insertOk;
	}

	@Override
	public boolean delete(Persona p) {
		
		PreparedStatement pst;
		Connection cn = Conexion.getConexion().getSQLConexion();
		boolean insertOk = false;
		try
		{
			pst = cn.prepareStatement(delete);
			pst.setString(1, p.getDni());
			if(pst.executeUpdate()>0)
			{
				cn.commit();
				cn.close();
				insertOk = true;
			}				
		}
		catch(Exception e)
		{
			e.printStackTrace();
			try
			{
				cn.rollback();
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		return insertOk;
	}
	
	@Override
	public boolean modify(Persona p) {
		
		PreparedStatement pst;
		Connection cn = Conexion.getConexion().getSQLConexion();
		boolean insertOk = false;
		try
		{
			pst = cn.prepareStatement(modify);
			pst.setString(1, p.getDni());
			pst.setString(2, p.getNombre());
			pst.setString(3, p.getApellido());
			if(pst.executeUpdate()>0)
			{
				cn.commit();
				cn.close();
				insertOk = true;
			}				
		}
		catch(Exception e)
		{
			e.printStackTrace();
			try
			{
				cn.rollback();
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		return insertOk;
	}	

	@Override
	public List<Persona> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; //la query se guarda aca
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getPersona(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}

	
	
	private Persona getPersona(ResultSet resultSet) throws SQLException
	{
		String Dni = resultSet.getString("Dni");
		String Nombre = resultSet.getString("Nombre");
		String Apellido = resultSet.getString("Apellido");
		return new Persona(Dni, Nombre, Apellido);
	}

}
