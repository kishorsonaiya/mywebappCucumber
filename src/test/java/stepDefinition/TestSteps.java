package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.junit.Assertions;
import junit.framework.Assert;

/**
 * 
 * @author jiteshkumar.patel
 *
 */
public class TestSteps {
	private WebDriver driver = null;
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "//opt//selenium//geckodriver");

		// this line of code is to resolve protected mode issue
		// capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
		// true);
		//capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		// without this setting, page will get open and then get closed
		//capabilities.setCapability(ChromeDriver.INITIAL_BROWSER_URL, "");

		// capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,
		// "http://localhost:8090/mywebapp/userlogin.jsp");

		// this line of code is to resolve protected mode issue
		//capabilities.setCapability(ChromeDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

		// **VERY important** adding this line make launching the webapp site
		//capabilities.setCapability(ChromeDriver.IGNORE_ZOOM_SETTING, true);

		// Adding INITIAL_BROWSER_URL, help to load the IE with required url.
		// Otherwise it will open browser with default url and then redirect to
		// application url
		//capabilities.setCapability(ChromeDriver.INITIAL_BROWSER_URL,"http://10.177.162.26:9080/mywebapp/userlogin.jsp");

		// using this feature, sendKeys function was with good speed. Other wise
		// it takes 3 sends to type one character.
		//capabilities.setCapability(ChromeDriver.NATIVE_EVENTS, false);

		driver = new FirefoxDriver();
		String baseUrl = "http://10.177.162.26:9080/mywebapp/userlogin.jsp";
		driver.manage().window().maximize();
		driver.navigate().to(baseUrl);
	}


	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() throws Throwable {
		String userlogin_title = driver.findElement(By.id("userlogin_title")).getText();
		if (null != userlogin_title && userlogin_title.contains("Login Here")) {
			WebElement email = driver.findElement(By.id("email"));
			WebElement password = driver.findElement(By.id("password"));
			email.sendKeys("jiteshkumar.patel@infosys.com");
			password.sendKeys("1234");
			driver.findElement(By.id("loginsubmit")).click();
		}
		
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		WebElement loginServlet_success = driver.findElement(By.id("loginServlet_success"));

		if (null != loginServlet_success) {
			String loginServlet_success_txt = loginServlet_success.getText();
			Assert.assertTrue(loginServlet_success_txt.contains("Welcome,"));
			
			/*if (loginServlet_success_txt.contains("Welcome,")) {
				System.out.println("Login successfull");
				Assert.assertTrue(true);
			}*/ 
			
		} 
		driver.quit();
	}

}
