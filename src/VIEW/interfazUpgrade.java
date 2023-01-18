package VIEW;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JPanel;

import MODEL.gestorCuenta;
import MODEL.usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class interfazUpgrade {

	private JFrame frmVolversePremium;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, usuario usuario) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazUpgrade window = new interfazUpgrade(usuario);
					window.frmVolversePremium.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfazUpgrade(usuario usuario) {
		initialize(usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(usuario usuario) {
		frmVolversePremium = new JFrame();
		frmVolversePremium.setResizable(false);
		frmVolversePremium.setIconImage(Toolkit.getDefaultToolkit().getImage(interfazUpgrade.class.getResource("/img/icono.png")));
		frmVolversePremium.setTitle("Volverse Premium");
		frmVolversePremium.setBounds(100, 100, 450, 300);
		frmVolversePremium.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmVolversePremium.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 228, 434, 33);
		frmVolversePremium.getContentPane().add(panel);
		
		JButton goPrem = new JButton("Si");
		goPrem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorCuenta.upgradeUser(usuario.getUsuario());
				usuario.setPrem(true);
				frmVolversePremium.dispose();
				interfazLibreria.main(new String[0],usuario);
			}
		});
		panel.add(goPrem);
		
		JButton discardPrem = new JButton("No");
		discardPrem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmVolversePremium.dispose();
				interfazLibreria.main(new String[0],usuario);
			}
		});
		panel.add(discardPrem);
		
		JLabel lblNewLabel = new JLabel("\u00A1Vuelvete Premium hoy!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 27);
		frmVolversePremium.getContentPane().add(lblNewLabel);
		
		JLabel lblOrSolo = new JLabel("Por solo $100 al mes, podras disfrutar de:");
		lblOrSolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrSolo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOrSolo.setBounds(10, 49, 414, 27);
		frmVolversePremium.getContentPane().add(lblOrSolo);
		
		JLabel lblAccesoATodo = new JLabel("     - Acceso a todo nuestro catalogo de juegos");
		lblAccesoATodo.setHorizontalAlignment(SwingConstants.LEFT);
		lblAccesoATodo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAccesoATodo.setBounds(10, 87, 414, 27);
		frmVolversePremium.getContentPane().add(lblAccesoATodo);
		
		JLabel lblAccesoAnticipadoPara = new JLabel("     - Acceso anticipado para juegos nuevos");
		lblAccesoAnticipadoPara.setHorizontalAlignment(SwingConstants.LEFT);
		lblAccesoAnticipadoPara.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAccesoAnticipadoPara.setBounds(10, 125, 414, 27);
		frmVolversePremium.getContentPane().add(lblAccesoAnticipadoPara);
		
		JLabel lblNewLabel_1 = new JLabel("\u00BFTe gustar\u00EDa volverte premium?");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 203, 414, 14);
		frmVolversePremium.getContentPane().add(lblNewLabel_1);
	}

}
