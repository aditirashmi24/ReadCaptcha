package Captcha.ReadCaptcha;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utiliti_Recaptcha {

	public static void main(String[] args) throws Exception {
	System.setProperty("webdriver.chrome.driver", "D:\\workspace\\ReadCaptcha\\chromedriver.exe");
	ChromeOptions opt = new ChromeOptions();
	opt.addArguments("--disable-notification");
	WebDriver driver = new ChromeDriver(opt);
	driver.get("https://markettest.utilibill.com.au/marketbilling/SrvSignup");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.findElement(By.id("company-name")).sendKeys("AVFD");
	driver.findElement(By.id("contact-given-name")).sendKeys("efdf");
	driver.findElement(By.id("contact-surname")).sendKeys("scseF");
	driver.findElement(By.id("contact-email")).sendKeys("sefe@sef.xdf");
	driver.findElement(By.id("country")).click();
	Select country = new Select(driver.findElement(By.id("country")));
	country.selectByVisibleText("Australia");
	driver.findElement(By.id("contact-phone-number"));
	driver.findElement(By.id("customer-base")).click();
	Select base = new Select(driver.findElement(By.id("customer-base")));
	base.selectByVisibleText("2 - 250");
	Thread.sleep(2000);
	//driver.findElement(By.xpath("//*[@id='recaptcha-anchor']/div[2]"));
	
	
	new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("div#rc-anchor-container")));

	new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark"))).click();
	
	
}
}