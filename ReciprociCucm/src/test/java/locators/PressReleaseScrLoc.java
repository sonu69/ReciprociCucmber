package locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PressReleaseScrLoc {
	
	@FindBy(css=".filter-btn-wrap>span") public WebElement expandSearch;
	
	@FindBy(xpath="//span[text()='Brand Name']") public WebElement searchBrand;
	
	@FindBy(css=".mat-datepicker-toggle>button") public List<WebElement> startDate;
	
	@FindBy(xpath="//button[text()='APPLY ']") public WebElement apply;
	
	@FindBy(xpath="//td/u/a[@class='text-blue']") public List<WebElement> releaseTitle;
	
	@FindBy(css="div[class='mat-paginator-range-label']") public WebElement count;
	
	@FindBy(xpath="//button[@aria-label='Next page']") public WebElement nextPage;
	
	@FindBy(xpath="//td[4]") public List<WebElement> brandName;
	
	@FindBy(xpath="//div[text()=' No Records Found! ']") public WebElement resultNotfound;
	
	@FindBy(xpath="//input[@placeholder='Search Press Release']") public WebElement globalSearch;
	
	@FindBy(xpath="//button[text()='EDIT']") public WebElement edit;
	
	@FindBy(css="input[placeholder='Release Title']") public List<WebElement> title;
	
	@FindBy(xpath="//button[text()='UPDATE']") public WebElement update;
	
	@FindBy(xpath="//div[contains(text(),'Press Release category master has been updated successfully')]") public WebElement successUpdateMessage;
	
	
	
}