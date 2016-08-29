package ar.com.bijou.services;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;
import org.apache.poi.xssf.usermodel.*;

public class CreateWorbookTest {

	@Test
	public void crearLibroTest() throws NullPointerException, IOException {
		XSSFWorkbook workbookEscritura = new XSSFWorkbook();
		FileOutputStream out = new FileOutputStream(new File("Resources/createworkbook.xlsx"));
		workbookEscritura.write(out);
		out.close();
		workbookEscritura.close();
		
		File file = new File("Resources/createworkbook.xlsx");
		FileInputStream in = new FileInputStream(file);
		XSSFWorkbook workbookLectura = new XSSFWorkbook(in);
		assertNotNull(workbookLectura);
		workbookLectura.close();
	}
	
	@Test
	public void crearHojaTest() throws Exception {
		XSSFWorkbook workbookEscritura = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbookEscritura.createSheet("Hoja1");
		XSSFRow row = spreadsheet.createRow((short)1);
		System.out.println(row.getRowNum());
		workbookEscritura.close();
	}

}
