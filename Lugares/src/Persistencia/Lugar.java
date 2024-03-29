package Persistencia;

public class Lugar {
	private int id;
	private String nombre;
	private String descripcion;
	private double latitud;
	private double longitud;
	private String foto;
	public int getId() {
		return id;
	}
	
	public Lugar() {
	}
	
	public Lugar(int id, String nombre, String descripcion, double latitud,
			double longitud, String foto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.foto = foto;
	}
	public Lugar(String nombre, String descripcion, double latitud,
			double longitud, String foto) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.foto = foto;
	}



	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
}
