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

public class PanelDevolucion extends javax.swing.JPanel implements ActionListener {

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	
	private JLabel fechaLabel;
	private JLabel edicionLabel;
	static private PanelDevolucion panelDevolucion;
	private JTextField fechaTextField;
	private JTextField edicionTextField;
	static private JButton buscar;
	static private JButton confirmar;
	private JTable colocacionesTable;
	static private JScrollPane tabelPanel;

	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new PanelDevolucion());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
	
	
	public PanelDevolucion() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
//			this.setPreferredSize(new java.awt.Dimension(454, 300));
//			this.setLayout(null);
//			this.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			
			panelDevolucion = this;
			panelDevolucion.setBounds(0, 0, 770, 557);
			panelDevolucion.setLayout(null);
			panelDevolucion.setBackground(new java.awt.Color(219,238,249));
			{
				fechaLabel = new JLabel();
				panelDevolucion.add(fechaLabel);
				fechaLabel.setText("Fecha: ");
				fechaLabel.setBounds(20, 30, 82, 16);
			}
			{
				fechaTextField = new JTextField();
				panelDevolucion.add(fechaTextField);
				fechaTextField.setText("DD/MM/AAAA");
				fechaTextField.setBounds(100, 30, 100, 16);
			}
			{
				edicionLabel = new JLabel();
				panelDevolucion.add(edicionLabel);
				edicionLabel.setText("Edicion: ");
				edicionLabel.setBounds(220, 30, 82, 16);				
			}
			{
				edicionTextField = new JTextField();
				panelDevolucion.add(edicionTextField);
				edicionTextField.setText("XXXXXXXXXX");
				edicionTextField.setBounds(300, 30, 82, 16);				
			}
			{	buscar = new JButton();
				panelDevolucion.add(buscar);
				buscar.setText("Buscar");
				buscar.addActionListener(this);
				buscar.setBounds(20, 60, 82, 16);
			}
			
			{	
				confirmar = new JButton();
				panelDevolucion.add(confirmar);
				confirmar.setText("Confirmar");
				confirmar.addActionListener(this);
				confirmar.setBounds(400, 30, 120, 16);
		}			
			
			{
				colocacionesTable = new JTable();
			}
			{
				tabelPanel = new JScrollPane(colocacionesTable);
				panelDevolucion.add(tabelPanel);
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
		
		if(event.getSource() == buscar){
			
			Date fecha = Utils.parseFecha(fechaTextField.getText());
			String codEdicion = edicionTextField.getText();
			Vector<CargaVendedorView> cargas = Sistema.getInstance().buscarColocacion(fecha, codEdicion);	
			DevolucionTableModel model = new DevolucionTableModel(cargas);
			colocacionesTable.setModel(model);
			colocacionesTable.setPreferredSize(new java.awt.Dimension(499, 326));
			
		} else if (event.getSource() == confirmar) {
			
			DevolucionTableModel model = (DevolucionTableModel)colocacionesTable.getModel();
			
			Sistema.getInstance().confirmarDevolucion(model.getCargas());
		}
	}
	

}
