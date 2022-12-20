package locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CampaignAddLoc {
	
	@FindBy(xpath="//div[@class='mat-select-value']/span[text()='Activity']") public WebElement clickActivity;
	
	@FindBy(xpath="//span[contains(text(),'Other')]") public WebElement otherCampaignType;
	
	@FindBy(css="input[placeholder='Campaign Name']") public WebElement campaignName;
	
	@FindBy(css="textarea[formcontrolname='campaignDesc']") public WebElement campaignDescription;
	
	@FindBy(xpath="//span[contains(text(),'App-Push Notification')]") public WebElement pushCommunicationType;
	
	@FindBy(xpath="//span[contains(text(),'Email')]") public WebElement EmailCommunicationType;
	
	@FindBy(xpath="//span[text()='Frequency']") public WebElement deliverySchedule;
	
	@FindBy(xpath="//span[contains(text(),'IMMEDIATE')]") public WebElement immediateSchedule;
	
	@FindBy(xpath="//button[contains(text(),'CONTINUE')]") public List<WebElement> continueBasic;
	
	@FindBy(css="input[placeholder='Notification Limit']") public WebElement notificationLimit;
	
	@FindBy(xpath="//a[text()='SEGMENT RULE']") public WebElement selectSegment;
	
	@FindBy(xpath="//select[@class='form-control']") public WebElement segmentRule;
	
	@FindBy(xpath="//button[text()='ADD']") public List<WebElement> submitSegment;
	
	@FindBy(xpath="") public WebElement continueAudience;
	
	@FindBy(xpath="//mat-panel-title[contains(text(),'App-Push Notification')]") public WebElement pushContentTab;
	
	@FindBy(xpath="//span[contains(text(),'Link To')]") public WebElement liknTo;
	
	@FindBy(xpath="//mat-option/span[contains(text(),'Coupons')]")  public WebElement liknToOption;
	
	@FindBy(xpath="//div[@class='text-fields']/div/div/mat-form-field/div/div/div/textarea[@formcontrolname='subject' and @placeholder='Subject']") public WebElement subject;
	
	@FindBy(xpath="//div[@class='text-fields']/div/div/mat-form-field/div/div/div/textarea[@formcontrolname='content' and @placeholder='Content']") public WebElement pushContent;
	
	@FindBy(xpath="//mat-panel-title[contains(text(),'Email')]") public WebElement emailContentTab;
	
	@FindBy(xpath="//span[text()='Sender Email ID']") public WebElement selectSenderID;

	@FindBy(css=".mat-option.ng-star-inserted.mat-active") public WebElement senderID;
	
	@FindBy(xpath="//mat-panel-title[contains(text(),'English')]") public WebElement engEmailContent;
	
	@FindBy(xpath="//textarea[@placeholder='Subject']") public List<WebElement> emailSubject;
	
	@FindBy(id="tinymce") public List<WebElement> emailContentBody;
	
	
	
	

}
