package reciproci.pages;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import locators.CommunicationSetLoc;
import reciproci.base.Base;
import utility.ElementNotFound;


public class CommunicationSetting extends Base{

	CommunicationSetLoc cs = new CommunicationSetLoc();

	public CommunicationSetting() throws Exception {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,20);
		PageFactory.initElements(factory, cs);
	}

	
	public void verifyBreadCrumb() throws ElementNotFound {
		try {
			if(cs.communicationBreadcrumb.isDisplayed()) {
			}
		}catch(Exception e) {
			throw new ElementNotFound("Communication breadcrumb not found");
		}
	}

	
	
	public void veriyURL() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(cs.communicationBreadcrumb));
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.endsWith("search-communication"),"Different Page is showing");
	}

	
	public void verifyColumn() {
		Iterator<WebElement> itr = cs.columns.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next().getText());
		}
		
		String[] columnNames= {"SL.NO. ","SENDER ID","USER NAME","PASSWORD","COMMUNICATION TYPE","CREATED BY","CREATED ON","LAST MODIFIED BY","LAST MODIFIED ON","STATUS"};
		for (int i = 0; i < cs.columns.size(); i++) {
			System.out.println(cs.columns.get(i).getText());
			if(cs.columns.get(i).getText().equalsIgnoreCase((columnNames[i]))){
				System.out.println(cs.columns.get(i).getText());
			}else{
				Assert.fail("Not Matched");
			}
		}
	}


	public void verifySenderIDLink() {
		Assert.assertTrue(cs.senderId.get(0).getTagName().equalsIgnoreCase("a"),"Test case Fail");
	}

	
	public void verifyInputResult(String input) throws InterruptedException, ElementNotFound {
		Thread.sleep(1000);
		cs.searchBox.sendKeys(input);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		List<WebElement> senderIdp = driver.findElements(By.xpath("//tr/td[2]/u/a"));
		Assert.assertTrue(senderIdp.get(0).getText().contains(input), "Result Not matched");
		
//		if(senderIdp.get(0).getText().contains(input)) {
//			
//		}else {
//			Assert.fail("Result Not matched");
//		}
	}


	public void verifyHdrTxt() throws InterruptedException, ElementNotFound {		
		Thread.sleep(1000);
		cs.senderId.get(0).click();
		String header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='subtitle flex-center']>h3"))).getText();
		Assert.assertTrue(header.equalsIgnoreCase("View Communication Settings"),"Test case Fail");
	}


//	public void verifyDupSIdMsg() throws Exception {
//
//		wait.until(ExpectedConditions.visibilityOf(cs.addCommunication));
//		cs.addCommunication.click();
//		
//		wait.until(ExpectedConditions.visibilityOf(cs.userName));
//		String username = Base.getString(1, 0, "AddCommunication");
//		
//		cs.userName.sendKeys(username);
//		String password = Base.getString(1, 1, "AddCommunication");
//		
//		cs.password.sendKeys(password);
//		String senderId = Base.getString(1, 2, "AddCommunication");	
//		
//		cs.senderIds.sendKeys(senderId);
//		String purpose = Base.getString(1, 3, "AddCommunication");
//		
//		cs.purpose.sendKeys(purpose);
//		cs.add.click();
//
//		try {
//			String errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'UserName with the same senderId is already present')]"))).getText();
//			if(errorMessage.equalsIgnoreCase(Base.getString(1, 4, "AddCommunication"))) {	
//			}
//		}catch(Exception e) {
//			throw new ElementNotFound("Error Validation message is incorrect");
//		}
//	}



	public void verifySucMsg() throws InterruptedException, ElementNotFound {
		Thread.sleep(1000);
		cs.addCommunication.click();
		Thread.sleep(1000);
		cs.userName.sendKeys("Shabistan Testt");
		Thread.sleep(1000);
		cs.password.sendKeys("Shabistanquamm");
		cs.senderIds.sendKeys("Shabistan@12345");
		cs.purpose.sendKeys("testing");
		cs.add.click();
		
		Thread.sleep(1000);

		try {
			String successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully added new communication setting')]"))).getText();
			if(successMessage.startsWith("Successfully")) {	
			}
		}catch(Exception e) {
			throw new ElementNotFound("Error Validation message is incorrect");
		}
	}
}


// https://docs.google.com/spreadsheets/d/1Gnq5oCNmdBjkDNGmMacys-adtT1-D9NtXehoy9P_v3k/edit#gid=0