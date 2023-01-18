package MODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

import SERVICE.DB_Connector;

public class gestorPagos {
	
	static DB_Connector con;
	
    public static void comprarJuego(videojuego juego,String usuario) {
    	con = new DB_Connector();
    	Connection reg = con.getConnection();
    	try {
    		String sqlU="SELECT * FROM usuarios WHERE usuario='"+usuario+"'";
    		Statement st=reg.createStatement();
			ResultSet rs=st.executeQuery(sqlU);
			if(rs.next()) {
				int IDuser=rs.getInt("id_usuario");
				int IDgame=juego.getID();
				try {
					String sqlJ="SELECT * FROM libreria WHERE id_usuario='"+IDuser+"' AND id_juego='"+IDgame+"'";
					Statement stJ=reg.createStatement();
					ResultSet rsJ=stJ.executeQuery(sqlJ);
					if(rsJ.next()) {
						JOptionPane.showMessageDialog(null, juego.getNombre() + " ya se encuentra en tu libreria.");
					}
					else {
						try {
							String sql="INSERT INTO libreria (id_usuario,id_juego) VALUES(?,?)";
				    		PreparedStatement pst=reg.prepareStatement(sql);
				    		pst.setInt(1, IDuser);
				    		pst.setInt(2, IDgame);
				    		pst.executeUpdate();
				    		JOptionPane.showMessageDialog(null, "Gracias por comprar ''" + juego.getNombre() + "'', ahora podras verlo en tu librería.");
						}catch (Exception x) {
							JOptionPane.showMessageDialog(null, "ERROR: " + x);
						}
					}
				}catch (Exception x) {
					JOptionPane.showMessageDialog(null, "ERROR: " + x);
				}
			}			
		}catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
    }
    
    public static void solicitarReembolso(videojuego juego,String usuario) {
    	con = new DB_Connector();
    	Connection reg = con.getConnection();
    	try {
    		String sqlU="SELECT * FROM usuarios WHERE usuario='"+usuario+"'";
    		Statement st=reg.createStatement();
    		ResultSet rs=st.executeQuery(sqlU);
    		if(rs.next()) {
    			int IDuser=rs.getInt("id_usuario");
    			try {
    				String sql="DELETE FROM libreria WHERE id_usuario='"+IDuser+"' AND id_juego='"+juego.getID()+"'";
    				PreparedStatement pst=reg.prepareStatement(sql);
    	    		pst.executeUpdate();
    	    		JOptionPane.showMessageDialog(null, "Se ha eliminado ''" + juego.getNombre() + "'' de tu librería.");
    			}catch (Exception x) {
    				JOptionPane.showMessageDialog(null, "ERROR: " + x);
    			}
    		}
    	}catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
    }
}