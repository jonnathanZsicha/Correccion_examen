package examen.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emaxen.dao.ComidaDAO;
import emaxen.dao.DAOFactory;
import emaxen.dao.PedidoDAO;
import examen.entidad.Comida;

/**
 * Servlet implementation class RegistrarComida
 */
@WebServlet("/RegistrarComida")
public class RegistrarComida extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarComida() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ComidaDAO comidadao = DAOFactory.getFactory().getComidaDAO();
		PedidoDAO pedidodao = DAOFactory.getFactory().getPedidoDAO();
		
		if (request.getParameter("id") != null) {
		int id = Integer.parseInt(request.getParameter("id"));
		Comida comidapedido = comidadao.read(id);
		
		System.out.println("esta es la comida" + comidapedido);
		//Comida comida1 = new Comida(comidapedido.getNombre(),comidapedido.getPreciounitario(),id);
			
		} else {
			
			double precio1= Double.parseDouble(request.getParameter("precio")); 	
			Comida comida1 = new Comida(request.getParameter("nombre"),precio1 , null);
			comidadao.create(comida1);
			System.out.println("ingresado comida exitosamente");

		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
