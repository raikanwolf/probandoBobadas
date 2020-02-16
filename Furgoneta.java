package poo;
//herencia
public class Furgoneta extends Carro {
	
	private int capacidad_de_carga;
	
	private int plazas_extra;
	
	public Furgoneta (int plazas_extra, int capacidad_de_carga) {
		super();//llamar al constructor de la clase padre
		
		this.capacidad_de_carga=capacidad_de_carga;
		
		this.plazas_extra=plazas_extra;
		
	}
	//getter
	public String dimeDatosFurgoneta() {
		return "la capacidad de carga es: " + capacidad_de_carga + "Y las plazas son: " + plazas_extra;
		
	}
}
