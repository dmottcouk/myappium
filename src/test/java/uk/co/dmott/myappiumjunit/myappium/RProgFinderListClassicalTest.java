package uk.co.dmott.myappiumjunit.myappium;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;
import java.util.List;

import io.appium.java_client.android.AndroidDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RProgFinderListClassicalTest {
	
	private static AndroidDriver driver;

	@Before
	public void setUp() throws Exception {
		
		String sysprop = System.getProperty("user.dir");
		
		File classpathRoot = new File(System.getProperty("user.dir"));
        
		System.out.println("created classpathRoot" );
		
//		
		File appDir = new File(classpathRoot, "./apps/RProgFinder");
		
		System.out.println("created appDir" );
		
		
		
        File app = new File(appDir, "RProgFinder.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "uk.co.dmott.rprogfinder");
        capabilities.setCapability("appActivity", ".MainActivity");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);		
		
		System.out.println("created driver" );		
		
		
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
		
		//spinner and appium
		
		WebElement spinner = driver.findElement(By.xpath("//android.widget.Spinner[@content-desc='GenreSpinner']"));
		//WebElement spinner = driver.findElement(By.className("android.widget.Spinner"));
		
		
		System.out.println("Found the spinner");
		spinner.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.scrollToExact("Classical");
		WebElement optionClassical = driver.findElement(By.name("Classical"));
		optionClassical.click();
		
		WebElement goButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc='GoButton']"));
		goButton.click();
		//try {
		//	Thread.sleep(8000);
		//} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
		
		
		(new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				List<WebElement> returnListEles = driver.findElements(By.className("android.widget.ImageView"));
				return (returnListEles.size() > 0);
			}
		});
		
		
		
		List<WebElement> returnListEles = driver.findElements(By.className("android.widget.ImageView"));
		int numLines = returnListEles.size();
		
		System.out.println("Found Imageicons = " + numLines );	
		
		assertTrue(numLines > 0);
		
	}

}
