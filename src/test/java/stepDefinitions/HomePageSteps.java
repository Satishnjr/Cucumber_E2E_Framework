package stepDefinitions;


import PageObjects.HomePage;
import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps {
	TestContext testContext;
	 HomePage homePage;
	 
	 public HomePageSteps(TestContext context) {
	 testContext = context;
	 homePage = testContext.getPageObjectManager().getHomePage();
	 }

	@Given("^I open EMI Calculator website$")
	public void i_open_EMI_Calculator_website() throws Throwable {
		HomePage.navigateTo_HomePage();
	}

	@Given("^I open EMI Calculator website in mobile$")
	public void i_open_EMi_Calculator_website_in_mobile() throws Throwable {
		HomePage.navigateTo_HomePage();
		//driver.manage().window().setSize(new Dimension(412, 732));

	}
	
	@Given("^I click on FAQS Nav Link$")
	public void i_click_on_FAQS_Nav_Link() throws Throwable {
		homePage.i_click_on_FAQS_Nav_Link();
	}

	

	@When("^I Click on menu$")
	public void i_Click_on_menu() throws Throwable {
		homePage.i_Click_on_menu();
	}
	
	
	@Then("^I Verify all the links in menu$")
	public void i_Verify_all_the_links_in_menu() throws Throwable {
		homePage.i_Verify_all_the_links_in_menu();
	}

	@Then("^I Verify it shows all the sub links$")
	public void i_Verify_it_shows_all_the_sub_links() throws Throwable {
		homePage.i_Verify_all_the_FAQS_sub_links();
	}
	
	

	@Then("^I Verify all the FAQS sub links$")
	public void i_Verify_all_the_FAQS_sub_links() throws Throwable {
		homePage.i_Verify_all_the_FAQS_sub_links();
	}

}
