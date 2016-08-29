package ar.com.bijou.domain;

import java.io.Serializable;
import java.util.Date;

public class Pago implements Serializable {
	
	private static final long serialVersionUID = 5L;
	private Cliente pagador;
	private Date fecha;
	private Double importe;
	
	public Pago(){
		fecha = new Date();
		importe = 0.0;
	}
	
	public Pago(Cliente pagador){
		this.pagador = pagador;
		this.fecha = new Date();
		importe = 0.0;
	}
	
	public Pago(Cliente pagador, Double importe){
		this.pagador = pagador;
		this.fecha = new Date();
		this.importe = importe;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Cliente getPagador() {
		return pagador;
	}

	public void setPagador(Cliente pagador) {
		this.pagador = pagador;
	}
	
	public String toString(){
		return "[pagador=" + pagador + "], [fecha=" + fecha + "], [importe=" + importe + "]";
	}
}
