package conexion;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PruebaBD {

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
		new Conexion();
		Connection conn = null;
		try {
			conn = Conexion.GetConexion();
			PreparedStatement ps = conn.prepareStatement("SELECT id,direccion,nombre FROM ambientes");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(2));
			} 
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
