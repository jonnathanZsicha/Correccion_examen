package examen.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emaxen.dao.ComidaDAO;
import emaxen.dao.DAOFactory;
import emaxen.dao.PedidoDAO;
import emaxen.dao.TarjetaCreditoDAO;
import examen.entidad.Comida;
import examen.entidad.Pedido;

/**
 * Servlet implementation class Busquedas
 */
@WebServlet("/Busqueda")
public class Busquedas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Pedido>pedidos;
	private String url;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Busquedas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		TarjetaCreditoDAO tarjetadao = DAOFactory.getFactory().getTarjetaCreditoDAO();
		ComidaDAO comidadao = DAOFactory.getFactory().getComidaDAO();
		PedidoDAO pedidodao = DAOFactory.getFactory().getPedidoDAO();
		
		if (request.getParameter("nombre") != null) {
			String busqueda = request.getParameter("busqueda");
			pedidos=pedidodao.findByComida(busqueda);
			request.setAttribute("pedidos", pedidos);
			url="/JSP/ListComidas.jsp" ;
			
			
		}else if (request.getParameter("tarjeta")!=null) {
			String busqueda = request.getParameter("busqueda");
			pedidos=pedidodao.findByTarjeta(busqueda);
			request.setAttribute("pedidos", pedidos);
			url="/JSP/ListComidas.jsp" ;
			
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
