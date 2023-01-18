package MODEL;

public class noticia {
	
	private int id_noticia;
	private String titulo;
	private String noticia;
	private String fecha;
	
	public noticia(){}
	
	public noticia(int id_noticia, String titulo, String noticia, String fecha) {
    	this.id_noticia = id_noticia;
        this.titulo = titulo;
        this.noticia = noticia;
        this.fecha = fecha;
    }
	
	public int getId_noticia() {
		return id_noticia;
	}

	public void setId_noticia(int id_noticia) {
		this.id_noticia = id_noticia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNoticia() {
		return noticia;
	}

	public void setNoticia(String noticia) {
		this.noticia = noticia;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
