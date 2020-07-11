package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import model.Ambientes;

public class Ambientes_dao {
	private Connection conn;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	public Ambientes_dao() {
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean Crear(Ambientes ambiente) throws SQLException, IOException {
		String sql=null;
		 
		estadoOperacion = false;
		try {
			conn = Conexion.GetConexion();
			conn.setAutoCommit(false);
			sql = "INSERT INTO ambientes (id,nombre,direccion,color) Value (?,?,?,?)";
			statement = conn.prepareStatement(sql);
			statement.setString(1, null);
			statement.setString(2,ambiente.getNombre());
			statement.setString(3, ambiente.getDireccion());
			statement.setString(4, ambiente.getColor());
			estadoOperacion=statement.executeUpdate()>0;
			 
			conn.commit();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return estadoOperacion;
		
	}
	
	public List<Ambientes> leerAbientes() throws SQLException, IOException{
		String sql=null;
		ResultSet resultset = null;
		List<Ambientes> lista_ambiente = new ArrayList<Ambientes>();
		conn = Conexion.GetConexion();
		sql ="SELECT  * from ambientes";
		statement = conn.prepareStatement(sql);
		resultset = statement.executeQuery(sql);
		while (resultset.next()) {
			Ambientes cursor_modelo = new Ambientes();
			cursor_modelo.setId(resultset.getInt(1));
			cursor_modelo.setNombre(resultset.getString(2));
			cursor_modelo.setDireccion(resultset.getString(3));
			cursor_modelo.setColor(resultset.getString(4));
			lista_ambiente.add(cursor_modelo);
		}
		statement.close();
		conn.close();
		return lista_ambiente;
		
	}
	
	public Ambientes leerAmbiente(int id) throws SQLException, IOException {
		String sql = null;
		ResultSet resultset =null;
		Ambientes cursor_modelo = new Ambientes();
		estadoOperacion = false;
		conn = Conexion.GetConexion();
		
		sql ="SELECT  * from ambientes where id = " + id ;
		
		statement = conn.prepareStatement(sql);
		resultset = statement.executeQuery(sql);
		
		while (resultset.next()) {
			cursor_modelo.setId(resultset.getInt(1));
			cursor_modelo.setNombre(resultset.getString(2));
			cursor_modelo.setDireccion(resultset.getString(3));
			cursor_modelo.setColor(resultset.getString(4));
			 
		}
		return cursor_modelo;
	}
	
	public boolean Eliminar(int id) throws SQLException, IOException {
		String sql = null;
		
		estadoOperacion=false;
		conn = Conexion.GetConexion();
		conn.setAutoCommit(false);
		sql  = "DELETE from ambientes where id = ? ";
		statement = conn.prepareStatement(sql);
		statement.setInt(1, id);
		estadoOperacion= statement.executeUpdate()>0;
		conn.commit();
		statement.close();
		conn.close();
		
		return estadoOperacion;
		
		
	}
	
	public boolean Editar (Ambientes ambiente) throws SQLException, IOException {
		String sql = null; 
		estadoOperacion=false;
		conn = Conexion.GetConexion();
		conn.setAutoCommit(false);
		
		sql = "UPDATE ambientes SET nombre = ?, direccion = ?, color = ? WHERE id = ?";
		statement = conn.prepareStatement(sql);
		
		statement.setString(1,ambiente.getNombre());
		statement.setString(2,ambiente.getDireccion());
		statement.setString(3, ambiente.getColor());
		statement.setInt(4, ambiente.getId());
		
		
		estadoOperacion=statement.executeUpdate()>0;
		
		conn.commit();
		statement.close();
		conn.close();
		
		return estadoOperacion;
		
	}
	
	
	
	
	

}
