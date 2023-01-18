package MODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import SERVICE.DB_Connector;

public class gestorSoporte {
	
	static DB_Connector con;
	
	public static void generarReporte(String usuario,String titulo,String descripcion,String fecha) {
		con = new DB_Connector();
        Connection reg = con.getConnection();
        try {
        	String sqlU="SELECT * FROM usuarios WHERE usuario='"+usuario+"'";
    		Statement st=reg.createStatement();
			ResultSet rs=st.executeQuery(sqlU);
			if(rs.next()) {
				int IDuser=rs.getInt("id_usuario");
				String sql="INSERT INTO soporte (id_usuario,titulo,descripcion,fecha) VALUES(?,?,?,?)";
	    		PreparedStatement pst=reg.prepareStatement(sql);
	    		pst.setInt(1, IDuser);
	    		pst.setString(2, titulo);
	    		pst.setString(3, descripcion);
	    		pst.setString(4, fecha);
	    		pst.executeUpdate();
	    		JOptionPane.showMessageDialog(null, "El reporte se ha enviado exitosamente, ¡gracias por tus comentarios!");
			}
        }catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR: " + x);
		}
	}
}