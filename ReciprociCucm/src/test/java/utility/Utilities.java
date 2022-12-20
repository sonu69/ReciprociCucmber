package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import reciproci.base.Base;

public class Utilities{

//	public static Object getCell(int rowNum, int colNum, String sheetName) throws IOException {
//
//		File fl = new File(System.getProperty("user.dir")+"/DataFiles/TestDatas/TestData.xlsx");
//
//		FileInputStream fis = new FileInputStream(fl);
//
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
//
//		XSSFSheet sh = wb.getSheet(sheetName);
//
//		Row row = sh.getRow(rowNum);
//
//		Cell cell = row.getCell(colNum);
//
//		CellType ct = cell.getCellType();
//
//		Object data;
//
//		switch(ct) {
//
//		case STRING:
//
//			data=cell.getStringCellValue();
//			
//			break;
//
//		case NUMERIC:
//
//			data = cell.getNumericCellValue();
//			
//			break;
//
//		case BOOLEAN:
//
//			data = cell.getBooleanCellValue();
//			
//			break;
//
//		default:
//
//			data=cell.getStringCellValue();
//
//		}
//
//		return data;
//
//	}
//
//	@Test(enabled=false)
//	public void getValue() throws Exception {
//		
//		System.out.println(Base.getCell(1, 0, "AddCommunication"));
//		
////		System.out.println(getCell(1,5,"AddCommunication"));
////		System.out.println(getCell(2,5,"AddCommunication"));
////		System.out.println(getCell(3,5,"AddCommunication"));
//		
//	}
//	
//	
//	public String[][] getExcelData(String fileName, String sheetName) throws IOException{
//
//		FileInputStream fis = new FileInputStream(new File(fileName));
//
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
//
//		XSSFSheet sh = wb.getSheet(sheetName);
//
//		int rowLast=sh.getLastRowNum();
//
//		int cellLast=sh.getRow(0).getLastCellNum();
//
//		String[][] datas = null;
//
//		datas = new String[rowLast][cellLast];
//
//		for(int i=1;i<=rowLast;i++) {   //1,2,3,4,5
//
//			for (int j = 0; j < cellLast; j++) {
//
//				datas[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();
//
//				System.out.println(datas[i-1][j]);
//			}
//
//		}
//
//		return datas;
//
//	}
//
//
//	@DataProvider(name="excel-data")
//	public Object[][] excelDP() throws IOException{
//		Object[][] arrObj= getExcelData(System.getProperty("user.dir")+"/DataFiles/TestDatas/TestData.xlsx","Sheet1");
//		return arrObj;
//	}
//
//
//
//	@Test(dataProviderClass=Utilities.class,dataProvider="excel-data")
//	public void search(String username, String password,String Title) {
//		System.out.println(username+" ,"+password);
//	}

}
