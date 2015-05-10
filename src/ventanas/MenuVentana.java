package ventanas;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.Sistema;

public class MenuVentana extends javax.swing.JFrame {
	
	public MenuVentana() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			setSize(400, 300);
			setTitle("Sistema de colocacion de ediciones");
			
			/**
			 * Menu
			 */
			
			JMenuBar menuBar = new JMenuBar();
			
			/**
			 * Colocaciones
			 */
			
			JMenu menuColocacion = new JMenu();
			menuColocacion.setText("Colocacion");
			menuColocacion.setSize(120, 30);
			
			JMenuItem menuItemGenerarColocacion = new JMenuItem();
			menuItemGenerarColocacion.setText("Generar colocacion");
		
			JMenuItem menuItemCargarDevoluciones = new JMenuItem();
			menuItemCargarDevoluciones.setText("Cargar devoluciones");
			
			menuColocacion.add(menuItemGenerarColocacion);
			menuColocacion.add(menuItemCargarDevoluciones);
			
			/**
			 * ABM Ediciones
			 */
			
			JMenu menuEdiciones = new JMenu();
			menuEdiciones.setText("Ediciones");
			menuEdiciones.setSize(120, 30);			
			
			/**
			 * Reportes
			 */
			
			JMenu menuReportes = new JMenu();
			menuReportes.setText("Reportes");
			menuReportes.setSize(120, 30);		
			
			menuBar.add(menuColocacion);
			menuBar.add(menuEdiciones);
			menuBar.add(menuReportes);
			
			setJMenuBar(menuBar);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
