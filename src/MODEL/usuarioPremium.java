package MODEL;

public class usuarioPremium{

	private int id_usuario;
	private String usuario;
	private String nombre;
	private String paterno;
	private String materno;
	private String direccion;
	private double telefono;
	private String correo;
	@SuppressWarnings("unused")
	private String contrasena;	
	private boolean premium;
	
	public usuarioPremium(){}
	
	public usuarioPremium(int id_usuario, String usuario, String nombre, String paterno, String materno, String direccion, double telefono, String correo, String contrasena, boolean premium) {
		this.id_usuario = id_usuario;
		this.usuario = usuario;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.contrasena = contrasena;
		this.premium = premium;
	}

	public int getId_usuario() {
		return id_usuario;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getTelefono() {
		return telefono;
	}

	public void setTelefono(double telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public boolean getPrem() {
		return premium;
	}
	
	public void setPrem(boolean premium) {
		this.premium = premium;
	}
}