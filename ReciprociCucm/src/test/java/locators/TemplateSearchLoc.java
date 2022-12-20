package locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TemplateSearchLoc {
	
	@FindBy(css="input[placeholder='Search Template']") public WebElement searchTemplateBox;
	
	@FindBy(css="div[class='common-search']>span") public WebElement searchButton;
	
	@FindBy(xpath="//td[contains(@class,'templateName')]/u/a") public List<WebElement> templateNames;

}
