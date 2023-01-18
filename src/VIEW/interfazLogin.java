 package VIEW;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import MODEL.gestorCuenta;
import MODEL.usuario;
import java.awt.Toolkit;

public class interfazLogin {

	private JFrame frmAmadeus;
	private JTextField usernameTxt;
	private JPasswordField passwordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazLogin window = new interfazLogin();
					window.frmAmadeus.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfazLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {		
		String session="Invitado";
		
		frmAmadeus = new JFrame();
		frmAmadeus.setIconImage(Toolkit.getDefaultToolkit().getImage(interfazLogin.class.getResource("/img/icono.png")));
		frmAmadeus.setResizable(false);
		frmAmadeus.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmAmadeus.setTitle("Amadeus");
		frmAmadeus.setBounds(100, 100, 450, 319);
		frmAmadeus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAmadeus.getContentPane().setLayout(null);
		
		JButton exit = new JButton("Salir");
		exit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setBounds(335, 227, 89, 23);
		frmAmadeus.getContentPane().add(exit);
		
		JLabel username = new JLabel("Nombre de ususario:");
		username.setFont(new Font("Tahoma", Font.PLAIN, 11));
		username.setBounds(65, 85, 99, 14);
		frmAmadeus.getContentPane().add(username);
		
		JLabel password = new JLabel("Contraseña:");
		password.setFont(new Font("Tahoma", Font.PLAIN, 11));
		password.setBounds(104, 126, 60, 14);
		frmAmadeus.getContentPane().add(password);
		
		usernameTxt = new JTextField();
		usernameTxt.setBounds(174, 82, 173, 20);
		frmAmadeus.getContentPane().add(usernameTxt);
		usernameTxt.setColumns(10);
		
		JButton login = new JButton("Iniciar Sesión");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username=usernameTxt.getText();
				String Password=passwordTxt.getText();
		        if(gestorCuenta.logIn(Username,Password)==1) {
		        	frmAmadeus.dispose();
		        	usuario usuario=gestorCuenta.visualizarCuenta(Username);
					interfazLibreria.main(new String[0],usuario);
		        }
				else {
					JOptionPane.showMessageDialog(null, "Usuario/Contraseña - Incorrectos");
				}
			}
		});
		login.setFont(new Font("Tahoma", Font.PLAIN, 11));
		login.setBounds(248, 154, 99, 23);
		frmAmadeus.getContentPane().add(login);
		login.getRootPane().setDefaultButton(login);
		
		JLabel signinTxt = new JLabel("¿No tienes una cuenta?");
		signinTxt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		signinTxt.setBounds(10, 231, 112, 14);
		frmAmadeus.getContentPane().add(signinTxt);
		
		JButton signin = new JButton("Registrarse");
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAmadeus.dispose();
				interfazRegistro.main(new String[0]);
			}
		});
		signin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		signin.setBounds(132, 227, 89, 23);
		frmAmadeus.getContentPane().add(signin);
		
		JButton store = new JButton("Ver Tienda");
		store.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAmadeus.dispose();
				interfazTiendaInvitado.main(new String[0],session);
			}
		});
		store.setFont(new Font("Tahoma", Font.PLAIN, 11));
		store.setBounds(335, 193, 89, 23);
		frmAmadeus.getContentPane().add(store);
		
		ImageIcon imageIcon = new ImageIcon(interfazLogin.class.getResource("/img/icono.png"));
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(imageIcon);
		logo.setBounds(191, 11, 60, 60);
		frmAmadeus.getContentPane().add(logo);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(174, 123, 173, 20);
		frmAmadeus.getContentPane().add(passwordTxt);
		
		JMenuBar menuBar = new JMenuBar();
		frmAmadeus.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Ayuda");
		mnNewMenu.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mnNewMenu);
		
		JMenuItem acercaMenu = new JMenuItem("Acreca de Amadeus");
		acercaMenu.setHorizontalAlignment(SwingConstants.LEFT);
		acercaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazAcerca.main(new String[0]);
			}
		});
		mnNewMenu.add(acercaMenu);
	}
}
