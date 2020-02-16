package poo;
//diseño de herencia: regla "es un"
//para saber si el diseño de herencia escorrecta preguntate
//esta "clase" es un(a) "superclase"
//ejemplo este "carro" es un "vehiculo"


public class Uso_vehiculo {

	public static void main(String[] args) {
		Carro micarro1=new Carro();
		
		micarro1.establece_color("Rojo");
		
		Furgoneta mifurgoneta1=new Furgoneta(7, 580); //pide parametros
		
		mifurgoneta1.establece_color("azul");//el metodo establececoloe se hereda de carro
		
		mifurgoneta1.configura_asientos("si");
		
		mifurgoneta1.configura_climatizador("si");
		
		System.out.println(micarro1.dime_datos_generales() + " " + micarro1.dime_color()); 
		// si no se añade el metodo y dejas solo el objeto aparece algo como esto poo.Carro@46daef40
		
		System.out.println(mifurgoneta1.dime_datos_generales()+ " " + mifurgoneta1.dimeDatosFurgoneta());
		
	}

}
