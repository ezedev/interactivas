package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.Sistema;

public class MenuVentana extends javax.swing.JFrame {
	private JMenuBar menuBar;
	private JMenu menuColocacion;
	private JMenuItem menuItemGenerarColocacion;
	private JMenuItem menuItemCargarDevoluciones;
	private JMenu menuEdiciones;
	private JMenu menuReportes;

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
			getContentPane().setBackground(new java.awt.Color(64,128,128));

			/**
			 * Menu
			 */
			
			menuBar = new JMenuBar();
			
			/**
			 * Colocaciones
			 */
			
			menuColocacion = new JMenu();
			menuColocacion.setText("Colocacion");
			menuColocacion.setSize(120, 30);
			
			menuItemGenerarColocacion = new JMenuItem();
			menuItemGenerarColocacion.setText("Generar colocacion");
			
			menuItemCargarDevoluciones = new JMenuItem();
			menuItemCargarDevoluciones.setText("Cargar devoluciones");
			
			menuColocacion.add(menuItemGenerarColocacion);
			menuColocacion.add(menuItemCargarDevoluciones);
			
			/**
			 * ABM Ediciones
			 */
			
			menuEdiciones = new JMenu();
			menuEdiciones.setText("Ediciones");
			menuEdiciones.setSize(120, 30);			
			
			/**
			 * Reportes
			 */
			
			menuReportes = new JMenu();
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
