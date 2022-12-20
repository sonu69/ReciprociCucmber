package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import reciproci.base.Base;
import reciproci.pages.LoginPageAct;

class LoginValidation {
	
	LoginPageAct lp;

	@Test
	public void doLogin(){
		lp = new LoginPageAct();
		lp.doLogin();
	}
	
	
	@Test()
	public void doLogin1(){
		lp = new LoginPageAct();
		lp.doLogin("admin", "test@123");
	}
	
	
	@AfterMethod
	public void tearDown() {
		Base.driver=null;
	}
}
