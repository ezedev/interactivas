package programa;

import javax.swing.SwingUtilities;

import persistencia.EdicionesMapper;
import persistencia.PoolConnection;
import ventanas.Login;
import ventanas.MenuVentana;

public class Programa {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Login ventanaLogin = new Login();				
				ventanaLogin.setLocationRelativeTo(null);
				ventanaLogin.setVisible(true);
			}
		});		
	}
}
