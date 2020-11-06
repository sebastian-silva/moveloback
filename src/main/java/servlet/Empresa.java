package servlet;

public class Empresa implements Componente {

    private int nit;
    private String nombre;
    private String direccion;
    private String correo;
    private String password;
    private Contenedor container = new Contenedor();

    public Empresa(int nit, String nombre, String direccion) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void add(Componente a){
        container.add(a);
    }

    public void eliminar(Componente a){
        container.eliminar(a);
    }

    public int tamano(){
        return container.tamano();
    }

    public Componente getChild(int index){
        return container.getChild(index);
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String mostrarInformacion() {
        return "Nit: "+this.nit+", Nombre: "+this.nombre+", Direccion:"+this.direccion+", Correo: "+this.correo+", clave: "+this.password+"\n"+this.container.mostrarInformacion();
    }
}
