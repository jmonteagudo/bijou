package ar.com.bijou.domain;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class OperacionTest {
	
	@Test
	public void muriCompraA1Verde() {
		Operacion nueva = new Operacion();
		
		nueva.setComprador(ClienteTest.getMuri());
		nueva.addArticulo(ArticuloTest.crearArticuloA1Verde()); // $135
		
		assertEquals(nueva.getDescuento(), 0.0, 0.01);
		assertNotNull(nueva.getArticulos());
		assertEquals(135.0, nueva.importe(), 0.01);

	}
	
	@Test
	public void luciaCompraA1VerdeYB1Rojo(){
		Operacion nueva = new Operacion();
		
		nueva.setComprador(ClienteTest.getLucia());
		nueva.addArticulo(ArticuloTest.crearArticuloA1Verde()); // $135
		nueva.addArticulo(ArticuloTest.crearArticuloB1Rojo());	// $270
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		assertEquals(df.format(new Date()), df.format(nueva.getFecha()));
		assertEquals(nueva.getDescuento(), 0.0, 0.01);
		
		assertEquals(nueva.getArticulos().size(), 2);

		assertEquals(405.0, nueva.importe(),  0.01);
	}
	
	@Test
	public void luciaCompraB1AzulYSeLeHaceUn25PorcientoDeDecuento(){
		Operacion nueva = new Operacion();
		
		nueva.setComprador(ClienteTest.getLucia());
		nueva.addArticulo(ArticuloTest.crearArticuloB1Azul()); // $270

		nueva.setDescuento(0.25);
		
		assertEquals(0.25, nueva.getDescuento(), 0.01);
		assertEquals(202.50, nueva.importe(), 0.01);		
	}
	
	@Test
	public void luciaCompraB1AzulYA1VerdeYSeLeHaceUn25PorcientoDeDecuento(){
		Operacion nueva = new Operacion();
		
		nueva.setComprador(ClienteTest.getLucia());
		nueva.addArticulo(ArticuloTest.crearArticuloB1Azul()); // $270
		nueva.addArticulo(ArticuloTest.crearArticuloA1Verde()); // $135

		nueva.setDescuento(0.25);
		
		assertEquals(2, nueva.getArticulos().size());
		assertEquals(0.25, nueva.getDescuento(), 0.01);
		assertEquals(303.75, nueva.importe(), 0.01);		
	}
	
	@Test
	public void luciaCompra2B1AzulYA1VerdeYSeLeHaceUn25PorcientoDeDecuento(){
		Operacion nueva = new Operacion();
		
		nueva.setComprador(ClienteTest.getLucia());
		nueva.addArticulo(ArticuloTest.crearArticuloB1Azul(), 2); // $540
		nueva.addArticulo(ArticuloTest.crearArticuloA1Verde()); // $135

		nueva.setDescuento(0.25);
		
		assertEquals(2, nueva.getArticulos().size());
		assertEquals(0.25, nueva.getDescuento(), 0.01);
		assertEquals(506.25, nueva.importe(), 0.01);		
	}
}
