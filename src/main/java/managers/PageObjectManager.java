package managers;
 
 
 
import org.openqa.selenium.WebDriver;

import PageObjects.HomePage;
import PageObjects.LoansPage;


 
 
 
public class PageObjectManager {
 
 private WebDriver driver;
 
 private HomePage homePage;
 
 private LoansPage loansPage;		
 

 
 
 
 public PageObjectManager(WebDriver driver) {
 
 this.driver = driver;
 
 }
 
 
 
 public HomePage getHomePage(){
 
 return (homePage == null) ? homePage = new HomePage(driver) : homePage;
 
 }
 
 
 
 public LoansPage getLoansPage() {
 
 return (loansPage == null) ? loansPage = new LoansPage(driver) : loansPage;
 
 }
 
 
 
 	}