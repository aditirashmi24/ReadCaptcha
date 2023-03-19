package Captcha.ReadCaptcha;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class PassportCaptcha {
	
	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "D:\\workspace\\ReadCaptcha\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notification");
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://portal2.passportindia.gov.in/AppOnlineProject/user/RegistrationBaseAction?request_locale=en");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
		
		 /* String path = "C:\\Users\\varun\\Documents\\New folder\\\\Passport.png";
		//driver.findElement(By.id("captcha"));
		  
		 File arrScreen = driver.findElement(By.id("captcha"))
	    		   .getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(arrScreen, new File(path));
		  File DestFile=new File(path);
	     		  ITesseract image = new Tesseract();
	     	        
	     	        String str = image.doOCR(DestFile);
	     			System.out.println(str);*/
		
		
		 String path = "C:\\Users\\varun\\Documents";
	       
	       byte[] arrScreen = (byte[]) driver.findElement(By.id("captcha"))
	    		   .getScreenshotAs(OutputType.BYTES);
	    		   BufferedImage imageScreen = ImageIO.read(new ByteArrayInputStream(arrScreen));
	    		   BufferedImage imgCap = imageScreen.getSubimage(71, 252, 90, 18);
	    		   File f1 = new File(String.valueOf(path) + "\\New folder\\Passport2.png");
	    		   //String f2 = String.valueOf(path) + "\\New folder\\3.png";
	    		   ImageIO.write(imgCap, "png", f1);
	    		  ITesseract image = new Tesseract();
	    	        
	    	        String str = image.doOCR(f1);
	    			System.out.println(str);
	
		
	
	}
}
