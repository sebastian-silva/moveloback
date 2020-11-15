package servlet;

import java.util.ArrayList;
import java.util.HashMap;

public class Facade implements Subject{

    private static Facade unica = null;
    private HashMap<Integer, String> sesion = new HashMap<Integer,String>();
    private ArrayList<Componente> registros = new ArrayList<Componente>();

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

    public void ejecutarOperaciones(String operacion) {
        System.out.println("Funciona");
        String[] separador = operacion.split(",");

        switch (separador[0]) {
            case "agregarUsuario":
                this.agregarBiciUsuario(separador[1], separador[2], separador[3], separador[4], separador[5], separador[6], separador[7], separador[8]);
                System.out.println(((BiciUsuario)registros.get(registros.size()-1)).toString());
                break;
            case "agregarEmpresa":
                break;
            default:
        }
        // Proxy np = Proxy.crearUnicaInstancia();
        // np.sesion.size();
        // System.out.println(np.sesion.size());
    }

    public void agregarBiciUsuario(String nombre, String apellido, String documento, String fecha, String telefono, String direccion, String correo, String password) {
        Componente prov = registros.get(registros.size()-1);
        int Id = ((BiciUsuario) prov).getId();

        BiciUsuario nuevo = new BiciUsuario(Id,nombre,apellido,documento,fecha,telefono,direccion,correo,password);
        registros.add(nuevo);
        Proxy p = Proxy.crearUnicaInstancia();
        p.addBiciUsuario(nuevo.getCorreo(), nuevo.getPassword());
    }

    /*public void agregarBicicleta(int id,int serial,String marca,String modelo) {
        boolean found=false;
        for(Componente cmp : registros){
            if(cmp instanceof BiciUsuario){
                if (((BiciUsuario) cmp).getId()==id) {
                    Bicicleta bike = new Bicicleta(serial,marca,modelo);
                    ((BiciUsuario) cmp).add(bike);
                    found=true;
                    break;
                }
            }else if(cmp instanceof Empresa){
                if(((Empresa) cmp).tamano()!=0){
                    for (int i = 0; i < ((Empresa) cmp).tamano(); i++) {
                        Componente n = ((Empresa) cmp).getChild(i);
                        if(n instanceof BiciUsuario){
                            if(((BiciUsuario) n).getId()==id){
                                Bicicleta bike = new Bicicleta(serial,marca,modelo);
                                ((BiciUsuario) n).add(bike);  
                                found=true;
                            }
                        }
                    }
                }
            }
        }
    }

    // public void agregarEmpresa(int nit, String nombre, String direccion, String correo, String password){
    //     Empresa nuevo = new Empresa(nit,nombre,direccion,correo,password);
    //     registros.add(nuevo);
    //     Proxy p = Proxy.crearUnicaInstancia();
    //     p.addEmpresaUsuario(nuevo.getCorreo(), nuevo.getPassword());
    // }

    public void agregarEmpleado(int id, int nit){
        String nombre="";
        String apellido="";
        int documento=0;
        String fecha="";
        String telefono="";
        String direccion="";
        String correo="";
        String password="";
        for(Componente cmp : registros){
            if(cmp instanceof BiciUsuario){
                if (((BiciUsuario) cmp).getId()==id){
                    nombre=((BiciUsuario) cmp).getNombre();
                    apellido=((BiciUsuario) cmp).getApellido();
                    documento=((BiciUsuario) cmp).getDocumento();
                    fecha=((BiciUsuario) cmp).getFecha();
                    telefono=((BiciUsuario) cmp).getTelefono();
                    direccion=((BiciUsuario) cmp).getDireccion();
                    correo=((BiciUsuario) cmp).getCorreo();
                    password=((BiciUsuario) cmp).getPassword();
                    registros.remove(cmp);
                }
            }
        }
        for(Componente cmp : registros){
            if(cmp instanceof Empresa){
                if(((Empresa) cmp).getNit()==nit){
                    ((Empresa) cmp).add(new BiciUsuario(id,nombre,apellido,documento,fecha,telefono,direccion,correo,password));            
                }
            }
        }
    }

    public void agregarMovelo(int nit, String nombre, String direccion, String correo, String password){
        Movelo nuevo = new Movelo(nit,nombre,direccion,correo,password);
        registros.add(nuevo);
        Proxy p = Proxy.crearUnicaInstancia();
        p.addMoveloUsuario(nuevo.getEmail(), nuevo.getClave());
    }

    public void modificarBiciusuario(int id,int idb,String nombre, String apellido, int documento, String fecha, String telefono, String direccion, String correo, String password){
        for(Componente cmp : registros){
            if(cmp instanceof BiciUsuario){
                if (((BiciUsuario) cmp).getId()==id){
                    ((BiciUsuario) cmp).setId(idb);
                    ((BiciUsuario) cmp).setNombre(nombre);
                    ((BiciUsuario) cmp).setApellido(apellido);
                    ((BiciUsuario) cmp).setDocumento(documento);
                    ((BiciUsuario) cmp).setFecha(fecha);
                    ((BiciUsuario) cmp).setTelefono(telefono);
                    ((BiciUsuario) cmp).setDireccion(direccion);
                    ((BiciUsuario) cmp).setCorreo(correo);
                    ((BiciUsuario) cmp).setPassword(password);
                }
            }else if(cmp instanceof Empresa){
                if(((Empresa) cmp).tamano()!=0){
                    for (int i = 0; i < ((Empresa) cmp).tamano(); i++) {
                        Componente n = ((Empresa) cmp).getChild(i);
                        if(n instanceof BiciUsuario){
                            if(((BiciUsuario) n).getId()==id){
                                ((BiciUsuario) n).setId(idb);
                                ((BiciUsuario) n).setNombre(nombre);
                                ((BiciUsuario) n).setApellido(apellido);
                                ((BiciUsuario) n).setDocumento(documento);
                                ((BiciUsuario) n).setFecha(fecha);
                                ((BiciUsuario) n).setTelefono(telefono);
                                ((BiciUsuario) n).setDireccion(direccion);
                                ((BiciUsuario) n).setCorreo(correo);
                                ((BiciUsuario) n).setPassword(password);
                            }
                        }
                    }
                }
            }
        }
    }

    public void modificarEmpresa(int nit,int nitb, String nombre, String direccion, String correo, String password){
        for(Componente cmp : registros){
            if(cmp instanceof Empresa){
                if(((Empresa) cmp).getNit()==nit){
                    ((Empresa) cmp).setNit(nitb);
                    ((Empresa) cmp).setNombre(nombre);
                    ((Empresa) cmp).setDireccion(direccion);
                    ((Empresa) cmp).setCorreo(correo);
                    ((Empresa) cmp).setPassword(password);
                }
            }
        }
    }

    public void modificarMovelo(int nit,int nitb, String nombre, String direccion, String correo, String password){
        for(Componente cmp : registros){
            if(cmp instanceof Movelo){
                if(((Movelo) cmp).getNit()==nit){
                    ((Movelo) cmp).setNit(nitb);
                    ((Movelo) cmp).setNombre(nombre);
                    ((Movelo) cmp).setDireccion(direccion);
                    ((Movelo) cmp).setEmail(correo);
                    ((Movelo) cmp).setClave(password);
                }
            }
        }
    }

    public void modificarBicicleta(int serial,int serialb,String marca,String modelo){
        for(Componente cmp : registros){
            if(cmp instanceof BiciUsuario){
                if(((BiciUsuario) cmp).tamano()!=0){
                    for (int i = 0; i < ((BiciUsuario) cmp).tamano(); i++) {
                        Componente n = ((BiciUsuario) cmp).getChild(i);
                        if(n instanceof Bicicleta){
                            if(((Bicicleta) n).getSerial()==serial){
                                ((Bicicleta) n).setSerial(serialb);
                                ((Bicicleta) n).setMarca(marca);
                                ((Bicicleta) n).setModelo(modelo);
                            }
                        }
                    }
                }
            }else if(cmp instanceof Empresa){
                if(((Empresa) cmp).tamano()!=0){
                    for (int i = 0; i < ((Empresa) cmp).tamano(); i++) {
                        Componente n = ((Empresa) cmp).getChild(i);
                        if(n instanceof BiciUsuario){
                            if(((BiciUsuario) n).tamano()!=0){
                                for (int j = 0; j < ((BiciUsuario) n).tamano(); j++) {
                                    Componente m = ((BiciUsuario) cmp).getChild(j);
                                    if(m instanceof Bicicleta){
                                        if(((Bicicleta) m).getSerial()==serial){
                                            ((Bicicleta) m).setSerial(serialb);
                                            ((Bicicleta) m).setMarca(marca);
                                            ((Bicicleta) m).setModelo(modelo);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void eliminarBicicleta(int serial){
        for(Componente cmp : registros){
            if(cmp instanceof BiciUsuario){
                if(((BiciUsuario) cmp).tamano()!=0){
                    for (int i = 0; i < ((BiciUsuario) cmp).tamano(); i++) {
                        Componente n = ((BiciUsuario) cmp).getChild(i);
                        if(n instanceof Bicicleta){
                            if(((Bicicleta) n).getSerial()==serial){
                                registros.remove(((Bicicleta) n));
                            }
                        }
                    }
                }
            }else if(cmp instanceof Empresa){
                if(((Empresa) cmp).tamano()!=0){
                    for (int i = 0; i < ((Empresa) cmp).tamano(); i++) {
                        Componente n = ((Empresa) cmp).getChild(i);
                        if(n instanceof BiciUsuario){
                            if(((BiciUsuario) n).tamano()!=0){
                                for (int j = 0; j < ((BiciUsuario) n).tamano(); j++) {
                                    Componente m = ((BiciUsuario) cmp).getChild(j);
                                    if(m instanceof Bicicleta){
                                        if(((Bicicleta) m).getSerial()==serial){
                                            registros.remove(((Bicicleta) n));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void eliminarEmpresa(int nit){
        for(Componente cmp : registros){
            if(cmp instanceof Empresa){
                if(((Empresa) cmp).getNit()==nit){
                    registros.remove(((Empresa) cmp));
                }
            }
        }
    }

    public void eliminarMovelo(int nit){
        for(Componente cmp : registros){
            if(cmp instanceof Movelo){
                if(((Movelo) cmp).getNit()==nit){
                    registros.remove(((Movelo) cmp));
                }
            }
        }
    }

    public void eliminarBiciusuario(int id){
        for(Componente cmp : registros){
            if(cmp instanceof BiciUsuario){
                if(((BiciUsuario) cmp).getId()==id){       
                    registros.remove(((BiciUsuario) cmp));
                }
            }else if(cmp instanceof Empresa){
                if(((Empresa) cmp).tamano()!=0){
                    for (int i = 0; i < ((Empresa) cmp).tamano(); i++) {
                        Componente n = ((Empresa) cmp).getChild(i);
                        if(n instanceof BiciUsuario){
                            if(((BiciUsuario) n).getId()==id){       
                                registros.remove(((BiciUsuario) n));
                            }           
                        }
                    }
                }
            }
        }
    }

    public void buscarBicicleta(int serial){
        for(Componente cmp : registros){
            if(cmp instanceof BiciUsuario){
                if(((BiciUsuario) cmp).tamano()!=0){
                    for (int i = 0; i < ((BiciUsuario) cmp).tamano(); i++) {
                        Componente n = ((BiciUsuario) cmp).getChild(i);
                        if(n instanceof Bicicleta){
                            if(((Bicicleta) n).getSerial()==serial){
                                registros.remove(((Bicicleta) n));
                            }
                        }
                    }
                }
            }else if(cmp instanceof Empresa){
                if(((Empresa) cmp).tamano()!=0){
                    for (int i = 0; i < ((Empresa) cmp).tamano(); i++) {
                        Componente n = ((Empresa) cmp).getChild(i);
                        if(n instanceof BiciUsuario){
                            if(((BiciUsuario) n).tamano()!=0){
                                for (int j = 0; j < ((BiciUsuario) n).tamano(); j++) {
                                    Componente m = ((BiciUsuario) cmp).getChild(j);
                                    if(m instanceof Bicicleta){
                                        if(((Bicicleta) m).getSerial()==serial){
                                            registros.remove(((Bicicleta) n));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void buscarEmpresa(int nit){
        for(Componente cmp : registros){
            if(cmp instanceof Empresa){
                if(((Empresa) cmp).getNit()==nit){
                    registros.remove(((Empresa) cmp));
                }
            }
        }
    }

    public void buscarMovelo(int nit){
        for(Componente cmp : registros){
            if(cmp instanceof Movelo){
                if(((Movelo) cmp).getNit()==nit){
                    registros.remove(((Movelo) cmp));
                }
            }
        }
    }

    public void buscarBiciusuario(int id){
        for(Componente cmp : registros){
            if(cmp instanceof BiciUsuario){
                if(((BiciUsuario) cmp).getId()==id){       
                    registros.remove(((BiciUsuario) cmp));
                }
            }else if(cmp instanceof Empresa){
                if(((Empresa) cmp).tamano()!=0){
                    for (int i = 0; i < ((Empresa) cmp).tamano(); i++) {
                        Componente n = ((Empresa) cmp).getChild(i);
                        if(n instanceof BiciUsuario){
                            if(((BiciUsuario) n).getId()==id){       
                                registros.remove(((BiciUsuario) n));
                            }           
                        }
                    }
                }
            }
        }
    }*/
}
