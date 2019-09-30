package driver;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileDriver {
	
	static AppiumDriver<MobileElement> driver  = null;
	public Properties prop = null;
	
	
	public MobileDriver() throws Exception {
		try {
			prop = new Properties();
			ClassLoader loader = Thread.currentThread().getContextClassLoader();           
			InputStream stream = loader.getResourceAsStream("locators.properties");
			prop.load(stream);
		}catch(Exception e) {
			System.out.println("Exception occurred loading properties file due to : "+e.getMessage());
			throw new Exception("Exception occurred loading properties file due to : "+e.getMessage());
		}
	}

	public void launchDriver() throws Exception{
		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("deviceName", "5f6a9781");
			cap.setCapability("platformName", "Android");
			cap.setCapability("appPackage", "com.bt.bms");
			cap.setCapability("appActivity", "com.movie.bms.splashscreen.SplashScreenActivity");
			cap.setCapability(MobileCapabilityType.NO_RESET, true);
			cap.setCapability(MobileCapabilityType.FULL_RESET, false);
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}catch(Exception e) {
			System.out.println("Exception occurred while lauching app due to : "+e.getMessage());
			throw new Exception("Exception occurred while lauching app due to : "+e.getMessage());
		}
	}
	
	public MobileElement findElement(LocatorType type, String attribute) throws Exception {
		try {
			switch(type) {
			case XPATH:
				return driver.findElementByXPath(attribute);
			case ID:
				return driver.findElementById(attribute);
			case CLASSNAME:
				return driver.findElementByClassName(attribute);
			default:
				System.out.println("type not supported");
				throw new Exception("type not supported");
			}
		}catch(Exception e) {
			System.out.println("Exception occurred while getting element due to : "+e.getMessage());
			throw new Exception("Exception occurred while getting element due to : "+e.getMessage());
		}
	}
	
	public void click(LocatorType type, String attribute) throws Exception {
		try {
			findElement(type, attribute).click();
		}catch(Exception e) {
			System.out.println("Exception occurred while clicking on element due to : "+e.getMessage());
			throw new Exception("Exception occurred while clicking on element due to : "+e.getMessage());
		}
	}
	
	public void setText(LocatorType type, String attribute, String textToEnter) throws Exception {
		try {
			findElement(type, attribute).sendKeys(textToEnter);
		}catch(Exception e) {
			System.out.println("Exception occurred while entering text due to : "+e.getMessage());
			throw new Exception("Exception occurred while entering text due to : "+e.getMessage());
		}
	}
	
	public void waitForElementToClickable(LocatorType type, String attribute) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(findElement(type, attribute)));
		}catch(Exception e) {
			System.out.println("Exception occurred while waiting for element to clickable due to : "+e.getMessage());
			throw new Exception("Exception occurred while waiting for element to clickable due to : "+e.getMessage());
		}
	}
	
	public void waitForElementPresence(LocatorType type, String attribute, String text) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.textToBePresentInElement(findElement(type, attribute), text));
		}catch(Exception e) {
			System.out.println("Exception occurred while waiting for element to clickable due to : "+e.getMessage());
			throw new Exception("Exception occurred while waiting for element to clickable due to : "+e.getMessage());
		}
	}
	
	public String getText(LocatorType type, String attribute) throws Exception {
		try {
			return findElement(type, attribute).getText();
		}catch(Exception e) {
			System.out.println("Exception occurred while clicking on element due to : "+e.getMessage());
			throw new Exception("Exception occurred while clicking on element due to : "+e.getMessage());
		}
	}
	
	public void closeApp() throws Exception {
		try {
			Thread.sleep(5000);
			driver.closeApp();
		}catch(Exception e) {
			System.out.println("Exception occurred while closing app due to : "+e.getMessage());
			throw new Exception("Exception occurred while closing app due to : "+e.getMessage());
		}
	}
}