package ar.com.bijou.domain;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

import ar.com.bijou.util.Configuracion;

public class Fabricante implements Vendedor, Serializable {
	
	private static final long serialVersionUID = 3L;
	private String nombre;
	private String eMail;
	private Set<Articulo> catalogo;
	
	public Fabricante(){
		this.nombre = Configuracion.propiedades.getProperty("defaultNombreFabricante");
		this.eMail = Configuracion.propiedades.getProperty("defaultEMailFabricante");
		catalogo = new TreeSet<Articulo>();
	}
		
	public void fabricar(Articulo nuevo){
		catalogo.add(nuevo);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEMail() {
		return eMail;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	public Set<Articulo> getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Set<Articulo> catalogo) {
		this.catalogo = catalogo;
	}
	
	public void vender(Operacion venta){
		System.out.println("Not yet implemented");
	}
	
	public String toString(){
		return ("[nombre=" + getNombre() + "], [eMail=" + getEMail() + "]");
	}

}
