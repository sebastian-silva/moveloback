package servlet;

public class Movelo implements Componente {

    private int nit;
    private String nombre;
    private String direccion;
    private String email;
    private String clave;

    public Movelo(int nit, String nombre, String direccion, String email, String clave) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.clave = clave;
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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }

    public String mostrarInformacion() {
        return "Nit: "+this.nit+", Nombre: "+this.nombre+", Direccion:"+this.direccion+", Correo: "+this.email+", clave: "+this.clave+"\n";
    }
}
