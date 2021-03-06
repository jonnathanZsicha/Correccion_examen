package examen.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import emaxen.dao.ComidaDAO;
import emaxen.dao.DAOFactory;
import emaxen.dao.PedidoDAO;
import emaxen.dao.TarjetaCreditoDAO;
import examen.entidad.Comida;
import examen.entidad.Pedido;
import examen.entidad.TarjetaCredito;

/**
 * Servlet implementation class RegistrarPedido
 */
@WebServlet("/RegistrarPedido")
public class RegistrarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Date fec;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PedidoDAO pedidoDAO = DAOFactory.getFactory().getPedidoDAO();
		ComidaDAO comidaDAO = DAOFactory.getFactory().getComidaDAO();
		TarjetaCreditoDAO tarjetaDAO = DAOFactory.getFactory().getTarjetaCreditoDAO();
		
		double tota = Double.parseDouble(request.getParameter("total"));
		SimpleDateFormat formato = new SimpleDateFormat("yyy/MM/dd");
		TarjetaCredito tarjeta =tarjetaDAO.findByNumero(request.getParameter("tarjeta"));
		System.out.println(tarjeta);
		
		 try {
			fec = formato.parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Pedido pedido = new Pedido(fec,request.getParameter("nombre") ,tota, request.getParameter("observaciones"),tarjeta);
		pedidoDAO.create(pedido);
		List<Comida>comidas=comidaDAO.findByVacio(null);
		for (Comida comida : comidas) {
			Comida comidaupdate = new Comida(comida.getNombre(), comida.getPreciounitario(), pedido);
			comidaDAO.update(comidaupdate);
			
		}
		System.out.println("Se ha creado exitosamente el pedido");
		
		List<Pedido>pedidos=pedidoDAO.readAll();
		request.setAttribute("pedidos", pedidos);
		
		request.getRequestDispatcher( "/JSP/ListComidas.jsp" ).forward( request, response );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
