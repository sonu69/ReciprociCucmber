package reciproci.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import locators.TemplateAddLoc;
import reciproci.base.Base;
import utility.ElementNotFound;

public class TemplateADDPage extends Base{
	
	TemplateAddLoc at = new TemplateAddLoc();
	
	public TemplateADDPage() {
		
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,20);
		PageFactory.initElements(factory, at);
		
	}
	
	public TemplateSearchPage addWhatsappTemplate() throws Exception{
		
		Thread.sleep(1000);
		
		at.templateType.click();
		
		at.whatsappTemplate.click();
		
		at.templateName.sendKeys("New Template");
		
		at.templateID.get(0).sendKeys("56325678");
		
		at.content.get(0).sendKeys("English contents");
		
		at.uploadImg.get(0).click();
		
		Base.uploadImage("/DataFiles/Images/HighHQ.jpg");
		
		at.templateID.get(1).sendKeys("56325678");
		
		at.content.get(1).sendKeys("Arabic contents");
		
		Base.scrollToElement(at.uploadImg.get(1));
		
		at.uploadImg.get(1).click();
		
		Base.uploadImage("/DataFiles/Images/HighHQ.jpg");
		
		at.cancelTemplate.click();
		
		return new TemplateSearchPage();
		
	}
	
	public void duplicateSenderID() throws Exception{
		
		Thread.sleep(1000);
		
		at.templateType.click();
		
		at.whatsappTemplate.click();
		
		at.templateName.sendKeys("New Template");
		
		at.templateID.get(0).sendKeys("6288887");
		
		at.content.get(0).sendKeys("English contents");
		
		at.uploadImg.get(0).click();
		
		Base.uploadImage("/DataFiles/Images/HighHQ.jpg");
		
		at.templateID.get(1).sendKeys("6288887");
		
		at.content.get(1).sendKeys("Arabic contents");
		
		Base.scrollToElement(at.uploadImg.get(1));
		
		at.uploadImg.get(1).click();
		
		Base.uploadImage("/DataFiles/TestDatas/Certification.docx");
		
		at.addTemplate.click();
		
		try {
			at.duplicateMsg.isDisplayed();
		}catch(Exception e){
			throw new ElementNotFound("Not Found");
		}
		
		
	}
	
	
	public void verifyErrMsg() throws Exception {
		
		Thread.sleep(1000);
		
		at.templateType.click();
		
		at.whatsappTemplate.click();
		
		at.templateName.sendKeys("New Template");
		
		at.templateID.get(0).sendKeys("123456");
		
		at.content.get(0).sendKeys("English contents");
		
		at.uploadImg.get(0).click();
		
		Base.uploadImage("/DataFiles/TestDatas/Certification.docx");
		
		wait.until(ExpectedConditions.visibilityOf(at.errFileMsg));
		
		try {
			at.errFileMsg.isDisplayed();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	public TemplateSearchPage cancelWhatsappTemplate() {
		at.cancelTemplate.click();
		return new TemplateSearchPage();
	}

}
