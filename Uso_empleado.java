package poo;
import java.util.*;//con el asterisco importas todas las clases

public class Uso_empleado {
	public static void main (String [] args) {
		
		Jefatura jefe_RRHH=new Jefatura("Juan", 55000, 2006, 9, 25);
		
		jefe_RRHH.establecIncentivo(2570);
		
		Empleado[] misEmpleados=new Empleado[6];
		
		misEmpleados[0]=new Empleado ("paco gomez", 85000, 1990, 12, 17);
		misEmpleados[1]=new Empleado ("ana lopez", 95000, 1995, 06, 2);
		misEmpleados[2]=new Empleado ("maria martin", 105000, 2002, 03, 15);
		//java distingue un constructor de otro por el numero de parametros
		misEmpleados[3]=new Empleado ("antonio fernandez");
		misEmpleados[4]=jefe_RRHH; //polimorfismo en accion, principio de ejecucion
		//podemos usar un objeto de la subclase, siempre y cuando esperemos un ojbeto de la superclase
		misEmpleados[5]=new Jefatura("Maria", 95000, 1999, 5, 26);
		
		
		/*for(int i=0;i<3;i++) {
			misEmpleados[i].subeSueldo(5);
		}*/
		
		for(Empleado e: misEmpleados) {
			e.subeSueldo(5);
		}
		
		for(Empleado e: misEmpleados) {
			System.out.println("nombre: "+e.dameNombre()
					+" sueldo: "+e.dameSuel()//se llamara al dame suel dependiendo de la clase alli esta el polimorfismo
					//una variable de tipo objeto se comporta de una forma u otra dependiendo del contexto o como se aplique
					+" fecha de alta: "+e.dameFechaContrato());
		}
	}	
}

class Empleado{
	private String nombre;
	
	private double sueldo;
	
	private Date altaContrato;
	
	private static int IdSiguiente;
	
	private int Id;
	
	public Empleado (String nom, double suel, int agno, int mes, int dia){
		nombre=nom;
		sueldo=suel;
		GregorianCalendar calendario=new GregorianCalendar(agno,mes-1, dia);//enero es 0
		altaContrato=calendario.getTime();
		++IdSiguiente;
		Id=IdSiguiente;
	}
	
	public Empleado (String nom) {
		//nombre=nom;
		this(nom,30000,2000,01,01);
		
		//el this llama al otro constructor
		//y si hay mas constructores es this llama al que tenga el numero de parametros que le dimos
	}
	
	public String dameNombre(){//getter
		return nombre + " " +Id;
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

class Jefatura extends Empleado{
	
	public Jefatura(String nom, double sue, int agno, int mes, int dia) {
		super(nom, sue, agno, mes, dia); //dependiendo de que parametros le demos buscara a tal constructor
	}
	
	public void establecIncentivo (double b) {
		incentivo=b;
	}
	
	public double dameSuel() {//un triangulo verde
		double sueldoJefe=super.dameSuel();//sobreescribe el metodo de la clase padre
		//con super llama a damesuel de la clase padre y no el de jefatura
		return sueldoJefe + incentivo;
	}
	
	private double incentivo;
}