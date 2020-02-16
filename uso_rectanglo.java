package poo;

import javax.swing.JOptionPane;

public class uso_rectanglo {
	public static void main(String[] args) {
		int largo,ancho;
		
		largo=Integer.parseInt(JOptionPane.showInputDialog("ingrese largo"));
		ancho=Integer.parseInt(JOptionPane.showInputDialog("ingrese ancho"));
		
		rectangulo rec=new rectangulo(largo, ancho);
		
		JOptionPane.showMessageDialog(null, rec.mostrar());
		JOptionPane.showMessageDialog(null, "el area es: "+rec.area());
	}
}
