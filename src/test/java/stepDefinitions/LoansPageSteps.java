package stepDefinitions;

import PageObjects.LoansPage;
import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoansPageSteps {
	TestContext testContext;
	LoansPage loansPage;
	 
	 public LoansPageSteps(TestContext context) {
	 testContext = context;
	 loansPage = testContext.getPageObjectManager().getLoansPage();
	 }

	@When("^I enter \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" in search textbox$")
	public void i_enter_in_search_textbox(String homeLoanAmount, String interest, String tenure) throws Throwable {
		
		loansPage.i_enter_in_search_textbox(homeLoanAmount, interest, tenure);
		
	}

	@Then("^I should get result as \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void i_should_get_result_as(String emiAmount, String loanInterest, String loanTotalPay) throws Throwable {

		loansPage.i_should_get_result_as(emiAmount, loanInterest, loanTotalPay);
	}

	@And("^I Click on Personal Loan$")
	public void i_Click_on_Personal_Loan() throws Throwable {
		loansPage.i_Click_on_Personal_Loan();
	}

	@When("^I Click on Car Loan$")
	public void i_Click_on_Car_Loan() throws Throwable {
		loansPage.i_Click_on_Car_Loan();
	}
	
	

}
