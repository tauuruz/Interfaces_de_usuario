package VIEW;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import MODEL.gestorCuenta;
import MODEL.usuario;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
public class interfazDowngrade {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,usuario usuario) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazDowngrade window = new interfazDowngrade(usuario);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfazDowngrade(usuario usuario) {
		initialize(usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(usuario usuario) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(interfazUpgrade.class.getResource("/img/icono.png")));
		frame.setTitle("Cancelar membresía");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 228, 434, 33);
		frame.getContentPane().add(panel);
		
		JButton downG = new JButton("Si");
		downG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorCuenta.downgradeUser(usuario.getUsuario());
				usuario.setPrem(false);
				frame.dispose();
				interfazLibreria.main(new String[0],usuario);
			}
		});
		panel.add(downG);
		
		JButton cancelB = new JButton("No");
		cancelB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				interfazLibreria.main(new String[0],usuario);
			}
		});
		panel.add(cancelB);
		
		JLabel lblNewLabel = new JLabel("Si cancelas tu membres\u00EDa premium");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPerderasAccesoA = new JLabel("perderas acceso a todo el contenido");
		lblPerderasAccesoA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPerderasAccesoA.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerderasAccesoA.setBounds(10, 55, 414, 33);
		frame.getContentPane().add(lblPerderasAccesoA);
		
		JLabel lblYBeneficiosQue = new JLabel("y beneficios que te ofrece.");
		lblYBeneficiosQue.setHorizontalAlignment(SwingConstants.CENTER);
		lblYBeneficiosQue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblYBeneficiosQue.setBounds(10, 99, 414, 33);
		frame.getContentPane().add(lblYBeneficiosQue);
		
		JLabel lblNewLabel_1 = new JLabel("\u00BFEstas segura/o?");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(121, 197, 186, 20);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
