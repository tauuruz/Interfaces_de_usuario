package VIEW;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import MODEL.gestorCuenta;
import MODEL.usuario;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class interfazCuenta {

	private JFrame cuentaIU;
	private JTextField usuariotxt;
	private JTextField nombretxt;
	private JTextField paternotxt;
	private JTextField maternotxt;
	private JTextField direcciontxt;
	private JTextField telefonotxt;
	private JTextField correotxt;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,usuario usuario) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazCuenta window = new interfazCuenta(usuario);
					window.cuentaIU.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfazCuenta(usuario usuario) {
		initialize(usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize(usuario usuario) {
		
		cuentaIU = new JFrame();
		cuentaIU.setTitle("Mi cuenta - " + usuario.getUsuario());
		cuentaIU.setIconImage(Toolkit.getDefaultToolkit().getImage(interfazCuenta.class.getResource("/img/icono.png")));
		cuentaIU.setResizable(false);
		cuentaIU.setBounds(100, 100, 450, 550);
		cuentaIU.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cuentaIU.getContentPane().setLayout(null);
		
		JButton back = new JButton("Regresar");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cuentaIU.dispose();
				interfazLibreria.main(new String[0],usuario);
			}
		});
		back.setBounds(335, 477, 89, 23);
		cuentaIU.getContentPane().add(back);
		
		JLabel username = new JLabel("Usuario");
		username.setHorizontalAlignment(SwingConstants.RIGHT);
		username.setFont(new Font("Tahoma", Font.PLAIN, 11));
		username.setBounds(42, 72, 128, 14);
		cuentaIU.getContentPane().add(username);
		
		usuariotxt = new JTextField();
		usuariotxt.setHorizontalAlignment(SwingConstants.CENTER);
		usuariotxt.setText(usuario.getUsuario());
		usuariotxt.setColumns(10);
		usuariotxt.setBounds(180, 69, 173, 20);
		cuentaIU.getContentPane().add(usuariotxt);
		usuariotxt.disable();
		
		nombretxt = new JTextField();
		nombretxt.setHorizontalAlignment(SwingConstants.CENTER);
		nombretxt.setText(usuario.getNombre());
		nombretxt.setColumns(10);
		nombretxt.setBounds(180, 110, 173, 20);
		cuentaIU.getContentPane().add(nombretxt);
		nombretxt.disable();
		
		JLabel name = new JLabel("Nombre:");
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		name.setFont(new Font("Tahoma", Font.PLAIN, 11));
		name.setBounds(81, 113, 89, 14);
		cuentaIU.getContentPane().add(name);
		
		JLabel app = new JLabel("Apellido paterno:");
		app.setHorizontalAlignment(SwingConstants.RIGHT);
		app.setFont(new Font("Tahoma", Font.PLAIN, 11));
		app.setBounds(42, 150, 128, 14);
		cuentaIU.getContentPane().add(app);
		
		paternotxt = new JTextField();
		paternotxt.setHorizontalAlignment(SwingConstants.CENTER);
		paternotxt.setText(usuario.getPaterno());
		paternotxt.setColumns(10);
		paternotxt.setBounds(180, 147, 173, 20);
		cuentaIU.getContentPane().add(paternotxt);
		paternotxt.disable();
		
		maternotxt = new JTextField();
		maternotxt.setHorizontalAlignment(SwingConstants.CENTER);
		maternotxt.setText(usuario.getMaterno());
		maternotxt.setColumns(10);
		maternotxt.setBounds(180, 188, 173, 20);
		cuentaIU.getContentPane().add(maternotxt);
		maternotxt.disable();
		
		JLabel apm = new JLabel("Apellido materno:");
		apm.setHorizontalAlignment(SwingConstants.RIGHT);
		apm.setFont(new Font("Tahoma", Font.PLAIN, 11));
		apm.setBounds(81, 191, 89, 14);
		cuentaIU.getContentPane().add(apm);
		
		JLabel direccion = new JLabel("Dirección:");
		direccion.setHorizontalAlignment(SwingConstants.RIGHT);
		direccion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		direccion.setBounds(42, 230, 128, 14);
		cuentaIU.getContentPane().add(direccion);
		
		direcciontxt = new JTextField();
		direcciontxt.setHorizontalAlignment(SwingConstants.CENTER);
		direcciontxt.setText(usuario.getDireccion());
		direcciontxt.setColumns(10);
		direcciontxt.setBounds(180, 227, 173, 20);
		cuentaIU.getContentPane().add(direcciontxt);
		direcciontxt.disable();
		
		JLabel telefono = new JLabel("Teléfono:");
		telefono.setHorizontalAlignment(SwingConstants.RIGHT);
		telefono.setFont(new Font("Tahoma", Font.PLAIN, 11));
		telefono.setBounds(81, 271, 89, 14);
		cuentaIU.getContentPane().add(telefono);
		
		telefonotxt = new JTextField();
		telefonotxt.setHorizontalAlignment(SwingConstants.CENTER);
		telefonotxt.setText(String.format("%.0f",usuario.getTelefono()));
		telefonotxt.setColumns(10);
		telefonotxt.setBounds(180, 268, 173, 20);
		cuentaIU.getContentPane().add(telefonotxt);
		telefonotxt.disable();
		
		correotxt = new JTextField();
		correotxt.setHorizontalAlignment(SwingConstants.CENTER);
		correotxt.setText(usuario.getCorreo());
		correotxt.setColumns(10);
		correotxt.setBounds(180, 305, 173, 20);
		cuentaIU.getContentPane().add(correotxt);
		correotxt.disable();
		
		JLabel email = new JLabel("Correo:");
		email.setHorizontalAlignment(SwingConstants.RIGHT);
		email.setFont(new Font("Tahoma", Font.PLAIN, 11));
		email.setBounds(42, 308, 128, 14);
		cuentaIU.getContentPane().add(email);
		
		JLabel password = new JLabel("Contraseña:");
		password.setHorizontalAlignment(SwingConstants.RIGHT);
		password.setFont(new Font("Tahoma", Font.PLAIN, 11));
		password.setBounds(81, 349, 89, 14);
		cuentaIU.getContentPane().add(password);
		
		JLabel accountTxt = new JLabel("Información de la cuenta:");
		accountTxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		accountTxt.setHorizontalAlignment(SwingConstants.CENTER);
		accountTxt.setBounds(10, 11, 414, 45);
		cuentaIU.getContentPane().add(accountTxt);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setToolTipText("");
		passwordField.setBounds(180, 346, 173, 20);
		cuentaIU.getContentPane().add(passwordField);
		
		JButton updatepssw = new JButton("Cambiar contraseña");
		updatepssw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Password=passwordField.getText();
				gestorCuenta.cambiarPssw(usuario.getId_usuario(), Password);
			}
		});
		updatepssw.setBounds(180, 391, 173, 23);
		cuentaIU.getContentPane().add(updatepssw);
		
		JButton premiumBt = new JButton("Ver beneficios");
		premiumBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}			
		});
		premiumBt.setFont(new Font("Tahoma", Font.PLAIN, 9));
		premiumBt.setBounds(10, 446, 108, 23);
		cuentaIU.getContentPane().add(premiumBt);
		if(usuario.getPrem()==true) {
			premiumBt.setVisible(true);
		}
		else {
			premiumBt.setVisible(false);
		}
		
		JButton upgradeBt = new JButton("Hazte premium");
		upgradeBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cuentaIU.dispose();
				interfazUpgrade.main(null, usuario);
			}			
		});
		upgradeBt.setFont(new Font("Tahoma", Font.PLAIN, 9));
		upgradeBt.setBounds(10, 477, 108, 23);
		cuentaIU.getContentPane().add(upgradeBt);
		if(usuario.getPrem()==false) {
			upgradeBt.setVisible(true);
		}
		else {
			upgradeBt.setVisible(false);
		}
		
		JButton cancelPrem = new JButton("Cancelar Membresia");
		cancelPrem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cuentaIU.dispose();
				interfazDowngrade.main(null, usuario);
			}
		});
		cancelPrem.setFont(new Font("Tahoma", Font.PLAIN, 9));
		cancelPrem.setBounds(10, 477, 128, 23);
		cuentaIU.getContentPane().add(cancelPrem);
		if(usuario.getPrem()==true) {
			cancelPrem.setVisible(true);
		}
		else {
			cancelPrem.setVisible(false);
		}
	}
}