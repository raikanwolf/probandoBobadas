package poo;

import javax.swing.JOptionPane;

public class Uso_vehiculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Carro renault=new Carro(); //INSTANCIAR UNA CLASE, EJEMPLAR DE CLASE
		
		//renault.ruedas=3;
		renault.establece_color(JOptionPane.showInputDialog("introduce color"));//llamamos al metodo setter
		
		System.out.println(renault.dime_datos_generales());
		
		System.out.println(renault.dime_color());
		
		renault.configura_asientos(JOptionPane.showInputDialog("tiene asientos de cuero?"));
		
		System.out.println(renault.dime_asientos());
		
		renault.configura_climatizador(JOptionPane.showInputDialog("tiene climatizador?"));
		
		System.out.println(renault.dime_climatizador());
		
		System.out.println(renault.dime_peso_coche());
		
		System.out.println("el precio final es"+renault.precio_carro());
		
		
		//System.out.println (renault.dime_largo());//obtenemos resultados con el getter
		//System.out.println (renault.dime_color());
		
		/*System.out.println("Este carro tiene "+renault.ruedas+" ruedas");
		JOptionPane.showMessageDialog(null, "Este carro tiene "+renault.ruedas+" ruedas");*/

	}

}
