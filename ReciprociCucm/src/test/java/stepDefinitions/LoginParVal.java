package stepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginParVal {

	WebDriver driver;

	@Before
	public void initiate() {
		System.out.println("--initiate property File / Excel file etc");
	}

//	@BeforeStep
//	public void logs() {
//		System.out.println("--logs--");
//	}
//
//
//	@AfterStep
//	public void recorded() {
//		System.out.println("--recorded--");		
//	}


	@Given("Open {string}")
	public void open(String string) {
		if(string.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
	}


	@Given("launch admin login url")
	public void launch_admin_login_url() {
		driver.get("https://ca-admin-uat.reciproci.com/admin/login");
	}


	@When("Enter {string} and {string}")
	public void enter_and(String username, String password) {
		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}

	@When("Enter LoginButton")
	public void enter_LoginButton() {
		driver.findElement(By.cssSelector(".login")).click();
	}


	@Then("Admin Dashboard page will open")
	public void admin_Dashboard_page_will_open() {
		String txt = driver.findElement(By.xpath("//div[contains(text(),'You have successfully logged in')]")).getText();
		System.out.println(txt);
	}

	@After
	public void closeBrowser() {
		System.out.println("--closing browser--");
		driver.close();
	}

	
	@Given("Open browser")
	public void open_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);  
	    
	}

	@Given("Enter admin url")
	public void enter_admin_url() {
		driver.get("https://ca-admin-uat.reciproci.com/admin/login");
	}

	@When("Enter invalid username")
	public void enter_invalid_username() {
		driver.findElement(By.name("userName")).sendKeys("username");
	}

	@When("Enter valid password")
	public void enter_valid_password() {

		driver.findElement(By.name("password")).sendKeys("test@123");
	}

	@When("click on login button")
	public void click_on_login_button() {
		driver.findElement(By.cssSelector(".login")).click();
	}

	@Then("Error message will be displayed")
	public void error_message_will_be_displayed() {
		System.out.println("--Error msg will be displayed--");
	}
	
}
