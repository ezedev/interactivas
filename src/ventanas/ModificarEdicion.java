package ventanas;
//import com.cloudgarden.layout.AnchorLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

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

import controlador.Sistema;
import modelo.ComboItem;
import modelo.EdicionView;
import modelo.Vendedor;


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
public class ModificarEdicion extends javax.swing.JPanel implements ActionListener{
	static private ModificarEdicion PanelPrincipal;
	
	static private JComboBox<ComboItem> cmbPublicaciones;
	static private JLabel lblFecha;
	static private JLabel lblPublicacionDet;
	static private JButton BtnCancelar;
	static private JTextField txtPrecio;
	static private JTextField jTextField1;
	static private JTextField txtTituloTapa;
	static private JTextField txtCodigo;
	static private JComboBox<ComboItem> cmbPublicacionDetalle;
	static private JButton btnModificar;
	static private JLabel lblPrecio;
	static private JLabel lblFechaSalida;
	static private JLabel lblTituloTapa;
	static private JLabel lblCodigo;
	static private JPanel panelDetalleEdicion;
	static private JButton btnBuscar;
	static private JTextField txtFecha;
	static private JLabel lblPublicacion;
	static private JPanel panelBuscarPub;

	/**
	* Auto-generated main method to display this JFrame
	*/

	
	public ModificarEdicion() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {

			PanelPrincipal = this;
			FlowLayout thisLayout = new FlowLayout();
			PanelPrincipal.setLayout(null);
			PanelPrincipal.setBackground(new java.awt.Color(219,238,249));
			
			{
				
				PanelPrincipal.setPreferredSize(new java.awt.Dimension(391, 295));
				{
					panelBuscarPub = new JPanel();
					PanelPrincipal.add(panelBuscarPub);
					panelBuscarPub.setLayout(null);
					panelBuscarPub.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
					panelBuscarPub.setBounds(0, 0, 372, 100);
					panelBuscarPub.setPreferredSize(new java.awt.Dimension(791, 117));
					panelBuscarPub.setEnabled(true);
					{
						lblPublicacion = new JLabel();
						panelBuscarPub.add(lblPublicacion);
						lblPublicacion.setText("Publicacion:");
						lblPublicacion.setBounds(19, 24, 108, 16);
					}
					{
						
						cmbPublicaciones = new JComboBox<ComboItem>(Sistema.getInstance().listaPublicaciones());
						

					
						panelBuscarPub.add(cmbPublicaciones);
						
						cmbPublicaciones.setBounds(133, 19, 280, 26);
					}
					{
						lblFecha = new JLabel();
						panelBuscarPub.add(lblFecha);
						lblFecha.setText("Fecha salida:");
						lblFecha.setBounds(440, 25, 98, 16);
					}
					{
						txtFecha = new JTextField();
						panelBuscarPub.add(txtFecha);
			
						txtFecha.setText(Sistema.getInstance().getStringFechaSalida());
						txtFecha.setBounds(544, 22, 110, 23);
						txtFecha.setEditable(false);
					}
					{
						btnBuscar = new JButton();
						panelBuscarPub.add(btnBuscar);
						btnBuscar.setText("Buscar");
						btnBuscar.addActionListener(this);
						btnBuscar.setBounds(531, 70, 82, 23);
					}
					{
						BtnCancelar = new JButton();
						panelBuscarPub.add(BtnCancelar);
						BtnCancelar.setText("Cancelar");
						BtnCancelar.setBounds(638, 70, 94, 23);
				
						BtnCancelar.addActionListener(this);
					}
				}
				
				{
					panelDetalleEdicion = new JPanel();
					PanelPrincipal.add(panelDetalleEdicion);
					panelDetalleEdicion.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
					panelDetalleEdicion.setLayout(null);
					panelDetalleEdicion.setBounds(0, 0, 373, 182);
					panelDetalleEdicion.setPreferredSize(new java.awt.Dimension(769, 213));
					panelDetalleEdicion.setEnabled(true);
					{
						lblPublicacionDet = new JLabel();
						panelDetalleEdicion.add(lblPublicacionDet);
						lblPublicacionDet.setText("Publicacion:");
						lblPublicacionDet.setBounds(27, 14, 97, 16);
					}
					{
						lblCodigo = new JLabel();
						panelDetalleEdicion.add(lblCodigo);
						lblCodigo.setText("Codigo:");
						lblCodigo.setBounds(50, 43, 74, 16);
					}
					{
						lblTituloTapa = new JLabel();
						panelDetalleEdicion.add(lblTituloTapa);
						lblTituloTapa.setText("Titulo tapa:");
						lblTituloTapa.setBounds(30, 74, 99, 16);
					}
					{
						lblFechaSalida = new JLabel();
						panelDetalleEdicion.add(lblFechaSalida);
						lblFechaSalida.setText("Fecha salida");
						lblFechaSalida.setBounds(27, 109, 102, 16);
					}
					{
						lblPrecio = new JLabel();
						panelDetalleEdicion.add(lblPrecio);
						lblPrecio.setText("Precio($):");
						lblPrecio.setBounds(39, 141, 90, 16);
					}
					{
						btnModificar = new JButton();
						panelDetalleEdicion.add(btnModificar);
						btnModificar.setText("Modificar");
						btnModificar.setBounds(481, 168, 108, 23);
					}
					{

						cmbPublicacionDetalle = new JComboBox<ComboItem>(Sistema.getInstance().listaPublicaciones());
						
						panelDetalleEdicion.add(cmbPublicacionDetalle);
						
						cmbPublicacionDetalle.setBounds(136, 11, 228, 23);
					}
					{
						txtCodigo = new JTextField();
						panelDetalleEdicion.add(txtCodigo);
						txtCodigo.setBounds(136, 40, 89, 23);
					}
					{
						txtTituloTapa = new JTextField();
						panelDetalleEdicion.add(txtTituloTapa);
						txtTituloTapa.setBounds(136, 71, 174, 23);
					}
					{
						jTextField1 = new JTextField();
						panelDetalleEdicion.add(jTextField1);
						jTextField1.setBounds(136, 106, 86, 22);
					}
					{
						txtPrecio = new JTextField();
						panelDetalleEdicion.add(txtPrecio);
						txtPrecio.setBounds(136, 134, 77, 23);
					}
				}
			}
			//pack();
			setSize(400, 300);
			this.setPreferredSize(new java.awt.Dimension(557, 351));
			this.setLayout(thisLayout);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void limpiarPantalla (){
		try{
			JPanel panelInicial = this;
			panelInicial.removeAll();
			panelInicial.setBounds(0, 0, 770, 557);
			panelInicial.setLayout(null);
			panelInicial.setBackground(new java.awt.Color(64,128,128));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource()==this.BtnCancelar){
			limpiarPantalla();
		}
		else{
			if(event.getSource()==this.btnBuscar){
				ComboItem item = (ComboItem) cmbPublicaciones.getSelectedItem();
				EdicionView edicionView = Sistema.getInstance().buscarEdicionXPublicacion(item.getValue());
			    cmbPublicacionDetalle.setSelectedItem(new ComboItem(edicionView.getCodigo(),edicionView.getPublicacion().getTitulo()) );
				txtTituloTapa.setText(edicionView.getTituloTapa());
				 txtCodigo.setText(edicionView.getCodigo());
				
				 txtPrecio.setText( String.valueOf(edicionView.getPrecio()));
				 txtFecha.setText( edicionView.getFechaSalida().toString());

			}
			
		}
		

		
	}
	
	
}
