package VIEW;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import MODEL.gestorLibreria;
import MODEL.videojuego;
import MODEL.gestorTienda;
import MODEL.usuario;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class interfazLibreria {
	
	static String sel = null;
	static videojuego game = null;

	private JFrame frmAmadeusLibrera;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, usuario usuario) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazLibreria window = new interfazLibreria(usuario);
					window.frmAmadeusLibrera.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfazLibreria(usuario usuario) {
		initialize(usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize(usuario usuario) {
		
		frmAmadeusLibrera = new JFrame();
		frmAmadeusLibrera.setResizable(false);
		frmAmadeusLibrera.setIconImage(Toolkit.getDefaultToolkit().getImage(interfazLibreria.class.getResource("/img/icono.png")));
		frmAmadeusLibrera.setTitle("Amadeus - Librería");
		frmAmadeusLibrera.setBounds(100, 100, 1000, 717);
		frmAmadeusLibrera.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmAmadeusLibrera.getContentPane().setLayout(null);
		
		
		
		JButton btnTienda = new JButton("Tienda");
		btnTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAmadeusLibrera.dispose();
				interfazTienda.main(new String[0],usuario);
			}
		});
		btnTienda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnTienda.setBounds(20, 627, 89, 23);
		frmAmadeusLibrera.getContentPane().add(btnTienda);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 964, 609);
		frmAmadeusLibrera.getContentPane().add(panel);
		panel.setLayout(null);
		
		ImageIcon imageIcon = new ImageIcon(interfazLogin.class.getResource("/img/icono.png"));
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		
		JLabel logoA = new JLabel("");
		logoA.setHorizontalAlignment(SwingConstants.CENTER);
		logoA.setIcon(imageIcon);
		logoA.setBounds(428, 171, 294, 286);
		panel.add(logoA);
		
		@SuppressWarnings("rawtypes")
		JList list = new JList();
		if(usuario.getPrem()==false) {
			DefaultListModel<String> model;
			model = new DefaultListModel<>();
			for (String nomJ : gestorLibreria.mostrarLibreria(usuario.getUsuario())) {
				model.addElement(nomJ);
	        }
			list.setModel(model);
		}
		else {
			DefaultListModel<String> model;
			model = new DefaultListModel<>();
			for (String nomJ : gestorLibreria.mostrarLibreriaPrem()) {
				model.addElement(nomJ);
	        }
			list.setModel(model);
		}	
		list.setBackground(Color.LIGHT_GRAY);
		list.setBounds(10, 63, 185, 546);
		panel.add(list);
		
		JLabel lblNewLabel = new JLabel("Tus juegos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 29, 185, 23);
		panel.add(lblNewLabel);
		
		JLabel userName = new JLabel("Bienvenido/a: " + usuario.getUsuario());
		userName.setHorizontalAlignment(SwingConstants.LEFT);
		userName.setBounds(10, 4, 206, 14);
		panel.add(userName);
		
		JLabel title = new JLabel("");
		title.setFont(new Font("Tahoma", Font.BOLD, 20));
		title.setBounds(205, 53, 759, 30);
		panel.add(title);
		
		JTextArea descBox = new JTextArea();
		descBox.setBackground(Color.LIGHT_GRAY);
		descBox.setBounds(205, 385, 749, 224);
		descBox.setLineWrap(true);
		descBox.setWrapStyleWord(true);
		panel.add(descBox);
		descBox.setVisible(false);
		
		JLabel cat = new JLabel("Categoría: ");
		cat.setHorizontalAlignment(SwingConstants.CENTER);
		cat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cat.setBounds(304, 354, 78, 20);
		panel.add(cat);
		cat.setVisible(false);
		
		JLabel genre = new JLabel("Genero: ");
		genre.setHorizontalAlignment(SwingConstants.CENTER);
		genre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		genre.setBounds(642, 354, 62, 20);
		panel.add(genre);
		genre.setVisible(false);
		
		JLabel catLabel = new JLabel("");
		catLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		catLabel.setBounds(392, 354, 240, 20);
		panel.add(catLabel);
		
		JLabel genLabel = new JLabel("");
		genLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		genLabel.setBounds(714, 354, 240, 20);
		panel.add(genLabel);
		
		JLabel img1 = new JLabel("");
		img1.setBounds(205, 117, 232, 191);
		panel.add(img1);
		
		JLabel img2 = new JLabel("");
		img2.setBounds(462, 117, 232, 191);
		panel.add(img2);
		
		JLabel img3 = new JLabel("");
		img3.setBounds(722, 117, 232, 191);
		panel.add(img3);
		
		JButton play = new JButton("Iniciar juego");
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Iniciando juego.");
			}
		});
		play.setBounds(205, 86, 118, 20);
		panel.add(play);
		play.setVisible(false);
		
		JLabel devTxt = new JLabel("");
		devTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		devTxt.setBounds(740, 69, 214, 14);
		panel.add(devTxt);
		
		JButton upgradeBt = new JButton("Hazte premium");
		upgradeBt.setBounds(838, 4, 126, 23);
		panel.add(upgradeBt);
		upgradeBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAmadeusLibrera.dispose();
				interfazUpgrade.main(null, usuario);
			}			
		});
		upgradeBt.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		upgradeBt.setVisible(false);
		if(usuario.getPrem()==false) {
			upgradeBt.setVisible(true);
		}
		
		JButton btnNoticias = new JButton("Noticias");
		btnNoticias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazNoticias.main(new String[0]);
			}
		});
		btnNoticias.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNoticias.setBounds(118, 627, 89, 23);
		frmAmadeusLibrera.getContentPane().add(btnNoticias);
		
		JButton devolucion = new JButton("Solicitar devolución");
		devolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sel==null) {
					JOptionPane.showMessageDialog(null, "Primero seleccione un juego.");
				}
				else {
					frmAmadeusLibrera.dispose();
					interfazDevolucion.main(new String[0],game,usuario);
				}
			}
		});
		devolucion.setBounds(338, 627, 145, 23);
		frmAmadeusLibrera.getContentPane().add(devolucion);
		devolucion.setVisible(false);
		
		JButton reseña = new JButton("Escribir reseña");
		reseña.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sel==null) {
					JOptionPane.showMessageDialog(null, "Primero seleccione un juego.");
				}
				else {
					interfazResena.main(new String[0],game,usuario.getUsuario());
				}
			}
		});
		reseña.setBounds(493, 627, 143, 23);
		frmAmadeusLibrera.getContentPane().add(reseña);
		
		JButton friendsChatBtn = new JButton("Amigos y chat");
		friendsChatBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazAmigos.main(new String[0], usuario);
			}
		});
		friendsChatBtn.setBackground(new Color(255, 128, 0));
		friendsChatBtn.setBounds(821, 627, 142, 23);
		frmAmadeusLibrera.getContentPane().add(friendsChatBtn);
		reseña.setVisible(false);
		
		JMenuBar menuBar = new JMenuBar();
		frmAmadeusLibrera.setJMenuBar(menuBar);
		
		JMenu amadeusM = new JMenu("Amadeus");
		menuBar.add(amadeusM);
		
		JMenuItem logoffM = new JMenuItem("Cerrar sesión");
		logoffM.setHorizontalAlignment(SwingConstants.LEFT);
		logoffM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAmadeusLibrera.dispose();
				interfazLogin.main(new String[0]);
			}
		});
		
		JMenuItem account = new JMenuItem("Mi cuenta");
		account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAmadeusLibrera.dispose();
				interfazCuenta.main(new String[0],usuario);
			}
		});
		amadeusM.add(account);
		
		JSeparator separator = new JSeparator();
		amadeusM.add(separator);
		amadeusM.add(logoffM);
		
		JMenuItem exit = new JMenuItem("Salir");
		exit.setHorizontalAlignment(SwingConstants.LEFT);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		amadeusM.add(exit);
		
		JMenu helpM = new JMenu("Ayuda");
		helpM.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(helpM);
		
		JMenuItem reporteMenu = new JMenuItem("Generar reporte");
		reporteMenu.setHorizontalAlignment(SwingConstants.LEFT);
		reporteMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazReporte.main(new String[0],usuario.getUsuario());
			}
		});
		helpM.add(reporteMenu);
		
		JMenuItem acercaMenu = new JMenuItem("Acreca de Amadeus");
		acercaMenu.setHorizontalAlignment(SwingConstants.LEFT);
		acercaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazAcerca.main(new String[0]);
			}
		});
		helpM.add(acercaMenu);
		
		list.addListSelectionListener(new ListSelectionListener() {

	        @Override
	        public void valueChanged(ListSelectionEvent arg0) {
	            if (!arg0.getValueIsAdjusting()) {
	            	logoA.setVisible(false);
	            	String selected =list.getSelectedValue().toString();
	            	sel=selected;
	            	videojuego juego=gestorTienda.visualizarTienda(selected);
	            	game=juego;
	            	
	            	ImageIcon imageIcon1 = new ImageIcon(interfazLogin.class.getResource("/img/"+juego.getID()+"_1.jpg"));
	        		Image image = imageIcon1.getImage();
	        		Image newimg = image.getScaledInstance(198, 172,  java.awt.Image.SCALE_SMOOTH);
	        		imageIcon1 = new ImageIcon(newimg);
	        		img1.setIcon(imageIcon1);
	        		
	        		ImageIcon imageIcon2 = new ImageIcon(interfazLogin.class.getResource("/img/"+juego.getID()+"_2.jpg"));
	        		Image image2 = imageIcon2.getImage();
	        		Image newimg2 = image2.getScaledInstance(198, 172,  java.awt.Image.SCALE_SMOOTH);
	        		imageIcon2 = new ImageIcon(newimg2);
	        		img2.setIcon(imageIcon2);
	        		
	        		ImageIcon imageIcon3 = new ImageIcon(interfazLogin.class.getResource("/img/"+juego.getID()+"_3.jpg"));
	        		Image image3 = imageIcon3.getImage();
	        		Image newimg3 = image3.getScaledInstance(198, 172,  java.awt.Image.SCALE_SMOOTH);
	        		imageIcon3 = new ImageIcon(newimg3);
	        		img3.setIcon(imageIcon3);
	        		
	            	descBox.setText(juego.getDescripcion());
	            	title.setText(juego.getNombre());
	            	catLabel.setText(juego.getCategoria());
	            	genLabel.setText(juego.getGenero());
	            	devTxt.setText(juego.getDev());
	            	
	            	play.setVisible(true);
	            	devolucion.setVisible(true);
	            	reseña.setVisible(true);
	            	cat.setVisible(true);
	            	genre.setVisible(true);
	            	descBox.setVisible(true);
	            }
	        }
	    });
	}
}
