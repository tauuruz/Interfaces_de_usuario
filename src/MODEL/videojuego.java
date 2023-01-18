package MODEL;

public class videojuego{
	
	private int id_juego;
    private String nombre;
    private String categoria;
    private String genero;
    private double precio;
    private String descripcion;
    private String desarrollador;

    public videojuego(){}

    public videojuego(int id_juego,String nombre, String categoria, String genero, double precio, String descripcion, String desarrollador) {
    	this.id_juego = id_juego;
        this.nombre = nombre;
        this.categoria = categoria;
        this.genero = genero;
        this.precio = precio;
        this.descripcion = descripcion;
        this.desarrollador = desarrollador;
    }
    
    public int getID() {
        return this.id_juego;
    }

    public String getNombre() {
        return this.nombre;
    }
    public String getCategoria() {
        return this.categoria;
    }
    public String getGenero() {
        return this.genero;
    }
    public double getPrecio() {
        return this.precio;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    public String getDev() {
    	return this.desarrollador;
    }
}
