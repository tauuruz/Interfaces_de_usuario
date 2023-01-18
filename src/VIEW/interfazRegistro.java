package VIEW;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import MODEL.gestorCuenta;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class interfazRegistro {

	private JFrame frmAmadeusRegistrarse;
	private JTextField usernameBx;
	private JTextField nameBx;
	private JTextField appBx;
	private JTextField apmBx;
	private JTextField passwordBx;
	private JTextField emailBx;
	private JTextField telefonoBx;
	private JTextField direccionBx;
	private JLabel lblHasElegidoFormar;
	private JLabel lblParaConcluirEl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazRegistro window = new interfazRegistro();
					window.frmAmadeusRegistrarse.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfazRegistro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAmadeusRegistrarse = new JFrame();
		frmAmadeusRegistrarse.setIconImage(Toolkit.getDefaultToolkit().getImage(interfazRegistro.class.getResource("/img/icono.png")));
		frmAmadeusRegistrarse.setResizable(false);
		frmAmadeusRegistrarse.setTitle("Amadeus - Registrarse");
		frmAmadeusRegistrarse.setBounds(100, 100, 450, 550);
		frmAmadeusRegistrarse.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmAmadeusRegistrarse.getContentPane().setLayout(null);
		
		JLabel username = new JLabel("Usuario");
		username.setHorizontalAlignment(SwingConstants.RIGHT);
		username.setFont(new Font("Tahoma", Font.PLAIN, 11));
		username.setBounds(51, 135, 128, 14);
		frmAmadeusRegistrarse.getContentPane().add(username);
		
		usernameBx = new JTextField();
		usernameBx.setColumns(10);
		usernameBx.setBounds(189, 132, 173, 20);
		frmAmadeusRegistrarse.getContentPane().add(usernameBx);
		
		JLabel name = new JLabel("Nombre:");
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		name.setFont(new Font("Tahoma", Font.PLAIN, 11));
		name.setBounds(90, 176, 89, 14);
		frmAmadeusRegistrarse.getContentPane().add(name);
		
		nameBx = new JTextField();
		nameBx.setColumns(10);
		nameBx.setBounds(189, 173, 173, 20);
		frmAmadeusRegistrarse.getContentPane().add(nameBx);
		
		JButton signin = new JButton("Registrarse");
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username=usernameBx.getText();
				String Name=nameBx.getText();
				String Pat=appBx.getText();
				String Mat=apmBx.getText();
				String Dir=direccionBx.getText();
				String Tel=telefonoBx.getText();
				String Email=emailBx.getText();
				String Password=passwordBx.getText();
				boolean Premium=false;
				if(Username.isEmpty() || Name.isEmpty() || Pat.isEmpty() || Mat.isEmpty() || Dir.isEmpty() || Tel.isEmpty() || Email.isEmpty() || Password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
				}
				else{
					gestorCuenta.registrarUsuario(Username,Name,Pat,Mat,Dir,Tel,Email,Password,Premium);
					frmAmadeusRegistrarse.dispose();
					interfazUpgradeR.main(new String[0],Username);
				}
			}
		});
		signin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		signin.setBounds(335, 477, 89, 23);
		frmAmadeusRegistrarse.getContentPane().add(signin);
		signin.getRootPane().setDefaultButton(signin);
		
		appBx = new JTextField();
		appBx.setColumns(10);
		appBx.setBounds(189, 210, 173, 20);
		frmAmadeusRegistrarse.getContentPane().add(appBx);
		
		JLabel app = new JLabel("Apellido paterno:");
		app.setHorizontalAlignment(SwingConstants.RIGHT);
		app.setFont(new Font("Tahoma", Font.PLAIN, 11));
		app.setBounds(51, 213, 128, 14);
		frmAmadeusRegistrarse.getContentPane().add(app);
		
		JLabel apm = new JLabel("Apellido materno:");
		apm.setHorizontalAlignment(SwingConstants.RIGHT);
		apm.setFont(new Font("Tahoma", Font.PLAIN, 11));
		apm.setBounds(90, 254, 89, 14);
		frmAmadeusRegistrarse.getContentPane().add(apm);
		
		apmBx = new JTextField();
		apmBx.setColumns(10);
		apmBx.setBounds(189, 251, 173, 20);
		frmAmadeusRegistrarse.getContentPane().add(apmBx);
		
		passwordBx = new JTextField();
		passwordBx.setColumns(10);
		passwordBx.setBounds(189, 409, 173, 20);
		frmAmadeusRegistrarse.getContentPane().add(passwordBx);
		
		JLabel password = new JLabel("Contrase\u00F1a:");
		password.setHorizontalAlignment(SwingConstants.RIGHT);
		password.setFont(new Font("Tahoma", Font.PLAIN, 11));
		password.setBounds(90, 412, 89, 14);
		frmAmadeusRegistrarse.getContentPane().add(password);
		
		JLabel email = new JLabel("Correo:");
		email.setHorizontalAlignment(SwingConstants.RIGHT);
		email.setFont(new Font("Tahoma", Font.PLAIN, 11));
		email.setBounds(51, 371, 128, 14);
		frmAmadeusRegistrarse.getContentPane().add(email);
		
		emailBx = new JTextField();
		emailBx.setColumns(10);
		emailBx.setBounds(189, 368, 173, 20);
		frmAmadeusRegistrarse.getContentPane().add(emailBx);
		
		telefonoBx = new JTextField();
		telefonoBx.setColumns(10);
		telefonoBx.setBounds(189, 331, 173, 20);
		frmAmadeusRegistrarse.getContentPane().add(telefonoBx);
		
		JLabel telefono = new JLabel("Tel\u00E9fono:");
		telefono.setHorizontalAlignment(SwingConstants.RIGHT);
		telefono.setFont(new Font("Tahoma", Font.PLAIN, 11));
		telefono.setBounds(90, 334, 89, 14);
		frmAmadeusRegistrarse.getContentPane().add(telefono);
		
		JLabel direccion = new JLabel("Direcci\u00F3n:");
		direccion.setHorizontalAlignment(SwingConstants.RIGHT);
		direccion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		direccion.setBounds(51, 293, 128, 14);
		frmAmadeusRegistrarse.getContentPane().add(direccion);
		
		direccionBx = new JTextField();
		direccionBx.setColumns(10);
		direccionBx.setBounds(189, 290, 173, 20);
		frmAmadeusRegistrarse.getContentPane().add(direccionBx);
		
		lblHasElegidoFormar = new JLabel("Has elegido formar parte de AMADEUS");
		lblHasElegidoFormar.setHorizontalAlignment(SwingConstants.CENTER);
		lblHasElegidoFormar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHasElegidoFormar.setBounds(10, 43, 414, 23);
		frmAmadeusRegistrarse.getContentPane().add(lblHasElegidoFormar);
		
		lblParaConcluirEl = new JLabel("Para concluir el registo por favor llene todos los campos.");
		lblParaConcluirEl.setHorizontalAlignment(SwingConstants.CENTER);
		lblParaConcluirEl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblParaConcluirEl.setBounds(10, 68, 414, 20);
		frmAmadeusRegistrarse.getContentPane().add(lblParaConcluirEl);
		
		JButton back = new JButton("Regresar");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAmadeusRegistrarse.dispose();
				interfazLogin.main(new String[0]);
			}
		});
		back.setFont(new Font("Tahoma", Font.PLAIN, 11));
		back.setBounds(236, 477, 89, 23);
		frmAmadeusRegistrarse.getContentPane().add(back);
	}
}
