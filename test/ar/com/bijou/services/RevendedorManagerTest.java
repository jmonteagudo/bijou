package ar.com.bijou.services;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import ar.com.bijou.domain.Articulo;
import ar.com.bijou.domain.Cliente;
import ar.com.bijou.domain.Operacion;
import ar.com.bijou.domain.Revendedor;
import ar.com.bijou.services.exceptions.PeriodoInexistenteException;

public class RevendedorManagerTest {

	@Test
	public void realizarPedidoJunio06Test() {
		RevendedorManager manager = new RevendedorManager();
		Revendedor flor = new Revendedor();
		
		try {
			manager.realizarPedido(flor, 2016, 06);
			assertNotNull(flor.getPedidos());
			assertEquals(1, flor.getPedidos().size());
			List<Operacion> pedidosRealizados = new ArrayList<Operacion>(flor.getPedidos().values());
			Operacion ultimoPedido = pedidosRealizados.get(0);
			assertEquals(35, ultimoPedido.getArticulos().size(), 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PeriodoInexistenteException p){
			p.printStackTrace();
		}	
	}

	@Test
	public void realizarPedidoJulio2016VerificandoNoDuplicaLosArticulos(){
		RevendedorManager manager = new RevendedorManager();
		Revendedor flor = new Revendedor();
		
		try {
			manager.realizarPedido(flor, 2016, 07);
			assertEquals(1, flor.getPedidos().size());
			
			List<Operacion> pedidosRealizados = new ArrayList<Operacion>(flor.getPedidos().values());
			Operacion pedido201607 = pedidosRealizados.get(0);
			assertEquals(41, pedido201607.getArticulos().size(), 0); // Son 42 filas de Excel que tiene un duplicado.			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PeriodoInexistenteException p){
			p.printStackTrace();
		}	
	}
	
	@Test
	public void realizarPedidoJunio2016YJulio2016(){
		RevendedorManager manager = new RevendedorManager();
		Revendedor flor = new Revendedor();
		
		try {
			manager.realizarPedido(flor, 2016, 06);
			assertNotNull(flor.getPedidos());
			assertEquals(1, flor.getPedidos().size());
	
			manager.realizarPedido(flor, 2016, 07);
			assertEquals(2, flor.getPedidos().size());
			
			List<Operacion> pedidosRealizados = new ArrayList<Operacion>(flor.getPedidos().values());
			Operacion pedido201606 = pedidosRealizados.get(0);
			Operacion pedido201607 = pedidosRealizados.get(1);
			assertEquals(35, pedido201606.getArticulos().size(), 0);
			assertEquals(41, pedido201607.getArticulos().size(), 0);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PeriodoInexistenteException p){
			p.printStackTrace();
		}	
	}
	
	@Test
	public void realizarPedidoJulio2016YVenderE1(){
		RevendedorManager manager = new RevendedorManager();
		Revendedor flor = new Revendedor();
		
		try {
			manager.realizarPedido(flor, 2016, 07);
			assertNotNull(flor.getPedidos());
			assertEquals(1, flor.getPedidos().size());
	
			manager.realizarPedido(flor, 2016, 07);
			assertEquals(1, flor.getPedidos().size());
			
			List<Operacion> pedidosRealizados = new ArrayList<Operacion>(flor.getPedidos().values());
			Operacion pedido201607 = pedidosRealizados.get(0);
			assertEquals(41, pedido201607.getArticulos().size(), 0);
			
			// Realizamos la venta
			Operacion ventaAMaria = new Operacion();
			Cliente maria = new Cliente("Maria", "maria@hotmail.com");
			ventaAMaria.setVendedor(flor);
			ventaAMaria.setComprador(maria);
			Iterator<Articulo> buscadorArticulo = (Iterator<Articulo>) pedido201607.getArticulos().keySet().iterator();
			while(buscadorArticulo.hasNext()){
				Articulo actual = buscadorArticulo.next();
				if(actual.getCodigo().equals("E1") && actual.getAgregados().equals("Dije san benito y mano")){
					ventaAMaria.addArticulo(actual, 1);
				}
			}
			
			maria.comprar(ventaAMaria);
			flor.vender(ventaAMaria);
			
			System.out.println("Resultado de la operación");
			System.out.println(ventaAMaria);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PeriodoInexistenteException p){
			p.printStackTrace();
		}	
	}
}
