package locators;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommunicationSetLoc {
	
	@FindBy(xpath="//ol[@class='breadcrumb']/li/a[text()='Communication settings']") public WebElement communicationBreadcrumb;
	
	@FindBy(css="th[role='columnheader']") public List<WebElement> columns;
	
	@FindBy(xpath="//button[text()='ADD COMMUNICATION SETTINGS ']") public WebElement addCommunication;
	
	@FindBy(xpath="//mat-error[contains(@id,'mat-error')]") public List<WebElement> errorMessage;
	
	@FindBy(xpath="//button[text()='ADD']") public WebElement add;
	
	@FindBy(css=".text-blue1") public List<WebElement> senderId;
	
	@FindBy(css="div[class='mat-select-value']") public WebElement itemsPerPage;
	
	@FindBy(xpath="//mat-option/span[text()='100']") public WebElement page100;
	
	@FindBy(xpath="//input[@placeholder='Search']") public WebElement searchBox;
	
	@FindBy(css="input[placeholder='User Name*']") public WebElement userName;
	
	@FindBy(css="input[placeholder='Password*']") public WebElement password;
	
	@FindBy(css="input[placeholder='Sender ID*']") public WebElement senderIds;
	
	@FindBy(css="input[placeholder='Purpose*']") public WebElement purpose;
	
	@FindBy(xpath="//div[contains(text(),'UserName with the same senderId is already present')]")  public WebElement errordup;
	
	@FindBy(xpath="//div[contains(text(),'Successfully added new communication setting')]")  public WebElement successCreated;

}
