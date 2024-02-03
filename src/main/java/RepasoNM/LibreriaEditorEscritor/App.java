package RepasoNM.LibreriaEditorEscritor;

import dao.Service;
import hibernate.Editor;
import hibernate.EditorEscritor;
import hibernate.Escritor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
//        var sf=Hibernateconexion.getSessionFactory();   
//    	Editor editor = sf.openSession().get(Editor.class, "Editor1");
//    	System.out.println(editor);
//    	for(EditorEscritor x : editor.getEscritores()) {
//    		System.out.println("DNI: "+x.getEscritor().getDNI()+" Fecha inicio: "+x.getFecha_inicio() );
//    	}
//    	Escritor escritor = sf.openSession().get(Escritor.class, "3C");
//    	System.out.println(escritor);
    	
    	Service service = new Service();
    	
    	//esta no lo añade
    	//service.addEditorEscritor("A8", "Editor1");
    	//funciona
    	//service.addEscritorEditorPrueba("A8", "Editor1");
    	//no lo añade
    	//service.addEscritorEditor("A8", "Editor2");
    	
    	//obtener escritorEditor --funciona
    	//service.getEditorEscritor("3C", "Editor2");
    	
    	//borrar editorEscritor --funciona
    	//service.deleteEscritorEditor("3C", "Editor2");
    	
    	//update fecha_inicio  -funciona
    	//service.updateEditorEscritor("2B", "Editor3",2025);
    	
    	//update cambiar editor a otro -- no me deja hacer el update
    	//service.updateEditorEscritorEditor("2B", "Editor3","Editor1");
    	
//    	contarTotalEscritoresPorEditorial
    	//service.contarTotalEscritoresPorEditorial();
    	
    	//contarTotalEscritoresPorEditorialEnconcreto
    	//service.contarTotalEscritoresPorEditorialEnConcreto("Editor1");
    	
    	//contar total editoriales por escritor
    	//service.contarTotalEditorialesPorEscritor();
    	
    	//contar total editoriales por escritor SQL
    	//service.contarTotalEditorialesPorEscritorSQL();
    	
    	//contarTotalEscritoresPorEditorial SQL
    	//service.contarTotalEscritoresPorEditorialSQL();
    	
    	//filtro por año en SQL
    	service.filtroPorAnoEditorial();
    	
    }
}
