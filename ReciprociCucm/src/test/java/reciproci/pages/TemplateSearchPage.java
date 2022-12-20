package reciproci.pages;

import java.util.Iterator;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import locators.TemplateSearchLoc;
import reciproci.base.Base;

public class TemplateSearchPage extends Base{
	
	TemplateSearchLoc tc = new TemplateSearchLoc();
	
	public TemplateSearchPage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,20);
		PageFactory.initElements(factory, tc);
	}
	
	public void verifySearch() throws InterruptedException {
		
		tc.searchTemplateBox.sendKeys("Test Data");
		Base.click(tc.searchButton);
		tc.searchButton.click();
		
	}
	
	
	public void getTemplatesName(){
		
		int templates = tc.templateNames.size();
		String[] templateNames = null;
		for (int i = 0; i < templates; i++) {
			templateNames[i] = tc.templateNames.get(i).getText();
		}
		
	}
	

}
