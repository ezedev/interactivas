package ventanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

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
public class Login extends javax.swing.JFrame {
	private JLabel LblUser;
	private JPasswordField TxtPass;
	private JLabel LblPassword;
	private JButton BtbLogin;
	private JTextField TxtUser;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Login inst = new Login();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Login() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				LblUser = new JLabel();
				getContentPane().add(LblUser);
				LblUser.setText("Usuario:");
				LblUser.setBounds(51, 60, 66, 16);
			}
			{
				LblPassword = new JLabel();
				getContentPane().add(LblPassword);
				LblPassword.setText("Password:");
				LblPassword.setBounds(51, 104, 81, 16);
			}
			{
				TxtUser = new JTextField();
				getContentPane().add(TxtUser);
				TxtUser.setBounds(151, 59, 170, 22);
			}
			{
				BtbLogin = new JButton();
				getContentPane().add(BtbLogin);
				BtbLogin.setText("Login");
				BtbLogin.setBounds(247, 143, 74, 37);
				BtbLogin.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						boolean estaAutenticado = Sistema.getInstance().iniciarSesion(TxtUser.getText(), TxtPass.getText());
						
						if(estaAutenticado) {
							
							setVisible(false);
							dispose();
							MenuVentana ventana = new MenuVentana();
							ventana.setVisible(true);
							
						} else {
						
							// Mostrar error al usuario en un label
						}
					}
				});
			}
			{
				TxtPass = new JPasswordField();
				getContentPane().add(TxtPass);
				TxtPass.setBounds(151, 102, 170, 22);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
