package servlet;

public class Policia implements ComponenteAlarma{
    int id;
    String cuadrante;
    String correo;
    String passsword;
    ContenedorAlarma Alarmas = new ContenedorAlarma();

    public Policia(int id, String cuadrante, String correo, String passsword) {
        this.id = id;
        this.cuadrante = cuadrante;
        this.correo = correo;
        this.passsword = passsword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuadrante() {
        return cuadrante;
    }

    public void setCuadrante(String cuadrante) {
        this.cuadrante = cuadrante;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }


    public String mostrarInformacion() {
        return "ID: "+this.id+"\n"+", Cuadrante: "+this.cuadrante+"\n"+", Correo: "+this.correo+"\n"+", Alarmas: "+this.Alarmas+"\n";
    }

    public void add(ComponenteAlarma a){
        this.Alarmas.add(a);
    }

    public void eliminar(ComponenteAlarma a){
        this.Alarmas.eliminar(a);
    }

    public ComponenteAlarma getChild(int index){
        return this.Alarmas.getChild(index);
    }
}
