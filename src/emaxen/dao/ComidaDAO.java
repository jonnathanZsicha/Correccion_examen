package emaxen.dao;

import java.util.List;

import examen.entidad.Comida;


public interface ComidaDAO extends GenericDAO<Comida, Integer>{

	public abstract List<Comida> findByVacio(String nulo);
	
	
}
