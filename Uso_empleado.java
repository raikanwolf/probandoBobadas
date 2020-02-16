package poo;
import java.util.*;//con el asterisco importas todas las clases

public class Uso_empleado {
	public static void main (String [] args) {
		/*Empleado empleado1=new Empleado("paco gomez", 85000, 1990, 12, 17);
		
		Empleado empleado2=new Empleado("ana lopez", 95000, 1995, 06, 2);
		
		Empleado empleado3=new Empleado("maria martin", 105000, 2002, 03, 15);
		
		empleado1.subeSueldo(5);
		empleado2.subeSueldo(5);
		empleado3.subeSueldo(5);
		
		
		
		System.out.println("nombre: "+empleado1.dameNombre()+" sueldo: "+empleado1.dameSuel()
		+" fecha de alta: "+empleado1.dameFechaContrato());
		
		System.out.println("nombre: "+empleado2.dameNombre()+" sueldo: "+empleado2.dameSuel()
		+" fecha de alta: "+empleado2.dameFechaContrato());
		
		System.out.println("nombre: "+empleado3.dameNombre()+" sueldo: "+empleado3.dameSuel()
		+" fecha de alta: "+empleado3.dameFechaContrato());*/
		
		Empleado[] misEmpleados=new Empleado[4];
		
		misEmpleados[0]=new Empleado ("paco gomez", 85000, 1990, 12, 17);
		misEmpleados[1]=new Empleado ("ana lopez", 95000, 1995, 06, 2);
		misEmpleados[2]=new Empleado ("maria martin", 105000, 2002, 03, 15);
		//java distingue un constructor de otro por el numero de parametros
		misEmpleados[3]=new Empleado ("antonio fernandez");
		
		/*for(int i=0;i<3;i++) {
			misEmpleados[i].subeSueldo(5);
		}*/
		
		for(Empleado e: misEmpleados) {
			e.subeSueldo(5);
		}
		
		for(int i=0;i<4;i++) {
			System.out.println("nombre: "+misEmpleados[i].dameNombre()
					+"sueldo: "+misEmpleados[i].dameSuel()
					+"fecha de alta: "+misEmpleados[i].dameFechaContrato());
		}
	}	
}

class Empleado{
	private String nombre;
	
	private double sueldo;
	
	private Date altaContrato;
	
	public Empleado (String nom, double suel, int agno, int mes, int dia){
		nombre=nom;
		sueldo=suel;
		GregorianCalendar calendario=new GregorianCalendar(agno,mes-1, dia);//enero es 0
		altaContrato=calendario.getTime();
	}
	
	public Empleado (String nom) {
		//nombre=nom;
		this(nom,30000,2000,01,01);
		
		//el this llama al otro constructor
		//y si hay mas constructores es this llama al que tenga el numero de parametros que le dimos
	}
	
	public String dameNombre(){//getter
		return nombre;
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