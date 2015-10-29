package uk.co.dmott.myappiumjunit.myappium;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MetroNewTest {
	
	private static AndroidDriver driver;
	

	@Before
	public void setUp() throws Exception {
		
		String sysprop = System.getProperty("user.dir");
		
		File classpathRoot = new File(System.getProperty("user.dir"));
        
		System.out.println("created classpathRoot" );
		
//		
		File appDir = new File(classpathRoot, "./apps/MetroNew");
		
		System.out.println("created appDir" );
		
		
		
        File app = new File(appDir, "MetroNew.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "uk.co.dmott.metronew");
        capabilities.setCapability("appActivity", ".MainActivity");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);		
		
		System.out.println("created driver" );		
		
		
		
		
	}

	@After
	public void tearDown() throws Exception {
		
		driver.quit();
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

}
