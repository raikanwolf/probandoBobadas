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
		
		//casting de objetos (conversion de tipos)
		Jefatura jefa_Finanzas=(Jefatura) misEmpleados[5];
		
		jefa_Finanzas.establecIncentivo(55000);
	//si intentamos convertir a un empleado en jefe no funcionara debido a como es la herencia
		
		
		/*for(int i=0;i<3;i++) {
			misEmpleados[i].subeSueldo(5);
		}*/
		
		/*//principio de sustitucion "es un" asi se le dice que es del tipo jefatura
		Empleado director_comercial=new Jefatura ("Sandra",85000,2012,05,05);
		//no se puede instanciar directamente pero si podemos decirle que es un empleado 
		Comparable ejemplo=new Empleado ("Elisabeth",95,2011,06,07);
		
		if(director_comercial instanceof Empleado){
			System.out.println("es de tipo Jefatura");
		}
		
		if(ejemplo instanceof Empleado) {
			System.out.println("implementa la interfaz comparable");
		}*/
		
		System.out.println(jefa_Finanzas.tomar_decisiones("dar mas dias de vacaciones"));
		
		System.out.println("El jefe "+jefa_Finanzas.dameNombre() + "tienen un bonus de " + jefa_Finanzas.establece_bonus(500));
		
		System.out.println(misEmpleados[3].dameNombre()+" tiene un bonus de: "+misEmpleados[3].establece_bonus(200));
		
		for(Empleado e: misEmpleados) {
			e.subeSueldo(5);
		}
		
		//en la clase empleado hay que decirle que implemente la intefaz comparable.
		//revisa Arrays (clase) en la api de java, sort es estatico
		Arrays.sort(misEmpleados);
		
		for(Empleado e: misEmpleados) {
			System.out.println("nombre: "+e.dameNombre()
					+" sueldo: "+e.dameSuel()//se llamara al dame suel dependiendo de la clase alli esta el polimorfismo
					//una variable de tipo objeto se comporta de una forma u otra dependiendo del contexto o como se aplique
					+" fecha de alta: "+e.dameFechaContrato());
		}
	}	
}
//le decimos que implemente la interfaz "comparable" significa que hay que incluir los metodos abstractos de la interfaz
//NOTA: no se puede instanciar una interfaz
class Empleado implements Comparable, Trabajadores {
	private String nombre;
	
	private double sueldo;
	
	private Date altaContrato;
	
	private static int IdSiguiente;
	
	private int Id;
	
	public double establece_bonus(double gratificacion) {
		return Trabajadores.bonus_base+gratificacion;
	}
	
	public Empleado (String nom, double suel, int agno, int mes, int dia){
		nombre=nom;
		sueldo=suel;
		GregorianCalendar calendario=new GregorianCalendar(agno,mes-1, dia);//enero es 0
		altaContrato=calendario.getTime();
		++IdSiguiente;
		Id=IdSiguiente;
	}
	
	//compare to debe ser publico y abstracto, si no pones public se da por su puesto
	//Pero una cosa es crear el metodo en la interfaz y otra cosa es sobreescribitlo en una clase
	//Si lo sobreescribes en una clase alli si es necesario el public
	//se esta sobreescribiendo el metodo
	public int compareTo(Object miObjeto) {
		//hacemos casting
		Empleado otroEmpleado=(Empleado) miObjeto;

		//this si este empleado
		if(this.Id<otroEmpleado.Id) {//revisa la api sobre compare to
			return -1;
		}
		
		if(this.Id>otroEmpleado.Id) {
			return 1;
		}
		
		return 0;
		
	}
	
	
	public Empleado (String nom) {
		//nombre=nom;
		this(nom,30000,2000,01,01);
		
		//el this llama al otro constructor
		//y si hay mas constructores es this llama al que tenga el numero de parametros que le dimos
	}
	
	public String dameNombre(){//getter
		return nombre + " " +"id "+Id;
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
//final evita que una clase herede de otra
//lo mismo se puede hacer con los metodos para evitar sobreescribir
//herencia multiple prohibida en java, pero puedes usar interfaces
class Jefatura extends Empleado implements Jefes{
	
	public Jefatura(String nom, double sue, int agno, int mes, int dia) {
		super(nom, sue, agno, mes, dia); //dependiendo de que parametros le demos buscara a tal constructor
	}
	
	public String tomar_decisiones (String decision){
		
		return "Un miembro de la direccion ha tomado la decision de:" + decision;
	}
	
	public double establece_bonus(double gratificacion) {
		double prima=2000;
		return Trabajadores.bonus_base+gratificacion+prima;
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




