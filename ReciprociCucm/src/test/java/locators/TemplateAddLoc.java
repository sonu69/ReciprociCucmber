package locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TemplateAddLoc {
	
	@FindBy(css=".mat-form-field-infix>mat-select") public WebElement templateType;
	
	@FindBy(css="mat-option[value='WHATSAPP']") public WebElement whatsappTemplate;
	
	@FindBy(css="input[placeholder='Template Name']") public WebElement templateName;
	
	@FindBy(css="input[placeholder='Template ID']") public List <WebElement> templateID;
	
	@FindBy(css="textarea[placeholder='Content']") public List <WebElement> content;
	
	@FindBy(xpath="//span[contains(text(),'Upload Image/Video/File')]") public List <WebElement> uploadImg;
	
	@FindBy(xpath="//button[text()='ADD']") public WebElement addTemplate;
	
	@FindBy(xpath="//button[text()='CANCEL']") public WebElement cancelTemplate;
	
	@FindBy(xpath="//div[contains(text(),'Invalid file type- supported')]") public WebElement errFileMsg;
	
	@FindBy(xpath="//div[contains(text(),'whatsApp Template Id is already present')]")  public WebElement duplicateMsg;


}