package Captcha.ReadCaptcha;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TestData {
	
	public static void main (String args[]){
		
//		ITesseract image = new Tesseract();
//		
//		try {
//			String str = image.doOCR(new File("C:\\Users\\varun\\Downloads\\processed\\7UWUQ.png"));
//			System.out.println(str);
//			
//		} catch (TesseractException e) {
//			System.out.println("Exception Message" + e.getMessage());
//		}
		
		ITesseract instance = (ITesseract) new Tesseract();
		try {
			String dirpath = System.getProperty("user.dir");
			instance.setDatapath(String.valueOf(dirpath) + "\\tessdata");
			String imgText = instance.doOCR(new File("C://Users//varun//Documents//New folder//Passport.png"));
			System.out.println(imgText);
		} catch (TesseractException e) {
			e.printStackTrace();
		}
	}

}
