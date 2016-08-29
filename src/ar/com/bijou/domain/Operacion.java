package ar.com.bijou.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Operacion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	private Vendedor vendedor;
	private Comprador comprador;
	private Date fecha;
	private Double descuento;
	private Map<Articulo, Integer> articulos;
	
	public Operacion(){
		this.fecha = new Date();
		this.descuento = 0.0;
		articulos = new HashMap<Articulo, Integer>();
	}
	
	public Operacion(Vendedor vendedor, Comprador comprador){
		this.setVendedor(vendedor);
		this.comprador = comprador;
		this.fecha = new Date();
		this.descuento = 0.0;
		articulos = new TreeMap<Articulo, Integer>();
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getDescuento() {
		return descuento;
	}
	public void setDescuento(Double descuento) {
		if(descuento>= 0.0 && descuento <=1.0){
			this.descuento = descuento;
		}
	}
	
	public Map<Articulo, Integer> getArticulos() {
		return articulos;
	}

	public void addArticulo(Articulo vendido){
		articulos.put(vendido, 1);
	}
	
	public void addArticulo(Articulo vendido, Integer cantidad){
		articulos.put(vendido, cantidad);
	}
	
	public Comprador getComprador() {
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	public Double importe(){
		
		Double subTotal = 0.0;
		
		Iterator<Articulo> articulosVendidos = articulos.keySet().iterator();
		while(articulosVendidos.hasNext()){
			Articulo actual = articulosVendidos.next();
			subTotal += (actual.getPrecioVenta() * articulos.get(actual));
		}
		
		return (subTotal - (subTotal * this.descuento));
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	public String toString(){
		return "{vendedor=" + vendedor + "], [comprador=" + comprador + "], [fecha=" + fecha + "], [descuento=" + descuento + "]";
	}
}
