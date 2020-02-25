package poo;
import java.util.Scanner;

public class Uso_talla_tipo_enumerado {
	//el tipo enumerado no puede estar dentro del main
	//enum Talla {MINI,MEDIANO,GRANDE,MUY_GRANDE};
	
	enum Talla{
		
		MINI("S"),MEDIANO("M"),GRANDE("L"),MUY_GRANDE("XL");
		//los tipos enumerados no permiten la creacion de objetos
		//si se crea un constructor debe ser private para evitar crear instancias
		private Talla(String abreviatura) {
			this.abreviatura=abreviatura;
		}
		
		public String dameAbreviatura() {
			return abreviatura;
		}
		
		private String abreviatura;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Talla s=Talla.MINI;
		Talla m=Talla.MEDIANO;
		Talla l=Talla.GRANDE;
		Talla xl=Talla.MUY_GRANDE;*/
		
		Scanner entrada=new Scanner(System.in);
		System.out.println("escribe una talla: MINI, MEDIANO, GRANDE, MUY GRANDE");
		String entrada_datos=entrada.next().toUpperCase();
		Talla la_talla=Enum.valueOf(Talla.class, entrada_datos);
		System.out.println("talla=" + la_talla);
		System.out.println("abreviatura="+ la_talla.dameAbreviatura());
		entrada.close();
		
	}
	
}
