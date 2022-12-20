package reciproci.base;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Constants;

public class Base{

	public static WebDriver driver=null;
	public static Actions act;
	public static WebDriverWait wait;
	//public static XSSFWorkbook wb;
	public Properties or = new Properties();
	//public Properties config = new Properties();
	public FileInputStream fis;
	//public static Logger log = Logger.getLogger("devpinoyLogger");



//	public XSSFWorkbook getwbook() throws Exception {
//		File fl = new File(Constants.sheetPath);
//		FileInputStream fis = new FileInputStream(fl);
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
//		return wb;
//	}


	public Base(){

		if(driver==null) {
//			try {
//				fis = new FileInputStream(System.getProperty("user.dir")+"/DataFiles/Property/config.properties");
//			} catch (FileNotFoundException e1) {
//				e1.printStackTrace();
//			}
//			
//			try {
//				config.load(fis);
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
//
//			try {
//				fis = new FileInputStream(System.getProperty("user.dir")+"/DataFiles/Property/or.properties");
//			} catch (FileNotFoundException e1) {
//				e1.printStackTrace();
//			}
//			
//			try {
//				or.load(fis);
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}

			switch(Constants.browserName) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;

			default:
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
			driver.get("https://ca-admin-uat.reciproci.com/admin/login");
			act = new Actions(driver);
			wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			
//			try {
//				wb = getwbook();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}

		}
	}
	
	public static void quitBrowser(){
		
		driver.quit();
		
	}


	public static void scrollToElement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView();", element);
	}


	public static void type(WebElement element,String input) {
		element.clear();
		element.sendKeys(input);
	}


	@SuppressWarnings("deprecation")
	public static void click(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}


	public static void clickJ(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}


	public static String getScreenshott() throws IOException {
		Date d = new Date();
		String screenshot_name = d.toString().replace(":", "_").replace(" ", "_");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshot = ts.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir")+"/DataFiles/Screenshots/"+screenshot_name+".png";
		File dstScr = new File(path);

		FileUtils.copyFile(screenshot,dstScr);

		return path;
	}


	public static Object[][] getExcelData(String fileName, String sheetName) throws IOException{
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File(fileName)));
		XSSFSheet sh = wb.getSheet(sheetName);
		int rowLast=sh.getLastRowNum();
		int cellLast=sh.getRow(0).getLastCellNum();
		Object[][] datas = null;
		datas = new String[rowLast][cellLast];
		for(int i=1;i<=rowLast;i++) {
			for (int j = 0; j < cellLast; j++) {
				datas[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return datas;
	}


	@DataProvider(name="excel-data")
	public Object[][] excelDP() throws IOException{
		Object[][] arrObj= Base.getExcelData(System.getProperty("user.dir")+"/DataFiles/TestDatas/TestData.xlsx","Login");
		return arrObj;
	}


//	public static Object getCell(int rowNum, int colNum, String sheetName) throws IOException {
//		XSSFSheet sh = wb.getSheet(sheetName);
//		Row row = sh.getRow(rowNum);
//		Cell cell = row.getCell(colNum);
//		CellType ct = cell.getCellType();
//		Object data;
//
//		switch(ct) {
//
//		case STRING:
//			data=cell.getStringCellValue();
//			break;
//
//		case NUMERIC:
//			data = cell.getNumericCellValue();
//			break;
//
//		case BOOLEAN:
//			data = cell.getBooleanCellValue();
//			break;
//
//		default:
//			data=cell.getStringCellValue();
//		}
//		return data;
//	}


//	public static String getString(int rowNum, int colNum, String sheetName) throws IOException {
//		XSSFSheet sh = wb.getSheet(sheetName);
//		Row row = sh.getRow(rowNum);
//		Cell cell = row.getCell(colNum);
//		CellType ct = cell.getCellType();
//		String data = sh.getRow(rowNum).getCell(colNum).getStringCellValue();
//		return data;
//	}


	public static void uploadImage(String path) throws Exception {
		StringSelection ss = new StringSelection(System.getProperty("user.dir")+path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}


	public static void getScreenshot() throws Exception {
		
		Date d = new Date();
		String newDate = d.toString().substring(4, 18).replace(" ", "_");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(System.getProperty("user.dir")+"/DataFiles/Screenshots/"+newDate+".png");
		FileUtils.copyFile(srcFile, dst);
		
	}
	
	
}
