package ar.com.bijou.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.TreeSet;

import org.junit.Test;

public class ArticuloTest {
		
	public static Articulo crearArticuloA1Verde(){
		
		Articulo nuevo = new Articulo("A1", "Prueba nuevo articulo A", "Verde", "", new Double(100.0));
		return nuevo;
	}
	
	public static Articulo crearArticuloA1VerdeConAgregados(){
		
		Articulo nuevo = new Articulo("A1", "Prueba nuevo articulo A", "Verde", "Agregados con respecto a A", new Double(150.0));
		return nuevo;
	}
	
	public static Articulo crearArticuloB1Rojo(){

		Articulo nuevo = new Articulo("B1", "Prueba nuevo articulo B", "Rojo", "", new Double(200.0));
		return nuevo;
	}
	
	public static Articulo crearArticuloB1Azul(){

		Articulo nuevo = new Articulo("B1", "Prueba nuevo articulo B", "Azul", "", new Double(200.0));
		return nuevo;
	}
	
	public static ArrayList<Articulo> crearListaDeArticulos(){
		ArrayList<Articulo> articulos = new ArrayList<Articulo>();
		
		articulos.add(crearArticuloA1Verde());
		articulos.add(crearArticuloA1VerdeConAgregados());
		articulos.add(crearArticuloB1Rojo());
		articulos.add(crearArticuloB1Azul());
		
		return articulos;
	}
	
	public static TreeSet<Articulo> crearConjuntoDeArticulos(){
		TreeSet<Articulo> articulos = new TreeSet<Articulo>();
			
		articulos.add(crearArticuloA1Verde());
		articulos.add(crearArticuloA1VerdeConAgregados());
		articulos.add(crearArticuloB1Rojo());
		articulos.add(crearArticuloB1Azul());
		
		return articulos;
	}
	
	@Test
	public void testCrearArticuloA1Verde(){

		Articulo nuevo = crearArticuloA1Verde();
		
		assertEquals("A1", nuevo.getCodigo());
		assertEquals("Prueba nuevo articulo A", nuevo.getDescripcion());
		assertEquals("Verde", nuevo.getColor());
		assertEquals("", nuevo.getAgregados());
		assertEquals(100.0D, nuevo.getPrecioCompra(), 0.01);
		assertEquals(0.35, nuevo.getdefaultPorcentajeGanancia(), 0.01);
		assertEquals(135.0, nuevo.getPrecioVenta(), 0.01);
	}
	
	@Test
	public void testCrearArticuloA1VerdeConAgregados(){

		Articulo nuevo = crearArticuloA1VerdeConAgregados();
		
		assertEquals("A1", nuevo.getCodigo());
		assertEquals("Prueba nuevo articulo A", nuevo.getDescripcion());
		assertEquals("Verde", nuevo.getColor());
		assertEquals("Agregados con respecto a A", nuevo.getAgregados());
		assertEquals(150.0D, nuevo.getPrecioCompra(), 0.01);
		assertEquals(0.35, nuevo.getdefaultPorcentajeGanancia(), 0.01);
		assertEquals(203.0, nuevo.getPrecioVenta(), 0.01);
	}
	
	@Test
	public void testCrearArticuloB1Rojo(){

		Articulo nuevo = crearArticuloB1Rojo();
		
		assertEquals("B1", nuevo.getCodigo());
		assertEquals("Prueba nuevo articulo B", nuevo.getDescripcion());
		assertEquals("Rojo", nuevo.getColor());
		assertEquals("", nuevo.getAgregados());
		assertEquals(200.0D, nuevo.getPrecioCompra(), 0.01);
		assertEquals(0.35, nuevo.getdefaultPorcentajeGanancia(), 0.01);
		assertEquals(270.0, nuevo.getPrecioVenta(), 0.01);
	}
	
	@Test
	public void testCrearArticuloB1Azul(){

		Articulo nuevo = crearArticuloB1Azul();
		
		assertEquals("B1", nuevo.getCodigo());
		assertEquals("Prueba nuevo articulo B", nuevo.getDescripcion());
		assertEquals("Azul", nuevo.getColor());
		assertEquals("", nuevo.getAgregados());
		assertEquals(200.0D, nuevo.getPrecioCompra(), 0.01);
		assertEquals(0.35, nuevo.getdefaultPorcentajeGanancia(), 0.01);
		assertEquals(270.0, nuevo.getPrecioVenta(), 0.01);
	}

	@Test
	public void testCrearListaArticulos(){

		ArrayList<Articulo> articulos = crearListaDeArticulos();
		
		assertEquals(4, articulos.size());
		assertEquals("A1", articulos.get(1).getCodigo());
		
	}
	
	@Test
	public void testListaArticulosNoAdmiteDuplicados(){

		TreeSet<Articulo> articulos = crearConjuntoDeArticulos();
		Articulo nuevo = crearArticuloA1Verde();
		articulos.add(nuevo);
		
		assertEquals(4, articulos.size());		
	}
	
	
}
