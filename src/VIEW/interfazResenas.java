package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import MODEL.videojuego;
import MODEL.gestorResena;
import MODEL.resena;

public class interfazResenas {

	private JFrame frmRese;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,videojuego juego) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazResenas window = new interfazResenas(juego);
					window.frmRese.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfazResenas(videojuego juego) {
		initialize(juego);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(videojuego juego) {
		List<resena> resen = gestorResena.visualizarResenas(juego);
		int stringLength = resen.size();
		
		frmRese = new JFrame();
		frmRese.setAlwaysOnTop(true);
		frmRese.setTitle("Reseñas - "+juego.getNombre());
		frmRese.setIconImage(Toolkit.getDefaultToolkit().getImage(interfazResenas.class.getResource("/img/icono.png")));
		frmRese.setResizable(false);
		frmRese.setBounds(100, 100, 600, 450);
		frmRese.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRese.getContentPane().setLayout(null);
		
		JButton back = new JButton("Regresar");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRese.dispose();
			}
		});
		back.setBounds(485, 377, 89, 23);
		frmRese.getContentPane().add(back);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 564, 358);
		frmRese.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel titulo = new JLabel("");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		titulo.setBounds(0, 11, 544, 25);
		if(stringLength!=0) {
			titulo.setText(resen.get(0).getTitulo());
		}
		panel.add(titulo);
		
		JLabel user = new JLabel("");
		user.setBounds(0, 33, 544, 20);
		if(stringLength!=0) {
			user.setText(resen.get(0).getusuario());
		}
		panel.add(user);
		
		JLabel date = new JLabel("");
		date.setBounds(0, 47, 544, 20);
		if(stringLength!=0) {
			date.setText(resen.get(0).getFecha());
		}
		panel.add(date);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		if(stringLength!=0) {
			textArea.setText(resen.get(0).getResena());
		}
		textArea.setBounds(0, 64, 564, 89);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		panel.add(textArea);
		
		String bueno = "Recomendado";
		String malo = "No recomendado";
		JLabel recomendado = new JLabel("");
		recomendado.setHorizontalAlignment(SwingConstants.RIGHT);
		recomendado.setBounds(453, 47, 111, 20);
		if(stringLength!=0) {
			if(resen.get(0).getCalificacion()==0) {
				recomendado.setText(malo);
			}
			if(resen.get(0).getCalificacion()==1) {
				recomendado.setText(bueno);
			}
		}
		panel.add(recomendado);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		if(stringLength>1) {
			textArea_1.setText(resen.get(1).getResena());
		}
		textArea_1.setBounds(0, 237, 564, 89);
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		panel.add(textArea_1);
		
		JLabel date_1 = new JLabel("");
		if(stringLength>1) {
			date_1.setText(resen.get(1).getFecha());
		}
		date_1.setBounds(0, 220, 544, 20);
		panel.add(date_1);
		
		JLabel user_1 = new JLabel("");
		if(stringLength>1) {
			user_1.setText(resen.get(1).getusuario());
		}
		user_1.setBounds(0, 206, 544, 20);
		panel.add(user_1);
		
		JLabel titulo_1 = new JLabel("");
		if(stringLength>1) {
			titulo_1.setText(resen.get(1).getTitulo());
		}
		titulo_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		titulo_1.setBounds(0, 184, 544, 25);
		panel.add(titulo_1);
		
		JLabel recomendado_1 = new JLabel("");
		if(stringLength>1) {
			if(resen.get(1).getCalificacion()==0) {
				recomendado_1.setText(malo);
			}
			if(resen.get(1).getCalificacion()==1) {
				recomendado_1.setText(bueno);
			}
		}
		recomendado_1.setHorizontalAlignment(SwingConstants.RIGHT);
		recomendado_1.setBounds(453, 220, 111, 20);
		panel.add(recomendado_1);
	}
}
