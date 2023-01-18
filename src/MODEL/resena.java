package MODEL;

public class resena {

	private String usuario;
	private int id_juego;
	private String titulo;
	private String resena;
	private int calificacion;
	private String fecha;
	
	public resena(){}
	
	public resena(int id_resena,String usuario, int id_juego, String titulo, String resena, int calificacion, String fecha) {
    	this.id_resena = id_resena;
        this.usuario = usuario;
        this.id_juego = id_juego;
        this.titulo = titulo;
        this.resena = resena;
        this.calificacion = calificacion;
        this.fecha = fecha;
    }
	
	private int id_resena;
	public int getId_resena() {
		return id_resena;
	}

	public void setId_resena(int id_resena) {
		this.id_resena = id_resena;
	}

	public String getusuario() {
		return usuario;
	}

	public void setusuario(String usuario) {
		this.usuario = usuario;
	}

	public int getId_juego() {
		return id_juego;
	}

	public void setId_juego(int id_juego) {
		this.id_juego = id_juego;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResena() {
		return resena;
	}

	public void setResena(String resena) {
		this.resena = resena;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
