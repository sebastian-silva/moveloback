package servlet;

import java.util.ArrayList;
import java.util.Iterator;

public class ContenedorAlarma implements ComponenteAlarma{
    private ArrayList<ComponenteAlarma> lista = new ArrayList<ComponenteAlarma>();

    public ContenedorAlarma(){}
    
    public String mostrarInformacion() {
        Iterator<ComponenteAlarma> it = lista.iterator();
        String a="";
        while(it.hasNext()){
            ComponenteAlarma i = it.next();
            a=a+"\n"+i.mostrarInformacion();
        }
        return a;
    }

    public void add(ComponenteAlarma a){
        lista.add(a);
    }

    public void eliminar(ComponenteAlarma a){
        lista.remove(a);
    }

    public int tamano(){
        return lista.size();
    }

    public ComponenteAlarma getChild(int index){
        return lista.get(index);
    }
}
