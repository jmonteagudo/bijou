package ar.com.bijou.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ar.com.bijou.util.Formato;

public class Pedido implements Serializable {

	private static final long serialVersionUID = 6L;
	private Integer ano;
	private Integer mes;
	private Date fecha;
	private Map<Articulo, Integer> articulos;
	
	public Pedido(){
		fecha = new Date();
		articulos = new HashMap<Articulo, Integer>();
	}
	
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Map<Articulo, Integer> getArticulos() {
		return articulos;
	}

	public void addArticulo(Articulo nuevo, Integer cantidad){
		this.articulos.put(nuevo, cantidad);
	}
	
	public String toString(){
		return ("{periodo=" + Formato.NumeroAString(ano, 4) + Formato.NumeroAString(mes, 2) + "], [fecha=" + fecha + 
				"], [articulos=" + articulos.size() + "]");
	}
}
