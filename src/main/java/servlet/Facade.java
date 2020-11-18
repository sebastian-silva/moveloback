package servlet;

import java.util.ArrayList;
import java.util.HashMap;

public class Facade implements Subject{

    private static Facade unica = null;
    private HashMap<Integer, String> sesion = new HashMap<Integer,String>();
    private ArrayList<Componente> registros = new ArrayList<Componente>();
    private ArrayList<ComponenteAlarma> seguridad = new ArrayList<ComponenteAlarma>();
    private int idsec=0;
    private int idal=0;

    public static Facade crearUnicaInstancia() {
        if (unica == null) {
            unica = new Facade();
        }
        return unica;
    }

    public float acceso(String correo, String password) {
        this.sesion.put(Integer.parseInt(correo), password);
        return 0;
    }

    public void cerrarSesion(int key,String login){
        this.sesion.remove(key);
    }

    public String ejecutarOperaciones(String operacion) {
        String r="";
        String[] separador = operacion.split(",");
        int n=0;
        if(separador[0].equals("agregarUsuario")){
            n=1;
        }
        if(separador[0].equals("policia")){
            n=2;
        }
        if(separador[0].equals("ambulancia")){
            n=3;
        }
        if(separador[0].equals("alarma")){
            n=4;
        }
        switch (n) {
            case 1:
                this.agregarBiciUsuario(separador[1], separador[2], separador[3], separador[4], separador[5], separador[6], separador[7], separador[8]);
                System.out.println(((BiciUsuario)registros.get(registros.size()-1)).mostrarInformacion());
                r=((BiciUsuario)registros.get(registros.size()-1)).getCorreo()+" "+((BiciUsuario)registros.get(registros.size()-1)).getPassword();
                break;
            case 2:
                this.addPolicia(separador[1], separador[2], separador[3]);
                r="";
                break;
            case 3:
                this.addHospital(separador[1], separador[2], separador[3]);
                r="";
                break;
            case 4:
                if(separador[1].equals("policia")){
                    this.alarmaPolicia(Double.parseDouble(separador[2]),Double.parseDouble(separador[3]),separador[4]);
                }else{
                    this.alarmaPolicia(Double.parseDouble(separador[2]),Double.parseDouble(separador[3]),separador[4]);
                }
                r="";
                break;
            default:
                r="";
        }
        return r;
    }

    public void agregarBiciUsuario(String nombre, String apellido, String documento, String fecha, String telefono, String direccion, String correo, String password) {
        int id=0;
        if(registros.size()==0){
            id=0;
        }else{
            Componente prov = registros.get(registros.size()-1);
            id = ((BiciUsuario) prov).getId()+1;
        }
        BiciUsuario nuevo = new BiciUsuario(id,nombre,apellido,documento,fecha,direccion,telefono,correo,password);
        registros.add(nuevo);
        Proxy p = Proxy.crearUnicaInstancia();
        p.addBiciUsuario(nuevo.getCorreo(), nuevo.getPassword());
        
    }

    public void addPolicia(String cuadrante,String correo, String clave) {
        idsec=idsec+1;
        Policia tombo = new Policia(idsec, cuadrante, correo, clave);
        seguridad.add(tombo);
        Proxy p = Proxy.crearUnicaInstancia();
        p.addPolicia(correo, clave);
        System.out.println("Policia");
    }

    public void addHospital(String cuadrante,String correo, String clave) {
        idsec=idsec+1;
        Hospital tombo = new Hospital(idsec, cuadrante, correo, clave);
        seguridad.add(tombo);
        Proxy p = Proxy.crearUnicaInstancia();
        p.addHospital(correo, clave);
        System.out.println("Hospital");
    }

    public void alarmaPolicia(double latitud, double longitud, String correo){
        this.idal+=1;
        Punto ubicacion = new Punto(latitud, longitud);
        BiciUsuario bc = null;
        for (int i = 0; i < registros.size(); i++) {
            if(((BiciUsuario) registros.get(i)).getCorreo().equals(correo)){
                bc = ((BiciUsuario) registros.get(i));
            }
        }
        Alarma a = new Alarma(this.idal, ubicacion, bc, true);
        ((Policia) seguridad.get(0)).add(a);
    }

    public void alarmaHospital(double latitud, double longitud, String correo){
        this.idal+=1;
        Punto ubicacion = new Punto(latitud, longitud);
        BiciUsuario bc = null;
        for (int i = 0; i < registros.size(); i++) {
            if(((BiciUsuario) registros.get(i)).getCorreo().equals(correo)){
                bc = ((BiciUsuario) registros.get(i));
            }
        }
        Alarma a = new Alarma(this.idal, ubicacion, bc, true);
        ((Hospital) seguridad.get(0)).add(a);
        // ((Hospital) seguridad.get(0)).mostrarInformacion()
        System.out.println(((Hospital) seguridad.get(0)).mostrarInformacion());
    }
}
