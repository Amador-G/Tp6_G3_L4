package Entidad;

import java.util.Objects;

public class Persona {
	private String Dni;
	private String Nombre;
	private String Apellido;
   
	public Persona(){}
	public Persona(String Dni,String Nombre,String Apellido){
		this.Dni = Dni;
		this.Nombre = Nombre;
		this.Apellido = Apellido;
	}
	public String getDni() {
		return Dni;
	}
	public void setDni(String dni) {
		Dni = dni;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Apellido, Dni, Nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(Apellido, other.Apellido) && Objects.equals(Dni, other.Dni)
				&& Objects.equals(Nombre, other.Nombre);
	}
	@Override
	public String toString() {
		return Dni + " - " + Nombre + " - " + Apellido;
	}
	
	
	
	
	
	
	
	
	
}