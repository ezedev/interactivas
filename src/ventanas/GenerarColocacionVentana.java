package ventanas;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
public class GenerarColocacionVentana extends javax.swing.JFrame {
	private JPanel jPanelTop;
	private JPanel jPanelLeft;
	private JPanel jPanelRight;
	private JLabel jLabelTituloPublicacion;
	private JLabel jLabelTituloEdicion;
	private JButton jButtonAplicar;
	private JButton jButtonCancelar;
	private JButton jButtonGuardar;
	private JComboBox jComboBoxPautasColocacion;
	private JTable jTableColocaciones;
	private JLabel jLabelPautasColocacion;
	private JTextField jTextFieldTotal;
	private JLabel jLabelTotal;
	private JTextField jTextFieldFechaSalida;
	private JLabel jLabelFechaSalida;
	private JTextField jTextFieldTituloEdicion;
	private JComboBox jComboBoxTituloPublicacion;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticXPLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GenerarColocacionVentana inst = new GenerarColocacionVentana();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public GenerarColocacionVentana() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(thisLayout);
			this.setTitle("Generar Colocación");
			{
				jPanelTop = new JPanel();
				getContentPane().add(jPanelTop, BorderLayout.NORTH);
				jPanelTop.setPreferredSize(new java.awt.Dimension(384, 67));
				jPanelTop.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
				jPanelTop.setLayout(null);
				{
					jLabelTituloPublicacion = new JLabel();
					jPanelTop.add(jLabelTituloPublicacion);
					jLabelTituloPublicacion.setText("Título publicación:");
					jLabelTituloPublicacion.setBounds(9, 9, 99, 16);
				}
				{
					ComboBoxModel jComboBoxTituloPublicacionModel = 
							new DefaultComboBoxModel(
									new String[] { "Item One", "Item Two" });
					jComboBoxTituloPublicacion = new JComboBox();
					jPanelTop.add(jComboBoxTituloPublicacion);
					jComboBoxTituloPublicacion.setModel(jComboBoxTituloPublicacionModel);
					jComboBoxTituloPublicacion.setBounds(120, 6, 93, 23);
				}
				{
					jLabelTituloEdicion = new JLabel();
					jPanelTop.add(jLabelTituloEdicion);
					jLabelTituloEdicion.setText("Título edición:");
					jLabelTituloEdicion.setBounds(9, 43, 99, 16);
				}
				{
					jTextFieldTituloEdicion = new JTextField();
					jPanelTop.add(jTextFieldTituloEdicion);
					jTextFieldTituloEdicion.setText("...");
					jTextFieldTituloEdicion.setBounds(92, 40, 80, 23);
				}
				{
					jLabelFechaSalida = new JLabel();
					jPanelTop.add(jLabelFechaSalida);
					jLabelFechaSalida.setText("Fecha Salida:");
					jLabelFechaSalida.setBounds(211, 43, 80, 16);
				}
				{
					jTextFieldFechaSalida = new JTextField();
					jPanelTop.add(jTextFieldFechaSalida);
					jTextFieldFechaSalida.setText("DD/MM/AAAA");
					jTextFieldFechaSalida.setBounds(285, 40, 86, 23);
				}
			}
			{
				jPanelRight = new JPanel();
				getContentPane().add(jPanelRight, BorderLayout.CENTER);
				jPanelRight.setLayout(null);
				jPanelRight.setPreferredSize(new java.awt.Dimension(240, 208));
				jPanelRight.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
				{
					jLabelPautasColocacion = new JLabel();
					FlowLayout jLabelPautasColocacionLayout = new FlowLayout();
					jLabelPautasColocacion.setLayout(null);
					jPanelRight.add(jLabelPautasColocacion);
					jLabelPautasColocacion.setText("Pautas");
					jLabelPautasColocacion.setBounds(11, 9, 35, 16);
				}
				{
					ComboBoxModel jComboBoxPautasColocacionModel = 
							new DefaultComboBoxModel(
									new String[] { "Item One", "Item Two" });
					jComboBoxPautasColocacion = new JComboBox();
					jPanelRight.add(jComboBoxPautasColocacion);
					jComboBoxPautasColocacion.setModel(jComboBoxPautasColocacionModel);
					jComboBoxPautasColocacion.setBounds(50, 6, 73, 23);
				}
				{
					jButtonGuardar = new JButton();
					FlowLayout jButtonGuardarLayout = new FlowLayout();
					jButtonGuardar.setLayout(null);
					jPanelRight.add(jButtonGuardar);
					jButtonGuardar.setText("Guardar");
					jButtonGuardar.setBounds(6, 163, 54, 23);
				}
				{
					jButtonCancelar = new JButton();
					FlowLayout jButtonCancelarLayout = new FlowLayout();
					jButtonCancelar.setLayout(null);
					jPanelRight.add(jButtonCancelar);
					jButtonCancelar.setText("Cancelar");
					jButtonCancelar.setBounds(71, 163, 58, 23);
				}
				{
					jButtonAplicar = new JButton();
					jPanelRight.add(jButtonAplicar);
					jButtonAplicar.setText("Aplicar");
					jButtonAplicar.setBounds(46, 48, 49, 23);
				}
			}
			{
				jPanelLeft = new JPanel();
				getContentPane().add(jPanelLeft, BorderLayout.WEST);
				jPanelLeft.setPreferredSize(new java.awt.Dimension(248, 208));
				jPanelLeft.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				jPanelLeft.setLayout(null);
				{
					TableModel jTableColocacionesModel = 
							new DefaultTableModel(
									new String[][] { { "Nombre", "Date 1", "Date 2", "Date 3", "Salida" },{},{},{},{},{},{},{} },
									new String[] { "Nombre", "Date 1", "Date 2", "Date 3", "Salida" });
					jTableColocaciones = new JTable();
					jPanelLeft.add(jTableColocaciones);
					FlowLayout jTableColocacionesLayout = new FlowLayout();
					jTableColocaciones.setLayout(jTableColocacionesLayout);
					jTableColocaciones.setModel(jTableColocacionesModel);
					GridLayout tableHeaderLayout = new GridLayout(1, 1);
					tableHeaderLayout.setHgap(5);
					tableHeaderLayout.setVgap(5);
					tableHeaderLayout.setColumns(1);
					jTableColocaciones.setPreferredSize(new java.awt.Dimension(243, 151));
					jTableColocaciones.getTableHeader().setLayout(tableHeaderLayout);
					jTableColocaciones.getTableHeader().setPreferredSize(new java.awt.Dimension(243, 25));
					jTableColocaciones.setBounds(3, 7, 243, 151);
				}
				{
					jLabelTotal = new JLabel();
					jPanelLeft.add(jLabelTotal);

					FlowLayout jLabelTotalLayout = new FlowLayout();
					jLabelTotal.setLayout(jLabelTotalLayout);
					jLabelTotal.setText("Total:");
					jLabelTotal.setBounds(140, 166, 50, 16);
				}
				{
					jTextFieldTotal = new JTextField();
					jPanelLeft.add(jTextFieldTotal);
					jTextFieldTotal.setText("...");
					jTextFieldTotal.setBounds(194, 163, 45, 23);
				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}