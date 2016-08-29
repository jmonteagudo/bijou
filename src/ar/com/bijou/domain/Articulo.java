package ar.com.bijou.domain;

import java.io.Serializable;

import ar.com.bijou.util.Configuracion;

public class Articulo implements Comparable<Articulo>, Serializable {

	private static final long serialVersionUID = 1L;
	private String codigo;
	private String descripcion;
	private String color;
	private String agregados;
	private Double precioCompra;
	private Double defaultPorcentajeGanancia;
	
	public Articulo(){
		this.precioCompra = 0.0;
		this.defaultPorcentajeGanancia = Double.parseDouble(Configuracion.propiedades.getProperty("defaultPorcentajeGanancia"));
	}
	
	public Articulo(String codigo, String descripcion, String color, String agregados, Double precioCompra){
	
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.color = color;
		this.agregados = agregados;
		this.precioCompra = precioCompra;
		this.defaultPorcentajeGanancia = Double.parseDouble(Configuracion.propiedades.getProperty("defaultPorcentajeGanancia"));
	}
		
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getAgregados() {
		return agregados;
	}
	public void setAgregados(String agregados) {
		this.agregados = agregados;
	}
	public Double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(Double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public Double getdefaultPorcentajeGanancia() {
		return defaultPorcentajeGanancia;
	}
	public void setdefaultPorcentajeGanancia(Double defaultPorcentajeGanancia) {
		this.defaultPorcentajeGanancia = defaultPorcentajeGanancia;
	}
	
	public Double getPrecioVenta(){
		return (double) Math.round(precioCompra+(precioCompra*defaultPorcentajeGanancia));
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((agregados == null) ? 0 : agregados.hashCode());
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
		Articulo other = (Articulo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (agregados == null) {
			if (other.agregados != null)
				return false;
		} else if (!agregados.equals(other.agregados))
			return false;
		return true;
	}

	@Override
	public int compareTo(Articulo otro) {
		if(otro==null){
			return 1;
		}
		if(codigo.compareTo(otro.getCodigo()) == 0){
			if(color.compareTo(otro.getColor()) == 0){
				return agregados.compareTo(otro.agregados);
			}else{
				return color.compareTo(otro.getColor());
			}
		}
		return codigo.compareTo(otro.getCodigo());
	}
	
	public String toString(){
		return ("[codigo=" + getCodigo() + "], [descripcion=" + getDescripcion() + "], [color=" + getColor() + 
				"], [agregados=" + getAgregados() + "], [precioCompra=" + getPrecioCompra() 
				+ "], precioAlPublico=" + getPrecioVenta());
	}
}
