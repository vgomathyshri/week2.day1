package selenium.week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		/*
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		  2. Enter UserName and Password Using Id Locator
		  3. Click on Login Button using Class Locator
		  4. Click on CRM/SFA Link
		  5. Click on Leads Button
		  6. Click on Create Lead 
		  7. Enter CompanyName Field Using id Locator
		  8. Enter FirstName Field Using id Locator
		  9. Enter LastName Field Using id Locator
		  10. Enter FirstName(Local) Field Using id Locator
		  11. Enter Department Field Using any Locator of Your Choice
		  12. Enter Description Field Using any Locator of your choice 
		  13. Enter your email in the E-mail address Field using the locator of your choice
		  14. Select State/Province as NewYork Using Visible Text
		  15. Click on Create Button
                  16. Get the Title of Resulting Page(refer the video)  using driver.getTitle()
                  17. Click on Duplicate button
                  18. Clear the CompanyName Field using .clear() And Enter new CompanyName
                  19.Clear the FirstName Field using .clear() And Enter new FirstName
                  20.Click on Create Lead Button
                  21. Get the Title of Resulting Page(refer the video)  using driver.getTitle()
		 */

		
		
		WebDriverManager.edgedriver().setup();
		
		String driverpath = System.getProperty("Webdriver.edge.driver");	
		System.out.println(driverpath);
		
		EdgeDriver driver = new EdgeDriver();
		
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Tcs");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Gomathy Shri");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Venugopalan");
		//Drop Down
		WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dd = new Select(source);
				dd.selectByValue("LEAD_CONFERENCE");
		
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Gomathy Shri_Local");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Department123");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Description 123");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("gomathyshri.v19@gmail.com");
		
		//Drop Down
		WebElement stateProvince = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select sp = new Select(stateProvince);
		sp.selectByVisibleText("New York");
		
		driver.findElement(By.className("smallSubmit")).click();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Hexaware");
		driver.findElement(By.name("submitButton")).click();
		String title2 = driver.getTitle();
		System.out.println(title2);
		
		
		
		
	}

}
