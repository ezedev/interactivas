package programa;

import javax.swing.SwingUtilities;

import persistencia.EdicionesMapper;
import persistencia.PoolConnection;
import ventanas.MenuVentana;

public class Programa {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MenuVentana menuVentana = new MenuVentana();				
				menuVentana.setLocationRelativeTo(null);
				menuVentana.setVisible(true);
			}
		});		
	}
}
