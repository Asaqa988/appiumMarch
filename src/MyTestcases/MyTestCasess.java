package MyTestcases;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v109.database.Database;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MyTestCasess {
	
	DesiredCapabilities caps = new DesiredCapabilities();
	
	AndroidDriver driver ; 
	
	Assertion myassert = new Assertion(); 
	
	@BeforeTest
	public void mySetup() {
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "abc");
		
		File myApplicationCalcuator = new File("src/myApplications/calculator.apk"); 
		
		caps.setCapability(MobileCapabilityType.APP, myApplicationCalcuator.getAbsolutePath());
	}
	
	@Test(enabled = false)
	public void myTest() throws MalformedURLException {
		
		driver = new AndroidDriver( new URL("http://127.0.0.1:4723/wd/hub"),caps);
		
		WebElement number9 = driver.findElement(By.id("com.google.android.calculator:id/digit_9"));
		number9.click();
		
		WebElement Multiply = driver.findElement(By.id("com.google.android.calculator:id/op_mul"));
		
		Multiply.click(); 
		
		WebElement number5 = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
		
		number5.click();
		
		WebElement results = driver.findElement(By.id("com.google.android.calculator:id/result_preview"));
		
			
		myassert.assertNotEquals(results.getText(), 45, "jayen n3ml test ");
	}

	@Test
	public void pressonAllNumbersOnlyNumbers() throws IOException, InterruptedException {

		Date date = new Date(); 
		System.out.println(date);
		
		String fileName = date.toString().replace(":", "-"); 
		
		driver = new AndroidDriver( new URL("http://127.0.0.1:4723/wd/hub"),caps);

		List<WebElement> allNumbers = driver.findElements(By.className("android.widget.ImageButton"));
		
		for(int i = 0 ; i < allNumbers.size();i++) {
			if(allNumbers.get(i).getAttribute("resource-id").contains("2")||allNumbers.get(i).getAttribute("resource-id").contains("4")||allNumbers.get(i).getAttribute("resource-id").contains("6")||allNumbers.get(i).getAttribute("resource-id").contains("8")||allNumbers.get(i).getAttribute("resource-id").contains("0")) {
				allNumbers.get(i).click();;
				
				TakesScreenshot ts = (TakesScreenshot) driver ;
				Thread.sleep(3000);
				File file = ts.getScreenshotAs(OutputType.FILE); 
				
				FileUtils.copyFile(file, new File("./src/Pictures/"+fileName+".jpg")); 
				
				
			}
			
		}
	}

}
