package ar.com.bijou.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ar.com.bijou.domain.Articulo;
import ar.com.bijou.domain.Fabricante;
import ar.com.bijou.domain.Operacion;
import ar.com.bijou.domain.Revendedor;
import ar.com.bijou.services.exceptions.PeriodoInexistenteException;
import ar.com.bijou.services.exceptions.UnexpectedColumnException;
import ar.com.bijou.util.Configuracion;
import ar.com.bijou.util.Formato;

public class RevendedorManager {
	
	private Set<Revendedor> revendedores;
	
	public RevendedorManager() {
		revendedores = new TreeSet<Revendedor>();
		revendedores.add(new Revendedor());
	}
	
	public Set<Revendedor> getRevendedores(){
		return revendedores;
	}
		
	public void realizarPedido(Revendedor revendedor, Integer ano, Integer mes) throws IOException, PeriodoInexistenteException{
		
		FileInputStream in = new FileInputStream(new File(Configuracion.propiedades.getProperty("defaultPathPedidos")));
		XSSFWorkbook pedidos = new XSSFWorkbook(in);
		XSSFSheet periodo = pedidos.getSheet(Formato.NumeroAString(ano, 4) + Formato.NumeroAString(mes, 2));
		Iterator<Row> filas = periodo.iterator();
		Operacion compra = new Operacion(new Fabricante(), revendedor);
		
		while(filas.hasNext()){
			XSSFRow filaActual = (XSSFRow)filas.next();
			if(filaActual.getRowNum()!=0){
				Iterator<Cell> celdas = filaActual.iterator();
				Articulo nuevo = new Articulo();
				Integer cantidad = 0;
				while(celdas.hasNext()){
					Cell celdaActual = celdas.next();
					switch(celdaActual.getColumnIndex()){
					case 0: // Codigo Articulo
						nuevo.setCodigo(celdaActual.getStringCellValue());
						break;
					case 1: // Descripción
						nuevo.setDescripcion(celdaActual.getStringCellValue());
						break;
					case 2: // Precio
						nuevo.setPrecioCompra(celdaActual.getNumericCellValue());
						break;
					case 3: // Color
						nuevo.setColor(celdaActual.getStringCellValue());
						break;
					case 4: // Agregados
						nuevo.setAgregados(celdaActual.getStringCellValue());
						break;
					case 5: // Porcentaje Ganancia
						nuevo.setdefaultPorcentajeGanancia(celdaActual.getNumericCellValue());
						break;
					case 6: // Cantidad
						cantidad = (int)celdaActual.getNumericCellValue();
						break;
					default:
						throw new UnexpectedColumnException();
					}
				}
				compra.addArticulo(nuevo, cantidad);			
			}
		}
		revendedor.comprar(Formato.NumeroAString(ano, 4) + Formato.NumeroAString(mes, 2), compra);
		revendedores.add(revendedor);
		
		pedidos.close();
		
	}
}
