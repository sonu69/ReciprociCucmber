package reciproci.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import locators.CampaignAddLoc;
import reciproci.base.Base;

public class CampaignAddPage extends Base{
	
	CampaignAddLoc ca = new CampaignAddLoc();
	
	public CampaignAddPage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,20);
		PageFactory.initElements(factory, ca);
	}
	
	
	public void createCampaign() throws InterruptedException {
		
		Thread.sleep(2000);
		click(ca.clickActivity);
		click(ca.otherCampaignType);
		type(ca.campaignName,"Testing campaign 072101");
		type(ca.campaignDescription,"Testing campaign 072101");
		click(ca.pushCommunicationType);
		click(ca.EmailCommunicationType);
		clickJ(ca.deliverySchedule);
		Thread.sleep(1000);
		clickJ(ca.immediateSchedule);
		clickJ(ca.continueBasic.get(0));
		Thread.sleep(2000);
		type(ca.notificationLimit,"1");
		click(ca.selectSegment);
		Thread.sleep(2000);
		clickJ(ca.segmentRule);
		driver.findElement(By.xpath("//option[contains(text(),'Gender')]")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Male')]")).click();
		click(ca.submitSegment.get(1));
		Thread.sleep(1000);
		clickJ(ca.continueBasic.get(1));
		Thread.sleep(1000);
		ca.pushContentTab.click();Thread.sleep(1000);
		ca.liknTo.click();Thread.sleep(1000);
		ca.liknToOption.click();Thread.sleep(1000);
		ca.subject.sendKeys("Hope You are doing great");Thread.sleep(1000);
		ca.pushContent.sendKeys("Hello Dear, Hope You are doing great");Thread.sleep(1000);
		clickJ(ca.emailContentTab);
		Thread.sleep(1000);
		clickJ(ca.selectSenderID);Thread.sleep(1000);
		clickJ(ca.senderID);Thread.sleep(1000);
		clickJ(ca.engEmailContent);Thread.sleep(1000);
		ca.emailSubject.get(2).sendKeys("Hope You are doing great");Thread.sleep(1000);
		driver.switchTo().frame(0);
		ca.emailContentBody.get(0).sendKeys("Hello Email Body");
		driver.switchTo().parentFrame();
		
		
	}
	

}
