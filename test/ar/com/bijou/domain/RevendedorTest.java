package ar.com.bijou.domain;

public class RevendedorTest {
	
	private static Revendedor flor;
	
	static{
		flor = new Revendedor("Flor", "flor_18@hotmail.com");
	}
	
	public static Revendedor getFlor(){
		return flor;
	}
}
