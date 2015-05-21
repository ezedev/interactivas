package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import modelo.Modulo;
import controlador.Sistema;

import java.awt.BorderLayout;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class MenuVentana extends javax.swing.JFrame implements MenuListener,
		ActionListener {
	private JMenuBar menuBar;
	private JPanel jPanelInicial;
	private JMenu menuColocacion;
	private JMenuItem menuItemGenerarColocacion;
	private JMenuItem menuItemCargarDevoluciones;
	private JMenuItem itemAltaEdicion;
	private JMenuItem itemModEdicion;
	private JMenuItem itemBajaEdicion;
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
			this.setSize(770, 557);
			setTitle("Sistema de colocacion de ediciones");
			getContentPane().setBackground(new java.awt.Color(64, 128, 128));
			this.setPreferredSize(new java.awt.Dimension(770, 557));
			this.setResizable(false);

			{
				jPanelInicial = new JPanel();
				getContentPane().add(jPanelInicial, BorderLayout.CENTER);
				jPanelInicial.setBackground(new java.awt.Color(64, 128, 128));
			}

			/**
			 * Menu
			 */

			menuBar = new JMenuBar();

			/**
			 * Colocaciones
			 */

			if(Sistema.getInstance().tieneAcceso(Modulo.MODULO_COLOCACION)) {
			
				menuColocacion = new JMenu();
				menuColocacion.setText("Colocacion");
				menuColocacion.setSize(120, 30);
	
				menuItemGenerarColocacion = new JMenuItem();
				menuItemGenerarColocacion.setText("Generar colocacion");
				this.menuItemGenerarColocacion.addActionListener(this);
	
				menuItemCargarDevoluciones = new JMenuItem();
				menuItemCargarDevoluciones.setText("Cargar devoluciones");
	
				menuColocacion.add(menuItemGenerarColocacion);
				menuColocacion.add(menuItemCargarDevoluciones);
				
				menuBar.add(menuColocacion);
			}

			/**
			 * ABM Ediciones
			 */

			if(Sistema.getInstance().tieneAcceso(Modulo.MODULO_EDICIONES)) {
			
				menuEdiciones = new JMenu();
				menuEdiciones.setText("Ediciones");
				menuEdiciones.setSize(120, 30);
	
				itemAltaEdicion = new JMenuItem();
				itemAltaEdicion.setText("Alta edicion");
				this.itemAltaEdicion.addActionListener(this);
	
				itemModEdicion = new JMenuItem();
				itemModEdicion.setText("Modificar edicion");
				this.itemModEdicion.addActionListener(this);
	
				itemBajaEdicion = new JMenuItem();
				itemBajaEdicion.setText("Baja edicion");
				this.itemBajaEdicion.addActionListener(this);
	
				this.menuEdiciones.add(itemAltaEdicion);
				this.menuEdiciones.add(itemModEdicion);
				this.menuEdiciones.add(itemBajaEdicion);
				
				menuBar.add(menuEdiciones);
			}			

			setJMenuBar(menuBar);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void menuCanceled(MenuEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void menuDeselected(MenuEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void menuSelected(MenuEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == this.menuItemGenerarColocacion) {
			getContentPane().removeAll();
			getContentPane().add(new PanelColocacion());
		} else if (event.getSource() == this.itemAltaEdicion) {
			getContentPane().removeAll();
			getContentPane().add(new panelAltaEdicion());
		} else if (event.getSource() == this.itemModEdicion) {
			getContentPane().removeAll();
			getContentPane().add(new ModificarEdicion());
		}
		getContentPane().revalidate();
		getContentPane().repaint();
	}
}
