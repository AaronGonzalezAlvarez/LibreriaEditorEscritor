package hibernate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Escritor implements Serializable{
	
	String DNI;
	String Nombre;
	Set<EditorEscritor> editores = new HashSet<EditorEscritor>(0);
	
	
	
	
	public Set<EditorEscritor> getEditores() {
		return editores;
	}


	public void setEditores(Set<EditorEscritor> editores) {
		this.editores = editores;
	}


	public String getDNI() {
		return DNI;
	}
	
	
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	
	
	public String getNombre() {
		return Nombre;
	}
	
	
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	@Override
	public String toString() {
		return "Escritor [DNI=" + DNI + ", Nombre=" + Nombre + ", editores=" + editores.size() + "]";
	}
}
