package stepdefinations;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DashboardPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private DashboardPage dashboardPage;

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credDataTable) {
		List<Map<String, String>> credList = credDataTable.asMaps();
		String uname = credList.get(0).get("username");
		String password = credList.get(0).get("password");

		DriverFactory.getDriver().get("https://practice.automationtesting.in/my-account/");
		dashboardPage = loginPage.doLogin(uname, password);
	}

	@Given("user is on Dashboard page")
	public void user_is_on_dashboard_page() {
		dashboardPage.getDashboardPageTitle();
	}

	@Then("user gets dashboard section")
	public void user_gets_dashboard_section(DataTable dashboardSectionDataTable) {
		List<String> expectedList = dashboardSectionDataTable.asList();
		System.out.println("Expected dashboard section list: " + expectedList);

		List<String> actualList = dashboardPage.getDashboardSectionList();
		System.out.println("Actual dashboard section list: " + actualList);

		Assert.assertTrue(expectedList.containsAll(actualList));
	}

	@Then("dashboard section could should be {int}")
	public void dashboard_section_could_should_be(Integer expectedDashboardCount) {
		Assert.assertTrue(dashboardPage.getDashboardSectionCount() == 6);
	}

	/*
	 * @When("user gets the title of the page") public void
	 * user_gets_the_title_of_the_page() {
	 * 
	 * }
	 */

	/*
	 * @Then("page title should be {string}") public void
	 * page_title_should_be(String string) {
	 * 
	 * }
	 */
}
