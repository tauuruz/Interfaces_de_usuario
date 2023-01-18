package VIEW;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class interfazAcerca {

	private JFrame frmAcercaDeAmadeus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazAcerca window = new interfazAcerca();
					window.frmAcercaDeAmadeus.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfazAcerca() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAcercaDeAmadeus = new JFrame();
		frmAcercaDeAmadeus.setResizable(false);
		frmAcercaDeAmadeus.setAlwaysOnTop(true);
		frmAcercaDeAmadeus.setTitle("Acerca de Amadeus");
		frmAcercaDeAmadeus.setIconImage(Toolkit.getDefaultToolkit().getImage(interfazAcerca.class.getResource("/img/icono.png")));
		frmAcercaDeAmadeus.setBounds(100, 100, 450, 300);
		frmAcercaDeAmadeus.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAcercaDeAmadeus.getContentPane().setLayout(null);
		
		ImageIcon imageIcon = new ImageIcon(interfazLogin.class.getResource("/img/icono.png"));
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(imageIcon);
		logo.setBounds(156, 11, 120, 120);
		frmAcercaDeAmadeus.getContentPane().add(logo);
		
		JLabel amadeusTxt = new JLabel("Amadeus ver. 1.0");
		amadeusTxt.setHorizontalAlignment(SwingConstants.CENTER);
		amadeusTxt.setBounds(10, 142, 414, 25);
		frmAcercaDeAmadeus.getContentPane().add(amadeusTxt);
		
		JButton aceptar = new JButton("Aceptar");
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAcercaDeAmadeus.dispose();
			}
		});
		aceptar.setBounds(156, 227, 120, 23);
		frmAcercaDeAmadeus.getContentPane().add(aceptar);
		
		JLabel amadeusTxt_3_2 = new JLabel("UAM-C");
		amadeusTxt_3_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		amadeusTxt_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		amadeusTxt_3_2.setBounds(10, 185, 414, 20);
		frmAcercaDeAmadeus.getContentPane().add(amadeusTxt_3_2);
	}
}
