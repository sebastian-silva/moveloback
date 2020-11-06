package servlet;

public class BiciUsuario implements Componente {

    private int id;
    private String nombre;
    private String apellido;
    private int documento;
    private String fecha;
    private String telefono;
    private String direccion;
    private String correo;
    private String password;
    private Contenedor container = new Contenedor();

    public BiciUsuario(int id, String nombre, String apellido, int documento, String fecha, String direccion, String telefono, String correo, String password){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.fecha = fecha;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.password = password;
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

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
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

    public String mostrarInformacion() {
        return "Id: "+this.id+", Nombre: "+this.nombre+", Apellido: "+this.apellido+", Documento: "+this.documento+", Fecha: "+this.fecha+", Telefono: "+this.telefono+", direccion: "+this.direccion+", correo: "+this.correo+", password: "+this.password+"\n"+this.container.mostrarInformacion();
    }
}
