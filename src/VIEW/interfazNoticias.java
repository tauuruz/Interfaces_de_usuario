package VIEW;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import MODEL.gestorNoticias;
import MODEL.noticia;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

public class interfazNoticias {

	private JFrame frmNoticias;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazNoticias window = new interfazNoticias();
					window.frmNoticias.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfazNoticias() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		List<noticia> notic = gestorNoticias.visualizarNoticias();
		int stringLength = notic.size();
		
		frmNoticias = new JFrame();
		frmNoticias.setAlwaysOnTop(true);
		frmNoticias.setIconImage(Toolkit.getDefaultToolkit().getImage(interfazNoticias.class.getResource("/img/icono.png")));
		frmNoticias.setResizable(false);
		frmNoticias.setTitle("Noticias");
		frmNoticias.setBounds(100, 100, 994, 659);
		frmNoticias.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmNoticias.getContentPane().setLayout(null);
		
		JButton Back = new JButton("Regresar");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNoticias.dispose();
			}
		});
		Back.setBounds(879, 590, 89, 23);
		frmNoticias.getContentPane().add(Back);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 958, 568);
		frmNoticias.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel titulo = new JLabel("");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		titulo.setBounds(10, 11, 938, 25);
		if(stringLength!=0) {
			titulo.setText(notic.get(0).getTitulo());
		}
		panel.add(titulo);
		
		JLabel date = new JLabel("");
		date.setBounds(10, 36, 938, 25);
		if(stringLength!=0) {
			date.setText(notic.get(0).getFecha());
		}
		panel.add(date);
		
		JTextArea noticia = new JTextArea();
		noticia.setEditable(false);
		noticia.setBounds(10, 71, 938, 81);
		if(stringLength!=0) {
			noticia.setText(notic.get(0).getNoticia());
		}
		noticia.setLineWrap(true);
		noticia.setWrapStyleWord(true);
		panel.add(noticia);
		
		JTextArea noticia_1 = new JTextArea();
		noticia_1.setEditable(false);
		noticia_1.setBounds(10, 476, 938, 81);
		if(stringLength!=0) {
			noticia_1.setText(notic.get(1).getNoticia());
		}
		noticia_1.setLineWrap(true);
		noticia_1.setWrapStyleWord(true);
		panel.add(noticia_1);
		
		JLabel date_1 = new JLabel("");
		date_1.setBounds(10, 441, 938, 25);
		if(stringLength!=0) {
			date_1.setText(notic.get(1).getFecha());
		}
		panel.add(date_1);
		
		JLabel titulo_1 = new JLabel("");
		titulo_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		titulo_1.setBounds(10, 416, 938, 25);
		if(stringLength!=0) {
			titulo_1.setText(notic.get(1).getTitulo());
		}
		panel.add(titulo_1);
		
		JTextArea noticia_2 = new JTextArea();
		noticia_2.setEditable(false);
		noticia_2.setBounds(10, 274, 938, 81);
		if(stringLength!=0) {
			noticia_2.setText(notic.get(2).getNoticia());
		}
		noticia_2.setLineWrap(true);
		noticia_2.setWrapStyleWord(true);
		panel.add(noticia_2);
		
		JLabel date_2 = new JLabel("");
		date_2.setBounds(10, 239, 938, 25);
		if(stringLength!=0) {
			date_2.setText(notic.get(2).getFecha());
		}
		panel.add(date_2);
		
		JLabel titulo_2 = new JLabel("");
		titulo_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		titulo_2.setBounds(10, 214, 938, 25);
		if(stringLength!=0) {
			titulo_2.setText(notic.get(2).getTitulo());
		}
		panel.add(titulo_2);
	}
}
