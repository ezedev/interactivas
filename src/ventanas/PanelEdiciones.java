package ventanas;
//import com.cloudgarden.layout.AnchorLayout;
//import com.jgoodies.forms.layout.FormLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
//
//import info.clearthought.layout.TableLayout;


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
public class PanelEdiciones extends javax.swing.JPanel implements ActionListener{
	static private PanelEdiciones panelEdiciones_IL;
	static private JPanel JPanelEdiciones;
	static private JButton jButtonBaja;
	static private JButton jButtonModificacion;
	static private JLabel jLabelTitulo;
	static private JButton jButtonAlta;

	/**
	* Auto-generated main method to display this JFrame
	*/
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				PanelEdiciones inst = new PanelEdiciones();
//				inst.setLocationRelativeTo(null);
//				inst.setVisible(true);
//			}
//		});
//	}
	
	public PanelEdiciones() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
//			getContentPane().setLayout(null);
//			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			
//				JPanelEdiciones = new JPanel();
//				getContentPane().add(JPanelEdiciones);
//				JPanelEdiciones.setBounds(0, 0, 384, 262);
//				JPanelEdiciones.setLayout(null);
//				JPanelEdiciones.setBackground(new java.awt.Color(219,238,249));
//				JPanelEdiciones.setPreferredSize(new java.awt.Dimension(367, 244));
				
				panelEdiciones_IL = this;
				panelEdiciones_IL.setBounds(0, 0, 770, 557);
				panelEdiciones_IL.setLayout(null);
				panelEdiciones_IL.setBackground(new java.awt.Color(219,238,249));
				{
					jButtonAlta = new JButton();
					panelEdiciones_IL.add(jButtonAlta);
					jButtonAlta.setText("Alta");
					jButtonAlta.setBounds(33, 46, 74, 23);
				}
				{
					jButtonBaja = new JButton();
					panelEdiciones_IL.add(jButtonBaja);
					jButtonBaja.setText("Baja");
					jButtonBaja.setBounds(33, 89, 74, 23);
				}
				{
					jButtonModificacion = new JButton();
					panelEdiciones_IL.add(jButtonModificacion);
					jButtonModificacion.setText("Modificación");
					jButtonModificacion.setBounds(33, 133, 84, 23);
				}
				{
					jLabelTitulo = new JLabel();
					panelEdiciones_IL.add(jLabelTitulo);
					jLabelTitulo.setText("Ediciones");
					jLabelTitulo.setBounds(25, 7, 148, 16);
					jLabelTitulo.setFont(new java.awt.Font("Segoe UI",1,16));
				}
			
//			pack();
//			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
