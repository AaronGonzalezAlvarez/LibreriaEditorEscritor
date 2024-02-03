package hibernate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Editor implements Serializable{
	
	String editor;
	String nivel;
	Set<EditorEscritor> escritores = new HashSet<EditorEscritor>(0);
	
	
	
	
	public Set<EditorEscritor> getEscritores() {
		return escritores;
	}
	public void setEscritores(Set<EditorEscritor> escritores) {
		this.escritores = escritores;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	
	@Override
	public String toString() {
		return "Editor [editor=" + editor + ", nivel=" + nivel + ", escritores=" + escritores.size() + "]";
	}
	
}
