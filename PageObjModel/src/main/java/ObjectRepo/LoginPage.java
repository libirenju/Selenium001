package ObjectRepo;

import org.openqa.selenium.By;

public class LoginPage
{
	By username = By.id("user-name");
	By password = By.cssSelector(" input[placeholder*='Password']");
	By loginbutton = By.xpath("//input[@value='Login']");
}
