package ventanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import modelo.ComboItem;
import modelo.EdicionView;
import persistencia.CargaVendedorView;
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
public class PanelColocacion extends javax.swing.JPanel implements ActionListener {
	static private PanelColocacion panelColocacion_IL;
	static private JLabel publicacionLabel;
	static private JLabel fechaLabel;
	static private JLabel fechaSalidaLabel;
	static private JButton limpiarButton;
	static private JButton cancelarJButton;
	static private JTable vendedoresTable;
	static private JScrollPane tabelPanel;
	static private JButton guardarButton;
	static private JLabel totalLabel;
	static private JButton aplicarButton;
	static private JComboBox<ComboItem> pautasComboBox;
	static private JLabel pautaLabel;
	static private JLabel totalColocacionLabel;
	static private JLabel tituloEdicionLabel;
	static private JLabel edicionLabel;
	static private JComboBox<ComboItem> publicacionesComboBox;
	
	private Vector<String> titulos = new Vector<String>();

	public PanelColocacion() {
		super();
		initGUI();
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
	
	
	private void initGUI() {
		try {
			panelColocacion_IL = this;
			panelColocacion_IL.setBounds(0, 0, 770, 557);
			panelColocacion_IL.setLayout(null);
			panelColocacion_IL.setBackground(new java.awt.Color(219,238,249));
			{
				publicacionLabel = new JLabel();
				panelColocacion_IL.add(publicacionLabel);
				publicacionLabel.setText("Publicaci�n: ");
				publicacionLabel.setBounds(20, 30, 82, 16);
			}
			{
				publicacionesComboBox = new JComboBox<ComboItem>(Sistema.getInstance().listaPublicaciones());
				panelColocacion_IL.add(publicacionesComboBox);
				publicacionesComboBox.setBounds(102, 27, 108, 23);
				publicacionesComboBox.addActionListener(this);
			}
			{
				fechaLabel = new JLabel();
				panelColocacion_IL.add(fechaLabel);
				fechaLabel.setText("Fecha de salida:");
				fechaLabel.setBounds(348, 30, 95, 16);
			}
			{
				fechaSalidaLabel = new JLabel();
				panelColocacion_IL.add(fechaSalidaLabel);
				fechaSalidaLabel.setText(Sistema.getInstance().getStringFechaSalida());
				fechaSalidaLabel.setBounds(450, 30, 82, 16);
			}
			{
				edicionLabel = new JLabel();
				panelColocacion_IL.add(edicionLabel);
				edicionLabel.setText("Edicion: ");
				edicionLabel.setBounds(20, 69, 82, 16);
			}
			{
				tituloEdicionLabel = new JLabel();
				panelColocacion_IL.add(tituloEdicionLabel);
				tituloEdicionLabel.setText("");
				tituloEdicionLabel.setBounds(102, 69, 100, 16);
			}
			{
				totalLabel = new JLabel();
				panelColocacion_IL.add(totalLabel);
				totalLabel.setText("Total: ");
				totalLabel.setBounds(461, 442, 50, 16);
			}
			{
				totalColocacionLabel = new JLabel();
				panelColocacion_IL.add(totalColocacionLabel);
				totalColocacionLabel.setText("...");
				totalColocacionLabel.setBounds(506, 442, 56, 16);
			}
			{
				pautaLabel = new JLabel();
				panelColocacion_IL.add(pautaLabel);
				pautaLabel.setText("Pautas: ");
				pautaLabel.setBounds(547, 122, 82, 16);
			}
			{
				ComboBoxModel pautasComboBoxModel = 
						new DefaultComboBoxModel();
				pautasComboBox = new JComboBox();
				panelColocacion_IL.add(pautasComboBox);
				pautasComboBox.setModel(pautasComboBoxModel);
				pautasComboBox.setBounds(600, 119, 140, 23);
			}
			{
				aplicarButton = new JButton();
				panelColocacion_IL.add(aplicarButton);
				aplicarButton.setText("Aplicar");
				aplicarButton.setBounds(547, 250, 90, 23);
				aplicarButton.setSize(90, 23);
			}
			{
				guardarButton = new JButton();
				panelColocacion_IL.add(guardarButton);
				guardarButton.setText("Guardar");
				guardarButton.setBounds(547, 360, 90, 23);
				guardarButton.setSize(90, 23);
				guardarButton.addActionListener(this);
			}
			{
				vendedoresTable = new JTable();
				titulos.add("Codigo");
				titulos.add("Direccion");
				titulos.add("C1");
				titulos.add("D1");
				titulos.add("C2");
				titulos.add("D2");
				titulos.add("C3");
				titulos.add("D3");
				titulos.add("Salida");
				
				CargaVendedorTableModel model = new CargaVendedorTableModel(titulos, new Vector<CargaVendedorView>());
				vendedoresTable.setModel(model);
				vendedoresTable.setPreferredSize(new java.awt.Dimension(499, 326));				
			}
				tabelPanel = new JScrollPane(vendedoresTable);
				panelColocacion_IL.add(tabelPanel);
				tabelPanel.setBounds(16, 91, 508, 339);
			{
				cancelarJButton = new JButton();
				panelColocacion_IL.add(cancelarJButton);
				cancelarJButton.setText("Cancelar");
				cancelarJButton.addActionListener(this);
				cancelarJButton.setBounds(670, 360, 90, 23);
			}
			{
				limpiarButton = new JButton();
				panelColocacion_IL.add(limpiarButton);
				limpiarButton.setText("Limpiar");
				limpiarButton.setBounds(670, 250, 90, 23);
				limpiarButton.setSize(90, 23);
				limpiarButton.setOpaque(false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void actionPerformed(ActionEvent event) {

		/**
		 * Si hay que cerrar la funcionalidad
		 */
		
		if(event.getSource() == this.cancelarJButton){
			
			limpiarPantalla();
			
		/**
		 * Si se selecciono una publiocacion
		 */
			
		}else if(event.getSource() == this.publicacionesComboBox){
			
				ComboItem item = (ComboItem) publicacionesComboBox.getSelectedItem();
				EdicionView edicionView = Sistema.getInstance().buscarUltimaEdicionPorPublicacion(item.getValue());
				tituloEdicionLabel.setText(edicionView.getTituloTapa());
				
				CargaVendedorTableModel model = new CargaVendedorTableModel(titulos, Sistema.getInstance().cargarVendedoresTable(item.getValue()));
				vendedoresTable.setModel(model);
				vendedoresTable.getColumnModel().getColumn(2).setCellRenderer(new CeldaColorRenderer(Utils.COLOR_VERDE_CELDA));
				vendedoresTable.getColumnModel().getColumn(4).setCellRenderer(new CeldaColorRenderer(Utils.COLOR_VERDE_CELDA));
				vendedoresTable.getColumnModel().getColumn(6).setCellRenderer(new CeldaColorRenderer(Utils.COLOR_VERDE_CELDA));
				vendedoresTable.getColumnModel().getColumn(3).setCellRenderer(new CeldaColorRenderer(Utils.COLOR_ROJO_CELDA));
				vendedoresTable.getColumnModel().getColumn(5).setCellRenderer(new CeldaColorRenderer(Utils.COLOR_ROJO_CELDA));
				vendedoresTable.getColumnModel().getColumn(7).setCellRenderer(new CeldaColorRenderer(Utils.COLOR_ROJO_CELDA));
			
		/**
		 * Procesar la colocacion con los datos ingresados 
		 */
				
		} else if(event.getSource() == this.guardarButton) {
			
			Vector<CargaVendedorView> rows = ((CargaVendedorTableModel)vendedoresTable.getModel()).getRows();
			ComboItem item = (ComboItem) publicacionesComboBox.getSelectedItem();
			
			boolean resultadoExitoso = Sistema.getInstance().crearColocacion(rows, item.getValue());
			
			if (!resultadoExitoso) {
				Utils.mostrarError(this, "No se pudieron insertar las cargas en la colocaci�n.");
			}else{
				Utils.mostrarExito(this, "Se ingresaron las cargas exitosamente");
			}
			
		}
	}


}
