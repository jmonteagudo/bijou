
package ar.com.bijou.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ar.com.bijou.util.Configuracion;

public class Revendedor implements Comprador, Vendedor, Serializable, Comparable<Object>{
	
	private static final long serialVersionUID = 7L;
	private String nombre;
	private String eMail;
	private Map<String, Operacion> pedidos;
	private ArrayList<Operacion> ventas;
	private ArrayList<Pago> cobranzas;
	
	public Revendedor(){
		this.nombre = Configuracion.propiedades.getProperty("defaultNombreRevendedor");
		this.eMail = Configuracion.propiedades.getProperty("defaultEMailRevendedor");
		pedidos = new HashMap<String, Operacion>();
		ventas = new ArrayList<Operacion>();
		cobranzas = new ArrayList<Pago>();
	}
	
	public Revendedor(String nombre, String eMail){
		this.nombre = nombre;
		this.eMail = eMail;
		this.pedidos = new HashMap<String, Operacion>();
		this.ventas = new ArrayList<Operacion>();
		this.setCobranzas(new ArrayList<Pago>());
	}
	
	@Override
	public void comprar(Operacion compra){
		Date fechaActual = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMM");
		String periodo = df.format(fechaActual);
		pedidos.put(periodo, compra);
	}
	
	public void comprar(String periodo, Operacion compra){
		pedidos.put(periodo, compra);
	}

	@Override
	public void vender(Operacion venta){
		ventas.add(venta);
	}
	
	public Double capital(){
		
		Double capital = 0.0;
		Iterator<Operacion> inversion = pedidos.values().iterator();
		
		while(inversion.hasNext()){
			capital += ((Operacion)inversion.next()).importe();
		}
		
		return capital;
	}
	
	public Double proyeccionCobros(){
		
		Double cobradoOACobrar = 0.0;
		Iterator<Operacion> venta = ventas.iterator();
		
		while(venta.hasNext()){
			cobradoOACobrar += ((Operacion)venta.next()).importe();
		}
		
		return cobradoOACobrar;
		
	}
	
	public Double ingresos(){
		
		Double cobrado = 0.0;
		Iterator<Pago> cobranza = cobranzas.iterator();
		
		while(cobranza.hasNext()){
			cobrado += ((Pago)cobranza.next()).getImporte();
		}
		
		return cobrado;
	}
	
	public Double ganancia(){
		return (ingresos() - capital());
	}
	
	public Double aCobrar(){
		return (ingresos() - proyeccionCobros());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public ArrayList<Pago> getCobranzas() {
		return cobranzas;
	}

	public void setCobranzas(ArrayList<Pago> cobranzas) {
		this.cobranzas = cobranzas;
	}
	
	public void cobrar(Pago nuevo){
		cobranzas.add(nuevo);
	}
	
	public Map<String, Operacion> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Map<String, Operacion> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public int compareTo(Object arg0) {
		if(arg0 == null){
			return 1;
		}
		Revendedor other = (Revendedor)arg0;
		if(other.geteMail()==null){
			return 1;
		}else if(this.eMail==null){
			return -1;
		}
		return this.eMail.compareTo(other.geteMail());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
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
		Revendedor other = (Revendedor) obj;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		return true;
	}
	
	public String toString(){
		return ("[nombre=" + nombre + "], [eMail=" + eMail + 
				"], [pedidos= " + pedidos.size() + "], [ventas= " + ventas.size() +
				"], cobranzas=" + cobranzas.size() + "]");
	}
}
