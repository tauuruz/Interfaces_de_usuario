package MODEL;

public class desarrollador{

	private int id_dev;
	private String desarrollador;
	private String nombre;
	private String correo;
	@SuppressWarnings("unused")
	private String contrasena;	
	
	public desarrollador(){}
	
	public desarrollador(int id_dev, String desarrollador, String nombre, String correo, String contrasena) {
		this.desarrollador = desarrollador;
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
	}

	public int getId_dev() {
		return id_dev;
	}
	
	public String getDev() {
		return desarrollador;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCorreo() {
		return correo;
	}
}