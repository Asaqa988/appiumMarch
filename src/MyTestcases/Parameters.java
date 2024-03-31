package MyTestcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.android.AndroidDriver;

public class Parameters {
	
	AndroidDriver driver ; 

	
	public void myFunctionToDoTheScreenShot() throws IOException, InterruptedException {
		
		
		
		Date date = new Date(); 
		System.out.println(date);
		
		String fileName = date.toString().replace(":", "-"); 
		
		TakesScreenshot ts = (TakesScreenshot) driver ;
		Thread.sleep(3000);
		File file = ts.getScreenshotAs(OutputType.FILE); 
		
		FileUtils.copyFile(file, new File("./src/Pictures/"+fileName+".jpg"));
		
	}

}


