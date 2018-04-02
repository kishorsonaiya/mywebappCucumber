package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
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
		System.setProperty("webdriver.gecko.driver", "//opt//selenium//geckodriver");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driver = new FirefoxDriver(capabilities);
		String baseUrl = "http://10.177.162.26:9080/mywebapp/userlogin.jsp";
		driver.get(baseUrl);
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
