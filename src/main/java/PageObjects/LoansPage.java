package PageObjects;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import dataProviders.DataHelper;

public class LoansPage {

	static WebDriver driver;

	public LoansPage(WebDriver driver) {
		LoansPage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "#loanamount")
	public static WebElement homeloan;

	@FindBy(how = How.CSS, using = "#loaninterest")
	public static WebElement interestRate;

	@FindBy(how = How.CSS, using = "#loanterm")
	public static WebElement loanTenure;

	@FindBy(how = How.CSS, using = "#emiamount p span")
	public static WebElement loanEMI;

	@FindBy(how = How.CSS, using = "#emitotalinterest p span")
	public static WebElement loanInterest;

	@FindBy(how = How.CSS, using = "#emitotalamount p span")
	public static WebElement LoanTotalPay;

	@FindBy(how = How.CSS, using = "#personal-loan a")
	public static WebElement personalloan;

	@FindBy(how = How.CSS, using = "#car-loan a")
	public static WebElement carloan;

	public void i_enter_in_search_textbox(String homeLoanAmount, String interest, String tenure) throws Throwable {

		homeloan.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), homeLoanAmount);
		interestRate.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), interest);
		loanTenure.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), tenure);
		loanTenure.sendKeys(Keys.ENTER);
	}

	public void i_should_get_result_as(String emiAmount, String loanInterest, String loanTotalPay) throws Throwable {

		String emi = loanEMI.getText();
		Assert.assertEquals(emiAmount, emi);

		String interest = LoansPage.loanInterest.getText();
		Assert.assertEquals(loanInterest, interest);

		String TotalPay = LoanTotalPay.getText();
		Assert.assertEquals(loanTotalPay, TotalPay);
	}

	public void i_Click_on_Personal_Loan() throws Throwable {
		personalloan.click();
	}

	public void i_Click_on_Car_Loan() throws Throwable {
		carloan.click();
	}

	public void i_read_data_from_excel_and_validate_emi_details() throws Throwable {

		List<HashMap<String, String>> data = DataHelper.data();

		for (HashMap<String, String> map : data) {
			System.out.println(map);

			i_enter_in_search_textbox(map.get("Home Loan Amount"), map.get("Interest Rate"), map.get("Loan Tenure"));
			i_should_get_result_as(map.get("Loan EMI"), map.get("Total Interest Payable"), map.get("Total Payment"));

			// LoansPageAction.enterLoanData(map.get("Home Loan Amount"), map.get("Interest
			// Rate"), map.get("Loan Tenure"));
			// LoansPageAction.validateLoanDetails(map.get("Loan EMI"), map.get("Total
			// Interest Payable"), map.get("Total Payment"));
		}
	}

	public void i_read_data_from_excel_and_validate_Personal_Loan_emi_details() throws Throwable {
		List<HashMap<String, String>> data = DataHelper.data();

		for (HashMap<String, String> map : data) {
			System.out.println(map);
			i_enter_in_search_textbox(map.get("Home Loan Amount"), map.get("Interest Rate"), map.get("Loan Tenure"));
			i_should_get_result_as(map.get("Loan EMI"), map.get("Total Interest Payable"), map.get("Total Payment"));
			// LoansPageAction.enterLoanData(map.get("Home Loan Amount"), map.get("Interest
			// Rate"),map.get("Loan Tenure"));
			// LoansPageAction.validateLoanDetails(map.get("Loan EMI"), map.get("Total
			// Interest Payable"),map.get("Total Payment"));
		}
	}
}
