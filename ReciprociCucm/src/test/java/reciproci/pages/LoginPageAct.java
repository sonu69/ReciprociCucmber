package reciproci.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import locators.LoginPageLoc;
import reciproci.base.Base;
import utility.ElementNotFound;

public class LoginPageAct extends Base{

	LoginPageLoc lc = new LoginPageLoc();

	
	public LoginPageAct(){
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, lc);
	}
	
	
	public void enterUserAndPass(String username, String password) {
		lc.userName.sendKeys(username);
		lc.password.sendKeys(password);
	}


	public Menu submit() {
		lc.loginButton.click();
		return new Menu();
	}
	
	
	public void verifySuccMsg() {
		wait.until(ExpectedConditions.visibilityOf(lc.successLoginMsg.get(0))).isDisplayed();
		Assert.assertTrue(lc.successLoginMsg.get(0).isDisplayed());
	}
	
	
	public void verifyErrMsg() {
		wait.until(ExpectedConditions.visibilityOf(lc.badCredentials)).isDisplayed();
		Assert.assertTrue(lc.badCredentials.isDisplayed());
	}
	
	
	public Menu doLogin() {
		lc.userName.sendKeys("admin");
		lc.password.sendKeys("test@123");
		lc.loginButton.click();
		wait.until(ExpectedConditions.visibilityOf(lc.successLoginMsg.get(0))).isDisplayed();
		Assert.assertEquals(lc.successLoginMsg.get(0).getText(), "You have successfully logged in");
		return new Menu();
	}
	
	
	public Menu doLogin(String username,String password) {
		lc.userName.sendKeys(username);
		lc.password.sendKeys(password);
		lc.loginButton.click();
		wait.until(ExpectedConditions.visibilityOf(lc.successLoginMsg.get(0))).isDisplayed();
		Assert.assertEquals(lc.successLoginMsg.get(0).getText(), "You have successfully logged in");
		return new Menu();
	}

	
//	public void verifyLoginSuccess() throws Exception {
//		lc.userName.sendKeys(Base.getString(1, 0, "Login"));
//		lc.password.sendKeys(Base.getString(1, 1, "Login"));
//		lc.loginButton.click();
//		
//		try {
//		wait.until(ExpectedConditions.visibilityOf(lc.successLoginMsg.get(0)));
//		if(lc.successLoginMsg.isEmpty()) {
//			throw new ElementNotFound("Success Message Not Found");
//		}
//		}catch(Exception e){
//			
//		}
//	}

	
	public void verifyLoginSuccess(String username,String password) throws Exception {
		type(lc.userName,username);
		type(lc.password,password);
		lc.loginButton.click();
		
		wait.until(ExpectedConditions.visibilityOf(lc.successLoginMsg.get(0)));
		if(lc.successLoginMsg.get(0).getSize().getHeight()>0){
			
		}else {
			throw new ElementNotFound("Test case Failed");
		}
	}
	
	public void verifyLoginError(String username, String password) throws Exception {
		lc.userName.sendKeys(username);
		lc.password.sendKeys(password);
		lc.loginButton.click();
		
			wait.until(ExpectedConditions.visibilityOf(lc.badCredential.get(0)));
			if(lc.badCredentials.isDisplayed()){
				System.out.println("Test case Pass");
			}else{
				throw new ElementNotFound("Test case Fail");
			}
	}
	
//	public void verifyLoginError() throws Exception {
//		
//		String username=Base.getString(2, 0, "Login");
//		lc.userName.sendKeys(username);
//		String password=Base.getString(2, 1, "Login");
//		lc.password.sendKeys(password);
//		lc.loginButton.click();
//		
//			wait.until(ExpectedConditions.visibilityOf(lc.badCredential.get(0)));
//			if(lc.badCredential.isEmpty()){
//				throw new ElementNotFound("Test case Fail");
//			}else{
//				System.out.println("Test case Pass");
//			}
//	}
	

}
