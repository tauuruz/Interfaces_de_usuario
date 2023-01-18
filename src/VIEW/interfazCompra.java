package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import MODEL.videojuego;
import MODEL.gestorPagos;
import MODEL.usuario;

import java.awt.Font;
import javax.swing.JTextField;

public class interfazCompra {

	private JFrame iuCompra;
	private JTextField titularBox;
	private JTextField tarjetaBox;
	private JTextField dateBox;
	private JTextField cvvBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,videojuego juego,usuario usuario) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazCompra window = new interfazCompra(juego,usuario);
					window.iuCompra.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfazCompra(videojuego juego,usuario usuario) {
		initialize(juego,usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(videojuego juego,usuario usuario) {
		iuCompra = new JFrame();
		iuCompra.setResizable(false);
		iuCompra.setTitle("Comprar");
		iuCompra.setIconImage(Toolkit.getDefaultToolkit().getImage(interfazCompra.class.getResource("/img/icono.png")));
		iuCompra.setBounds(100, 100, 655, 409);
		iuCompra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		iuCompra.getContentPane().setLayout(null);
		
		JButton back = new JButton("Cancelar");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iuCompra.dispose();
			}
		});
		back.setBounds(441, 335, 89, 23);
		iuCompra.getContentPane().add(back);
		
		JLabel juegotxt = new JLabel("Juego a comprar:");
		juegotxt.setFont(new Font("Tahoma", Font.BOLD, 14));
		juegotxt.setHorizontalAlignment(SwingConstants.RIGHT);
		juegotxt.setBounds(26, 36, 126, 25);
		iuCompra.getContentPane().add(juegotxt);
		
		JLabel nombretxt = new JLabel("");
		nombretxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nombretxt.setHorizontalAlignment(SwingConstants.LEFT);
		nombretxt.setText(juego.getNombre());
		nombretxt.setBounds(162, 36, 126, 25);
		iuCompra.getContentPane().add(nombretxt);
		
		JLabel datostxt = new JLabel("Ingrese los datos de su tarjeta de credito/debito:");
		datostxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		datostxt.setBounds(90, 91, 531, 25);
		iuCompra.getContentPane().add(datostxt);
		
		JLabel tarjetatxt = new JLabel("Numero de tarjeta:");
		tarjetatxt.setHorizontalAlignment(SwingConstants.RIGHT);
		tarjetatxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tarjetatxt.setBounds(90, 156, 126, 25);
		iuCompra.getContentPane().add(tarjetatxt);
		
		JLabel datetxt = new JLabel("Fecha:");
		datetxt.setHorizontalAlignment(SwingConstants.RIGHT);
		datetxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		datetxt.setBounds(90, 192, 126, 25);
		iuCompra.getContentPane().add(datetxt);
		
		JLabel cvvtxt = new JLabel("CVV:");
		cvvtxt.setHorizontalAlignment(SwingConstants.RIGHT);
		cvvtxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cvvtxt.setBounds(334, 192, 46, 25);
		iuCompra.getContentPane().add(cvvtxt);
		
		JLabel titulartxt = new JLabel("Nombre de titular:");
		titulartxt.setHorizontalAlignment(SwingConstants.RIGHT);
		titulartxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		titulartxt.setBounds(90, 228, 126, 25);
		iuCompra.getContentPane().add(titulartxt);
		
		titularBox = new JTextField();
		titularBox.setBounds(226, 229, 339, 25);
		iuCompra.getContentPane().add(titularBox);
		titularBox.setColumns(10);
		
		tarjetaBox = new JTextField();
		tarjetaBox.setColumns(10);
		tarjetaBox.setBounds(226, 156, 339, 25);
		iuCompra.getContentPane().add(tarjetaBox);
		
		dateBox = new JTextField();
		dateBox.setColumns(10);
		dateBox.setBounds(226, 193, 98, 25);
		iuCompra.getContentPane().add(dateBox);
		
		cvvBox = new JTextField();
		cvvBox.setColumns(10);
		cvvBox.setBounds(390, 192, 51, 25);
		iuCompra.getContentPane().add(cvvBox);
		
		JLabel totaltxt = new JLabel("Total:");
		totaltxt.setHorizontalAlignment(SwingConstants.RIGHT);
		totaltxt.setFont(new Font("Tahoma", Font.BOLD, 14));
		totaltxt.setBounds(416, 293, 69, 25);
		iuCompra.getContentPane().add(totaltxt);
		
		JLabel price = new JLabel((String) null);
		price.setHorizontalAlignment(SwingConstants.LEFT);
		price.setFont(new Font("Tahoma", Font.PLAIN, 14));
		price.setBounds(495, 293, 126, 25);
		price.setText("$"+juego.getPrecio());
		iuCompra.getContentPane().add(price);
		
		JButton buy = new JButton("Comprar");
		buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(titularBox.getText().isEmpty() || tarjetaBox.getText().isEmpty() || dateBox.getText().isEmpty() || cvvBox.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
				}
				else {
					gestorPagos.comprarJuego(juego, usuario.getUsuario());
					iuCompra.dispose();
				}
			}
		});
		buy.setBounds(540, 334, 89, 25);
		iuCompra.getContentPane().add(buy);
	}
}
