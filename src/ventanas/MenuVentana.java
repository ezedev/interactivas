package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import controlador.Sistema;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class MenuVentana extends javax.swing.JFrame implements MenuListener, ActionListener{
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
			this.setSize(770, 557);
			setTitle("Sistema de colocacion de ediciones");
			getContentPane().setBackground(new java.awt.Color(64,128,128));
			this.setPreferredSize(new java.awt.Dimension(770, 557));
			this.setResizable(false);

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
			this.menuItemGenerarColocacion.addActionListener(this);
			
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
		if(event.getSource()==this.menuItemGenerarColocacion){
			getContentPane().removeAll();
			getContentPane().add(new PanelColocacion());
		}
		getContentPane().revalidate();
		getContentPane().repaint();
	}
	
}
