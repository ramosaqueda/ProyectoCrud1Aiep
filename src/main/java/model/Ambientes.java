package model;

public class Ambientes {
	private int id;
	private String nombre;
	private String direccion;
	private String color;
	private String created_at;
	private String update_at;
	
	public Ambientes() {
		// TODO Auto-generated constructor stub
	}

	public Ambientes(int id, String nombre, String direccion, String color, String created_at, String update_at) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.color = color;
		this.created_at = created_at;
		this.update_at = update_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(String update_at) {
		this.update_at = update_at;
	}
	
	

}
