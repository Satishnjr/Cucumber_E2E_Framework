package PageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;

public class HomePage {
	static WebDriver driver;

	public HomePage(WebDriver driver) {
		HomePage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBys(@FindBy(css = "#menu-main-menu > li"))
	public static List<WebElement> verifyMenuLinks;

	@FindBy(how = How.CLASS_NAME, using = "dropdown-toggle")
	public static WebElement calculatorsDropDown;

	@FindBys(@FindBy(css = " .dropdown-menu li"))
	public static List<WebElement> verifyAllLinks;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'FAQs')]")
	public static WebElement faqsDropDown;

	@FindBys(@FindBy(xpath = "//a[contains(text(),'FAQs')]/following-sibling::ul[1]/li"))
	public static List<WebElement> verifyFaqLinks;

	@FindBy(how = How.CLASS_NAME, using = "navbar-toggler")
	public static WebElement mobilemenu;

	public void perform_Search(String search) {
		driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl() + "/?s=" + search
				+ "&post_type=product");
	}

	public static void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

	public void i_click_on_FAQS_Nav_Link() throws Throwable {
		faqsDropDown.click();
	}

	public void i_Click_on_menu() throws Throwable {
		mobilemenu.click();
	}

	public void i_Verify_all_the_links_in_menu() throws Throwable {
		List<WebElement> items = HomePage.verifyMenuLinks;
		System.out.println(items.size());

		Assert.assertTrue(items.size() > 4);
		Assert.assertTrue(items.size() < 10);

		for (WebElement links : items) {
			System.out.println(links.getText());
		}
	}

	public void i_Verify_it_shows_all_the_sub_links() throws Throwable {
		List<WebElement> items = HomePage.verifyAllLinks;
		System.out.println(items.size());
		Assert.assertTrue(items.size() > 5);
		Assert.assertTrue(items.size() < 10);

		int visibleElementCount = 0;
		for (WebElement links : items) {
			if (links.isDisplayed()) {
				visibleElementCount++;
				System.out.println(links.getText());
			}

		}
		System.out.println(visibleElementCount);
		Assert.assertEquals(4, visibleElementCount);

	}

	public void i_Verify_all_the_FAQS_sub_links() throws Throwable {

		List<WebElement> items = HomePage.verifyFaqLinks;
		System.out.println(items.size());
		Assert.assertTrue(items.size() > 3);
		Assert.assertTrue(items.size() < 10);

		for (WebElement links : items) {
			System.out.println(links.getText());
		}

	}

}
