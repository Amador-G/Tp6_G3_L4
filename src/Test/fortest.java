package Test;

import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.JList;

import DaoImpl.Dao_Persona_impl;
import Entidad.Persona;

public class fortest {
	public static void main(String[] args) {
			
		Persona p = new Persona("453333333","Nombre_ok","Ape_test");
		Persona p1 = new Persona("23333333","Nombre2_ok","Ape2_test");
		Persona p3 = new Persona();
		Dao_Persona_impl pdimpl = new Dao_Persona_impl();
		ArrayList<Persona> lista = new ArrayList<Persona>();
		pdimpl.insert(p);
		pdimpl.insert(p1);
		
		lista = (ArrayList<Persona>) pdimpl.readAll();
		
		ListIterator<Persona> lt = lista.listIterator();
		while (lt.hasNext()) {
			 p3 = lt.next();
			System.out.println(p3.toString());
						
		}									
	}
}
