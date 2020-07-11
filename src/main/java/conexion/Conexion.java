package conexion;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
	public static Connection GetConexion() throws SQLException, IOException {
		Connection conn = null;
		Properties props = new Properties(); 
		InputStream is = Conexion.class.getClassLoader().getResourceAsStream("app.properties");
		props.load(is);
		is.close();
		conn = DriverManager.getConnection(props.getProperty("url"), props);
		return conn;
	}

}
