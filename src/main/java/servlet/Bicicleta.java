package servlet;

public class Bicicleta implements Componente {
    private int serial;
    private String marca;
    private String modelo;

    public Bicicleta(int serial, String marca, String modelo) {
        this.serial = serial;
        this.marca = marca;
        this.modelo = modelo;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String mostrarInformacion() {
        return "Serial: "+this.serial+", Marca: "+this.marca+", Modelo: "+this.modelo;
    }
}
