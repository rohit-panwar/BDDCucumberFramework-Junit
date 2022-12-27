package stepdefinations;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private String title;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		//DriverFactory.getDriver().get("https://magento.softwaretestingboard.com/customer/account/login");
		DriverFactory.getDriver().get("https://practice.automationtesting.in/my-account/");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("Page title is: " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		Assert.assertTrue(title.contains(expectedTitle));
	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.forgotPwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String userId) {
		loginPage.enterUserName(userId);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}
	
	@Then("user clicks on login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	}

	/*
	 * @Then("user gets the title of the home page") public void
	 * user_gets_the_title_of_the_home_page() { //loginPage.clickOnLogin(); }
	 */

}
