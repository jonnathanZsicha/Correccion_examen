package examen.test;

import java.util.List;

import emaxen.dao.ComidaDAO;
import emaxen.dao.DAOFactory;
import examen.entidad.Comida;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComidaDAO comidaDAO = DAOFactory.getFactory().getComidaDAO();
		List<Comida>comidas=comidaDAO.readAll();
		System.out.println(comidas);
		

	}

}
