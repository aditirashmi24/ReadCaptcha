package Captcha.ReadCaptcha;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class ReadCaptcha {

	public static void main(String[] args) throws Exception {
	
		System.setProperty("webdriver.chrome.driver", "D:\\workspace\\ReadCaptcha\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notification");
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='h_menu_drop_button hidden-xs']")).click();
        driver.findElement(By.xpath("(//*[contains(text(),'LOGIN')])[3]")).click();
        Thread.sleep(3000);
        
  /*   byte[] path =  takeSnapShot(driver.findElement(By.xpath("//img[@id='nlpCaptchaImg']")), "C://Users//varun//Documents//New folder//test.png") ; 
       ByteArrayInputStream bais = new ByteArrayInputStream(path);
       //read png bytes as an image
       BufferedImage bufferedImage = ImageIO.read(bais);
        
       BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(),
               bufferedImage.getHeight(),
               BufferedImage.TYPE_INT_RGB);
       newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
       
       ByteArrayOutputStream baos = new ByteArrayOutputStream();
       //write image as jpg bytes
       ImageIO.write(newBufferedImage, "JPG", baos);

       //convert OutputStream to a byte[]
       return baos.toByteArray();*/
       
      String path = "C:\\Users\\varun\\Documents";
       
       byte[] arrScreen = (byte[]) driver.findElement(By.xpath("//img[@id='nlpCaptchaImg']"))
    		   .getScreenshotAs(OutputType.BYTES);
    		   BufferedImage imageScreen = ImageIO.read(new ByteArrayInputStream(arrScreen));
    		   BufferedImage imgCap = imageScreen.getSubimage(71, 252, 90, 18);
    		   File f1 = new File(String.valueOf(path) + "\\New folder\\60.png");
    		   //String f2 = String.valueOf(path) + "\\New folder\\3.png";
    		   ImageIO.write(imgCap, "png", f1);
    		  ITesseract image = new Tesseract();
    	        
    	        String str = image.doOCR(f1);
    			System.out.println(str);
    			
    			 String[] arrOfStr = str.split("“ \"");
    			  
    		      for (String a : arrOfStr)
    		      System.out.println(a);
    		     // String s = arrOfStr[1];
    		      //System.out.println(s);

       driver.findElement(By.id("nlpAnswer")).sendKeys(arrOfStr);
       driver.findElement(By.xpath("//*[contains(text(),'SIGN IN')]")).click();;
       
       
       
       
       
       
      /*  // takeSnapShot(driver.findElement(By.xpath(xpathExpression)), "C://Users//varun//Documents//New folder//test.png");
        File SrcFile=driver.findElement(By.xpath("//img[@id='nlpCaptchaImg']")).getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("C://Users//varun//Documents//New folder//test.jpg");
        FileHandler.copy(SrcFile, new File(path));
        File DestFile=new File(path);

        Files.copy(SrcFile, DestFile);*/
              
      /*  ITesseract image = new Tesseract();
        
        String str = image.doOCR(new File(path));
		System.out.println(str);  */
	
		
	}
	
    public static byte[] takeSnapShot(WebElement we,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)we);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath);

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);
				return null ;

    }
}
