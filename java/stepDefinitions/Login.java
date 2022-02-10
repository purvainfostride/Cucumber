package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	 WebDriver driver;
	 String url="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	 String expectedURL="https://opensource-demo.orangehrmlive.com/index.php/dashboard";

	 @Given("^user is on Login page$")
	 public void user_is_on_Login_page(){
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     driver.get(url);
	     
	   }
	 @When("^user enters username in the username textfield and password in password textfield$")
	 public void user_enters_username_in_the_username_textfield_and_password_in_password_textfield(DataTable dataTable) throws InterruptedException{
		 List<List<String>> data = dataTable.asLists(String.class);
		 for(List<String>e:data) {
		 driver.findElement(By.id("txtUsername")).clear();
		 driver.findElement(By.id("txtPassword")).clear();
		 driver.findElement(By.id("txtUsername")).sendKeys(e.get(0));
		 driver.findElement(By.id("txtPassword")).sendKeys(e.get(1));
		 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		 }
	   }
	 @And("^user clicks on the Login button$")
	 public void user_clicks_on_the_Login_button() {
		 driver.findElement(By.id("btnLogin")).click();
		 }
	 
	 @Then("^user is on Homepage$")
	 public void user_is_on_Homepage(){
		 Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
		}
}
