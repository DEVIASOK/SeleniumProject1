package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadUtility {
	static FileInputStream a;
	static XSSFWorkbook b;
	static XSSFSheet c;

	public static String getStringData(int x, int y,String SheetName) throws IOException

	{
		a = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//TestData.xlsx");
		b = new XSSFWorkbook(a);
		c = b.getSheet(SheetName); 
		Row r = c.getRow(x);
		Cell f = r.getCell(y);
		return f.getStringCellValue();

	} 

	public static String getIntegerData(int x, int y,String SheetName) throws IOException

	{
		a = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//TestData.xlsx");
		b = new XSSFWorkbook(a);
		c = b.getSheet(SheetName);
		Row r = c.getRow(x);
		Cell f = r.getCell(y);
		int s1 = (int) f.getNumericCellValue();
		return String.valueOf(s1);

	}

	
}
