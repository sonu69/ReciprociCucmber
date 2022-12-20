package locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PressReleaseAddLoc {
	
	@FindBy(xpath="//div[contains(text(),'Supported format is JPG, JPEG and PNG')]") public WebElement fileValidation;

	@FindBy(xpath="//div[@class='mat-select-trigger']/div/span") public List<WebElement> selCountry;

	@FindBy(xpath="//span[text()='Select Brand']") public WebElement selBrand;

	@FindBy(xpath="//mat-option/span") public List<WebElement> brands;

	@FindBy(css=".mat-datepicker-toggle >button") public List<WebElement> publishDate;

	@FindBy(css="input[formcontrolname='publishFromTime']") public WebElement publishFromTime;

	@FindBy(css="input[formcontrolname='publishToTime']") public WebElement publishToTime;

	@FindBy(css=".owl-dt-timer-content>input") public List<WebElement> fromHour;

	@FindBy(xpath="//span[text()='Set']") public WebElement set;

	@FindBy(css="input[placeholder='Release Title']") public List<WebElement> releaseTitle;

	@FindBy(id="tinymce") public WebElement releaseContent;

	@FindBy(css=".upload-icon >img") public List<WebElement> uploadEngImg;
	
	@FindBy(css=".upload-icon >img") public List<WebElement> uploadArbImg;
	
	@FindBy(xpath="//button[text()='CANCEL']") public WebElement cancel;

}
