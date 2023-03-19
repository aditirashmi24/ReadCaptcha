package Captcha.ReadCaptcha;

import com.aspose.ocr.AsposeOCR;
import Captcha.ReadCaptcha.Utils;

import java.io.IOException;

public class OCRReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dataDir = Utils.getSharedDataDir(OCRReader.class);

		// The image path
		String imagePath = dataDir + "XPPHR.png";

		//Create api instance
		AsposeOCR api = new AsposeOCR();

		try {
			String result = api.RecognizeLine(imagePath);
			System.out.println("File: " + imagePath);
			System.out.println("Result line: " + result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
