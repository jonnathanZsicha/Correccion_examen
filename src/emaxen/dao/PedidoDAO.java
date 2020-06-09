package emaxen.dao;

import java.util.List;

import examen.entidad.Pedido;

public interface PedidoDAO extends GenericDAO<Pedido, Integer>{
	public abstract List<Pedido> findByTarjeta(String numerotarjeta);
	 public abstract List<Pedido> findByComida(String comida);

}
