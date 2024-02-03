package dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import RepasoNM.LibreriaEditorEscritor.Hibernateconexion;
import hibernate.Editor;
import hibernate.EditorEscritor;
import hibernate.EditorEscritorId;
import hibernate.Escritor;

public class Service {
	private SessionFactory sf = Hibernateconexion.getSessionFactory();
	
	//este no lo añade
//	public void addEditorEscritor(String DNI, String editorial) {
//		Session session = sf.openSession();
//		Transaction tx1 = session.beginTransaction();
//		Escritor escritor = session.get(Escritor.class, DNI);
//		Editor editor = session.get(Editor.class, editorial);
//		var  escritores = editor.getEscritores();
//		
//
//		EditorEscritorId idAux = new EditorEscritorId();
//		idAux.setEditor(editor.getEditor());
//		idAux.setEscritor_dni((escritor.getDNI()));
//		
//		EditorEscritor nuevoEscritor = new EditorEscritor(editor,escritor,2024);
//		nuevoEscritor.setId(idAux);
//		escritores.add(nuevoEscritor);
//		session.persist(editor);
//		tx1.commit();
//		session.close();
//	}
//
//	public void addEscritorEditor(String DNI, String editorial) {
//		Session session = sf.openSession();
//		Transaction tx1 = session.beginTransaction();
//		Escritor escritor = session.get(Escritor.class, DNI);
//		Editor editor = session.get(Editor.class, editorial);
//		Set<EditorEscritor>  editoriales = escritor.getEditores();
//		EditorEscritorId idAux = new EditorEscritorId();
//		idAux.setEditor(editor.getEditor());
//		idAux.setEscritor_dni((escritor.getDNI()));
//		EditorEscritor nuevoEscritor = new EditorEscritor(editor,escritor,2023);
//		nuevoEscritor.setId(idAux);
//		editoriales.add(nuevoEscritor);
//		session.persist(escritor);
//		tx1.commit();
//		session.close();
//	}
	
	//funciona
	public void addEscritorEditorPrueba(String DNI, String editorial) {
		Session session = sf.openSession();
		Transaction tx1 = session.beginTransaction();
		Escritor escritor = session.get(Escritor.class, DNI);
		Editor editor = session.get(Editor.class, editorial);
		EditorEscritorId idAux = new EditorEscritorId();
		idAux.setEditor(editor.getEditor());
		idAux.setEscritor_dni((escritor.getDNI()));
		EditorEscritor nuevoEscritor = new EditorEscritor(editor,escritor,2024);	
		nuevoEscritor.setId(idAux);
		session.persist(nuevoEscritor);
		tx1.commit();
		session.close();
	}
	
	
	public void deleteEscritorEditor(String DNI, String editorial) {
		Session session = sf.openSession();
		Transaction tx1 = session.beginTransaction();
		Escritor escritor = session.get(Escritor.class, DNI);
		Editor editor = session.get(Editor.class, editorial);
		EditorEscritorId idEditorEscritor = new EditorEscritorId();
		idEditorEscritor.setEditor(editorial);
		idEditorEscritor.setEscritor_dni(DNI);
		EditorEscritor deleteEditorEscritor = session.get(EditorEscritor.class, idEditorEscritor);		
		session.remove(deleteEditorEscritor);
		tx1.commit();
		session.close();

	}
	
	public void getEditorEscritor(String DNI, String editorial) {
		Session session = sf.openSession();		
		Escritor escritor = session.get(Escritor.class, DNI);
		Editor editor = session.get(Editor.class, editorial);
		EditorEscritorId idEditorEscritor = new EditorEscritorId();
		idEditorEscritor.setEditor(editorial);
		idEditorEscritor.setEscritor_dni(DNI);
		EditorEscritor data = session.get(EditorEscritor.class, idEditorEscritor);
		System.out.println(data.getFecha_inicio());
		session.close();
	}
	
	
	public void updateEditorEscritor(String DNI, String editorial,int fecha) {
		Session session = sf.openSession();		
		Transaction tx1 = session.beginTransaction();
		Escritor escritor = session.get(Escritor.class, DNI);
		Editor editor = session.get(Editor.class, editorial);
		EditorEscritorId idEditorEscritor = new EditorEscritorId();
		idEditorEscritor.setEditor(editorial);
		idEditorEscritor.setEscritor_dni(DNI);
		EditorEscritor data = session.get(EditorEscritor.class, idEditorEscritor);
		data.setFecha_inicio(fecha);
		session.merge(data);
		tx1.commit();
		session.close();
	}
	
	public void updateEditorEscritorEditor(String DNI, String editorial,String nuevaEditorial) {
		Session session = sf.openSession();		
		Transaction tx1 = session.beginTransaction();
		Escritor escritor = session.get(Escritor.class, DNI);
		Editor editor = session.get(Editor.class, editorial);
		Editor editorCambio = session.get(Editor.class, nuevaEditorial);
		EditorEscritorId idEditorEscritor = new EditorEscritorId();
		idEditorEscritor.setEditor(editorial);
		idEditorEscritor.setEscritor_dni(DNI);
		EditorEscritor data = session.get(EditorEscritor.class, idEditorEscritor);
		data.setEditor(editorCambio);
		session.merge(data);
		tx1.commit();
		session.close();
	}
	
	
	public void contarTotalEscritoresPorEditorial() {
		Session session = sf.openSession();
		String hql = "SELECT e,count(es) FROM Editor e JOIN e.escritores es GROUP BY e.editor";
	    List<Object[]> resultados = session.createQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	    	Editor editor = (Editor) resultado[0];
	        long nif = (long) resultado[1];
	        System.out.println("editorial: " + editor.getEditor() + ", total escritores: " + nif);
	    }
		session.close();
	}
	
	
	public void contarTotalEscritoresPorEditorialEnConcreto(String editorial) {
		Session session = sf.openSession();
		String hql = "SELECT e,count(es) FROM Editor e JOIN e.escritores es where e.editor = :editor GROUP BY e.editor";
		Query<Object[]> query = session.createQuery(hql,Object[].class);
		query.setParameter("editor",editorial);
		List<Object[]> results = query.list();
	    for (Object[] resultado : results) {
	    	Editor e = (Editor) resultado[0];
	    	long nif = (long) resultado[1];
	        System.out.println("editorial: " + e.getEditor() + ", total escritores: " + nif);
	    }
		session.close();
	}
	
	
	public void contarTotalEditorialesPorEscritor() {
		Session session = sf.openSession();
		String hql = "SELECT e,count(es) FROM Escritor e JOIN e.editores es GROUP BY e.DNI";
	    List<Object[]> resultados = session.createQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	    	Escritor editor = (Escritor) resultado[0];
	        long nif = (long) resultado[1];
	        System.out.println("DNI escritor: " + editor.getDNI() + ", total escritores: " + nif);
	    }
		session.close();
	}
	
	
	public void contarTotalEditorialesPorEscritorSQL() {
		Session session = sf.openSession();
		String hql = "SELECT e.DNI,count(*) FROM Escritor e  INNER JOIN editor_escritor ee ON ee.escritor_dni= e.DNI GROUP BY e.DNI";
	    List<Object[]> resultados = session.createNativeQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	    	String dni = (String) resultado[0];
	        long nif = (long) resultado[1];
	        System.out.println("DNI escritor: " + dni + ", total escritores: " + nif);
	    }
		session.close();
	}
	
	
	public void contarTotalEscritoresPorEditorialSQL() {
		Session session = sf.openSession();
		String hql = "SELECT e.editor,count(*) FROM editor e INNER JOIN editor_escritor ee ON e.editor=ee.editor GROUP BY e.editor";
	    List<Object[]> resultados = session.createNativeQuery(hql, Object[].class).list();
	    for (Object[] resultado : resultados) {
	    	String editor = (String) resultado[0];
	        long nif = (long) resultado[1];
	        System.out.println("editorial: " + editor + ", total escritores: " + nif);
	    }
		session.close();
	}
	
	
	public void filtroPorAnoEditorial() {
		Session session = sf.openSession();
		String hql = "SELECT e.editor FROM editor e INNER JOIN editor_escritor ee ON e.editor=ee.editor WHERE ee.fecha_inicio > 2020 GROUP BY e.editor";
	    List<Object> resultados = session.createNativeQuery(hql, Object.class).list();
	    for (Object resultado : resultados) {
	        System.out.println("editorial: " + resultado);
	    }
		session.close();
	}

}
