package poo;

import javax.swing.*;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

public class PruebaTemporizador2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Reloj mireloj=new Reloj(3000,true);
		
		mireloj.enMarcha();
		
		JOptionPane.showMessageDialog(null, "Pulse aceptar para terminar");
		
		System.exit(0);

	}

}


class Reloj{
	private int intervalo;
	private boolean sonido;
	
	public Reloj(int intervalo, boolean sonido) {
		this.intervalo=intervalo;
		this.sonido=sonido;
	}
	
	public void enMarcha() {
		//como en este paquete ya esta damelahora ponemos el 2 para diferencial
		ActionListener oyente=new DameLaHora2(); 
		Timer mitemporizador=new Timer(intervalo,oyente);
		mitemporizador.start();
	}
	
	//clase interna (debe llevar private)
	private class DameLaHora2 implements ActionListener{
		public void actionPerformed(ActionEvent evento){
			Date ahora=new Date();
			System.out.println("Hora cada 3 segundos: "+ahora);
			
			if (sonido) {
				Toolkit.getDefaultToolkit().beep();
			}
			
		}
	}
	
}





