package com.fernandojimenez.ejerciciofinal.Persistencia;

public class Lugar {
	private long id;
	private String nombre;
	private String descripcion;
	private String latitud;
	private String longitud;
	private String foto;
	private String textoFoto;

	
	
	public Lugar() {
	}

 

	public Lugar(long id, String nombre, String descripcion, String latitud,
			String longitud, String foto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.foto = foto;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
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



	public String getLatitud() {
		return latitud;
	}



	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}



	public String getLongitud() {
		return longitud;
	}



	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}



	public String getFoto() {
		return foto;
	}



	public void setFoto(String foto) {
		this.foto = foto;
	}



	public String getTextoFoto() {
		return textoFoto;
	}



	public void setTextoFoto(String textoFoto) {
		this.textoFoto = textoFoto;
	}
	
	  


	
	
}
