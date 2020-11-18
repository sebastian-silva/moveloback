package servlet;

public class Punto implements Componente{
    private double latitud;
    private double longitud;

    public Punto(double la, double lo){
        latitud = la;
        longitud = lo;
    }
    
    public String mostrarInformacion(){
        return "Longitud: "+this.longitud+", Latitud: "+ this.latitud;
    }

    
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
    }

	public double getLatitud() {
		return latitud;
	}

	public double getLongitud() {
		return longitud;
	}
}