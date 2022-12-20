package reciproci.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import locators.PressReleaseScrLoc;
import reciproci.base.Base;
import utility.ElementNotFound;

public class PressReleaseSearchPage extends Base{

	PressReleaseScrLoc ps = new PressReleaseScrLoc();

	public PressReleaseSearchPage(){
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, ps);
	}


	public void verifyEditFunctionality(String title) throws Exception {

		ps.globalSearch.sendKeys(title);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		for (int i = 0; i <ps.releaseTitle.size(); i++) {
			if(ps.releaseTitle.get(i).getText().contains(title)){
				ps.releaseTitle.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		Base.scrollToElement(ps.edit);
		ps.edit.click();
		Thread.sleep(2000);
		ps.title.get(0).sendKeys(" Hello");
		Base.scrollToElement(ps.update);
		ps.update.click();
		Assert.assertTrue(ps.successUpdateMessage.getText().equalsIgnoreCase("Press Release category master has been updated successfully"));
		
	}


	public void verifyPressRelease(String brandName, String date) throws Exception{

		wait.until(ExpectedConditions.visibilityOf(ps.expandSearch));
		ps.expandSearch.click();

		wait.until(ExpectedConditions.visibilityOf(ps.searchBrand));
		Thread.sleep(1000);
		ps.searchBrand.click();

		Thread.sleep(1000);
		List<WebElement> brand = driver.findElements(By.xpath("//mat-option/span[contains(text(),'"+brandName+"')]"));
		brand.get(0).click();

		Thread.sleep(1000);
		ps.startDate.get(0).click();

		String[] newDate = date.split("/");
		String day = newDate[0];
		String year = newDate[2];
		String month = newDate[1];

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='mat-calendar-controls']>button>span")));

		List<WebElement> selMonYr = driver.findElements(By.cssSelector("div[class='mat-calendar-controls']>button>span"));
		selMonYr.get(0).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+year+"']"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'"+month+"')]"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'"+day+"')]"))).click();

		ps.apply.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[4]")));

		try {
			if(ps.brandName.get(0).getText().equalsIgnoreCase(brandName));
		}catch(Exception e) {
			throw new ElementNotFound("Not Matched");
		}

	}


	public void verifyPressRelease(String brandName) throws Exception {

		wait.until(ExpectedConditions.visibilityOf(ps.expandSearch));
		ps.expandSearch.click();

		wait.until(ExpectedConditions.visibilityOf(ps.searchBrand));
		Thread.sleep(1000);
		ps.searchBrand.click();

		Thread.sleep(1000);
		List<WebElement> brand = driver.findElements(By.xpath("//mat-option/span[contains(text(),'"+brandName+"')]"));
		brand.get(0).click();

		ps.apply.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[4]")));

		try {
			driver.findElement(By.xpath("//td[4][contains(text(),'"+brandName+"')]")).isDisplayed();
		}catch(Exception e) {
			throw new ElementNotFound("Not Matched");
		}

	}


	public void resultFound() throws Exception {
		Thread.sleep(2000);
		Base.scrollToElement(ps.count);
		String val = wait.until(ExpectedConditions.visibilityOf(ps.count)).getText();
		String[] number = val.split(" ");
		System.out.println(number[4]);

		Integer totalResult = Integer.valueOf(number[4]);

		int totalPage = totalResult/10;
		System.out.println(totalPage);

		for (int i = 0; i <= totalPage; i++) {

			Thread.sleep(2000);
			Base.scrollToElement(ps.count);
			wait.until(ExpectedConditions.visibilityOf(ps.nextPage)).click();

		}
	}
}
