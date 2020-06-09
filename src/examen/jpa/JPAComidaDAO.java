package examen.jpa;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import emaxen.dao.ComidaDAO;
import examen.entidad.Comida;
import examen.entidad.Pedido;

public class JPAComidaDAO extends JPAGenericDAO<Comida, Integer> implements ComidaDAO{

	public JPAComidaDAO() {
		super(Comida.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Comida> findByVacio(String nulo) {
		// TODO Auto-generated method stub
		Pedido pedido = null;
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Comida> criteriaQuery = criteriaBuilder.createQuery(Comida.class);
		
		Root<Comida> telefonoRoot = criteriaQuery.from(Comida.class);
		
		Predicate predicate = criteriaBuilder.equal(telefonoRoot.get("pedido"), pedido);
		
		criteriaQuery.select(telefonoRoot).where(predicate);

		return em.createQuery(criteriaQuery).getResultList();
		
	}

}
