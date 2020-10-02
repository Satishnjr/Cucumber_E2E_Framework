
package stepDefinitions;

import PageObjects.LoansPage;
import cucumber.TestContext;
import cucumber.api.java.en.Then;

public class ExcelLoansPageSteps {
	TestContext testContext;
	LoansPage loansPage;

	public ExcelLoansPageSteps(TestContext context) {
		testContext = context;
		loansPage = testContext.getPageObjectManager().getLoansPage();
	}

	@Then("^I read data from excel and validate emi details$")
	public void i_read_data_from_excel_and_validate_emi_details() throws Throwable {
		loansPage.i_read_data_from_excel_and_validate_emi_details();
	}

	public void i_read_data_from_excel_and_validate_Personal_Loan_emi_details() throws Throwable {
		loansPage.i_read_data_from_excel_and_validate_Personal_Loan_emi_details();
	}
}
