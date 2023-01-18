package MODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import SERVICE.DB_Connector;
import VIEW.interfazAmigos;

public class gestorAmigos {
	
	static DB_Connector con;
	
	public static String mostrarAmigos(usuario usuario) {
    	String amigosL = null;
    	con = new DB_Connector();
        Connection reg = con.getConnection();
        try {
        	String sqlU="SELECT amigos FROM amigos WHERE id_usuario='"+usuario.getId_usuario()+"'";
    		Statement st=reg.createStatement();
    		ResultSet rs=st.executeQuery(sqlU);
    		if(rs.next()) {
    			String nJ=rs.getString("amigos");
    			if(nJ!=null) {
    				amigosL=nJ;
    			}
    		}
        }catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
        return amigosL;
    }
	
	public static void agregarAmigo(usuario usuario, String username) {
		String friends = mostrarAmigos(usuario);
		if(friends==null) {
			friends=username;
		}
		else {
			friends=friends+","+username;
		}
		String sqlV="SELECT usuario FROM usuarios WHERE usuario='"+username+"'";
		con = new DB_Connector();
        Connection reg = con.getConnection();
        String sql="UPDATE amigos SET amigos ='"+friends+"' WHERE id_usuario='"+usuario.getId_usuario()+"'";
	        try {
	        	Statement st=reg.createStatement();
	    		ResultSet rsE=st.executeQuery(sqlV);
	    		if(rsE.next()) {
	    			PreparedStatement pst=reg.prepareStatement(sql);
		        	pst.executeUpdate();
		        	JOptionPane.showMessageDialog(null, "Se ha agregado a ''" + username + "'' a tu lista de amigos.");
				}
	    		else {
	    			JOptionPane.showMessageDialog(null, "El usuario ''" + username + "'' no existe.");
	    		}
	        	
			}catch (Exception x) {
				JOptionPane.showMessageDialog(null, "ERROR: " + x);
			}
    }
	
	public static void eliminarAmigo(usuario usuario,String selected) {
		String friends = mostrarAmigos(usuario);
		List<String> friendsList = new ArrayList<>(Arrays.asList(friends.split(",")));
		int index = friendsList.indexOf(selected);
		if(index!=-1) {
			friendsList.remove(index);
			StringBuilder str = new StringBuilder();
			for (String  friend : friendsList) {
				str.append(friend);
				str.append(",");
			}
			con = new DB_Connector();
	        Connection reg = con.getConnection();
	        String sql="UPDATE amigos SET amigos ='"+str+"' WHERE id_usuario='"+usuario.getId_usuario()+"'";
		        try {
		        	PreparedStatement pst=reg.prepareStatement(sql);
		        	pst.executeUpdate();
		    		JOptionPane.showMessageDialog(null, "Se ha eliminado a ''" + selected + "'' de tu lista de amigos.");
		    		interfazAmigos.main(new String[0], usuario);
				}catch (Exception x) {
					JOptionPane.showMessageDialog(null, "ERROR: " + x);
				}
		}
		else {
			JOptionPane.showMessageDialog(null, "El usuario ''" + selected + "'' no existe en tu lista de amigos.");
		}
    }
}