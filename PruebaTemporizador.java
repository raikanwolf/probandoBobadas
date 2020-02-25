package poo;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
//javax swing y java util tienen sus propias clases timer, para evitar conclictos
//pides que importe otra vez pero la clase en el paquete que quieres, asi puedes
//seleccinar la clase que necesitas y tener las otras que necesites de otros paquetes

public class PruebaTemporizador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DameLaHora oyente=new DameLaHora();//constructor por defecto
		
		//oyente es un evento (como en javascript) en vezde ser funcion es un objeto
		Timer miTemporizador=new Timer(5000,oyente);
		
		miTemporizador.start();
		
		JOptionPane.showMessageDialog(null, "pulsa aceptar para detener");
		
		System.exit(0);
		
	}

}


class DameLaHora implements ActionListener{
	public void actionPerformed(ActionEvent e) {
	
		Date ahora=new Date();
		
		System.out.println("hora cada 5 segundos: "+ahora);
	}
}