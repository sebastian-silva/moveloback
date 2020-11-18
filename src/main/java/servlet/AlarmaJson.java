package servlet;

public class AlarmaJson {
    double latitud;
    double longitud;
    String nombre;
    String apellido;
    Boolean activa;

    public AlarmaJson(double latitud, double longitud, String nombre, String apellido, Boolean activa) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombre = nombre;
        this.apellido = apellido;
        this.activa = activa;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }
}
