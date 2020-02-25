package poo;

public interface Jefes extends Trabajadores {//las interfaces tambien pueden heredar
	//aqui da por hecho que es publico y abstracto, asi que no es necesario escribirlo 
	
	String tomar_decisiones(String decisiones);
	
}
