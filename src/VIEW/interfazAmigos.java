package VIEW;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.util.Arrays;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import MODEL.gestorAmigos;
import MODEL.usuario;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class interfazAmigos {
	
	static String sel = null;

	private JFrame frmChatAmigos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,usuario usuario) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazAmigos window = new interfazAmigos(usuario);
					window.frmChatAmigos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfazAmigos(usuario usuario) {
		initialize(usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize(usuario usuario) {
		frmChatAmigos = new JFrame();
		frmChatAmigos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmChatAmigos.setTitle("Chat & Amigos");
		frmChatAmigos.setIconImage(Toolkit.getDefaultToolkit().getImage(interfazAmigos.class.getResource("/img/icono.png")));
		frmChatAmigos.setResizable(false);
		frmChatAmigos.setBounds(100, 100, 290, 450);
		frmChatAmigos.getContentPane().setLayout(null);
		
		@SuppressWarnings("rawtypes")
		JList list = new JList();
		DefaultListModel<String> model;
		model = new DefaultListModel<>();
		String friends = gestorAmigos.mostrarAmigos(usuario);
		if(friends==null) {
			model.addElement("Aún no tienes amigos agregados.");
		}
		else {
			List<String> friendsList = Arrays.asList(friends.split(","));
			for (String nomJ : friendsList) {
				model.addElement(nomJ);
	        }
		}
		list.setModel(model);
		list.setBackground(Color.LIGHT_GRAY);
		list.setBounds(10, 91, 254, 309);
		frmChatAmigos.getContentPane().add(list);
		
		ImageIcon imageIcon = new ImageIcon(interfazLogin.class.getResource("/img/profile.jpg"));
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		
		JLabel profile = new JLabel("");
		profile.setHorizontalAlignment(SwingConstants.CENTER);
		profile.setBounds(10, 11, 50, 50);
		profile.setIcon(imageIcon);
		frmChatAmigos.getContentPane().add(profile);
		
		JLabel userName = new JLabel(usuario.getUsuario());
		userName.setBounds(70, 11, 111, 14);
		frmChatAmigos.getContentPane().add(userName);
		
		JLabel lblNewLabel = new JLabel("En linea");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setBounds(70, 27, 68, 14);
		frmChatAmigos.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(10, 82, 254, 4);
		frmChatAmigos.getContentPane().add(separator);
		
		JButton addFriendBtn = new JButton("Agregar amigo");
		addFriendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazAgregarAmigo.main(new String[0],usuario);
				frmChatAmigos.dispose();
			}
		});
		addFriendBtn.setFont(new Font("Tahoma", Font.PLAIN, 8));
		addFriendBtn.setBounds(175, 65, 89, 14);
		frmChatAmigos.getContentPane().add(addFriendBtn);
		
		JButton deleteFriendBtn = new JButton("Eliminar amigo");
		deleteFriendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorAmigos.eliminarAmigo(usuario, sel);
				frmChatAmigos.dispose();
			}
		});
		deleteFriendBtn.setFont(new Font("Tahoma", Font.PLAIN, 8));
		deleteFriendBtn.setBounds(10, 66, 89, 14);
		deleteFriendBtn.setVisible(false);
		frmChatAmigos.getContentPane().add(deleteFriendBtn);
		
		list.addListSelectionListener(new ListSelectionListener() {

	        @Override
	        public void valueChanged(ListSelectionEvent arg0) {
	            if (!arg0.getValueIsAdjusting()) {
	            	String selected =list.getSelectedValue().toString();
	            	sel=selected;
	            	deleteFriendBtn.setVisible(true);
	            }
	        }
	    });
	}
}
