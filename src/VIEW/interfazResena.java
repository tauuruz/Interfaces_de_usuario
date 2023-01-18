package VIEW;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import MODEL.videojuego;
import MODEL.gestorResena;

import javax.swing.JTextArea;
import javax.swing.JCheckBox;

public class interfazResena {
	
	static int calificacion;

	private JFrame resenas;
	private JTextField resenaBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,videojuego juego,String usuario) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazResena window = new interfazResena(juego,usuario);
					window.resenas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfazResena(videojuego juego,String usuario) {
		initialize(juego,usuario);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(videojuego juego,String usuario) {
		resenas = new JFrame();
		resenas.setAutoRequestFocus(false);
		resenas.setResizable(false);
		resenas.setIconImage(Toolkit.getDefaultToolkit().getImage(interfazResena.class.getResource("/img/icono.png")));
		resenas.setTitle("Escribir reseña - "+juego.getNombre());
		resenas.setBounds(100, 100, 747, 444);
		resenas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		resenas.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 711, 353);
		resenas.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel resenaTxt = new JLabel("Para escribir una reseña primero escriba el titulo:");
		resenaTxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		resenaTxt.setBounds(10, 11, 691, 25);
		panel.add(resenaTxt);
		
		resenaBox = new JTextField();
		resenaBox.setBounds(10, 47, 691, 25);
		panel.add(resenaBox);
		resenaBox.setColumns(10);
		
		JLabel descTxt = new JLabel("Escriba la reseña:");
		descTxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		descTxt.setBounds(10, 83, 691, 25);
		panel.add(descTxt);
		
		JTextArea descBox = new JTextArea();
		descBox.setBounds(10, 119, 691, 188);
		descBox.setLineWrap(true);
		descBox.setWrapStyleWord(true);
		panel.add(descBox);
		
		JLabel recomiendasTxt = new JLabel("¿Recomiendas este juego?");
		recomiendasTxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		recomiendasTxt.setBounds(10, 318, 165, 25);
		panel.add(recomiendasTxt);
		
		JCheckBox Si = new JCheckBox("Si");
		Si.setSelected(false);
		Si.setBounds(181, 320, 43, 23);
		panel.add(Si);
		
		JCheckBox No = new JCheckBox("No");
		Si.setSelected(false);
		No.setBounds(226, 320, 43, 23);
		panel.add(No);
		
		JButton btnNewButton = new JButton("Escribir reseña");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = resenaBox.getText();
				String resenia = descBox.getText();
				if(Si.isSelected()==true) {
					calificacion=1;
				}
				if(No.isSelected()==true){
					calificacion=0;
				}
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
				LocalDateTime now = LocalDateTime.now(); 
				String fecha=dtf.format(now);
				gestorResena.escribirResena(juego,usuario,titulo,resenia,calificacion,fecha);
				resenas.dispose();
			}
		});
		btnNewButton.setBounds(597, 371, 124, 23);
		resenas.getContentPane().add(btnNewButton);
		
		JButton back = new JButton("Cancelar");
		back.setBounds(498, 371, 89, 23);
		resenas.getContentPane().add(back);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resenas.dispose();
			}
		});
	}
}
