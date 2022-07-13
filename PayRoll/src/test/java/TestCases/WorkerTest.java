package TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.payroll.Actions.Action;
import com.payroll.BaseClass.BaseClass;
import com.payroll.PageObjects.CreateWorker;
import com.payroll.PageObjects.HomePage;
import com.payroll.PageObjects.LoginPage;
import com.payroll.PageObjects.Workers;
import com.payroll.Utilities.Excel;

public class WorkerTest extends BaseClass
{
	@BeforeTest
	public void start()
	{
		launchApp();
	}
	
	LoginPage lp;
	Action act;
	HomePage hp;
	Excel ex; Workers w; CreateWorker cw;
	
	@BeforeClass
	public void object()
	{
		act = new Action();
		  hp = new  HomePage(driver);
		  lp = new LoginPage(driver);
		  ex = new Excel();
		 w = new Workers(driver); 
		 cw = new CreateWorker(driver);
	}
	
	@Test
	public void Home1()
	{
		lp.username().click();
		lp.username().sendKeys("carol");
		lp.password().click();
		lp.password().sendKeys("1q2w3e4r");
		lp.loginbutton().click();
		act.explicitWait(driver, hp.Hlogo(), 10);
		String expected = "Workers";
		String actual =	hp.Hworker().getText();
		assertEquals(actual, expected);
		hp.Hprofile().click();
		hp.Hlogout().click();
	}
	
	@Test
	public void Home2()
	{
		lp.username().click();
		lp.username().sendKeys("carol");
		lp.password().click();
		lp.password().sendKeys("1q2w3e4r");
		lp.loginbutton().click();
		hp.Hworker().click();
		act.explicitWait(driver, w.Wlogo(), 10);
		String expected = "WORKERS";
		String actual =	w.Wlogo().getText();
		assertEquals(actual, expected);
		hp.Hprofile().click();
		hp.Hlogout().click();
	}
	
	@Test
	public void Home3()
	{
		lp.username().click();
		lp.username().sendKeys("carol");
		lp.password().click();
		lp.password().sendKeys("1q2w3e4r");
		lp.loginbutton().click();
		hp.Hworker().click();
		w.createworker().click();
		act.explicitWait(driver, w.Wlogo(), 10);
		String expected = "CREATE WORKER";
		String actual =	w.Wlogo().getText();
		assertEquals(actual, expected);
		hp.Hprofile().click();
		hp.Hlogout().click();
	}
	
	@Test
	public void Home4() throws Exception
	{
		lp.username().click();
		lp.username().sendKeys("carol");
		lp.password().click();
		lp.password().sendKeys("1q2w3e4r");
		lp.loginbutton().click();
		hp.Hworker().click();
		w.createworker().click();
		act.explicitWait(driver, w.Wlogo(), 10);
		String expected = "CREATE WORKER";
		String actual =	w.Wlogo().getText();
		assertEquals(actual, expected);
		String value = "Mr";
		cw.Ctitle().click();
		act.selectByValue(cw.Ctitle(), value);
		//Thread.sleep(1000);
		String fname=ex.readStringData(1,0,"CreateWorker",System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx");
		cw.Cfname().click();
		cw.Cfname().sendKeys(fname);
		String lname=ex.readStringData(1,1,"CreateWorker",System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx");
		cw.Clname().click();
		cw.Clname().sendKeys(lname);
		String known=ex.readStringData(1,2,"CreateWorker",System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx");
		cw.Cknown().click();
		cw.Cknown().sendKeys(known);
		//Thread.sleep(3000);
		String phone=ex.readStringData(1,3,"CreateWorker",System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx");
		cw.Cphone().click();
		cw.Cphone().sendKeys(phone);
		String mobile=ex.readStringData(1,4,"CreateWorker",System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx");
		cw.Cmobile().click();
		cw.Cmobile().sendKeys(mobile);
		//Thread.sleep(3000);
		act.scrollByValue(driver);
		String email=ex.readStringData(1,5,"CreateWorker",System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx");
		cw.Cemail().click();
		cw.Cemail().sendKeys("email");
		Thread.sleep(1000);
		
		//String gvalue="Male";
		//cw.Cgender().click();
		//act.selectByValue(cw.Cgender(), gvalue);
		
		String mname=ex.readStringData(1,6,"CreateWorker",System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx");
		cw.Cmname().click();
		cw.Cmname().sendKeys(mname);
		
		cw.Cdob().click();
		cw.Cdate().click();
		
		String add1=ex.readStringData(1,7,"CreateWorker",System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx");
		cw.Caddress1().click();
		
		cw.Caddress1().sendKeys(add1);
		String add2=ex.readStringData(1,8,"CreateWorker",System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx");
		cw.Caddress2().click();
		cw.Caddress2().sendKeys(add2);
		String add3=ex.readStringData(1,9,"CreateWorker",System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx");
		cw.Caddress3().click();
		cw.Caddress3().sendKeys(add3);
		String pcode=ex.readStringData(1,10,"CreateWorker",System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx");
		cw.Cpcode().click();
		cw.Cpcode().sendKeys(pcode);
		
		String brtext="Alpha_new";
		cw.Cbranchid().click();
		act.selectByVisibleText(brtext,cw.Cbranchid());
		
		String division="NewAlpha";
		cw.Cdivisionid().click();
		act.selectByVisibleText(division,cw.Cdivisionid());
		
		String emptype="paye";
		cw.Cemptype().click();
		act.selectByValue(cw.Cemptype(), emptype);
		
		String slip="electronic";
		cw.Cpayslip().click();
		act.selectByValue(cw.Cpayslip(), slip);
		
		String status="partnership";
		cw.Cengstatus().click();
		act.selectByValue(cw.Cengstatus(), status);
		
		String ninmbr=ex.readStringData(1,11,"CreateWorker",System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx");
		cw.Cninmber().click();
		cw.Cninmber().sendKeys(ninmbr);
		String country=ex.readStringData(1,12,"CreateWorker",System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx");
		cw.Ccountry().click();
		cw.Ccountry().sendKeys(country);
		Thread.sleep(5000);
		hp.Hprofile().click();
		hp.Hlogout().click();
	}
	
	
	
	@AfterTest
	public void close()
	{
		driver.quit();
	}
	
}
