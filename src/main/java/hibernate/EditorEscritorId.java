
package hibernate;

import java.io.Serializable;

public class EditorEscritorId implements Serializable{
	
	String editor;
	String escritor_dni;
	
	
	public EditorEscritorId() {
		
	}
	
	public EditorEscritorId(String editor, String escritor_dni) {
		this.editor = editor;
		this.escritor_dni = escritor_dni;
	}


	public String getEditor() {
		return editor;
	}
	
	
	public void setEditor(String editor) {
		this.editor = editor;
	}
	
	
	public String getEscritor_dni() {
		return escritor_dni;
	}
	
	
	public void setEscritor_dni(String escritor_dni) {
		this.escritor_dni = escritor_dni;
	}


	@Override
	public String toString() {
		return "EditorEscritorId [editor=" + editor + ", escritor_dni=" + escritor_dni +"]";
	}
	
	
	
	

}
