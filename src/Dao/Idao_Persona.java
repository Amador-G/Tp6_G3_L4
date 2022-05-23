package Dao;

import java.util.List;
import Entidad.Persona;

public interface Idao_Persona {

	public boolean insert(Persona p);
	public boolean delete(Persona p);
	public boolean modify(Persona p);
	public List<Persona> readAll();	
}
