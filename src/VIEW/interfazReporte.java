package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import MODEL.gestorSoporte;

import javax.swing.JTextArea;

public class interfazReporte {

	private JFrame frmReporte;
	private JTextField tituloBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,String usuario) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazReporte window = new interfazReporte(usuario);
					window.frmReporte.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfazReporte(String usuario) {
		initialize(usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String usuario) {
		frmReporte = new JFrame();
		frmReporte.setTitle("Generar reporte");
		frmReporte.setIconImage(Toolkit.getDefaultToolkit().getImage(interfazReporte.class.getResource("/img/icono.png")));
		frmReporte.setResizable(false);
		frmReporte.setBounds(100, 100, 450, 300);
		frmReporte.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmReporte.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmReporte.dispose();
			}
		});
		btnNewButton.setBounds(10, 227, 89, 23);
		frmReporte.getContentPane().add(btnNewButton);
		
		JLabel tituloTxt = new JLabel("Para generar un reporte escriba el titulo del reporte:");
		tituloTxt.setBounds(10, 34, 414, 15);
		frmReporte.getContentPane().add(tituloTxt);
		
		tituloBox = new JTextField();
		tituloBox.setBounds(10, 60, 414, 20);
		frmReporte.getContentPane().add(tituloBox);
		tituloBox.setColumns(10);
		
		JLabel descripcionTxt = new JLabel("Ingrese los detalles del reporte(maximo 200 caractéres):");
		descripcionTxt.setBounds(10, 91, 414, 15);
		frmReporte.getContentPane().add(descripcionTxt);
		
		JTextArea reporteBox = new JTextArea();
		reporteBox.setBounds(10, 117, 414, 99);
		reporteBox.setLineWrap(true);
		reporteBox.setWrapStyleWord(true);
		frmReporte.getContentPane().add(reporteBox);
		
		JButton enviarReporte = new JButton("Enviar reporte");
		enviarReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
				LocalDateTime now = LocalDateTime.now(); 
				String fecha=dtf.format(now);
				String titulo=tituloBox.getText();
				String descripcion=reporteBox.getText();
				gestorSoporte.generarReporte(usuario, titulo, descripcion, fecha);
				frmReporte.dispose();
			}
		});
		enviarReporte.setBounds(282, 227, 142, 23);
		frmReporte.getContentPane().add(enviarReporte);
	}

}
