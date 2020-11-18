package servlet;

public class Hospital implements ComponenteAlarma{
    int id;
    String sector;
    String correo;
    String passsword;
    ContenedorAlarma Alarmas = new ContenedorAlarma();

    public Hospital(int id, String sector, String correo, String passsword) {
        this.id = id;
        this.sector = sector;
        this.correo = correo;
        this.passsword = passsword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ContenedorAlarma getAlarmas() {
        return Alarmas;
    }

    public void setAlarmas(ContenedorAlarma alarmas) {
        Alarmas = alarmas;
    }

    public String mostrarInformacion() {
        return "ID: "+this.id+"\n"+", Sector: "+this.sector+"\n"+", Correo: "+this.correo+"\n"+", Alarmas: "+this.Alarmas+"\n";
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

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}
