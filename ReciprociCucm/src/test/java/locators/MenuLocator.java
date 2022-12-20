package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuLocator {

	@FindBy(xpath="//a/span[text()=' Configurations']") public WebElement configurations;
	
	@FindBy(xpath="//a/span[text()=' Masters']") public WebElement master;
	
	@FindBy(xpath="//li/a[text()='Communication settings']") public WebElement communicationSetting;
	

	
	@FindBy(xpath="//a/span[text()=' Marketing']") public WebElement marketing;

	@FindBy(xpath="//span[contains(text(),'Templates')]") public WebElement selectTemplates;

	@FindBy(xpath="//span[contains(text(),'Search')]") public WebElement selectSearchTemplate;

	@FindBy(xpath="//span[contains(text(),'Add')]") public WebElement selectAddTemplates;

	@FindBy(xpath="//span[contains(text(),'Customer Segments')]") public WebElement selectCustomerSegments;

	@FindBy(xpath="//span[contains(text(),'Search')]") public WebElement selectSearchSegment;

	@FindBy(xpath="//span[contains(text(),'Add')]") public WebElement selectAddSegment;
	
	@FindBy(xpath="//span[contains(text(),'Campaigns')]") public WebElement selectCampaigns;

	@FindBy(xpath="//span[contains(text(),'Search')]") public WebElement selectSearhCampaigns;

	@FindBy(xpath="//span[contains(text(),'Add')]") public WebElement selectAddCampaigns;

	@FindBy(xpath="//a/span[text()=' Press Release']") public WebElement pressRelease;

	@FindBy(xpath="//span[contains(text(),'Search')]") public WebElement searchPressRelease;

	@FindBy(xpath="//span[contains(text(),'Add')]") public WebElement addPressRelease;
	
	


}
