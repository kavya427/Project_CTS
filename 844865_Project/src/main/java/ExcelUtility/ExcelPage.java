package ExcelUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelPage {
	public  String excel_Email(int a) throws IOException
	{	  
		FileInputStream fil = new FileInputStream(new File("E:\\Eclipse\\844865_Project\\TestData\\excel.xlsx\\"));
		XSSFWorkbook workbook = new XSSFWorkbook(fil);
		XSSFSheet sheet=workbook.getSheetAt(0);	
		String Email =sheet.getRow(a).getCell(0).getStringCellValue();		
		return Email;
	}
			
//	To read and return the password
	public  String excel_password(int b) throws IOException 
	{ 
	FileInputStream fil = new FileInputStream(new File("E:\\Eclipse\\844865_Project\\TestData\\excel.xlsx\\"));
		XSSFWorkbook workbook = new XSSFWorkbook(fil);
		XSSFSheet sheet=workbook.getSheetAt(0);
		String password =sheet.getRow(b).getCell(1).getStringCellValue();			          
	    return password;
  }

}
