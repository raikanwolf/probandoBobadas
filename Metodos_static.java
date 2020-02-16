package poo;

public class Metodos_static {

	public static void main(String[] args) {
		
		Empleados trabajador1=new Empleados("paco");
		
		Empleados trabajador2=new Empleados("ana");
		
		Empleados trabajador3=new Empleados ("antonio");
		
		Empleados trabajador4=new Empleados ("maria");
		
		trabajador1.cambiaSeccion("RRHH");
		
		//trabajador1.cambiaNombre("maria");
		
		System.out.println (trabajador1.devuelveDatos()+ "\n"+ trabajador2.devuelveDatos()+
		"\n"+trabajador3.devuelveDatos()+"\n"+trabajador4.devuelveDatos());
		
		System.out.println(Empleados.dameIdSiguiente());
//		System.out.println(trabajador1.dameIdSiguiente()); //esto se puede pero da una advertencia
		//los metodos estaticos no operan sobre objetos es decir no se puede empleado1.metodo estatico
		//los metodos estaticos pertenecen a la clase
		
/*un ejemplo de metodo estatico es con la clase math con math.sqrt()
 * sqrt es un metodo estatico perteneciente a la clase math y no a un objeto
 */

	}

}


class Empleados{
	
	public Empleados (String nom) {
		
		nombre=nom;
		
		seccion="administracion";
		
		Id=IdSiguiente; //con el static esta variable no pertenece a trabajador 1 o trabajador 2
		//sino que pertenece a la clase empleado, asi todos los empleados trendran un Id=1
		
		IdSiguiente++;
	}
	
	public void cambiaSeccion(String seccion) {//SETTER
		
		this.seccion=seccion;
		
	}
	
	/*public void cambiaNombre(String nombre) {
		
		this.nombre=nombre;
	}*/
	
	public String devuelveDatos() {
		
		return "el nombre es: "+nombre+" y la seccion es: "+seccion+ " el Id="+Id;
		
	}
	//accede a IdSiguiente pero no a las otras variables porque no son estaticos
	//un metodo estatico no puede acceder a otras variables que no sean estaticas
	public static String dameIdSiguiente() {
		
		return "El IdSiguiente es: "+IdSiguiente;
	}
	
	private final String nombre; //final convierte en constante
	//evita que se modifique el valor de una variable o atributo
	private String seccion;
	
	//public static int Id;//con el static id no pertenece a  un objeto si no que es de la propia clase
	private int Id;
	
	private static int IdSiguiente=1; //ningun objeto tiene copia de Idsiguiente, solo la clase
}


