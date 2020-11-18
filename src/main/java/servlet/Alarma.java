package servlet;

public class Alarma implements ComponenteAlarma{
    int id;
    Punto ubicacion;
    BiciUsuario usuario;
    Boolean activa;

    public Alarma(int id, Punto ubicacion, BiciUsuario usuario, Boolean activa) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.usuario = usuario;
        this.activa = activa;
    }

    public String mostrarInformacion() {
        // TODO Auto-generated method stub
        return "Id: "+this.id+","+this.ubicacion.mostrarInformacion()+","+this.usuario.mostrarInformacion()+","+this.activa+",";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Punto getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Punto ubicacion) {
        this.ubicacion = ubicacion;
    }

    public BiciUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(BiciUsuario usuario) {
        this.usuario = usuario;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }
    
}
