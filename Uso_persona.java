package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_persona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Persona[] lasPersonas=new Persona[2];
		
		lasPersonas[0]=new Empleado2("Luis conde", 50000,2009,2,25);
		lasPersonas[1]=new Alumno("Ana lopez","Biologia");
		
		for(Persona p:lasPersonas) {
			System.out.println(p.dameNombre() + " , " + p.dameDescripcion());
		}
		
	}

}

//si la clase tiene metodo abstracto la clase debe ser abstracta
abstract class Persona{
	private String nombre;
	
	public Persona (String nom) {
		nombre=nom;
	}
	
	public String dameNombre() {
		return nombre;
	}
	//un metodo abstracto se define pero no se construye
	public abstract String dameDescripcion();
	
}

class Empleado2 extends Persona{
	
	private double sueldo;
	
	private Date altaContrato;
	
	private static int IdSiguiente;
	
	private int Id;
	
	public Empleado2 (String nom, double suel, int agno, int mes, int dia){
		super (nom); //invocamos al constructor de la superclase
		sueldo=suel;
		GregorianCalendar calendario=new GregorianCalendar(agno,mes-1, dia);//enero es 0
		altaContrato=calendario.getTime();
		++IdSiguiente;
		Id=IdSiguiente;
	}
	//aqui es donde se construye el metodo, se sobre escribe el metodo de la clase abstracta
	public String dameDescripcion() {
		return "Este empleado tiene un Id= " + Id +" con un sueldo= " + sueldo; 
	}
	
	public double dameSuel(){//getter
		return sueldo;
	}
	
	public Date dameFechaContrato(){//getter
		return altaContrato;
	}
	
	public void subeSueldo(double porcentaje) {//setter
		
		double aumento=sueldo*porcentaje/100;
		
		sueldo+=aumento;	
	}
}

class Alumno extends Persona{
	private String carrera;
	
	public Alumno (String nom, String car) {
		super (nom);
		carrera=car;
	}
	
	public String dameDescripcion() {
		return "Este alumno esta estudiando la carrera de "+ carrera;
	}
}




