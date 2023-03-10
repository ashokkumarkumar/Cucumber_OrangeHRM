package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinations {
	WebDriver driver;
	String Expected="";
	String Actual ="";
	@Given("^user navigates url in chrome browser$")
	public void user_navigates_url_in_chrome_browser() throws Throwable {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://orangehrm.qedgetech.com/");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^user enter username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_enter_username_as_and_password_as(String username, String password) throws Throwable {
	   driver.findElement(By.name("txtUsername")).sendKeys(username);
	   driver.findElement(By.name("txtPassword")).sendKeys(password);
	}

	@When("^user click login button$")
	public void user_click_login_button() throws Throwable {
		driver.findElement(By.name("Submit")).click();
	}

	@When("^user click pim  and click add button$")
	public void user_click_pim_and_click_add_button() throws Throwable {
		driver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
		driver.findElement(By.name("btnAdd")).click();
	}

	@When("^user enter fname \"([^\"]*)\"$")
	public void user_enter_fname(String firstName) throws Throwable {
	    driver.findElement(By.name("firstName")).sendKeys(firstName);
	}

	@When("^user enter mname \"([^\"]*)\"$")
	public void user_enter_mname(String middleName) throws Throwable {
		 driver.findElement(By.name("middleName")).sendKeys(middleName);
	}

	@When("^user Enter lname \"([^\"]*)\"$")
	public void user_Enter_lname(String lastName) throws Throwable {
		 driver.findElement(By.name("lastName")).sendKeys(lastName);
	}

	@When("^user capture Eid Before$")
	public void user_capture_Eid_Before() throws Throwable {
	   Expected =driver.findElement(By.name("employeeId")).getAttribute("value");
	}

	@When("^user clicks save button$")
	public void user_clicks_save_button() throws Throwable {
		driver.findElement(By.id("btnSave")).click();
	}

	@When("^user capture Eid after$")
	public void user_capture_Eid_after() throws Throwable {
		Actual =driver.findElement(By.name("personal[txtEmployeeId]")).getAttribute("value");
	}

	@Then("^user validates eid$")
	public void user_validates_eid() throws Throwable {
	    if(Expected.equals(Actual))
	    {
	    	System.out.println("Emp Id is Macthing::"+Expected+"   "+Actual);
	    }
	    else
	    {
	    	System.out.println("Emp Id is Not Macthing::"+Expected+"   "+Actual);
	    }
	}

	@Then("^user close browser$")
	public void user_close_browser() throws Throwable {
	   driver.close();
	}


}
