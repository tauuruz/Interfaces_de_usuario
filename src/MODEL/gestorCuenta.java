package MODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

import SERVICE.DB_Connector;

public class gestorCuenta {
	static DB_Connector con;
	
	public static usuario visualizarCuenta(String user) {
    	usuario usuario = new usuario();
    	con = new DB_Connector();
        Connection reg = con.getConnection();
        String sql="SELECT * FROM usuarios WHERE usuario='"+user+"'";
        try {
    		Statement st=reg.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if (rs.next()) {
	            usuario usuarioR = new usuario(rs.getInt("id_usuario"),rs.getString("usuario"),rs.getString("nombre"),rs.getString("apellido_p"),rs.getString("apellido_m"),rs.getString("direccion"),rs.getDouble("telefono"),rs.getString("correo"),rs.getString("contrasena"),rs.getBoolean("premium"));
	            return usuarioR;
	        }
		}catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
        return usuario;
    }
	
	public static void cambiarPssw(int id_usuario,String newPass) {
		int stringLength = newPass.length();
		if(stringLength<8) {
			JOptionPane.showMessageDialog(null, "La longitud de la contraseña debe ser minimo de 8 carácteres.");
		}
		else {
			con = new DB_Connector();
	        Connection reg = con.getConnection();
	        String sql="UPDATE usuarios SET contrasena='"+newPass+"' WHERE usuarios.id_usuario='"+id_usuario+"'";
	        try {
	        	PreparedStatement pst=reg.prepareStatement(sql);
	        	pst.executeUpdate();
	        	JOptionPane.showMessageDialog(null, "La contraseña se actualizó correctamente.");
			}catch (Exception x) {
				JOptionPane.showMessageDialog(null, "ERROR: " + x);
			}
		}
    }
	
	public static void registrarUsuario(String usuario,String nombre,String paterno,String materno,String direccion,String telefono,String correo, String password, boolean premium) {
    	con = new DB_Connector();
        Connection reg = con.getConnection();
        String sql="SELECT * FROM usuarios WHERE usuario='"+usuario+"'";
        String sqlE="SELECT * FROM usuarios WHERE correo='"+correo+"'";
        try {
    		Statement st=reg.createStatement();
    		ResultSet rsE=st.executeQuery(sqlE);
			
			if(rsE.next()) {
				JOptionPane.showMessageDialog(null, "La direccion de correo ''" + correo + "'' ya se encuentra registrada.");
			}
			else {
				Statement stU=reg.createStatement();
	    		ResultSet rs=stU.executeQuery(sql);
				if(rs.next()) {
					JOptionPane.showMessageDialog(null, "El usuario ''" + usuario + "'' no está disponible, por favor elija otro.");
				}
				else {
					String sqlR="INSERT INTO usuarios (usuario,nombre,apellido_p,apellido_m,direccion,telefono,correo,contrasena,premium) VALUES(?,?,?,?,?,?,?,?,?)";
			    	try {
			    		PreparedStatement pst=reg.prepareStatement(sqlR);
			    		pst.setString(1, usuario);
			    		pst.setString(2, nombre);
			    		pst.setString(3, paterno);
			    		pst.setString(4, materno);
			    		pst.setString(5, direccion);
			    		pst.setString(6, telefono);
			    		pst.setString(7, correo);
			    		pst.setString(8, password);
			    		pst.setBoolean(9, premium);
			    		pst.executeUpdate();
			    		JOptionPane.showMessageDialog(null, "Usuario ''" + usuario + "'' registrado correctamente con el correo ''" + correo + "''");
			    		String sqluF="SELECT id_usuario FROM usuarios WHERE usuario='"+usuario+"'";
				    		try {
				    			Statement stuF=reg.createStatement();
					    		ResultSet rsUF=stuF.executeQuery(sqluF);
					    		if(rsUF.next()) {
					    			int idUs = rsUF.getInt("id_usuario");
						    		System.out.println(4);
						    		String sqlRF="INSERT INTO amigos (id_usuario) VALUES(?)";
						    		System.out.println(5);
					    			PreparedStatement pstrF=reg.prepareStatement(sqlRF);
					    			System.out.println(6);
					    			pstrF.setInt(1, idUs);
					    			System.out.println(7);
					    			pstrF.executeUpdate();
					    		}					    		
							}catch (Exception x) {
								JOptionPane.showMessageDialog(null, "ERROR: " + x);
							}
					}catch (Exception x) {
						JOptionPane.showMessageDialog(null, "ERROR: " + x);
					}
				}
			}
		}catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
    }
    
    public static int logIn(String user, String passw) {
    	int value=0;
		con = new DB_Connector();
        Connection reg = con.getConnection();
        String sql="SELECT * FROM usuarios WHERE usuario='"+user+"' AND BINARY contrasena='"+passw+"'";
    	try {
    		Statement st=reg.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if(rs.next()) {
				value=1;
			}			
		}catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
        return value;
    }
    
    public static int logInDev(String user, String passw) {
    	int value=0;
		con = new DB_Connector();
        Connection reg = con.getConnection();
        String sql="SELECT * FROM desarrolladores WHERE usuario='"+user+"' AND BINARY contrasena='"+passw+"'";
    	try {
    		Statement st=reg.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if(rs.next()) {
				value=1;
			}			
		}catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
        return value;
    }
    
    public static void upgradeUser(String user) {
    	con = new DB_Connector();
        Connection upg = con.getConnection();
        try {
        	String sql="UPDATE usuarios SET premium ='1' WHERE usuario='"+user+"'";
        	PreparedStatement pst=upg.prepareStatement(sql);
        	pst.executeUpdate();
        	JOptionPane.showMessageDialog(null, "Ahora eres premium ");
		}catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
    }
    
    public static void downgradeUser(String user) {
    	con = new DB_Connector();
        Connection upg = con.getConnection();
        try {
        	String sql="UPDATE usuarios SET premium ='0' WHERE usuario='"+user+"'";
        	PreparedStatement pst=upg.prepareStatement(sql);
        	pst.executeUpdate();
        	JOptionPane.showMessageDialog(null, "Ya no eres premium ");
		}catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
    }
}

