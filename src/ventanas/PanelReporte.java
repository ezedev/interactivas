package ventanas;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;

import persistencia.CargaVendedorView;
import controlador.Sistema;

public class PanelReporte extends javax.swing.JPanel implements ActionListener {

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	
	private JLabel fechaLabel;
	static private PanelReporte panelReporte;
	private JTextField fechaTextField;
	static private JButton buscar;
	private JTable colocacionesTable;
	private Vector<String> titulos = new Vector<String>();
	static private JScrollPane tabelPanel;

	
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.getContentPane().add(new PanelReporte());
//		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//		frame.pack();
//		frame.setVisible(true);
//	}
	
	
	public PanelReporte() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
//			this.setPreferredSize(new java.awt.Dimension(454, 300));
//			this.setLayout(null);
//			this.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			
			panelReporte = this;
			panelReporte.setBounds(0, 0, 770, 557);
			panelReporte.setLayout(null);
			panelReporte.setBackground(new java.awt.Color(219,238,249));
			{
				fechaLabel = new JLabel();
				panelReporte.add(fechaLabel);
				fechaLabel.setText("Fecha: ");
				fechaLabel.setBounds(20, 30, 82, 16);
			}
			{
				fechaTextField = new JTextField();
				panelReporte.add(fechaTextField);
				fechaTextField.setText("");
				fechaTextField.setBounds(100, 30, 82, 16);
			}
			{	buscar = new JButton();
				panelReporte.add(buscar);
				buscar.setText("Buscar");
				buscar.addActionListener(this);
				buscar.setBounds(20, 60, 82, 16);
			}
			{
				colocacionesTable = new JTable();
			}
			{
				tabelPanel = new JScrollPane(colocacionesTable);
				panelReporte.add(tabelPanel);
				tabelPanel.setBounds(16, 91, 508, 339);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void actionPerformed(ActionEvent event) {

		/**
		 * Si hay que cerrar la funcionalidad
		 */
		
		if(event.getSource() == this.buscar){
			Date fecha = Utils.parseFecha(fechaTextField.getText());
			Sistema.getInstance().buscarColocacionPorFecha(fecha);
			titulos.add("Edicion");
			titulos.add("Vendedor");
			titulos.add("Entrega");
			titulos.add("Devolucion");			
			ReporteColocacionTableModel model = new ReporteColocacionTableModel(Sistema.getInstance().buscarColocacionPorFecha(fecha));
			colocacionesTable.setModel(model);
			colocacionesTable.setPreferredSize(new java.awt.Dimension(499, 326));	
		}
	}
	

}
