package Main;

import Dao.Dao_Persona;
import Entidad.Persona;

public class Principal {

	public static void main(String[] args) {
		Dao_Persona daoPersona = new Dao_Persona();
		Persona persona = new Persona();
		persona.setDni("121212576");
		 boolean filas = daoPersona.ExistePersona(persona);
		 if(filas) 
		 {
			 System.out.println("usurio existe");
		 }
		 else {
			 System.out.println("no existe");
		 }
		

	}

}
