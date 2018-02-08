package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

/**
 * 
 * @author jiteshkumar.patel
 *
 */
public class TestStepsLoginWithData {
	private WebDriver driver = null;

	@Given("^User is on Login Page$")
	public void user_is_on_Home_Page() throws Throwable {
		System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");

		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		// this line of code is to resolve protected mode issue
		// capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
		// true);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		// without this setting, page will get open and then get closed
		capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");

		// capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,
		// "http://localhost:8090/mywebapp/userlogin.jsp");

		// this line of code is to resolve protected mode issue
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

		// **VERY important** adding this line make launching the webapp site
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);

		// Adding INITIAL_BROWSER_URL, help to load the IE with required url.
		// Otherwise it will open browser with default url and then redirect to
		// application url
		capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,
				"http://PUNITP383056D:8090/mywebapp/userlogin.jsp");

		// using this feature, sendKeys function was with good speed. Other wise
		// it takes 3 sends to type one character.
		capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);

		driver = new InternetExplorerDriver(capabilities);
		driver.manage().window().maximize();
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_UserName_and_Password(String p_username, String p_password) throws Throwable {
		try {
			System.out.println("p_username: " + p_username + " :");
			System.out.println("p_password: " + p_password + " :");

			String userlogin_title = driver.findElement(By.id("userlogin_title")).getText();
			if (null != userlogin_title && userlogin_title.contains("Login Here")) {
				WebElement we_email = driver.findElement(By.id("email"));
				WebElement we_password = driver.findElement(By.id("password"));
				we_email.sendKeys(p_username);
				we_password.sendKeys(p_password);
				driver.findElement(By.id("loginsubmit")).click();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}

	}

	@Then("^Login Successfully$")
	public void Login_Successfully() throws Throwable {

			WebElement loginServlet_success = driver.findElement(By.id("loginServlet_success"));

			System.out.println("Login success page loadded");

			if (null != loginServlet_success) {
				String loginServlet_success_txt = loginServlet_success.getText();
				Assert.assertTrue(loginServlet_success_txt.contains("Welcome,"));

				System.out.println("Login successfull");
				/*
				 * if (loginServlet_success_txt.contains("Welcome,")) {
				 * System.out.println("Login successfull"); }
				 */
			}
			driver.quit();

	}

}
