package poo;

public class Carro {
	private int ruedas;//al poner private encapsulas el dato, es un modificador de acceso

	private int largo;
	
	private int ancho;
	
	//private int motor;
	
	private int peso_plataforma;
	
	private String color;
	
	private int peso_total;
	
	private boolean asientos_cuero, climatizador;
	//al poner private evitas que los atributos puedan ser modificasod desde
	//otra clase, porque el constructor es el molde para crear los objetos
	public Carro() {//CONSTRUCTOR
		
		ruedas=4;
		largo=2000;
		ancho=300;
		//motor=1600;
		peso_plataforma=500;	
	}
	
	public String dime_datos_generales() {//getter
		
		return "la plataforma del vehiculo tiene "+ ruedas + " ruedas" + 
		". mide "+ largo/1000 + "metros con un ancho de " + ancho +
		" cm y un peso de plataforma de " + peso_plataforma + "kg";
	}
	
	public void establece_color (String color_carro) {//setter
		//color="azul";
		color=color_carro;
	}
	
	public String dime_color() {
		return "el color del carro es "+color;
	}
									//se llama igual a la variable de la clase, para diferenciarla usamos this
	public void configura_asientos (String asientos_cuero) {//setter
		//this.asientos_cuero=asientos_cuero;
		//boolean			//string
		if (asientos_cuero.equalsIgnoreCase("si")) {
			this.asientos_cuero=true;
		}else {
			this.asientos_cuero=false;
		}
	}
	
	public String dime_asientos() {
		if (asientos_cuero==true) {
			return "tiene asientos de cuero";
			
		}else {
			return "no los tiene de cuero";
		}
	}
	
	public void configura_climatizador (String climatizador) {
		if(climatizador.equalsIgnoreCase("si")) {
			this.climatizador=true;
		}else {
			this.climatizador=false;
		}
	}
	
	public String dime_climatizador() {
		if(climatizador==true) {
			return "el carro tiene climatizador";
		}else{
			return "lleva aire acondicionado";
		}
	}
	
	//se puede crear un getter que es setter a la vez pero no es muy recomendada
	public String dime_peso_coche() {
		int peso_carroceria=500;
		peso_total=peso_plataforma+peso_carroceria;
		
		if (asientos_cuero==true) {
			peso_total+=50;
		}
		if (climatizador==true) {
			peso_total+=20;
		}
		return "el peso es "+peso_total;
	}
	
	public int precio_carro() {//getter
		int precio_final=10000;
		
		if(asientos_cuero==true) {
			precio_final+=2000;
		}
		if (climatizador==true) {
			precio_final+=1500;
		}
		return precio_final;
	}
	
}


/*public static void main (String args []) {
Carro renault=new Carro(); //INSTANCIAR UNA CLASE, EJEMPLAR DE CLASE

System.out.println("Este carro tiene "+renault.ruedas+" ruedas");
}*/
//forma valida de programar pero desaconsejada, esto es como las funciones en c
/*class camion{
	
}

class moto{
	
}
*/
