package ar.com.bijou.domain;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class ClienteTest {
	
	public static Cliente getMuri(){
		return new Cliente("Muri", "muri@hotmail.com", "01/01/1980");
	}
	
	public static Cliente getLucia(){
		return new Cliente("Lucia", "lucia@gmail.com", "30/03/1986");
	}
	
	@Test
	public void testCrearClienteMuri(){
		
		Cliente muri = ClienteTest.getMuri();
		
		assertEquals("Muri", muri.getNombre());
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		assertEquals("01/01/1980", df.format(muri.getCumpleanos()));
	}
	/*
	@Test
	public void testMuriCompraA1Verde(){
		
		Cliente muri = ClienteTest.getLucia();
		
		Articulo a1 = ArticuloTest.crearArticuloA1Verde();
		Operacion compra = new Operacion(RevendedorTest.getFlor(), muri);
		compra.addArticulo(a1);
		muri.comprar(compra);
		
		assertNotNull(muri.getCompras());
		assertEquals(1, muri.getCompras().size());
		assertEquals(-135.0, muri.saldo(), 0.01);
	}
	
	@Test 
	public void testMuriCompraA1VerdeYB1Rojo(){
		
		Cliente muri = ClienteTest.getMuri();
		
		// Compra A1 Verde
		Articulo a1 = ArticuloTest.crearArticuloA1Verde();
		Operacion compraA1 = new Operacion(RevendedorTest.getFlor(), muri);
		compraA1.addArticulo(a1);
		muri.comprar(compraA1);
		// Compra B1 Rojo
		Articulo b1Rojo = ArticuloTest.crearArticuloB1Rojo();
		Operacion compraB1 = new Operacion(RevendedorTest.getFlor(), muri);
		compraB1.addArticulo(b1Rojo);
		muri.comprar(compraB1);
		
		assertEquals(2, muri.getCompras().size());
		assertEquals(335.0, muri.saldo(), 0.01);
	}
	
	@Test
	public void testLuciaCompra2B1AzulYLoPaga(){
		
		Cliente lucia = ClienteTest.getLucia();
		
		Articulo b1Azul = ArticuloTest.crearArticuloB1Azul();
		Operacion compra = new Operacion(RevendedorTest.getFlor(), lucia);
		compra.addArticulo(b1Azul, 2);
		lucia.comprar(compra);
		
		assertEquals(1,  lucia.getCompras().size());
		assertEquals(400.0, lucia.saldo(), 0.01);
		
		Pago pagoDeLucia = new Pago(lucia, 400.0);
		lucia.pagar(pagoDeLucia);
		
		assertNotNull(lucia.getPagos());
		assertEquals(1, lucia.getPagos().size());
		assertEquals(0.0, lucia.saldo(), 0.01);
	}*/
	
	@Test
	public void testMuriCompraA1VerdeYB1RojoYCancelaParteDeDeuda(){
		
		Cliente muri = ClienteTest.getMuri();
		
		// Compra A1 Verde
		Articulo a1 = ArticuloTest.crearArticuloA1Verde(); 
		Operacion compraA1 = new Operacion(RevendedorTest.getFlor(), muri);
		compraA1.addArticulo(a1); //$135
		muri.comprar(compraA1);
		// Compra B1 Rojo
		Articulo b1Rojo = ArticuloTest.crearArticuloB1Rojo();
		Operacion compraB1 = new Operacion(RevendedorTest.getFlor(), muri);
		compraB1.addArticulo(b1Rojo); //$270
		muri.comprar(compraB1);
		
		assertEquals(2, muri.getCompras().size());
		assertEquals(-405.0, muri.saldo(), 0.01);
		
		
		Pago pagoDeMuri = new Pago(muri, 100.0);
		muri.pagar(pagoDeMuri);
		
		assertNotNull(muri.getPagos());
		assertEquals(1,  muri.getPagos().size());
		assertEquals(-305.0, muri.saldo(), 0.01);
	}
}
