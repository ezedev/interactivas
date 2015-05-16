package ventanas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

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

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	/*public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setSize(770, 557);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setPreferredSize(new java.awt.Dimension(770, 557));
		{
			panelColocacion_IL = new PanelColocacion();
			frame.getContentPane().add(panelColocacion_IL);
			panelColocacion_IL.setBounds(0, 0, 770, 557);
			panelColocacion_IL.setLayout(null);
			{
				publicacionLabel = new JLabel();
				panelColocacion_IL.add(publicacionLabel);
				publicacionLabel.setText("Publicación: ");
				publicacionLabel.setBounds(12, 50, 109, 19);
			}
			{
				ComboBoxModel publicacionesComboBoxModel = 
						new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
				publicacionesComboBox = new JComboBox();
				panelColocacion_IL.add(publicacionesComboBox);
				publicacionesComboBox.setModel(publicacionesComboBoxModel);
				publicacionesComboBox.setBounds(219, 66, 108, 23);
			}
			{
				fechaLabel = new JLabel();
				panelColocacion_IL.add(fechaLabel);
				fechaLabel.setText("Fecha de salida:");
				fechaLabel.setBounds(348, 30, 83, 16);
			}
			{
				fechaTextField = new JTextField();
				panelColocacion_IL.add(fechaTextField);
				fechaTextField.setText("DD/MM/AAAA");
				fechaTextField.setBounds(449, 27, 86, 23);
			}
			{
				edicionLabel = new JLabel();
				panelColocacion_IL.add(edicionLabel);
				edicionLabel.setText("Edicion: ");
				edicionLabel.setBounds(20, 69, 45, 16);
			}
			{
				tituloEdicionLabel = new JLabel();
				panelColocacion_IL.add(tituloEdicionLabel);
				tituloEdicionLabel.setText("...");
				tituloEdicionLabel.setBounds(102, 69, 99, 16);
			}
			{
				totalLabel = new JLabel();
				panelColocacion_IL.add(totalLabel);
				totalLabel.setText("Total: ");
				totalLabel.setBounds(412, 450, 52, 16);
			}
			{
				totalColocacionLabel = new JLabel();
				panelColocacion_IL.add(totalColocacionLabel);
				totalColocacionLabel.setText("...");
				totalColocacionLabel.setBounds(470, 450, 56, 16);
			}
			{
				pautaLabel = new JLabel();
				panelColocacion_IL.add(pautaLabel);
				pautaLabel.setText("Pautas: ");
				pautaLabel.setBounds(547, 122, 41, 16);
			}
			{
				ComboBoxModel pautasComboBoxModel = 
						new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
				pautasComboBox = new JComboBox();
				panelColocacion_IL.add(pautasComboBox);
				pautasComboBox.setModel(pautasComboBoxModel);
				pautasComboBox.setBounds(630, 119, 109, 23);
			}
			{
				aplicarButton = new JButton();
				panelColocacion_IL.add(aplicarButton);
				aplicarButton.setText("Aplicar");
				aplicarButton.setBounds(547, 181, 83, 23);
			}
			{
				guardarButton = new JButton();
				panelColocacion_IL.add(guardarButton);
				guardarButton.setText("Guardar");
				guardarButton.setBounds(558, 447, 70, 23);
				guardarButton.setSize(83, 23);
			}
			{
				tabelPanel = new JPanel();
				panelColocacion_IL.add(tabelPanel);
				tabelPanel.setBounds(12, 91, 508, 339);
				{
					TableModel vendedoresTableModel = 
							new DefaultTableModel(
									new String[][] { { "One", "Two" }, { "Three", "Four" } },
									new String[] { "Column 1", "Column 2", "Column3", "Column 4", "Column 5" });
					vendedoresTable = new JTable();
					tabelPanel.add(vendedoresTable);
					vendedoresTable.setModel(vendedoresTableModel);
					vendedoresTable.setPreferredSize(new java.awt.Dimension(499, 326));
				}
			}
			{
				cancelarJButton = new JButton();
				panelColocacion_IL.add(cancelarJButton);
				cancelarJButton.setText("Cancelar");
				cancelarJButton.setBounds(656, 447, 83, 23);
			}
			{
				limpiarButton = new JButton();
				panelColocacion_IL.add(limpiarButton);
				limpiarButton.setText("Limpiar");
				limpiarButton.setBounds(654, 181, 70, 23);
				limpiarButton.setOpaque(false);
				limpiarButton.setSize(83, 23);
			}
		}
	}
	*/
	public PanelColocacion() {
		super();
		initGUI();
	}
	
	
	//Función que utiliza el botón cancelar para volver a la pantalla inicial
	
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
				publicacionLabel.setText("Publicación: ");
				publicacionLabel.setBounds(20, 30, 82, 16);
			}
			{
//				ComboBoxModel publicacionesComboBoxModel = 
//						new DefaultComboBoxModel(Sistema.getInstance().listaPublicaciones());
				publicacionesComboBox = new JComboBox<ComboItem>(Sistema.getInstance().listaPublicaciones());
				panelColocacion_IL.add(publicacionesComboBox);
//				publicacionesComboBox.setModel(publicacionesComboBoxModel);
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
			}
			{
				{
//					TableModel vendedoresTableModel = 
//							new DefaultTableModel(
//									new String[][] { { "One", "Two" }, { "Three", "Four" } },
//									new String[] { "Column 1", "Column 2", "Column3", "Column 4", "Column 5" });
					vendedoresTable = new JTable();
//					tabelPanel.add(vendedoresTable);
					vendedoresTable.setModel((new TablaVendedoresModel()).getModel());
					vendedoresTable.getColumnModel().getColumn(1).setCellRenderer(new CeldaColorRenderer(Utils.COLOR_VERDE_CELDA));
					vendedoresTable.getColumnModel().getColumn(3).setCellRenderer(new CeldaColorRenderer(Utils.COLOR_VERDE_CELDA));
					vendedoresTable.getColumnModel().getColumn(5).setCellRenderer(new CeldaColorRenderer(Utils.COLOR_VERDE_CELDA));
					vendedoresTable.getColumnModel().getColumn(2).setCellRenderer(new CeldaColorRenderer(Utils.COLOR_ROJO_CELDA));
					vendedoresTable.getColumnModel().getColumn(4).setCellRenderer(new CeldaColorRenderer(Utils.COLOR_ROJO_CELDA));
					vendedoresTable.getColumnModel().getColumn(6).setCellRenderer(new CeldaColorRenderer(Utils.COLOR_ROJO_CELDA));
					vendedoresTable.setPreferredSize(new java.awt.Dimension(499, 326));
				}
				tabelPanel = new JScrollPane(vendedoresTable);
				panelColocacion_IL.add(tabelPanel);
				tabelPanel.setBounds(16, 91, 508, 339);
			}
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
		// TODO Auto-generated method stub
		if(event.getSource()==this.cancelarJButton){
			limpiarPantalla();
		}else{
			if(event.getSource()==this.publicacionesComboBox){	
				ComboItem item = (ComboItem) publicacionesComboBox.getSelectedItem();
				EdicionView edicionView = Sistema.getInstance().buscarEdicionXPublicacion(item.getValue());
				tituloEdicionLabel.setText(edicionView.getTituloTapa());
			}
		}
	}


}
