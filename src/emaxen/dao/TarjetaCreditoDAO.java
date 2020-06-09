package emaxen.dao;


import examen.entidad.TarjetaCredito;

public interface TarjetaCreditoDAO extends GenericDAO<TarjetaCredito, Integer>{
	
	public abstract TarjetaCredito findByNumero(String numero);
	
}
