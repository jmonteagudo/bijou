package ar.com.bijou.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Cliente implements Comprador, Serializable{
	
	private static final long serialVersionUID = 2L;
	private String nombre;
	private String eMail;
	private Date cumpleanos;
	private List<Operacion> compras;
	private List<Pago> pagos;
	
	public Cliente(){
		nombre = "unknown";
		eMail = "not defined yet";
		compras = new ArrayList<Operacion>();
		pagos = new ArrayList<Pago>();
	}
		
	public Cliente(String nombre, String eMail){
		this.nombre = nombre;
		this.eMail = eMail;
		compras = new ArrayList<Operacion>();
		pagos = new ArrayList<Pago>();
	}
	
	public Cliente(String nombre, String eMail, Date cumpleanos){
		this.nombre = nombre;
		this.eMail = eMail;
		this.cumpleanos = cumpleanos;
		compras = new ArrayList<Operacion>();
		pagos = new ArrayList<Pago>();
	}
	
	public Cliente(String nombre, String eMail, String cumpleanos){
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		this.nombre = nombre;
		this.eMail = eMail;
		try {
			this.setCumpleanos(df.parse(cumpleanos));
		} catch (ParseException e) {
			this.cumpleanos = null;
		}
		compras = new ArrayList<Operacion>();
		pagos = new ArrayList<Pago>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getCumpleanos() {
		return cumpleanos;
	}

	public void setCumpleanos(Date cumpleanos) {
		this.cumpleanos = cumpleanos;
	}
	
	public void setCumpleanos(String cumpleanos){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.cumpleanos = df.parse(cumpleanos);
		} catch (ParseException e) {
			this.cumpleanos = null;
		}
		
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	@Override
	public void comprar(Operacion compra) {
		compras.add(compra);		
	}
	
	public List<Operacion> getCompras(){
		return compras;
	}
	
	public void pagar(Pago pagoRealizado){
		pagos.add(pagoRealizado);
	}
	
	public List<Pago> getPagos(){
		return pagos;
	}
	
	public Double saldo(){
		
		Double montoAdeudado = 0.0, montoPagado = 0.0;
		Iterator<Operacion> compra = compras.iterator();
		Iterator<Pago> pago = pagos.iterator();
		
		while(compra.hasNext()){
			montoAdeudado += ((Operacion)compra.next()).importe();
		}
		
		while(pago.hasNext()){
			montoPagado += ((Pago)pago.next()).getImporte();
		}
		
		return(montoPagado-montoAdeudado);
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
		Cliente other = (Cliente) obj;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return ("[nombre=" + nombre + "], [compras = " + compras.size() + "], [saldo = " + saldo() + "]");
	}
}
