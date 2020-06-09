package examen.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TarjetaCredito
 *
 */
@Entity

public class TarjetaCredito implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int codigo;
	private String numeroTarjeta;
	private String nombre;
	private Date fechaCaducidad;
	private int cvv;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tarjeta")
	private Set<Pedido> pedidos ;

	
	public TarjetaCredito() {
		super();
	}
	public TarjetaCredito(int codigo,String numeroTarjeta,String nombre,Date fechaCaducidad,int cvv) {

		this.codigo = codigo;
		this.numeroTarjeta = numeroTarjeta;
		this.nombre = nombre;
		this.fechaCaducidad= fechaCaducidad;
		this.cvv= cvv;
		
			
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
	public Set<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public void addPedidos(Pedido pedido) {
		this.pedidos.add(pedido);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TarjetaCredito other = (TarjetaCredito) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TarjetaCredito [codigo=" + codigo + ", numeroTarjeta=" + numeroTarjeta + ", nombre=" + nombre
				+ ", fechaCaducidad=" + fechaCaducidad + ", cvv=" + cvv + ", pedidos=" + pedidos + "]";
	}
	
	
   
}
