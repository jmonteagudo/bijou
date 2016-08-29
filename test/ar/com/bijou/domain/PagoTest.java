package ar.com.bijou.domain;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class PagoTest {

	@Test
	public void testPagar() {
		Pago nuevo = new Pago();
		nuevo.setImporte(1000.0);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		assertEquals(nuevo.getImporte(), 1000.0, 0.01);
		assertEquals(df.format(new Date()), df.format(nuevo.getFecha()));		
	}
	
	

}
