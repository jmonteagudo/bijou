package ar.com.bijou.services;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ar.com.bijou.domain.Operacion;
import ar.com.bijou.domain.Revendedor;
import ar.com.bijou.services.exceptions.PeriodoInexistenteException;
import ar.com.bijou.util.Configuracion;

public class OperacionManagerTest {

	@Test
	public void realizarPedidoJunio06Test() {
		OperacionManager manager = new OperacionManager();
		Revendedor flor = new Revendedor();
		
		try {
			Operacion compra = manager.realizarPedido(Configuracion.propiedades.getProperty("defaultPathPedidos"), 2016, 06, flor);
			assertNotNull(compra);
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
}
