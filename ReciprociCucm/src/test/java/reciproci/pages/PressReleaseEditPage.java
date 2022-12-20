package reciproci.pages;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import locators.PressReleaseScrLoc;
import reciproci.base.Base;

public class PressReleaseEditPage extends Base{
	
	PressReleaseScrLoc pl = new PressReleaseScrLoc();
	
	public PressReleaseEditPage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,20);
		PageFactory.initElements(factory, pl);	
	}



	

}
