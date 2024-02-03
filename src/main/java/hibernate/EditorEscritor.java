package hibernate;

import java.io.Serializable;

public class EditorEscritor implements Serializable{
	
	EditorEscritorId id;
	Editor editor;
	Escritor escritor;
	int fecha_inicio;
	
	
	public EditorEscritor() {
    }
	
	public EditorEscritor(Editor editor, Escritor escritor, int fecha_inicio) {
		this.editor = editor;
		this.escritor = escritor;
		this.fecha_inicio = fecha_inicio;
	}
	
	public EditorEscritor(EditorEscritorId id) {
		this.id = id;
	}


	public EditorEscritorId getId() {
		return id;
	}
	
	
	public void setId(EditorEscritorId id) {
		this.id = id;
	}
	
	
	public Editor getEditor() {
		return editor;
	}
	
	
	public void setEditor(Editor editor) {
		this.editor = editor;
	}
	
	
	public Escritor getEscritor() {
		return escritor;
	}
	
	
	public void setEscritor(Escritor escritor) {
		this.escritor = escritor;
	}

	public int getFecha_inicio() {
		return fecha_inicio;
	}


	public void setFecha_inicio(int fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}


	@Override
	public String toString() {
		return "EditorEscritor [id=" + id + ", editor=" + editor + ", escritor=" + escritor + ", fecha_inicio="
				+ fecha_inicio + "]";
	}
	
	

}
