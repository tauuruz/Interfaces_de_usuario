package MODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import SERVICE.DB_Connector;

public class gestorResena {
	
	static DB_Connector con;
	
	public static void escribirResena(videojuego juego,String usuario,String titulo,String resenia,int calificacion,String fecha) {
		con = new DB_Connector();
        Connection reg = con.getConnection();
        try {
        	String sqlU="SELECT * FROM usuarios WHERE usuario='"+usuario+"'";
    		Statement st=reg.createStatement();
			ResultSet rs=st.executeQuery(sqlU);
			if(rs.next()) {
				int IDuser=rs.getInt("id_usuario");
				String sql="INSERT INTO resenas (id_usuario,id_juego,titulo,resena,calificacion,fecha) VALUES(?,?,?,?,?,?)";
	    		PreparedStatement pst=reg.prepareStatement(sql);
	    		pst.setInt(1, IDuser);
	    		pst.setInt(2, juego.getID());
	    		pst.setString(3, titulo);
	    		pst.setString(4, resenia);
	    		pst.setInt(5, calificacion);
	    		pst.setString(6, fecha);
	    		pst.executeUpdate();
	    		JOptionPane.showMessageDialog(null, "Se ha registrado la reseña correctamente.");
			}
        }catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
	}
	
	public static List<resena> visualizarResenas(videojuego juego) {
		List<resena> resen = new ArrayList<resena>();
		con = new DB_Connector();
    	Connection reg = con.getConnection();
    	try {
    		String sql="SELECT * FROM resenas WHERE id_juego='"+juego.getID()+"'";
    		Statement st=reg.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				int IDuser=rs.getInt("id_usuario");
				try {
					String sqlU="SELECT usuario FROM usuarios WHERE id_usuario='"+IDuser+"'";
					Statement stU=reg.createStatement();
					ResultSet rsU=stU.executeQuery(sqlU);
					if(rsU.next()) {
						String user=rsU.getString("usuario");
						resena resR = new resena(rs.getInt("id_resena"),user,rs.getInt("id_juego"),rs.getString("titulo"),rs.getString("resena"),rs.getInt("calificacion"),rs.getString("fecha"));
						resen.add(resR);
					}
				}catch (Exception x) {
					JOptionPane.showMessageDialog(null, "ERROR: " + x);
				}
			}
    	}catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
		return resen;
	}

}
