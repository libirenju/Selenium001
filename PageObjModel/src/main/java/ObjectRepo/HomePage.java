package ObjectRepo;

import org.openqa.selenium.By;

public class HomePage 
{

	By homelogo = By.xpath("//div[@class='app_logo']");
	By menu = By.xpath("//button[text()='Open Menu']");
	By all_items = By.xpath("//a[text()='All Items']");
	By about = By.xpath("//a[text()='All Items']//following-sibling::a[text()='About']");
	By logout = By.linkText("Logout");
	By resetappstate = By.partialLinkText("Reset App St");
}
