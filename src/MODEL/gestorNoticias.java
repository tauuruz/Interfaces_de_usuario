package MODEL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import SERVICE.DB_Connector;

public class gestorNoticias {
	
	static DB_Connector con;
	
	public static List<noticia> visualizarNoticias() {
		List<noticia> notic = new ArrayList<noticia>();
		con = new DB_Connector();
    	Connection reg = con.getConnection();
    	try {
			String sqlU="SELECT * FROM noticias";
			Statement stU=reg.createStatement();
			ResultSet rs=stU.executeQuery(sqlU);
			while(rs.next()) {
				noticia resR = new noticia(rs.getInt("id_noticia"),rs.getString("titulo"),rs.getString("noticia"),rs.getString("fecha"));
				notic.add(resR);
			}
		}catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
		return notic;
	}
}