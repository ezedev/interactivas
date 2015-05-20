package ventanas;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.ComboItem;
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
public class panelAltaEdicion extends javax.swing.JPanel implements ActionListener{
	private JLabel lblPublicacion;
	private JComboBox cmbPublicaciones;
	private JLabel lblTituloTapa;
	private JTextField txtFechaSalida;
	private JLabel lblAltaEdicion;
	private JButton btnCrear;
	private JTextField txtPrecio;
	private JLabel lblPrecio;
	private JLabel lblFechaSalida;
	private JTextField txtTituloTapa;
	private JTextField txtCodigo;
	private JLabel lblCodigo;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new panelAltaEdicion());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public panelAltaEdicion() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(454, 300));
			this.setLayout(null);
			{
				lblPublicacion = new JLabel();
				this.add(lblPublicacion);
				lblPublicacion.setText("Publicacion:");
				lblPublicacion.setBounds(48, 40, 89, 16);
			}
			{
				ComboBoxModel cmbPublicacionesModel = 
						new DefaultComboBoxModel(Sistema.getInstance().listaPublicaciones());
				cmbPublicaciones = new JComboBox();
				this.add(cmbPublicaciones);
				cmbPublicaciones.setModel(cmbPublicacionesModel);
				cmbPublicaciones.setBounds(174, 37, 78, 23);
			}
			{
				lblCodigo = new JLabel();
				this.add(lblCodigo);
				lblCodigo.setText("Codigo:");
				lblCodigo.setBounds(76, 73, 61, 16);
			}
			{
				txtCodigo = new JTextField();
				this.add(txtCodigo);
				txtCodigo.setBounds(174, 70, 78, 23);
			}
			{
				lblTituloTapa = new JLabel();
				this.add(lblTituloTapa);
				lblTituloTapa.setText("Titulo de tapa:");
				lblTituloTapa.setBounds(42, 113, 101, 16);
			}
			{
				txtTituloTapa = new JTextField();
				this.add(txtTituloTapa);
				txtTituloTapa.setBounds(174, 110, 78, 23);
			}
			{
				lblFechaSalida = new JLabel();
				this.add(lblFechaSalida);
				lblFechaSalida.setText("Fecha de salida:");
				lblFechaSalida.setBounds(31, 152, 112, 16);
			}
			{
				txtFechaSalida = new JTextField();
				this.add(txtFechaSalida);
				txtFechaSalida.setBounds(174, 149, 78, 23);
			}
			{
				lblPrecio = new JLabel();
				this.add(lblPrecio);
				lblPrecio.setText("Precio:");
				lblPrecio.setBounds(82, 188, 55, 16);
			}
			{
				txtPrecio = new JTextField();
				this.add(txtPrecio);
				txtPrecio.setBounds(174, 185, 78, 23);
			}
			{
				btnCrear = new JButton();
				btnCrear.addActionListener(this);
				this.add(btnCrear);
				btnCrear.setText("Crear Edicion");
				btnCrear.setBounds(174, 242, 84, 23);
			}
			{
				lblAltaEdicion = new JLabel();
				this.add(lblAltaEdicion);
				lblAltaEdicion.setText("Alta de edicion");
				lblAltaEdicion.setBounds(18, 12, 112, 16);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		if(arg0.getSource() == btnCrear) {
			
			ComboItem selected = (ComboItem)cmbPublicaciones.getSelectedItem();
			
			Sistema.getInstance().altaEdicion(
				txtCodigo.getText(), 
				txtTituloTapa.getText(), 
				Float.parseFloat(txtPrecio.getText()), 
				new Date(), 
				selected.getValue()
			);
		}
	}
}
