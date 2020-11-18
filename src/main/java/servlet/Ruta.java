package servlet;

public class Ruta {
    private int id;
    private String nombre;
    private int duracion;
    private String fecha;
    private Punto[] puntos;

    public Ruta(int i, String n, int d, String f, Punto[] p){
        this.id = i;
        this.nombre = n;
        this.duracion = d;
        this.fecha = f;
        this.puntos = p;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Punto[] getPuntos() {
        return puntos;
    }

    public void setPuntos(Punto[] puntos) {
        this.puntos = puntos;
    }

    
}

