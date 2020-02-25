package poo;

import javax.swing.*;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

public class PruebaTemporizador2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Reloj mireloj=new Reloj();
		
		mireloj.enMarcha(3000,true);
		
		JOptionPane.showMessageDialog(null, "Pulse aceptar para terminar");
		
		System.exit(0);

	}

}


class Reloj{//si quitas comentarios esta mas simplificado
	//simplificando, podriamos hacer que intervalo y sonido sean parametros de en marcha
	
	/*private int intervalo;
	private boolean sonido;*/
	//se puede prescindirdel constructor y se usa el constructor por defecto
	/*public Reloj(int intervalo, boolean sonido) {
		this.intervalo=intervalo;
		this.sonido=sonido;
	}*/
	
	public void enMarcha(int intervalo, final boolean sonido) {
		class DameLaHora2 implements ActionListener{
			public void actionPerformed(ActionEvent evento){
				Date ahora=new Date();
				System.out.println("Hora cada 3 segundos: "+ahora);
				//si la  clase interna local esta accediendo a una variable local o parametro
				//el parametro debe se declarado final
				//con intervalo no es necesario ya que la clase inerna no lo llama
				if (sonido) {
					Toolkit.getDefaultToolkit().beep();
				}
				
			}
		}
		
		//como en este paquete ya esta damelahora ponemos el 2 para diferencial
		ActionListener oyente=new DameLaHora2(); 
		Timer mitemporizador=new Timer(intervalo,oyente);
		mitemporizador.start();
	}
	
	//clase interna (debe llevar private)
	//las clases internas local van dentro de metodos y se usan cuando se instancian una sola vez
	//si una clase interna es local no debe llevar modificadores de acceso (public private)
	
	/*private class DameLaHora2 implements ActionListener{
		
		public void actionPerformed(ActionEvent evento){
			Date ahora=new Date();
			System.out.println("Hora cada 3 segundos: "+ahora);
			//la clase interna esta accediendo a un atributo (en este caso sonido) que no pertenece a ella si no a la clase externa
			//te puedes ahorrar los getter y setter, esa es la ventaja de las clases internas
			if (sonido) {
				Toolkit.getDefaultToolkit().beep();
			}
			
		}
	}*/
	
}





