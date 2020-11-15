package servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class Proxy implements Subject{

    private static Proxy unica = null;
    public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    public HashMap<Integer, String> sesion = new HashMap<Integer,String>();
    private Facade fac = new Facade();

    public static Proxy crearUnicaInstancia() {
        if (unica == null) {
            unica = new Proxy();
        }
        return unica;
    }

    public float acceso(String correo, String password) {
        if(sesion.size()==0){
            sesion.put(2564823, "prueba");
        }

        int primo=0;
        Iterator<Usuario> tempo = usuarios.iterator();
        while (tempo.hasNext()) {
            Usuario i = tempo.next();
            if (i.getLogin().equals(correo) && i.getPassword().equals(password)) {
                primo = this.getPrime();
                sesion.put(primo, i.getLogin());
                fac.acceso(primo+"", i.getLogin());
            }
        }
        float r=primo;
        return (r/7);
    }

    public void ejecutarOperaciones(String operacion) {
        String[] a = operacion.split(",",2);
        float b = Float.parseFloat(a[0]);
        System.out.println(""+b);
        b=b*7;
        int c = (int)b;
        if(this.existe(c)){
            fac.ejecutarOperaciones(a[1]);
        }
    }

    private int getPrime() {
        Random rand = new Random(); 
        int n=0;
        do{
            do{
                n = rand.nextInt(10100) + 1;
            }while (!isPrime(n));
        }while(existe(n));
        return n;
    }

    private boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean existe(int key){
        if(sesion.get(key)==null){
            return false;
        }else{
            return true;
        }
    }

    public void cerrarSesion(float k) {
        k=k*7;
        int c = (int)k;
        if(this.existe(c)){
            sesion.remove(c);
            System.out.println("cerramos hp");
        }
    }

    public void addBiciUsuario(String correo, String clave){
        BiciUsuariouser e = new BiciUsuariouser(correo, clave);
        usuarios.add(e);
    }

    public void addEmpresaUsuario(String correo, String clave){
        EmpresaUser e = new EmpresaUser(correo, clave);
        usuarios.add(e);
    }

    public void addMoveloUsuario(String correo, String clave){
        MoveloUserAdapter e = new MoveloUserAdapter(correo,clave);
        usuarios.add(e);
    }

    public void eliminarUsuario(String correo){
        Iterator<Usuario> it = usuarios.iterator();

        while(it.hasNext()){
            Usuario user = it.next();
            if(user.getLogin().equals(correo)){
                it.remove();
                break;
            }
        }
    }

    public void modificarUsuario(String correo,String correonew,String clave){
        Iterator<Usuario> it = usuarios.iterator();
        while(it.hasNext()){
            Usuario user = it.next();
            if(user.getLogin().equals(correo)){
                user.setLogin(correonew);
                user.setPassword(clave);
            }
        }
    }
}
