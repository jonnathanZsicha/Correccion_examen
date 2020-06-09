package examen.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.txw2.Document;

import emaxen.dao.ComidaDAO;
import emaxen.dao.DAOFactory;
import examen.entidad.Comida;

/**
 * Servlet implementation class Sumar
 */
@WebServlet("/Sumar")
public class Sumar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Comida>comidas;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sumar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ComidaDAO comidaDAO = DAOFactory.getFactory().getComidaDAO();
		
		String[] titulos = request.getParameterValues("comidas");
		String[] nombres = request.getParameterValues("nombres");
		double suma=0;
		for (int i = 0; i< titulos.length; i++) {
			suma= suma + Double.parseDouble(titulos[i]);
			Comida comida = new Comida(nombres[i], Double.parseDouble(titulos[i]), null);
			comidaDAO.create(comida);
		}
		System.out.println(suma);
		comidas=comidaDAO.findByVacio(null);
		System.out.println(comidas);
	
		request.setAttribute("total", suma);
		request.setAttribute("comidas", comidas);
		

		request.getRequestDispatcher( "/JSP/Pedido.jsp" ).forward( request, response );
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
