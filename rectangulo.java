package poo;

public class rectangulo {
	private int largo;
	private int ancho;
	
	public rectangulo (int largo, int ancho) {//constructor
		this.largo=largo;
		this.ancho=ancho;
	}
	
	public String mostrar() {//getter
		return "el largo es "+largo+" y el ancho es "+ancho;
	}
	
	public int area() {
		return largo*ancho;
	}
}
