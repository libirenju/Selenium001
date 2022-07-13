package TestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.payroll.Actions.Action;
import com.payroll.BaseClass.BaseClass;
import com.payroll.PageObjects.HomePage;
import com.payroll.PageObjects.LoginPage;
import com.payroll.PageObjects.PasswordReset;
import com.payroll.Utilities.Excel;

public class LoginTest extends BaseClass
{
	@BeforeTest
	public void start()
	{
		launchApp();
	}
	
	LoginPage lp;
	Action act;
	HomePage hp;
	Excel ex; PasswordReset pr;
	
	@BeforeClass
	public void object()
	{
		act = new Action();
		  hp = new  HomePage(driver);
		  lp = new LoginPage(driver);
		  ex = new Excel();
		  pr = new PasswordReset(driver);
	}
	
	
	  @Test(priority=1) 
	  public void LoginTest1() throws Exception 
	  { 	
		  //act = new Action();
		  //hp = new  HomePage(driver);
		  //lp = new LoginPage(driver);
			/*
			 * lp.username().click(); lp.username().sendKeys("carol");
			 * lp.password().click(); lp.password().sendKeys("1q2w3e4r");
			 * lp.username().click();
			 */
		  String username=ex.readStringData(1,0,"Login",System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx");//username from excelfile
		  String password=ex.readStringData(1,1,"Login",System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx");//password from excelfile
		  lp.username().sendKeys(username);
		  lp.password().click();
		  lp.password().sendKeys(password);
		  lp.loginbutton().click();
		  act.explicitWait(driver, hp.Hlogo(), 10); 
		  String expected ="PAYROLL APPLICATION"; 
		  String actual = hp.Hlogo().getText();
		  assertEquals(actual, expected);
		  hp.Hprofile().click();
		  hp.Hlogout().click();
	  }
	  
	  @Test(dataProvider="getData")
	  public void LoginTest2(String Username, String Password) 
	  { 
		  lp.username().click();
		  lp.username().sendKeys(Username); 
		  lp.password().click();
		  lp.password().sendKeys(Password);
		  lp.loginbutton().click();
		  act.explicitWait(driver, lp.alertmsg(), 10);
		  String expected ="Incorrect username or password.";
		  String actual = lp.alertmsg().getText();
		  assertEquals(actual, expected);
	  }
	  
	  @DataProvider
		public Object[][] getData()
		{
			
			Object[][] data=new Object[1][2];
			//0th row
			data[0][0]="admin";
			data[0][1]="123456";
			return data;
		}
	 
	@Test(priority=3)
	public void LoginTest3()
	{
		lp.username().click();
		lp.username().sendKeys("   ");
		lp.password().click();
		lp.password().sendKeys("1q2w3e4r");
		lp.loginbutton().click();
		act.explicitWait(driver, lp.ualert(), 10);
		String expected = "Username cannot be blank.";
		String actual =	lp.ualert().getText();
		assertEquals(actual, expected);
	}
	
	
	  @Test(priority=4) 
	  public void LoginTest4()
	  { 
		  
		 lp.username().click();
		 lp.username().sendKeys("carol"); 
		 lp.password().click();
		 lp.password().sendKeys("");
		 lp.loginbutton().click();
		 act.explicitWait(driver, lp.palert(), 10);
		 String expected = "Password cannot be blank.";
		 String actual = lp.palert().getText();
		 assertEquals(actual, expected);
	  }
	  
	  @Test(priority=5) 
	  public void LoginTest5()
	  { 
		 lp.resetit().click();
		 act.explicitWait(driver,pr.Passlogo(), 10);
		 String expected = "Password Reset";
		 String actual = pr.Passlogo().getText();
		 assertEquals(actual, expected);
	  }
	  
	  @Test(priority=6) 
	  public void LoginTest6()
	  { 
		 lp.resetit().click();
		 pr.Passemail().click();
		 pr.Passemail().sendKeys("renju");
		 act.explicitWait(driver,pr.Passlogo(), 10);
		 String expected = "Password Reset";
		 String actual = pr.Passlogo().getText();
		 assertEquals(actual, expected);
	  }
	  
	  @Test(priority=7) 
	  public void LoginTest7()
	  { 
		 lp.resetit().click();
		 pr.Passemail().click();
		 pr.Passemail().sendKeys("renju");
		 pr.Psend().click();
		 act.explicitWait(driver,pr.Psend(), 10);
		 String expected = "Email is not a valid email address.";
		 String actual = pr.invalidmail().getText();
		 assertEquals(actual, expected);
	  }
	  
	  @Test(priority=8) 
	  public void LoginTest8()
	  { 
		 lp.resetit().click();
		 pr.Passemail().click();
		 pr.Passemail().sendKeys("  ");
		 pr.Psend().click();
		 act.explicitWait(driver,pr.Passlogo(), 10);
		 String expected = "Email cannot be blank.";
		 String actual = pr.invalidmail().getText();
		 System.out.println(actual);
		 assertEquals(actual, expected);
	  }
	  
	  @Test(priority=9) 
	  public void LoginTest9()
	  { 
		 lp.resetit().click();
		 pr.Passemail().click();
		 pr.Passemail().sendKeys("renju@gmail.com");
		 pr.Psend().click();
		 act.explicitWait(driver,pr.Passlogo(), 10);
		 String expected = "There is no user with this email address.";
		 String actual = pr.invalidmail().getText();
		 assertEquals(actual, expected);
	  }
	  
	  @Test(priority=10) 
	  public void LoginTest10()
	  { 
		 lp.resetit().click();
		 pr.Passemail().click();
		 pr.Passemail().sendKeys("renju");
		 act.explicitWait(driver,pr.Passlogo(), 10);
		 String expected = "Password Reset";
		 String actual = pr.Passlogo().getText();
		 assertEquals(actual, expected);
	  }
	  
	  @Test(priority=11) 
	  public void LoginTest11()
	  { 
		  lp.resetit().click();
		 pr.Pcancel().click();
		 act.explicitWait(driver,lp.loginlogo(), 10);
		 String expected = "Login";
		 String actual = lp.loginlogo().getText();
		 assertEquals(actual, expected);
	  }
	  
	 
	@AfterTest
	public void close()
	{
		driver.quit();
	}
	
}
