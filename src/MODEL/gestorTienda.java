package MODEL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

import SERVICE.DB_Connector;

public class gestorTienda {
	
	static DB_Connector con;
	
	public static videojuego visualizarTienda(String select) {
    	videojuego game = new videojuego();
    	con = new DB_Connector();
        Connection reg = con.getConnection();
        String sql="SELECT * FROM videojuego WHERE nombre='"+select+"'";
        try {
    		Statement st=reg.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()) {
	            videojuego gameR = new videojuego(rs.getInt("id_juego"),rs.getString("nombre"),rs.getString("categoria"),rs.getString("genero"),rs.getDouble("precio"),rs.getString("descripcion"),rs.getString("desarrollador"));
	            return gameR;
	        }
		}catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
        return game;
    }

}
