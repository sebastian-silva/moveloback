package servlet;

public abstract class Decorator implements Componente {
    protected Componente bicicleta;
    
    public Decorator(Componente bicicleta) {
        this.bicicleta=bicicleta;
    }

    public String mostrarInformacion() {
        return this.bicicleta.mostrarInformacion();
    }
}
