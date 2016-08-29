package ar.com.bijou.util;

import java.util.Properties;

public class Configuracion {
	
	public final static Properties propiedades;
	
	static{
		propiedades = new Properties();
		propiedades.setProperty("defaultPorcentajeGanancia", "0.35");
		propiedades.setProperty("defaultNombreFabricante", "Amor Amarillo");
		propiedades.setProperty("defaultEMailFabricante", "amore@hotmail.com");
		propiedades.setProperty("defaultNombreRevendedor", "Florencia Lucente");
		propiedades.setProperty("defaultEMailRevendedor", "lucente.florencia@gmail.com");
		propiedades.setProperty("defaultPathPedidos", "C:\\tmp\\Pedidos.xlsx");
		propiedades.setProperty("pathArchivoPedidos", "C:\\tmp");
	}

}
