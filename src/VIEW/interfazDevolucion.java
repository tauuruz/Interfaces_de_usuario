package VIEW;

import java.awt.EventQueue;
import javax.swing.JFrame;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import MODEL.videojuego;
import MODEL.gestorPagos;
import MODEL.usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class interfazDevolucion {

	private JFrame iuDevolucion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,videojuego juego,usuario usuario) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazDevolucion window = new interfazDevolucion(juego,usuario);
					window.iuDevolucion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfazDevolucion(videojuego juego,usuario usuario) {
		initialize(juego,usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(videojuego juego,usuario usuario) {
		iuDevolucion = new JFrame();
		iuDevolucion.setResizable(false);
		iuDevolucion.setTitle("Devolución - "+juego.getNombre());
		iuDevolucion.setIconImage(Toolkit.getDefaultToolkit().getImage(interfazDevolucion.class.getResource("/img/icono.png")));
		iuDevolucion.setBounds(100, 100, 450, 300);
		iuDevolucion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iuDevolucion.getContentPane().setLayout(null);
		
		JLabel txt = new JLabel("Se procederá a realizar la devolución del siguiente juego:");
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		txt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt.setBounds(10, 11, 414, 25);
		iuDevolucion.getContentPane().add(txt);
		
		JLabel nombreJ = new JLabel("");
		nombreJ.setHorizontalAlignment(SwingConstants.CENTER);
		nombreJ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nombreJ.setBounds(10, 47, 414, 48);
		nombreJ.setText(juego.getNombre());
		iuDevolucion.getContentPane().add(nombreJ);
		
		JLabel lblAlFinalizarLa = new JLabel("Al finalizar la devolución, el juego se eliminará de tu librería");
		lblAlFinalizarLa.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlFinalizarLa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAlFinalizarLa.setBounds(10, 106, 414, 25);
		iuDevolucion.getContentPane().add(lblAlFinalizarLa);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iuDevolucion.dispose();
				interfazLibreria.main(new String[0],usuario);
			}
		});
		cancelar.setBounds(10, 227, 89, 23);
		iuDevolucion.getContentPane().add(cancelar);
		
		JButton confirmar = new JButton("Confirmar");
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorPagos.solicitarReembolso(juego, usuario.getUsuario());
				iuDevolucion.dispose();
				interfazLibreria.main(new String[0],usuario);
			}
		});
		confirmar.setBounds(302, 227, 122, 23);
		iuDevolucion.getContentPane().add(confirmar);
		
		JLabel lblYSeRealizar = new JLabel("y se realizará un reembolso a tu tarjeta de credito/debito de:");
		lblYSeRealizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblYSeRealizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblYSeRealizar.setBounds(10, 127, 414, 25);
		iuDevolucion.getContentPane().add(lblYSeRealizar);
		
		JLabel precioJ = new JLabel((String) null);
		precioJ.setHorizontalAlignment(SwingConstants.CENTER);
		precioJ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		precioJ.setBounds(10, 163, 414, 48);
		precioJ.setText("$"+juego.getPrecio());
		iuDevolucion.getContentPane().add(precioJ);
	}

}