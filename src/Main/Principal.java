package Main;

import Dao.Dao_Persona;
import Entidad.Persona;

public class Principal {

	public static void main(String[] args) {
		Dao_Persona daoPersona = new Dao_Persona();
		Persona persona = new Persona("27123456","Federico","Gonzalez");
		 int filas = daoPersona.AgregarPersona(persona);
		 
		 if(filas ==1) 
		 {
			 System.out.println("usurio Agregado");
		 }
		 else {
			 System.out.println("no se agrero el usuario");
		 }
		

	}

}
