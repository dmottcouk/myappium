package uk.co.dmott.myappiumjunit.myappium;

import static org.junit.Assert.*;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidContactsTest {

	private static AndroidDriver driver;
	
	@Before
	public void setUp() throws Exception {
		
		String sysprop = System.getProperty("user.dir");
		
		File classpathRoot = new File(System.getProperty("user.dir"));
        
		System.out.println("created classpathRoot" );
		
//		
		File appDir = new File(classpathRoot, "./apps/ContactManager");
		
		System.out.println("created appDir" );
		
		
		
        File app = new File(appDir, "ContactManager.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.example.android.contactmanager");
        capabilities.setCapability("appActivity", ".ContactManager");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);		
		
		System.out.println("created driver" );
		
		
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
    public void addContact(){
        WebElement el = driver.findElement(By.name("Add Contact"));
        el.click();
        //List<AndroidElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
        List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
        
        
        
        textFieldsList.get(0).sendKeys("Some Name");
        textFieldsList.get(2).sendKeys("Some@example.com");
        driver.swipe(100, 500, 100, 100, 2);
        driver.findElementByName("Save").click();
    }	
	
	
	
	
	

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

}
