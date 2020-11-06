package servlet;

import java.util.ArrayList;
import java.util.Iterator;

public class Contenedor implements Componente{
    private ArrayList<Componente> lista = new ArrayList<Componente>();

    public Contenedor(){}
    
    public String mostrarInformacion() {
        Iterator<Componente> it = lista.iterator();
        String a="";
        while(it.hasNext()){
            Componente i = it.next();
            a=a+"\n"+i.mostrarInformacion();
        }
        return a;
    }

    public void add(Componente a){
        lista.add(a);
    }

    public void eliminar(Componente a){
        lista.remove(a);
    }

    public int tamano(){
        return lista.size();
    }

    public Componente getChild(int index){
        return lista.get(index);
    }
}
