package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Ambientes_dao;
import model.Ambientes;

/**
 * Servlet implementation class AmbienteController
 */
@WebServlet("/AmbienteController")
public class AmbienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AmbienteController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String opcion = request.getParameter("opc");
		if (opcion.contentEquals("listar")) {
				Ambientes_dao pambientes = new Ambientes_dao();
				List<Ambientes> ambientes = new ArrayList<Ambientes>();
				try {
					ambientes =  pambientes.leerAbientes();
					request.setAttribute("lista", ambientes);
					RequestDispatcher requestDispacher = request.getRequestDispatcher("/vista/ListarAmb.jsp");
					requestDispacher.forward(request, response);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else if (opcion.contentEquals("editar")) {
			int id = Integer.parseInt(request.getParameter("id"));			
			Ambientes_dao ambientedao = new Ambientes_dao();
			Ambientes pambiente = new Ambientes();
			try {
				pambiente = ambientedao.leerAmbiente(id);
				request.setAttribute("ambiente", pambiente);
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/vista/EditarAmb.jsp");
				requestDispacher.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	 
			
			}else if  (opcion.contentEquals("eliminar")){
				int id = Integer.parseInt(request.getParameter("id"));			
				Ambientes_dao ambientedao = new Ambientes_dao();
	 			try {
					boolean res = ambientedao.Eliminar(id);
						if (res) {
			                request.setAttribute("mensaje", "Registro eliminado");
			            } else 
			            {
			                request.setAttribute("mensaje", "No se pudo elimar el registro");
			            }
						
						Ambientes_dao pambientes = new Ambientes_dao();
						List<Ambientes> ambientes = new ArrayList<Ambientes>();
				 
						ambientes =  pambientes.leerAbientes();
						request.setAttribute("lista", ambientes);
							
						RequestDispatcher requestDispacher = request.getRequestDispatcher("/vista/ListarAmb.jsp");
						requestDispacher.forward(request, response);
			           
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if  (opcion.contentEquals("crear")){
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/vista/CrearAmb.jsp");
				requestDispacher.forward(request, response);
	           
			}
 		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		String opcion = request.getParameter("opcion");
		if (opcion.contentEquals("editar")){
			
			String nombre = request.getParameter("nombre");
			String color = request.getParameter("color");
			String direccion = request.getParameter("direccion");
			int id = Integer.parseInt(request.getParameter("id"));		
			
			Ambientes ambiente = new Ambientes();
			Ambientes_dao ambientedao = new Ambientes_dao();
			
			ambiente.setId(id);
			ambiente.setColor(color);
			ambiente.setDireccion(direccion);
			ambiente.setNombre(nombre); 
			

			try {
				boolean res = ambientedao.Editar(ambiente);
				if (res) {
					 request.setAttribute("mensaje", "Registro Guardado OK");
					 response.getWriter().append("Registro Guardado OK").append(request.getContextPath());
				}else {
					 response.getWriter().append("No se pudo grabar el registro").append(request.getContextPath());

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (opcion.contentEquals("guardar")){
			String nombre = request.getParameter("nombre");
			String color = request.getParameter("color");
			String direccion = request.getParameter("direccion");
			 
			
			Ambientes ambiente = new Ambientes();
			Ambientes_dao ambientedao = new Ambientes_dao();
			
			 
			ambiente.setColor(color);
			ambiente.setDireccion(direccion);
			ambiente.setNombre(nombre); 
			

			try {
				boolean res = ambientedao.Crear(ambiente);
				if (res) {
					 request.setAttribute("mensaje", "Registro Guardado OK");
					 response.getWriter().append("Registro Guardado OK").append(request.getContextPath());
					 
					 RequestDispatcher requestDispacher = request.getRequestDispatcher("index.jsp");
						requestDispacher.forward(request, response);
			           
						
				}else {
					 response.getWriter().append("No se pudo grabar el registro").append(request.getContextPath());

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
