package clases;

public class Jugador {

	private String nombre;
	private int puntuacion = 0;
	
	
	
	public Jugador (String nombre, int puntuacion){
		this.nombre= nombre;
		this.puntuacion= puntuacion;
		
	}
	
	public void setNombre(String nombre) {
	    this.nombre = nombre;
	}

	public String getNombre() {
	    return this.nombre;
	}
	public void setPuntuacion(int puntuacion) {
	    this.puntuacion = puntuacion;
	}

	public int getPuntuacion() {
	    return this.puntuacion;
	}
}

