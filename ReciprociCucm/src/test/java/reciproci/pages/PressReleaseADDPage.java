package reciproci.pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import locators.PressReleaseAddLoc;
import reciproci.base.Base;
import utility.InvalidPageVerification;

public class PressReleaseADDPage extends Base{

	PressReleaseAddLoc pr = new PressReleaseAddLoc();

	public PressReleaseADDPage(){
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,20);
		PageFactory.initElements(factory, pr);
	}


	public void errorMessage() throws Exception {
		pr.uploadEngImg.get(0).click();
		Base.uploadImage("/DataFiles/TestDatas/onlineBrandList.csv");
		wait.until(ExpectedConditions.visibilityOf(pr.fileValidation));
		try {
			pr.fileValidation.isDisplayed();
			System.out.println("Message Found");
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("Message not Found");
		}
	}
	

	public PressReleaseSearchPage addPressRelease(String country) throws Exception {
		//Feature:- In order to verify user is able to Enter all the fields and on click to cancel button redirected to the Search listing page.
		Thread.sleep(2000);
		Base.clickJ(pr.selCountry.get(0));
		Thread.sleep(1000);
		WebElement cont = driver.findElement(By.xpath("//span[contains(text(),'"+country+"')]"));
		Base.clickJ(cont);

		act.sendKeys(Keys.ESCAPE).build().perform();

		Thread.sleep(1000);
		pr.selBrand.click();

		Thread.sleep(1000);
		pr.brands.get(2).click();

		Thread.sleep(1000);
		pr.publishDate.get(0).click();
		Thread.sleep(1000);
		WebElement fromDate = driver.findElement(By.xpath("//td/div[text()='15']"));
		fromDate.click();

		pr.publishDate.get(1).click();
		Thread.sleep(1000);
		WebElement toDate = driver.findElement(By.xpath("//td/div[text()='25']"));
		toDate.click();

		Thread.sleep(1000);
		pr.publishFromTime.click();

		Thread.sleep(1000);
		pr.fromHour.get(0).clear();
		pr.fromHour.get(0).sendKeys("09");
		pr.fromHour.get(1).clear();
		pr.fromHour.get(1).sendKeys("00");

		Thread.sleep(1000);
		act.click(pr.set).perform();

		pr.publishToTime.click();

		Thread.sleep(1000);
		pr.fromHour.get(0).clear();
		pr.fromHour.get(0).sendKeys("15");
		pr.fromHour.get(1).clear();
		pr.fromHour.get(1).sendKeys("20");

		Thread.sleep(1000);
		act.click(pr.set).perform();

		pr.uploadEngImg.get(0).click();

		Thread.sleep(1000);

		Base.uploadImage("/DataFiles/Images/HighHQ.jpg");

		pr.releaseTitle.get(0).sendKeys("English Title");

		Base.type(pr.releaseTitle.get(1), "Arabic Title");

		driver.switchTo().frame(0);
		Base.type(pr.releaseContent, "Hello English Content");
		driver.switchTo().parentFrame();
		driver.switchTo().frame(1);
		Base.type(pr.releaseContent, "Hello Arabic Content");
		driver.switchTo().parentFrame();

		pr.uploadEngImg.get(1).click();

		Base.uploadImage("/DataFiles/Images/HighHQ.jpg");

		Base.scrollToElement(pr.cancel);

		Base.clickJ(pr.cancel);

		return new PressReleaseSearchPage();

	}


	public void verifyPage() throws InvalidPageVerification {
		String title = driver.getTitle();

		if(title.equalsIgnoreCase("Reciprocii")) {
			System.out.println("Page title verified");
		}else {
			//Assert.fail("Invalid Page Title");
			throw new InvalidPageVerification("Invalid Page Title");
		}

	}

	public void addPressRelease() throws Exception {
		Thread.sleep(2000);
		pr.selCountry.get(0).click();
		Thread.sleep(2000);
		WebElement cont = driver.findElement(By.xpath("//span[contains(text(),'India')]"));
		act.click(cont).perform();
	}


}
