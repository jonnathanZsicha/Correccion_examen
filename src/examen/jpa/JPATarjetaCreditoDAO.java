package examen.jpa;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import emaxen.dao.TarjetaCreditoDAO;
import examen.entidad.TarjetaCredito;

public class JPATarjetaCreditoDAO extends JPAGenericDAO<TarjetaCredito, Integer> implements TarjetaCreditoDAO{

	public JPATarjetaCreditoDAO() {
		super(TarjetaCredito.class);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public TarjetaCredito findByNumero(String numero) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<TarjetaCredito> criteriaQuery = criteriaBuilder.createQuery(TarjetaCredito.class);
		
		Root<TarjetaCredito> tarjetaRoot = criteriaQuery.from(TarjetaCredito.class);
		
		Predicate predicate = criteriaBuilder.like(tarjetaRoot.get("numeroTarjeta").as(String.class), numero);
		
		criteriaQuery.select(tarjetaRoot).where(predicate);
		
		return  (TarjetaCredito) em.createQuery(criteriaQuery).getSingleResult();
		
	}
	

}
