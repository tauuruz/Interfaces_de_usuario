package VIEW;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import MODEL.gestorVideojuego;
import MODEL.videojuego;
import MODEL.gestorTienda;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class interfazTiendaInvitado {
	
	static String sel = null;
	static videojuego game = null;

	private JFrame frmAmadeusTienda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, String sesion) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazTiendaInvitado window = new interfazTiendaInvitado(sesion);
					window.frmAmadeusTienda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfazTiendaInvitado(String sesion) {
		initialize(sesion);		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize(String sesion) {
		
		frmAmadeusTienda = new JFrame();
		frmAmadeusTienda.setIconImage(Toolkit.getDefaultToolkit().getImage(interfazTienda.class.getResource("/img/icono.png")));
		frmAmadeusTienda.setTitle("Amadeus - Tienda");
		frmAmadeusTienda.setBounds(100, 100, 1000, 700);
		frmAmadeusTienda.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmAmadeusTienda.getContentPane().setLayout(null);
		
		JLabel gameList = new JLabel("JUEGOS");
		gameList.setHorizontalAlignment(SwingConstants.CENTER);
		gameList.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gameList.setBounds(10, 91, 291, 20);
		frmAmadeusTienda.getContentPane().add(gameList);
		
		@SuppressWarnings("rawtypes")
		JList list = new JList();
		list.setBackground(Color.LIGHT_GRAY);
		DefaultListModel<String> model;
		model = new DefaultListModel<>();
		for (String nomJ : gestorVideojuego.visualizarJuegos()) {
			model.addElement(nomJ);
        }
		list.setModel(model);
		list.setBounds(10, 135, 291, 515);
		frmAmadeusTienda.getContentPane().add(list);
		
		String selected=("");
		JLabel lblNewLabel = new JLabel(selected);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(327, 135, 647, 31);
		frmAmadeusTienda.getContentPane().add(lblNewLabel);
		
		JLabel cat = new JLabel("Categoría: ");
		cat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cat.setHorizontalAlignment(SwingConstants.LEFT);
		cat.setBounds(327, 534, 78, 20);
		frmAmadeusTienda.getContentPane().add(cat);
		cat.setVisible(false);
		
		JLabel genre = new JLabel("Genero: ");
		genre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		genre.setHorizontalAlignment(SwingConstants.LEFT);
		genre.setBounds(646, 534, 78, 20);
		frmAmadeusTienda.getContentPane().add(genre);
		genre.setVisible(false);
		
		JLabel price = new JLabel("Precio: ");
		price.setFont(new Font("Tahoma", Font.PLAIN, 16));
		price.setHorizontalAlignment(SwingConstants.LEFT);
		price.setBounds(327, 586, 78, 20);
		frmAmadeusTienda.getContentPane().add(price);
		price.setVisible(false);
		
		JLabel catLabel = new JLabel("");
		catLabel.setHorizontalAlignment(SwingConstants.LEFT);
		catLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		catLabel.setBounds(415, 534, 222, 20);
		frmAmadeusTienda.getContentPane().add(catLabel);
		
		JLabel genLabel = new JLabel("");
		genLabel.setHorizontalAlignment(SwingConstants.LEFT);
		genLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		genLabel.setBounds(734, 534, 240, 20);
		frmAmadeusTienda.getContentPane().add(genLabel);
		
		JLabel priceLabel = new JLabel("");
		priceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		priceLabel.setBounds(415, 586, 117, 20);
		frmAmadeusTienda.getContentPane().add(priceLabel);
		
		JButton btnNewButton = new JButton("Mostrar reseñas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sel==null) {
					JOptionPane.showMessageDialog(null, "Primero seleccione un juego.");
				}
				else {
					interfazResenas.main(new String[0],game);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(327, 627, 129, 23);
		frmAmadeusTienda.getContentPane().add(btnNewButton);
		btnNewButton.setVisible(false);
		
		JLabel signinTxt = new JLabel("¿No tienes una cuenta?");
		signinTxt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		signinTxt.setBounds(763, 599, 112, 14);
		frmAmadeusTienda.getContentPane().add(signinTxt);
		
		JButton signin = new JButton("Registrarse");
		signin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAmadeusTienda.dispose();
				interfazRegistro.main(new String[0]);
			}
		});
		signin.setBounds(885, 593, 89, 23);
		frmAmadeusTienda.getContentPane().add(signin);
		
		JTextArea descBox = new JTextArea();
		descBox.setBackground(Color.LIGHT_GRAY);
		descBox.setBounds(327, 351, 647, 172);
		descBox.setLineWrap(true);
		descBox.setWrapStyleWord(true);
		frmAmadeusTienda.getContentPane().add(descBox);
		descBox.setVisible(false);
		
		JLabel storeWelcome = new JLabel("Bienvenido a la tienda - "+sesion);
		storeWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		storeWelcome.setFont(new Font("Tahoma", Font.PLAIN, 25));
		storeWelcome.setBounds(10, 11, 964, 31);
		frmAmadeusTienda.getContentPane().add(storeWelcome);
		
		JButton exit = new JButton("Salir");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		exit.setBounds(885, 627, 89, 23);
		frmAmadeusTienda.getContentPane().add(exit);
		
		JButton back = new JButton("Regresar");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAmadeusTienda.dispose();
				interfazLogin.main(new String[0]);
			}
		});
		back.setFont(new Font("Tahoma", Font.PLAIN, 11));
		back.setBounds(786, 627, 89, 23);
		frmAmadeusTienda.getContentPane().add(back);
		
		JLabel img1 = new JLabel("");
		img1.setBounds(327, 168, 198, 172);
		frmAmadeusTienda.getContentPane().add(img1);
		
		JLabel img2 = new JLabel("");
		img2.setBounds(551, 168, 198, 172);
		frmAmadeusTienda.getContentPane().add(img2);
		
		JLabel img3 = new JLabel("");
		img3.setBounds(776, 168, 198, 172);
		frmAmadeusTienda.getContentPane().add(img3);
		
		JLabel devTxt = new JLabel("");
		devTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		devTxt.setBounds(760, 152, 214, 14);
		frmAmadeusTienda.getContentPane().add(devTxt);
		
		list.addListSelectionListener(new ListSelectionListener() {

	        @Override
	        public void valueChanged(ListSelectionEvent arg0) {
	            if (!arg0.getValueIsAdjusting()) {
	            	String selected =list.getSelectedValue().toString();
	            	sel=selected;
	            	videojuego juego=gestorTienda.visualizarTienda(selected);
	            	game=juego;
	            	
	            	ImageIcon imageIcon1 = new ImageIcon(interfazLogin.class.getResource("/img/"+juego.getID()+"_1.jpg"));
	        		Image image = imageIcon1.getImage();
	        		Image newimg = image.getScaledInstance(232, 191,  java.awt.Image.SCALE_SMOOTH);
	        		imageIcon1 = new ImageIcon(newimg);
	        		img1.setIcon(imageIcon1);
	        		
	        		ImageIcon imageIcon2 = new ImageIcon(interfazLogin.class.getResource("/img/"+juego.getID()+"_2.jpg"));
	        		Image image2 = imageIcon2.getImage();
	        		Image newimg2 = image2.getScaledInstance(232, 191,  java.awt.Image.SCALE_SMOOTH);
	        		imageIcon2 = new ImageIcon(newimg2);
	        		img2.setIcon(imageIcon2);
	        		
	        		ImageIcon imageIcon3 = new ImageIcon(interfazLogin.class.getResource("/img/"+juego.getID()+"_3.jpg"));
	        		Image image3 = imageIcon3.getImage();
	        		Image newimg3 = image3.getScaledInstance(232, 191,  java.awt.Image.SCALE_SMOOTH);
	        		imageIcon3 = new ImageIcon(newimg3);
	        		img3.setIcon(imageIcon3);
	        		
	            	lblNewLabel.setText(juego.getNombre());
	            	catLabel.setText(juego.getCategoria());
	            	genLabel.setText(juego.getGenero());
	            	priceLabel.setText("$"+juego.getPrecio());
	            	descBox.setText(juego.getDescripcion());
	            	devTxt.setText(juego.getDev());
	            	
	            	btnNewButton.setVisible(true);
	            	descBox.setVisible(true);
	            	cat.setVisible(true);
	            	genre.setVisible(true);
	            	price.setVisible(true);
	            }
	        }
	    });
			
	}
}