package examen.jpa;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import emaxen.dao.PedidoDAO;
import examen.entidad.Pedido;
import examen.entidad.TarjetaCredito;

public class JPAPedidoDAO extends JPAGenericDAO<Pedido, Integer> implements PedidoDAO{
	private List<Pedido> list;

	public JPAPedidoDAO() {
		super(Pedido.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Pedido> findByTarjeta(String numerotarjeta) {
		// TODO Auto-generated method stub
		
		TarjetaCredito tarjeta = JPADAOFactory.getFactory().getTarjetaCreditoDAO().findByNumero(numerotarjeta);
		System.out.println("esta es la tarjeta" + tarjeta);
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Pedido> criteriaQuery = criteriaBuilder.createQuery(Pedido.class);
		
		Root<Pedido> telefonoRoot = criteriaQuery.from(Pedido.class);
		
		Predicate predicate = criteriaBuilder.equal(telefonoRoot.get("tarjeta"), tarjeta);
		
		criteriaQuery.select(telefonoRoot).where(predicate);
		
		list =em.createQuery(criteriaQuery).getResultList();
		
		return em.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public List<Pedido> findByComida(String comida) {
		// TODO Auto-generated method stub
		return null;
	}

}
