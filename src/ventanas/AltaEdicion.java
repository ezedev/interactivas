package ventanas;
import com.cloudgarden.layout.AnchorLayout;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.SwingUtilities;


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
public class AltaEdicion extends javax.swing.JPanel {
	private JPanel PanelPrincipal;
	private JComboBox cmbPublicaciones;
	private JLabel lblFecha;
	private JLabel lblPublicacionDet;
	private JTextField txtPrecio;
	private JTextField jTextField1;
	private JTextField txtTituloTapa;
	private JTextField txtCodigo;
	private JComboBox cmbPublicacionDetalle;
	private JButton btnModificar;
	private JLabel lblPrecio;
	private JLabel lblFechaSalida;
	private JLabel lblTituloTapa;
	private JLabel lblCodigo;
	private JPanel panelDetalleEdicion;
	private JButton btnBuscar;
	private JTextField txtFecha;
	private JLabel lblPublicacion;
	private JPanel panelBuscarPub;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AltaEdicion inst = new AltaEdicion();
				//inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AltaEdicion() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {

			PanelPrincipal = this;
			PanelPrincipal.setLayout(null);
			PanelPrincipal.setBackground(new java.awt.Color(219,238,249));
			
			{
				PanelPrincipal = new JPanel();
				PanelPrincipal.setPreferredSize(new java.awt.Dimension(391, 295));
				{
					panelBuscarPub = new JPanel();
					PanelPrincipal.add(panelBuscarPub);
					panelBuscarPub.setLayout(null);
					panelBuscarPub.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
					panelBuscarPub.setBounds(6, 12, 372, 67);
					panelBuscarPub.setPreferredSize(new java.awt.Dimension(389, 100));
					{
						lblPublicacion = new JLabel();
						panelBuscarPub.add(lblPublicacion);
						lblPublicacion.setText("Publicacion:");
						lblPublicacion.setBounds(14, 14, 65, 16);
					}
					{
						ComboBoxModel cmbPublicacionesModel = 
								new DefaultComboBoxModel(
										new String[] { "Item One", "Item Two" });
						cmbPublicaciones = new JComboBox();
						panelBuscarPub.add(cmbPublicaciones);
						cmbPublicaciones.setModel(cmbPublicacionesModel);
						cmbPublicaciones.setBounds(91, 11, 66, 23);
					}
					{
						lblFecha = new JLabel();
						panelBuscarPub.add(lblFecha);
						lblFecha.setText("Fecha salida:");
						lblFecha.setBounds(216, 14, 67, 16);
					}
					{
						txtFecha = new JTextField();
						panelBuscarPub.add(txtFecha);
						txtFecha.setText("jTextField1");
						txtFecha.setBounds(301, 11, 62, 23);
						txtFecha.setEditable(false);
					}
					{
						btnBuscar = new JButton();
						panelBuscarPub.add(btnBuscar);
						btnBuscar.setText("Buscar");
						btnBuscar.setBounds(265, 40, 49, 23);
					}
				}
				//getContentPane().add(PanelPrincipal);
				{
					panelDetalleEdicion = new JPanel();
					PanelPrincipal.add(panelDetalleEdicion);
					panelDetalleEdicion.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
					panelDetalleEdicion.setLayout(null);
					panelDetalleEdicion.setBounds(6, 101, 373, 182);
					panelDetalleEdicion.setPreferredSize(new java.awt.Dimension(385, 185));
					{
						lblPublicacionDet = new JLabel();
						panelDetalleEdicion.add(lblPublicacionDet);
						lblPublicacionDet.setText("Publicacion:");
						lblPublicacionDet.setBounds(23, 14, 65, 16);
					}
					{
						lblCodigo = new JLabel();
						panelDetalleEdicion.add(lblCodigo);
						lblCodigo.setText("Codigo:");
						lblCodigo.setBounds(39, 43, 42, 16);
					}
					{
						lblTituloTapa = new JLabel();
						panelDetalleEdicion.add(lblTituloTapa);
						lblTituloTapa.setText("Titulo tapa:");
						lblTituloTapa.setBounds(27, 74, 61, 16);
					}
					{
						lblFechaSalida = new JLabel();
						panelDetalleEdicion.add(lblFechaSalida);
						lblFechaSalida.setText("Fecha salida");
						lblFechaSalida.setBounds(27, 102, 64, 16);
					}
					{
						lblPrecio = new JLabel();
						panelDetalleEdicion.add(lblPrecio);
						lblPrecio.setText("Precio($):");
						lblPrecio.setBounds(39, 137, 52, 16);
					}
					{
						btnModificar = new JButton();
						panelDetalleEdicion.add(btnModificar);
						btnModificar.setText("Modificar");
						btnModificar.setBounds(295, 146, 65, 23);
					}
					{
						ComboBoxModel cmbPublicacionDetalleModel = 
								new DefaultComboBoxModel(
										new String[] { "Item One", "Item Two" });
						cmbPublicacionDetalle = new JComboBox();
						panelDetalleEdicion.add(cmbPublicacionDetalle);
						cmbPublicacionDetalle.setModel(cmbPublicacionDetalleModel);
						cmbPublicacionDetalle.setBounds(106, 11, 80, 23);
					}
					{
						txtCodigo = new JTextField();
						panelDetalleEdicion.add(txtCodigo);
						txtCodigo.setBounds(106, 40, 80, 23);
					}
					{
						txtTituloTapa = new JTextField();
						panelDetalleEdicion.add(txtTituloTapa);
						txtTituloTapa.setBounds(106, 71, 80, 23);
					}
					{
						jTextField1 = new JTextField();
						panelDetalleEdicion.add(jTextField1);
						jTextField1.setBounds(103, 99, 86, 22);
					}
					{
						txtPrecio = new JTextField();
						panelDetalleEdicion.add(txtPrecio);
						txtPrecio.setBounds(109, 134, 77, 23);
					}
				}
			}
			//pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
