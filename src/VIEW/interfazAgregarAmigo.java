package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;

import MODEL.gestorAmigos;
import MODEL.usuario;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class interfazAgregarAmigo {

	private JFrame frmAgregarAmigo;
	private JTextField userNameField;
	private JButton btnRegresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,usuario usuario) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazAgregarAmigo window = new interfazAgregarAmigo(usuario);
					window.frmAgregarAmigo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfazAgregarAmigo(usuario usuario) {
		initialize(usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(usuario usuario) {
		frmAgregarAmigo = new JFrame();
		frmAgregarAmigo.setTitle("Agregar amigo");
		frmAgregarAmigo.setIconImage(Toolkit.getDefaultToolkit().getImage(interfazAgregarAmigo.class.getResource("/img/icono.png")));
		frmAgregarAmigo.setResizable(false);
		frmAgregarAmigo.setBounds(100, 100, 450, 136);
		frmAgregarAmigo.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmAgregarAmigo.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingresa el nombre de usuario de tu amigo:");
		lblNewLabel.setBounds(10, 11, 414, 14);
		frmAgregarAmigo.getContentPane().add(lblNewLabel);
		
		userNameField = new JTextField();
		userNameField.setBounds(10, 36, 414, 20);
		frmAgregarAmigo.getContentPane().add(userNameField);
		userNameField.setColumns(10);
		
		JButton add = new JButton("Agregar");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username=userNameField.getText();
				if(Username.isEmpty()){
					JOptionPane.showMessageDialog(null, "Ingresa un nombre de usuario primero.");
				}
				else {
					frmAgregarAmigo.dispose();
					gestorAmigos.agregarAmigo(usuario, Username);
					interfazAmigos.main(new String[0], usuario);
				}
			}
		});
		add.setBounds(335, 63, 89, 23);
		frmAgregarAmigo.getContentPane().add(add);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAgregarAmigo.dispose();
				interfazAmigos.main(new String[0], usuario);
			}
		});
		btnRegresar.setBounds(10, 67, 89, 23);
		frmAgregarAmigo.getContentPane().add(btnRegresar);
	}
}
